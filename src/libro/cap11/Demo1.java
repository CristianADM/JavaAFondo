package libro.cap11;

import java.lang.reflect.Method;

public class Demo1 {

	public static void main(String [] args) {
		try {
			//Definimos el nombre de la clase (incluyendo el paquete)
			String sClass = "libro.cap04.DepartamentoDao";
			
			//obtengo una instancia de Class apuntando a la clase
			Class clazz = Class.forName(sClass);
			
			//obtengo la lista de los metodos (de tipo method) de la clase
			Method metodos[] = clazz.getDeclaredMethods();
			
			//recorro la lista de methods y muestro sus nombres
			for (Method mtd : metodos) {
				System.out.println(mtd.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
