package testcases.adminWebsite;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
import pages.adminWebsite.adminAuthentication;


public class adminAuthenticationTest extends base {
	 adminAuthentication adminAuthPage;
	String exp_Res = "Add Items";

	@BeforeMethod
	public void initObj() {
		adminAuthPage = new adminAuthentication(driver);
	}

	// TC_A5_01-Verify Admin can login using valid username and Password.
	@Test
	public void TC_A5_01_Adminlogin() {
		System.out.print("loginBtnClick "); 
		String userName = prop.getProperty("AdminWebsiteUsername");
		System.out.print(userName);
		String password = prop.getProperty("AdminWebsitePassword");
		adminAuthPage.loginBtnClick(userName, password);
		String act_Res = adminAuthPage.IsAuthenticated();
		System.out.print(act_Res);
		Assert.assertEquals(act_Res, exp_Res);

	}

//	@Test
//	public void TC_A5_02_AddItemsScreen() {
//		try {
//			
//			
//          //  Assert.assertTrue(responseBody.contains("\"success\":true"), "Success field is not true");
//           // Assert.assertTrue(responseBody.contains("\"message\":\"Product Added\""), "Message is not 'Product Added'");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail("Exception occurred: " + e.getMessage());
//        }
//		}
//	

//	@Test
//	public void TC_A5_03_AddButtonAction() {
//	}
//
//	@Test
//	public void TC_A5_04_ValidateProductAdmin() {
//	}
//
//	@Test
//	public void TC_A5_05_ValidateProductUser() {
//	}
//
//	@Test
//	public void TC_A5_06_AddProductInvalid() {
//	}
//
//	@Test
//	public void TC_A5_07_RemoveProduct() {
//	}
//
//	@Test
//	public void TC_A5_08_ValidateRemovedProduct() {
//	}
//


	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
