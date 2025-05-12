package pages.userWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;	
	}
	public void setEmail(String mail) {
		
		WebElement email=driver.findElement(By.xpath("//input[@type=\"email\"]"));
		email.sendKeys(mail);	
	}
	public void setPassword(String pass) {
		
		
		WebElement password=driver.findElement(By.xpath("//input[@type=\"password\"]"));
		password.sendKeys(pass);
		
		}


	public void btnSignIn() {
		WebElement signin=driver.findElement(By.xpath("//button[@class=\"bg-black text-white font-light px-8 py-2 mt-4\"]"));
		signin.click();
	}

	
}
