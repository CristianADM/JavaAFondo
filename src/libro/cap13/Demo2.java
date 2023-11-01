package libro.cap13;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = null;
		PrintStream stdErr = null;
		
		try {
			//abro el archivo
			fos = new FileOutputStream("errores.txt");
			
			//instancio un printstream basado en el input stream
			stdErr = new PrintStream(fos);
			
			//seteo la standard error
			System.setErr(stdErr);
			
			int[] arr = new int[5];
			
			//error cuando i sea mayor que 4
			for (int i = 0; i < 10; i++) {
				arr[i] = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stdErr!=null) {
					stdErr.close();
				}
				
				if(fos!=null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
