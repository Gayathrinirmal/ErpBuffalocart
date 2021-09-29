package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {
ReadpropertyFile readconfig;
public	String Username;
public String Password;
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Username=prop.getProperty("username");
		String Password=prop.getProperty("password");
		
		System.out.println("username"+Username);
		System.out.println("Password"+Password);
		
	}
	

}
