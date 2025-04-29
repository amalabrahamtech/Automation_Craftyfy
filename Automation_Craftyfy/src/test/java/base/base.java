package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;




public class base {
	
	protected WebDriver driver;
	String filePath = "..//Craftfy_auto001/src/test/resources/config.properties";
	
	//reading properties from config file
	protected Properties prop;
	public void loadProperties() throws IOException {
		
		FileInputStream configFile =new FileInputStream	(filePath);
		
	    prop=new Properties();
	    prop.load(configFile);
	}
	
	@BeforeMethod
	public void SetwebConfig() throws IOException{
		loadProperties();	
		// user specific browser preference from config file
		String browser = prop.getProperty("browser");
//System.out.print("SetwebConfig");
        if (browser.equalsIgnoreCase("chrome")) {
              driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            
            driver = new FirefoxDriver();
        }
		
		driver.get(prop.getProperty("AdminWebsiteUrl"));
		System.out.print(prop.getProperty("AdminWebsiteUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	
	
	
}
