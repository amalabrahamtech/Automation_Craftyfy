package testcases.adminWebsite;

import org.openqa.selenium.By;
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
	public void TC_A5_02_AddItemsScreen() {
		try {
			
			
			
//			boolean ResponseMessageDisplayedFlag=adminAddOrderPage.AddProductTest();
//            System.out.println(ResponseMessageDisplayedFlag);
//            Assert.assertTrue(ResponseMessageDisplayedFlag, "Product addition failed!");
           
        } catch (Exception e) {
            e.printStackTrace();
         //   Assert.fail("Exception occurred: " + e.getMessage());
        }
		}
//	
//
////	@Test
////	public void TC_A5_03_AddButtonAction() {
////	}
////
////	@Test
////	public void TC_A5_04_ValidateProductAdmin() {
////	}
////
////	@Test
////	public void TC_A5_05_ValidateProductUser() {
////	}
////
////	@Test
////	public void TC_A5_06_AddProductInvalid() {
////	}
////
////	@Test
////	public void TC_A5_07_RemoveProduct() {
////	}
////
////	@Test
////	public void TC_A5_08_ValidateRemovedProduct() {
////	}
////
////	@Test
////	public void TC_A5_09_ValidateDeletedOrder() {
////	}
//
////		//TC_LG_002-Verify Admin login with valid username and invalid password.
////		  @Test public void TC_LG_002_InValidPasswordCredentials() { 
////		  
////		   String userName=prop.getProperty("username");
////		   String invalidPassword=prop.getProperty("invalidPassword");
////		   loginpage.btnClick(userName,invalidPassword); 
////		   String  act_Res=loginpage.InvalidCredentials(); System.out.print(act_Res);
////		   exp_Res="Invalid credentials"; //div[@class='oxd-alert oxd-alert--error']
////		   Assert.assertEquals(act_Res, exp_Res);
////		  
////		    
////		  }
////		  //TC_LG_003-Verify login with enter Blank username and valid password.
////		  
////		  @Test public void TC_LG_003_BlankUsernameCredentials() { 
////			  String 	  userName="";  
////			  String 	  password=prop.getProperty("password"); 
////		  exp_Res="Required"; 	 
////		  loginpage.btnClick(userName,password);
////		  System.out.print("blankbuttonclick"); String
////		  act_Res=loginpage.BlankCredentials(); System.out.print(act_Res);
////		  Assert.assertEquals(act_Res, exp_Res);
////		  
////		    
////		  }
//
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
