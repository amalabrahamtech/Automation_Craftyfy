package testcases.adminWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
import pages.adminWebsite.adminAuthentication;
import pages.adminWebsite.adminDeleteProduct;

public class adminDeleteProductTest extends base {
	adminDeleteProduct adminDeleteProductPage;
	adminAuthentication adminAuthPage;
	String exp_Res = "Add Items";
	  
	@BeforeMethod
	public void initObj() {
		
		adminDeleteProductPage = new adminDeleteProduct(driver);
		
		

	}
	
	

   	@Test
	public void TC_A5_07_DeleteItemsScreen() {
		try {
			
			
			//adminDeleteProductPage.deleteNewProduct();
			boolean ResponseMessageDisplayed = adminDeleteProductPage.deleteNewProduct();
			//System.out.println(ResponseMessageDisplayed);
			Assert.assertTrue(ResponseMessageDisplayed, "Product removal failed!");

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
  

	   

   	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	}



