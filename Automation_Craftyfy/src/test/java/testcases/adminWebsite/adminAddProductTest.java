package testcases.adminWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Scanner;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
//import pages.adminWebsite.adminOrder;
import pages.adminWebsite.adminAddProduct;
import pages.adminWebsite.adminAuthentication;

public class adminAddProductTest extends base {
	adminAddProduct adminAddOrderPage;
	adminAuthentication adminAuthPage;
	String exp_Res = "Add Items";

	@BeforeMethod
	public void initObj() {
		adminAddOrderPage = new adminAddProduct(driver);
		
		
	}


	@Test
	public void TC_A5_03_AddItemsScreen() {
		try {
			
			
			
			boolean ResponseMessageDisplayedFlag=adminAddOrderPage.AddProductTest();
            System.out.println(ResponseMessageDisplayedFlag);
            Assert.assertTrue(ResponseMessageDisplayedFlag, "Product addition failed!");
           
        } catch (Exception e) {
            e.printStackTrace();
          Assert.fail("Exception occurred: " + e.getMessage());
        }
		}
	

  
        @Test
        public void TC_A5_02_ElementsDisplayed() {
        	
        	try {
        		        		
            // Product Name input
            Assert.assertTrue(adminAddOrderPage.productnameDisplayed(), "Product Name is not displayed");
            // Product Description textarea
            Assert.assertTrue(adminAddOrderPage.productDescriptionDisplayed(), "Product Description is not displayed");
            // Category select
            Assert.assertTrue(adminAddOrderPage.productCategoryDisplayed(), "Category is not displayed");
            // Subcategory select
            Assert.assertTrue(adminAddOrderPage.subCategoryDisplayed(), "Sub Category is not displayed");
            // Price input
            Assert.assertTrue(adminAddOrderPage.priceDisplayed(), "Price is not displayed");
        	 } catch (Exception e) {
                 e.printStackTrace();
              //   Assert.fail("Exception occurred: " + e.getMessage());
             }
        	
        	}

        @Test
        public void TC_A5_02_testDropdownOptionsAvailable() {
        	try {
        		
            // Category dropdown options
            Assert.assertTrue(adminAddOrderPage.categoryOptionsDisplayed(), "Category dropdown has no options");

            // Sub Category dropdown options
            Assert.assertTrue(adminAddOrderPage.subCategoryOptionsDisplayed(), "Sub Category dropdown has no options");
        	 } catch (Exception e) {
                 e.printStackTrace();
                Assert.fail("Exception occurred: " + e.getMessage());
             }
        	
        	}

        @SuppressWarnings("deprecation")
		@Test
        public void testRequiredFieldValidation() {
        	
        	try {
        		
        		        	      		
            // Click on submit without filling fields
            Assert.assertTrue(adminAddOrderPage.productNameRequiredFieldValidation(), "Validation message for Product Name is not displayed");

           Assert.assertTrue(adminAddOrderPage.productDescriptionRequiredFieldValidation(), "Validation message for Product Description is not displayed");
      
        	 } catch (Exception e) {
                 e.printStackTrace();
                Assert.fail("Exception occurred: " + e.getMessage());
             }
        	
        	}
        @Test
        public void TC_A5_06_testAddProductScenarios() {
        	
        	try {
        	
            // Scenario 2: Try with empty price
           
            Assert.assertTrue(adminAddOrderPage.emptyPriceScenario(), "Validation message for Price is not displayed");

            // Scenario 3: Try with blank name
           
            Assert.assertTrue(adminAddOrderPage.emptyProductNameScenario(), "Validation message for blank Product Name is not displayed");

            // Scenario 4: Try with blank description
               Assert.assertTrue(adminAddOrderPage.emptyProdDescriptionScenario(), "Validation message for blank Product Description is not displayed");
       
        	 } catch (Exception e) {
                 e.printStackTrace();
                 Assert.fail("Exception occurred: " + e.getMessage());
             }
        	
        	}

        

          

          
    

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
