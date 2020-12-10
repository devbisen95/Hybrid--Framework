package com.revseed.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties property;

	public ConfigDataProvider() {

		File src = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);

			property = new Properties();
			property.load(fis);
		} catch (Exception e) {
			System.out.println("not Able to load Config File" + e.getMessage());
		}
	}

	public String getDataFromconfig(String KeyTosearch) {
		return property.getProperty(KeyTosearch);

	}

	public String getBrowser() {
		return property.getProperty("Browser");

	}

	public String stagingURL() {
		return property.getProperty("URL");

	}

}
