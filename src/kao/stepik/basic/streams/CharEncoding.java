package kao.stepik.basic.streams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharEncoding {
	public static void main(String[] args) {
		ByteArrayInputStream in = new ByteArrayInputStream(new byte[] { 48, 49, 50, 51 });
		try {
			System.out.println(readAsString(in, StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
		InputStreamReader isr = new InputStreamReader(inputStream, charset);
		StringBuilder result = new StringBuilder();
		int r;
		while ((r = isr.read()) != -1) {
			result.append((char) r);
		}
		return result.toString();
	}

}
