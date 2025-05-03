package pages.adminWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class adminDeleteProduct {
	
	WebDriver driver;

	public adminDeleteProduct(WebDriver driver) {

		this.driver = driver;
		
	}
	
	public boolean deleteNewProduct() {
        // Get all product blocks
	    boolean productFound = false;
		
		WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
		 //System.out.print(user);
		userName.sendKeys("admin@example.com");
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("greatstack123");
		driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
		System.out.print("btnclick done");
  	WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='List Items']"));
		String elementName = "";
		if (landingPageElement != null) {
			elementName = landingPageElement.getText().toString();
			System.out.print(elementName);
			landingPageElement.click();
			System.out.print("remove prodclicked");
		}
        List<WebElement> products = driver.findElements(By.cssSelector("div.grid"));

    

        for (WebElement product : products) {
            WebElement nameElement = product.findElement(By.xpath(".//p[1]"));
            String productName = nameElement.getText();
            //System.out.println(" product: " + productName);
            if ("Handmade Vase".equalsIgnoreCase(productName)) {
                // Found the product, now click the delete "X" button
            	                WebElement deleteButton = product.findElement(By.cssSelector("p.text-right.md\\:text-center.cursor-pointer.text-lg"));
                deleteButton.click();
              //  System.out.println("Deleted product: " + productName);
                productFound = true;
                break;
            }
        }
return productFound;
//        if (!productFound) {
//            System.out.println("Product 'NewPROduct' not found.");
//        }
    }


	public String RemoveProduct() {System.out.print("iam in");
		//System.out.print(driver.getCurrentUrl());
		//WebElement landingPageElement1 = driver.findElement(By.xpath("//p[text()='Add Items']"));
		WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
		 //System.out.print(user);
		userName.sendKeys("admin@example.com");
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("greatstack123");
		driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
		System.out.print("btnclick done");
   	WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='List Items']"));
		String elementName = "";
		if (landingPageElement != null) {
			elementName = landingPageElement.getText().toString();
			System.out.print(elementName);
			landingPageElement.click();
			System.out.print("remove prodclicked");
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String toastText = null;
		// Locate product list items
		List<WebElement> productRows = driver.findElements(By.xpath("//div[contains(@class,'grid')]"));
		System.out.print("prod rows");
		// Loop through products to find 'newprod1'
		for (WebElement row : productRows) {
			WebElement productName = row.findElement(By.xpath(".//p[1]"));
			System.out.println(productName.getText());
			if (productName.getText().equals("TESTPROD")) {
				
				// Click the corresponding delete 'X' button
				WebElement deleteButton = row.findElement(By.xpath(".//p[contains(@class,'cursor-pointer')]"));
				deleteButton.click();

				System.out.println("Clicked delete button for product: " + productName.getText());

				// Wait for success message (Toast notification)
				WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='Toastify__toast Toastify__toast--success']")));

				// Capture the success message text
				toastText = toastMessage.getText();
				System.out.println("Success Message: " + toastText);

				// Assertion to verify successful deletion

				break; // Exit loop after deletion
			}

		}
		return toastText;
	}

	
}
