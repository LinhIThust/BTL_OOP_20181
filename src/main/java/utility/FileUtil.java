package utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileUtil {
	public static String[] getListFromFile(String fileName) {
		String[] values = null;
		String content = new String();

		try {
			InputStream in = new FileInputStream(fileName);
			Reader r = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(r);
			String line;
			while ((line = br.readLine()) != null) {
				content = content + line;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values = content.split(",");
		return values;
	}
}
