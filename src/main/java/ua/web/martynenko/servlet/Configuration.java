package ua.web.martynenko.servlet;


import java.util.Properties;

public final class Configuration {
	private Properties parameters;
	private static Configuration instance = null;
	
	private Configuration(){
		parameters = new Properties();
	}
	
	public static Configuration getInstance(){
		if (instance == null) instance = new Configuration();
		return instance;
	}
	
	public String getParameter(String name){
		return parameters.getProperty(name);
	}
	
	public void setParameter(String name, String value){
		parameters.setProperty(name, value);
	}
}
