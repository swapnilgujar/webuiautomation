package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import exceptions.RunTimeException;

public class PropertiesFileReader {
	private static Properties prop = new Properties();

	PropertiesFileReader() {
		try {
			prop.load(new FileInputStream("./src/main/resources/config.properties"));
		} catch (IOException e) {
			throw new RunTimeException(e.getMessage());
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}


	String getUrl() {
		String url =  prop.getProperty("test.env.url");
		return url;
	}


	boolean getBrowserMinimizeValue() {
		return Boolean.parseBoolean(prop.getProperty("browser.minimize"));
	}

	boolean getBrowserDisableImagesValue() {
		return Boolean.parseBoolean(prop.getProperty("browser.disable.image.icons"));
	}

	int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("timeouts.page.load"));
	}

	int getdefaultTimeOut() {
		return Integer.valueOf(prop.getProperty("timeouts.default.wait"));
	}

	int getMaxTimeOut() {
		return Integer.parseInt(prop.getProperty("timeouts.max.wait"));
	}
}
