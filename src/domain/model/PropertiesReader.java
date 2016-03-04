package domain.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	Properties properties;
	String path;
	
	public PropertiesReader(){
		setPath();
		properties = new Properties();
		setup();
	}
	
	
	protected void setPath(){
		path = "/settings.properties";
	}
	
	private void setup(){
		try {
			  properties.load(getClass().getResourceAsStream(path));
			} catch (IOException e) {
			  System.out.println("ERROR: Properties file not found!!");
			}
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
}
