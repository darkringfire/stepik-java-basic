package kao.stepik.basic.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {
    public static void main(String[] args) {
    	Path path = Paths.get(".project");
    	System.out.println(path.toAbsolutePath());
    	try (InputStream stream = new FileInputStream(path.toFile());) {
    		System.out.println((char)stream.read());
    	} catch (IOException e) {
			// TODO: handle exception
    		System.out.println(e.getMessage());
		}
    	try (InputStream stream = Files.newInputStream(path)) {
    		System.out.println((char)stream.read());
    	} catch (IOException e) {
			// TODO: handle exception
    		System.out.println(e.getMessage());
		}
    }
}
