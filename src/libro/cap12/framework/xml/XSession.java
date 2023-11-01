package libro.cap12.framework.xml;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import libro.cap12.framework.annotations.Colum;
import libro.cap12.framework.annotations.Pk;
import libro.cap12.framework.annotations.Table;

public class XSession {

	public Object findByPrimaryKey(Class dtoClass, Object pk) {
		
		//obtengo el pool de conexiones
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		//obtengo una conexion
		Connection con  = pool.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			//armo el query
			String sql = "";
			
			//SELECT campo1, campo2, ...
			sql += "SELECT " + _obtenerListaDeCampos(dtoClass) + " ";
			
			//FROM nombreTabla
			sql += "FROM " + _obtenerNombreDeTabla(dtoClass) + " ";
			
			//WHERE campoPK
			sql += "WHERE " + _obtenerClavePrimaria(dtoClass);
			
			//preparo la sentencia 
			pstm = con.prepareStatement(sql);
			
			//seteo el parametro de la sentencia
			pstm.setObject(1, pk);
			
			//ejecuto el query
			rs = pstm.executeQuery();
			
			//si existe al menos una fila...
			if(rs.next()){
				//obtengo una instancia del dto y le seto los datos del ResultSet
				Object dto = _obtenerInstancia(dtoClass);
				_invocarSetters(dto, rs, dtoClass);
				
				//si hay otra fila entonces hay
				//inconsistencias en los datos
				if(rs.next()) {
					throw new RuntimeException("Mas de una fila...");
				}
				
				//retornamos el dto
				return dto;
			}
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				pool.releaseConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	
	private String _obtenerListaDeCampos(Class<?> dtoClass) {
		try {
			String[] atts = UBean.getAttNames(dtoClass);
			
			String ret = "";
			for (int i = 0; i < atts.length; i++) {
				Field field = dtoClass.getDeclaredFields(atts[i]);
				Colum colum = field.getAnnotation(Colum.class);
				
				ret += colum.name() + (i<atts.length-1 ? ", " : "");
			}
			
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private String _obtenerNombreDeTabla(Class<?> dtoClass) {
		try {
			Table table = dtoClass.getAnnotation(Table.class);
			return table.name();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private String _obtenerClavePrimaria(Class<?> dtoClass) {
		try {
			String[] atts = UBean.getAttNames(dtoClass);
			
			for (int i = 0; i < atts.length; i++) {
				Field field = dtoClass.getDeclaredField(atts[i]);
				Pk pk = field.getAnnotation(Pk.class);
				
				if(pk != null) {
					Colum colum = field.getAnnotation(Colum.class);
					return colum.name() + "=?";
				}
				
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private Object _obtenerInstancia(Class dtoClass) {
		try {
			return dtoClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void _invocarSetters(Object dto, ResultSet rs, Class dtoClass) {
		try {
			String attName = "";
			Object value;
			//obtengo la lista de tags <field> de la tabla
			XTag[] fields = UXml.getFieldsTag(dto.getClass().getName());
			
			//por cada campo x voy a invocar a setX en el DTO
			for (int i = 0; i < fields.length; i++) {
				attName = fields[i].getAtts().get("att");
				value = rs.getObject(fields[i].getAtts().get("name"));
				
				//invoco al setter
				UBean.invoqueSetter(dto, attName, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public int insert(Object dto) {
		//Obtengo el pool de conexiones y pido una conexion
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		Connection con = pool.getConnection();
		PreparedStatement pstm = null;
		
		try {
			//armo el query
			String sql = "";
			
			int cantCampos = _obtenerCantidadDeCampos(dto.getClass());
			
			//INSERT INTO nomTabla (campo1, campo2...) VALUES (?,?, ...)
			sql += "INSERT INTO";
			sql += _obtenerNombreDeTabla(dto.getClass()) + "(";
			sql += _obtenerListaDeCampos(dto.getClass()) + ")";
			sql += "VALUES (";
			sql += UString.replicate("?", cantCampos, ",") + " )";
			
			//Preparo la sentencia
			pstm = con.prepareStatement(sql);
			
			//seteo el parametro sobre la sentencia
			_setearParametrosEnStatement(pstm, dto);
			
			//ejecuto el insert
			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
					pool.releaseConnection(con);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	
	public void _setearParametrosEnStatement(PreparedStatement pstm, Object dto) {
		try {
			XTag[] fields = UXml.getFieldsTag(dto.getClass().getName());
			
			Object value;
			
			for (int i = 0; i < fields.length; i++) {
				value = UBean.invoqueGetter(dto, fields[i].getAtts().get("att"));
				
				pstm.setObject(i+1, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private int _obtenerCantidadDeCampos(Class dto) {
		XTag[] fields = UXml.getFieldsTag(dto.getName());
		return fields.length;
	}
	
	public XTransaction beginTransaction() {
		//instancio un XTransactionManager
		XTransaction tm = new XTransaction();
		
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		//el tm manejara su propia conexion
		tm.setConnection(pool.getConnectionForTransaction());
		
		return tm;
	}
}
