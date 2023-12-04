package f04_try_with_resources;

import java.io.*;

public class TryWithResourcesExample {

	public static void main(String[] args) {
		String path = "C:\\Temp\\file2.txt";
		try(
			InputStream is = new FileInputStream(path);
			FileOutputStream os = new FileOutputStream(path);	
			) {
			
			int data;
			while((data = is.read()) != -1) {
				System.out.println(data);
			}
			
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
				

	}

}
