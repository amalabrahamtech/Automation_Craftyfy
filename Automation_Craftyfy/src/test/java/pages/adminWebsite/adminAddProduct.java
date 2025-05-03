package pages.adminWebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import base.base;
public class adminAddProduct {
     WebDriver driver;

	
     
	public adminAddProduct(WebDriver driver) 
	{
		
		this.driver=driver;
	}

	
    
    public boolean AddProductTest() {
    	System.out.println("AddProductTest!");
    	//AdminWebsiteUsername=admin@example.com
    		//	AdminWebsitePassword=greatstack123
    	WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
		 //System.out.print(user);
		userName.sendKeys("admin@example.com");
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("greatstack123");
		driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
		System.out.print("btnclick done");
    	WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='Add Items']"));
		String elementName = "";
		if (landingPageElement != null) {
			elementName = landingPageElement.getText().toString();
			System.out.print(elementName);
			landingPageElement.click();
			System.out.print("clicked");
		}
        // Locate elements using XPath
        WebElement productName = driver.findElement(By.xpath("//input[@placeholder='Type here']"));
        WebElement productDescription = driver.findElement(By.xpath("//textarea[@placeholder='Write content here']"));
        WebElement prodCatdropdownElement = driver.findElement(By.xpath("//select[@class='w-full px-3 py-2']"));

        // Use Select class to choose an option
        Select prodCatdropdown = new Select(prodCatdropdownElement);
        prodCatdropdown.selectByValue("HomeDecor"); // 
        
        //WebElement productCategory = driver.findElement(By.xpath("//select[@class='w-full px-3 py-2']/option[@value='HomeDecor']"));
       // WebElement subCategory = driver.findElement(By.xpath("//select[@class='w-full px-3 py-2']/option[@value='ClayItems']"));
        
        
        WebElement subCatdropdownElement = driver.findElement(By.xpath("//div[p[contains(text(),'Sub category')]]/select"));

        // Use Select class to choose an option
        Select subCatdropdown = new Select(subCatdropdownElement);
        subCatdropdown.selectByValue("ClayItems"); // 
        
        WebElement productPrice = driver.findElement(By.xpath("//input[@placeholder='25']"));
        WebElement productColor = driver.findElement(By.xpath("//p[contains(text(), 'Green')]"));
        WebElement addToBestseller = driver.findElement(By.xpath("//input[@id='bestseller']"));
        WebElement addButton = driver.findElement(By.xpath("//button[text()='ADD']"));

        // Assign values
        productName.sendKeys("Handmade Vase");
        productDescription.sendKeys("Beautiful handcrafted vase for home decor.");
        //productCategory.sendKeys("HomeDecor");
        //subCategory.sendKeys("ClayItems");
        productPrice.sendKeys("250");
        productColor.click(); // Select product color
        addToBestseller.click(); // Select Bestseller checkbox

        // Click Add Button
        addButton.click();
        System.out.println("Toast Message:start " );
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for toast notification to appear
        WebElement toastMessage =driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--light Toastify__toast--success']"));
        		//wait.until(ExpectedConditions.visibilityOfElementLocated(
              
     // Capture the text
        String toastText = toastMessage.getText();
        System.out.println("Toast Message: " + toastText);
        // Verify Response
        WebElement responseMessage = driver.findElement(By.xpath("//div[contains(text(), 'Product Added')]"));
        System.out.println("Toast Message: " + responseMessage.getText());
        return true;
//        Assert.assertTrue(responseMessage.isDisplayed(), "Product addition failed!");
//
//        System.out.println("Product added successfully!");
    }
    
   

    // Assertion to verify the message contains expected text
   // Assert.assertTrue(toastText.contains("Product Added"), "Toast message incorrect!");

   
}


