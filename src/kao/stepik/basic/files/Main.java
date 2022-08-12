package kao.stepik.basic.files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	private static void replaceNewline(InputStream inStream, OutputStream outStream) throws IOException {
		int prev = -1;
		for (;;) {
			int b = inStream.read();
			if (b == -1) {
				if (prev == (int)'\r') {
					outStream.write(prev);
				}
				break;
			}
			if (prev == (int)'\r') {
				if (b != (int)'\n') {
					outStream.write(prev);
					System.out.println(prev);
				}
			} 
			if (b != (int)'\r') {
				outStream.write(b);
				System.out.println(b);
			}
			prev = b;
		}
		outStream.flush();
	}
	
	public static void main(String[] args) {
		byte[] testData = { 65, 13, 10, 10, 13, 65, 13 };
		InputStream testIn = new ByteArrayInputStream(testData);
		OutputStream testOut = new ByteArrayOutputStream();
		
		try {
			Main.replaceNewline(testIn, testOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
