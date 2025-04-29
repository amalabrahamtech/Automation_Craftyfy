package testcases.adminWebsite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pages.adminWebsite.*;
import base.base;


	public class adminOrderTest extends base{
		adminOrder loginpage;
		//String exp_Res="Dashboard";
		
	@BeforeMethod
	public void initObj() {
		loginpage=new adminOrder(driver);
		}
	//TC_LG_001-Verify Admin can login using valid username and Password.	
	 @Test 
	 public  void TC_A5_01_Adminlogin() {
//			  
		String userName=prop.getProperty("AdminWebsiteUsername");
		 System.out.print(userName);
		String password=prop.getProperty("AdminWebsitePassword");
		 System.out.print(password);
	    loginpage.btnClick(userName,password);
			
	//	String act_Res=loginpage.dashboardPage();
			
	    //Assert.assertEquals(act_Res, exp_Res);
			
		}

//		//TC_LG_002-Verify Admin login with valid username and invalid password.
//		  @Test public void TC_LG_002_InValidPasswordCredentials() { 
//		  
//		   String userName=prop.getProperty("username");
//		   String invalidPassword=prop.getProperty("invalidPassword");
//		   loginpage.btnClick(userName,invalidPassword); 
//		   String  act_Res=loginpage.InvalidCredentials(); System.out.print(act_Res);
//		   exp_Res="Invalid credentials"; //div[@class='oxd-alert oxd-alert--error']
//		   Assert.assertEquals(act_Res, exp_Res);
//		  
//		    
//		  }
//		  //TC_LG_003-Verify login with enter Blank username and valid password.
//		  
//		  @Test public void TC_LG_003_BlankUsernameCredentials() { 
//			  String 	  userName="";  
//			  String 	  password=prop.getProperty("password"); 
//		  exp_Res="Required"; 	 
//		  loginpage.btnClick(userName,password);
//		  System.out.print("blankbuttonclick"); String
//		  act_Res=loginpage.BlankCredentials(); System.out.print(act_Res);
//		  Assert.assertEquals(act_Res, exp_Res);
//		  
//		    
//		  }
		 
	
	@AfterMethod
	 public void tearDown() {
	     if (driver != null) {
	         driver.quit();
	     }
	 }

	}
	






