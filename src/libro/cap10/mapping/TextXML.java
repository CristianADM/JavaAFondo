package libro.cap10.mapping;

public class TextXML {

	public static void main(String[] args) {
		ConnectionPoolTag cp = ConnectionPoolTag.getInstancia();

		// Obtengo y muestro los datos de la conexion de mysql
		ConnectionTag c1 = cp.getJdbc().getConnectionTag("mysqlconnection");
		System.out.println(c1.getDriver());
		System.out.println(c1.getUrl());
		System.out.println(c1.getUsuario());
		System.out.println(c1.getPassword());

		// Obtengo y muestro los datos de la conexion de mysql
		ConnectionTag c2 = cp.getJdbc().getConnectionTag("oracleconnection");
		System.out.println(c2.getDriver());
		System.out.println(c2.getUrl());
		System.out.println(c2.getUsuario());
		System.out.println(c2.getPassword());

		// Obtengo y muestro los datos del pool 1
		PoolTag t1 = cp.getPools().getPoolTag("P1");
		System.out.println(t1.getMaxsize());
		System.out.println(t1.getMinsize());
		System.out.println(t1.getSteep());

		// Obtengo y muestro los datos del pool 2
		PoolTag t2 = cp.getPools().getPoolTag("P2");
		System.out.println(t2.getMaxsize());
		System.out.println(t2.getMinsize());
		System.out.println(t2.getSteep());
	}
}
