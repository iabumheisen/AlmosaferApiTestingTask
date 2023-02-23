package helpersPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	// This method used to support reading values from properties files
	public static String propertyReader(String key) {

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "java" + File.separator + "testDataPackage" + File.separator + "testData.properties");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String value = properties.getProperty(key);
		return value;
	}

}
