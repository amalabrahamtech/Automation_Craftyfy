package pages.userWebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	
		WebDriver driver;
		
		public CartPage(WebDriver driver)
		{
			this.driver=driver;	
		}


		public void selectCart()
		{
			WebElement selcart= driver.findElement(By.xpath("//p[@class=\"absolute right-[-5px] bottom-[-5px] w-4 text-center leading-4 bg-black text-white aspect-square rounded-full text-[8px]\"]"));
					//"//a[img[@class='w-5 min-w-5']]"));		
			selcart.click();
		}
		public String initialcartValue()
		{
			WebElement value= driver.findElement(By.xpath("//p[@class=\"absolute right-[-5px] bottom-[-5px] w-4 text-center leading-4 bg-black text-white aspect-square rounded-full text-[8px]\"]"));
			String items=value.getText().toString();
			return items;
		}
		public void addCart()
		{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Actions actions = new Actions(driver);

	        // Step 1: Hover over the parent element (assumed)
	        WebElement hoverTarget = driver.findElement(By.xpath("//input[@class=\"border max-w-10 sm:max-w-20 px-1 sm:px-2 py-1\"]")); // Replace with real parent class or element
	        actions.moveToElement(hoverTarget).perform();

	        // Step 2: Wait for the input to become visible
	        WebElement hiddenInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/input")));
	                		//"//input[@type='number'][@value='8']")));

	        // Step 3: Interact with the input
	        hiddenInput.click();
		}
	        public String finalcartValue()
			{
				WebElement fvalue= driver.findElement(By.xpath("//p[@class=\"absolute right-[-5px] bottom-[-5px] w-4 text-center leading-4 bg-black text-white aspect-square rounded-full text-[8px]\"]"));
				String fitems=fvalue.getText().toString();
				return fitems;
	        
}
}
