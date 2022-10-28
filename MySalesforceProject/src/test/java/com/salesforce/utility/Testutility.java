package com.salesforce.utility;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Testutility {

	public String getapplicationproperty(String key){
	Properties propertyfile=new Properties();
	String filepath=Constants.APPLICATION_PROPERTIES_PATH;
	
	FileReader file = null;
	try {
		file = new FileReader(filepath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		propertyfile.load(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		String value=propertyfile.getProperty(key);
		System.out.println("Property from the file:"+value);
		return value;
	}
	
	}


