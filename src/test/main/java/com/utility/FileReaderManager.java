package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;

	private static void setProperty()  {

		File file = new File(
				"C:\\Users\\sky\\eclipse-workspace\\TestNGframeworksune\\src\\main\\resources\\TestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR OCCURED DURING FILE LOADING");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDataProperty(String datavalue)  {
		setProperty();
		String data = property.getProperty(datavalue);
		return data;

	}

	public static void main(String[] args) {
		System.out.println("url");
	}

}
