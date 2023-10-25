package libro.cap12.framework.xml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			sql += "FROM " + _obtenerNombreTabla(dtoClass) + " ";
			
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
				_invocatSetters(dto, rs, dtoClass);
				
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
				
				pool.reseaseConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
}
