package pages.userWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		this.driver=driver;	
	}


	public void selectCollection()
	{
		WebElement collection= driver.findElement(By.xpath("//a[p[contains(text(), 'COLLECTION')]]"));
				
				//cssSelector("a[href='/collection'].active[data-discover='true']\"));\r\n"
				//+ "\r\n);
				
		collection.click();
	}
public void selectBall()
{
	WebElement ball= driver.findElement(By.xpath("//img[@src=\"https://res.cloudinary.com/dvphv3ndw/image/upload/v1745303975/v2ntfysjpupxsdvf5agb.jpg\"]"));
	ball.click();
}

public void selectJewellery()
{
	WebElement jewellery= driver.findElement(By.xpath("//div[img[@class=\"hover:scale-110 transition ease-in-out\"]]"));
jewellery.click();
}
public void selectJewellery2()
{
	WebElement jewellery2= driver.findElement(By.xpath("//img[@src=\"https://res.cloudinary.com/dvphv3ndw/image/upload/v1744042084/uospplzmoqrgmr8shqie.webp\"]"));
jewellery2.click();
}
public void categoryHomedecor()
{
	WebElement chboxhmdecor= driver.findElement(By.xpath("//input[@value=\"HomeDecor\"]"));
	chboxhmdecor.click();
	System.out.println("No items in home decor");
	}
public void categoryJewellery()
{
	WebElement chboxjewel= driver.findElement(By.xpath("//input[@value=\"Jewellery\"]"));
	chboxjewel.click();
	}
public void selectColor()
{
	WebElement color= driver.findElement(By.xpath("//button[@class='border py-2 px-4 bg-gray-100 ']"));
	color.click();
}

public String errorColor()
{
	WebElement errorcol=driver.findElement(By.xpath("//section[@class=\"Toastify\"]"));
			//+ "
			//	+ //"//div[@class='Toastify__toast Toastify__toast-theme--light Toastify__toast--error']"));
			
			String errorcolor= errorcol.getText().toString();
			
			return errorcolor;
}


public void addtoCart()
{
	WebElement cart= driver.findElement(By.xpath("//button[@class='bg-black text-white px-8 py-3 text-sm active:bg-gray-700']"));
	cart.click();
	
}
public String errorMsg()
{
	WebElement error=driver.findElement(By.xpath("//section[@class='Toastify']"));
			//+ "class="Toastify__toast--error")]"));
			// "//and contains(text(), 'Please login to add items to the cart.')]\"));
			String errormessage= error.getText().toString();
			//System.out.println(errormessage);
			return errormessage;
}
}