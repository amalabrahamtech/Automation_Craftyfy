
package pages.adminWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminOrder {

//	
//
//WebDriver driver;
//	
//
//	public adminOrder(WebDriver driver) 
//	{
//		
//		this.driver=driver;
//	}
//
//public void setUsername(String user) {
//	
//	WebElement userName=driver.findElement(By.xpath("//input[@class='rounded-md w-full px-3 py-2 border border-gray-300 outline-none']"));
//	
//	
//	//[@class='rounded-md w-full px-3 py-2 border border-gray-300 outline-none']
//	userName.sendKeys(user);
//}
//public void setPassword(String password) {
//	
//	
//	WebElement Password=driver.findElement(By.xpath("//input[@class='rounded-md w-full px-3 py-2 border border-gray-300 outline-none']"));
//	
//	Password.sendKeys(password);
//	
//	}
//
//
////Login Button click 
//public void btnClick(String user,String password) {
//	WebElement userName=driver.findElement(By.xpath("//input[@type='email']"));
//	System.out.print(user);
//	userName.sendKeys(user);
//	WebElement Password=driver.findElement(By.xpath("//input[@type='password']"));
//	
//	Password.sendKeys(password);
//	driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
//	System.out.print("btnclick done");
//}
//
////verifying landing page after login
//  public String dashboardPage() { 
//	
//	 // List<WebElement> elements = driver.findElements(By.xpath("//p[text()='Add Items']"));
//	//p[@class='hidden md:block' and text()='Add Items']
//	  
//	 // checkbox=//input[@id='bestseller']
//	    //if (elements.size() > 0) 
// WebElement  Dashboard=driver.findElement(By.xpath("//p[text()='Add Items']"));
// String Dashboardname="";    
// if(Dashboard!=null) {
//   Dashboardname =Dashboard.getText().toString();
//  System.out.print(Dashboardname);}
//  return Dashboardname;
//  
//  
//  }
//  
//  
//  // Find all clickable paragraph elements
// 
// 
//////invalid credential test
////  public String InvalidCredentials() {
////	  
////	  WebElement  Error =driver.findElement(By.xpath("//p[@Class='oxd-text oxd-text--p oxd-alert-content-text']"));
////	  String errortext =Error.getText().toString();
////	 // System.out.print(Error);
////	  return errortext;
////	  		
////	}
////  //blank credential login test
////public String BlankCredentials() {
////	  
////	  WebElement  Error =driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
////
////	  String errortext =Error.getText().toString();
////	 // System.out.print(Error);
////	  return errortext;
////	  		
////	}


}
