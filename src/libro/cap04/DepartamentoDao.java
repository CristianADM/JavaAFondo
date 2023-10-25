package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import libro.cap04.dtos.DepartamentoDto;
//import practica.ConnectionPool;
//import practica.UConexion;

public class DepartamentoDao {
	
	public Collection<DepartamentoDto> buscarTodosDepartamentos(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Vector<DepartamentoDto> ret = new Vector<>();
		
		try {
			
			//tomo una conexion del pool de conexiones
//			con = ConnectionPool.getPool().getConnection();
			
			String sql = "SELECT * FROM departamentos";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			
			DepartamentoDto depDto = null;
			
			while(rs.next()) {
				depDto = new DepartamentoDto();
				depDto.setIdDepartamento(rs.getInt("id_departamento"));
				depDto.setNombre(rs.getString("nombre"));
				depDto.setLocacion(rs.getString("locacion"));
				ret.add(depDto);
			}
			
			return ret;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				//devuelvo la conexion
				if(con != null) {
//					ConnectionPool.getPool().releaseConnection(con);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}	
		}
	}
	
}
