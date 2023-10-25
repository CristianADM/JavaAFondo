package libro.demo;

public class Test {

	public static void main(String[] args) throws Exception {
		String sCass = "libro.demo.Demo";
		Class<?> clazz = Class.forName(sCass);
		
		HolaMundo a = clazz.getMethod("unMetodo").getAnnotation(HolaMundo.class);
		
		System.out.println("nombre = " + a.nombre());
	}
}
