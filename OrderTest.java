package testcases.userWebsite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.userWebsite.BaseUser;
import pages.userWebsite.CartPage;
import pages.userWebsite.LoginPage;
import pages.userWebsite.OrderPage;

public class OrderTest extends BaseUser{

OrderPage opage;
LoginPage lpage;
CartPage cpage;
@BeforeClass
public void objinit()
{
	opage= new OrderPage(driver);
}
@BeforeClass
public void objinit1()
{
	lpage= new LoginPage(driver);
}
@BeforeClass
public void objinit2()
{
	cpage= new CartPage(driver);
}

@Test(priority=1)
public void positiveTest()
{
	System.out.println("Manju");
	opage.selectCollection();
	System.out.println("Collection");
	opage.categoryJewellery();
	System.out.println("category");
	opage.selectJewellery();
	
	opage.selectColor();
	
	System.out.println("jewellery");
	opage.addtoCart();
	System.out.println("cart");
	opage.errorMsg();
	lpage.setEmail("testuser1@gmail.com");
	lpage.setPassword("Testuser123*");
	lpage.btnSignIn();
	System.out.println("Signin");
	cpage.selectCart();
	String value=cpage.initialcartValue();
	
	System.out.println(value);
	cpage.addCart();
	System.out.println("outside cart");
	String fvalue=cpage.finalcartValue();
	System.out.println(fvalue);
}

@Test(priority=2)

public void negativeTest()
{
	
	opage.selectCollection();
	opage.categoryHomedecor();
	System.out.println("categoryHomedecor");
	opage.categoryJewellery();
	opage.selectJewellery();
	opage.addtoCart();
	opage.selectColor();
	opage.addtoCart();
	
}

}
