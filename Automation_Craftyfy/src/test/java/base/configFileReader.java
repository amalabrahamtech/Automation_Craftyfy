package base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configFileReader {
    private static Properties properties;
    
    static {
        try {
        	String filePath = "..//CraftfyAutomationTest/src/test/resources/config.properties";
            FileInputStream file = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
