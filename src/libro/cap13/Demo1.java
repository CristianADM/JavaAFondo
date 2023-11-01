package libro.cap13;

import java.io.FileInputStream;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		//abro el archivo
		FileInputStream fls = new FileInputStream("demo.txt");
		
		//instancio a Scanner pasandole el FileInputStream
		Scanner sc = new Scanner(fls);
		
		int i = sc.nextInt();
		String n = sc.next();
		
		while(!n.equals("FIN")) {
			System.out.println(i + ", " + n);
			
			i = sc.nextInt();
			n =sc.next();
		}
		
		//cierro el archivo
		fls.close();
	}
}
