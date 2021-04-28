package configreaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	private Properties prop = null;

	public Properties getProperties() {

		prop = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

}
