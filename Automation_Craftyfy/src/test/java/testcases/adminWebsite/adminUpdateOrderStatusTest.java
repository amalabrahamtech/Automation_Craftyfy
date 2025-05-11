package testcases.adminWebsite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class adminUpdateOrderStatusTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://craftyfy-admin.vercel.app/"); // Update with your orders page URL
		WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
		//System.out.print(user);
		userName.sendKeys("admin@example.com");
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("greatstack123");
		driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
		System.out.print("btnclick done");

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='Orders']"));
		String elementName = "";
		if (landingPageElement != null) {
			elementName = landingPageElement.getText().toString();
			System.out.print(elementName);
			landingPageElement.click();
			System.out.print("clicked");
		}
	}



	@Test
	public void TC_A5_02_updateStatusForFirstLast() {
		
		
		try {
		// Get all order divs
		List<WebElement> orderDivs = driver.findElements(By.cssSelector(
				"div.grid.grid-cols-1.sm\\:grid-cols-\\[0\\.5fr_2fr_1fr\\].lg\\:grid-cols-\\[0\\.5fr_2fr_1fr_1fr_1fr\\].gap-3.items-start.border-2.border-gray-200.p-5.md\\:p-8.my-3.md\\:my-4.text-xs.sm\\:text-sm.text-gray-700"
				));

		boolean found = false;

		for (WebElement order : orderDivs) {
			// Look for name inside <p class="mt-3 mb-2 font-medium"> tag
			WebElement nameElement = null;
			try {
				nameElement = order.findElement(By.cssSelector("p.mt-3.mb-2.font-medium"));
				System.out.println(nameElement.getText().trim());
			} catch (Exception e) {
				continue; // Skip if not found
			}

			String customerName = nameElement.getText().trim();
			System.out.println(nameElement.getText().trim());
			if (customerName.equalsIgnoreCase("TestOrder TestOrder")) {
				
				
				  List<WebElement> orderDropdowns = driver.findElements(By.cssSelector("select.p-2.font-semibold"));
						  //driver.findElements(By.xpath("//select[@class='p-2 font-semibold']"));
		            
		            boolean statusChanged = false;

		            // Loop through dropdowns and update the first "Order Placed" to "Packing"
		            for (WebElement dropdownElement : orderDropdowns) {
		                Select dropdown = new Select(dropdownElement);
		                
		              //  WebElement dropdown = driver.findElement(By.cssSelector("select.p-2.font-semibold"));
		                //WebElement selectedOption = dropdown.getFirstSelectedOption();
		                //selectedOption.
		                dropdown.selectByValue("Packing");
		                //dropdown.getFirstSelectedOption()
	                    dropdown.selectByVisibleText("Packing");
	                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		                //JavascriptExecutor js = (JavascriptExecutor) driver;
		                //js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", dropdown);
	                    
	                    System.out.println("Order status changed from 'Order Placed' to 'Packing'.");
	                    System.out.println(dropdown.getFirstSelectedOption().getText());
	                    //if(dropdown.getFirstSelectedOption().getText())
	                    break;
		                
		                
		            }

				
//		        
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("❌ No order found for customer: first last");
		}
		
		
		 } catch (Exception e) {
             e.printStackTrace();
            Assert.fail("Exception occurred: " + e.getMessage());
         }	
		
		
	}


	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}




