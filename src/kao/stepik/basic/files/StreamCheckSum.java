package kao.stepik.basic.files;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamCheckSum {

	public static int checkSumOfStream(InputStream inputStream) throws IOException {
		int sum = 0;
		int data;
		for (;;) {
			data = inputStream.read();
			if (data == -1)
				break;
			sum = Integer.rotateLeft(sum, 1) ^ data;
		}
		return sum;
	}

	public static void main(String[] args) {
		Path path = Paths.get(".gitignore");
//		try (InputStream stream = Files.newInputStream(path)) {
		byte[] testData = { 0x33, 0x45, 0x01 };
		try (InputStream stream = new ByteArrayInputStream(testData)) {
			System.out.println(checkSumOfStream(stream));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
