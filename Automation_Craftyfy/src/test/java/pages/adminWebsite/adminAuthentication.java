package pages.adminWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class adminAuthentication {

	WebDriver driver;

	public adminAuthentication(WebDriver driver) {

		this.driver = driver;
	}

//Login Button click 
	public void loginBtnClick(String user, String password) {
		WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
		 System.out.print(user);
		userName.sendKeys(user);
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys(password);
		driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
		System.out.print("btnclick done");
	}

//verifying landing page after login-verifying side menu element is present
	public String IsAuthenticated() {

		WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='Add Items']"));
		String elementName = "";
		if (landingPageElement != null) {
			elementName = landingPageElement.getText().toString();
			System.out.print(elementName);
			landingPageElement.click();
			System.out.print("clicked");
		}
		return elementName;

	}
	
}
