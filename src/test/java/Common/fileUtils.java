package Common;

import java.io.File;
import java.nio.file.Files;

public class fileUtils {
	public static boolean deleteIfExists(String filePath) {
		try {
			System.out.println("start deleteIfExists:"+filePath);
			// File (or directory) with old name
			File file = new File(filePath);
			// File (or directory) with new name
			return Files.deleteIfExists(file.toPath());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
	
	public static File getFileFromPath(String path) {
		try {
			return new File(path);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can't find path "+path);
		}
		return null;
	}
}
