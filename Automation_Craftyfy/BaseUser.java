package base.userWebsite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseUser {

			
		public WebDriver driver;
		protected Properties prop;
		public void loadProperties() throws IOException
		{
			
			FileInputStream flins =new FileInputStream("E:\\Selenium Workspace\\Maven\\Final\\src\\test\\resources\\config.properties");
			
		    prop=new Properties();
		    prop.load(flins);
		    System.out.println("Welcome");
		}
		
		@BeforeTest
		public void setConfig() throws IOException{
			loadProperties();
			String browser=prop.getProperty("browser").toLowerCase();
			
		if (browser.equalsIgnoreCase("chrome"))
		{
			 System.out.println("In loop 1");
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			 System.out.println("In loop 2");
			driver=new FirefoxDriver();
			driver.get(prop.getProperty("url"));				
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	}
	
}

		
		


