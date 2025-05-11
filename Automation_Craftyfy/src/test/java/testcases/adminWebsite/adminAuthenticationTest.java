package testcases.adminWebsite;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

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

		try {
			System.out.print("loginBtnClick ");
			String userName = prop.getProperty("AdminWebsiteUsername");
			System.out.print(userName);
			String password = prop.getProperty("AdminWebsitePassword");
			adminAuthPage.loginBtnClick(userName, password);
			String act_Res = adminAuthPage.IsAuthenticated();
			System.out.print(act_Res);
			Assert.assertEquals(act_Res, exp_Res);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}
	@Test
	public void TC_A5_01_usernameDisplayed() {
		try {
			boolean usernameDisplayed = adminAuthPage.usernameDisplayed();

			Assert.assertTrue(usernameDisplayed, "UserName  textbox should be displayed");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}

	}
	@Test
	public void TC_A5_01_passwordDisplayed() {

		try {
			boolean passwordDisplayed = adminAuthPage.passwordDisplayed();

			Assert.assertTrue(passwordDisplayed, "Password textbox should be displayed");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}

	}
	@Test
	public void TC_A5_01_loginButtonDisplayed() {

		try {
			boolean loginDisplayed = adminAuthPage.loginButtonDisplayed();

			Assert.assertTrue(loginDisplayed, "Login button should be displayed");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}

	}
	@Test
	public void TC_A5_01_blankEmailFieldValidation() {
		try {
			
			 String requiredValidationMessage = adminAuthPage.blankEmailFieldValidation();
		        Assert.assertTrue(requiredValidationMessage.contains("Please fill out this field") ||
		                          requiredValidationMessage.contains("required"), "Blank field validation failed!");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}

	}
	@Test
	public void TC_A5_01_emailFieldformatValidation() {
		try {
			 String formatValidationMessage = adminAuthPage.emailFieldformatValidation();
		       Assert.assertTrue(formatValidationMessage.contains("Please include an '@'"),
		                         "Email format validation failed!");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}}
		
		@Test
	public void TC_A5_01_passwordBlankFieldValidation() {
		try {
			
			  String validationMessage = adminAuthPage.passwordBlankFieldValidation();
      Assert.assertTrue(validationMessage.contains("Please fill out this field") ||
         validationMessage.contains("required"), "Blank password field validation failed!");

			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}}
		@Test
	public	void TC_A5_01_InvalidLogin() {
		try {
			String errorText = adminAuthPage.InvalidLogin();

			  // Assert that "Invalid credentials" appears in the error message
		       Assert.assertTrue(errorText.contains("Invalid credentials"), "Error message verification failed!");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred: " + e.getMessage());
		}}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
