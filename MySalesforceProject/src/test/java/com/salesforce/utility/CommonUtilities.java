package com.salesforce.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
	
	public FileInputStream stream=null;
	
	public Properties loadfile(String filename) {
			
	Properties propertyfile=new Properties();
	String Propertyfilepath=null;
	switch(filename) {
	case "applicationproperties":
		  Propertyfilepath=Constants.APPLICATION_PROPERTIES_PATH;
		  break;
		}
		
		try {
			stream=new FileInputStream(Propertyfilepath);
			try {
				propertyfile.load(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return propertyfile;
		}
		
		public String getapplicationproperty(String key,Properties propertyfile) {
			String value=propertyfile.getProperty(key);
			System.out.println( "Property we got from the file is"+value);
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}
}

