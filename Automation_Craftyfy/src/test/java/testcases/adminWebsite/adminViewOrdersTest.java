package testcases.adminWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import base.base;

import java.time.Duration;
import java.util.List;

public class adminViewOrdersTest extends base{
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://craftyfy-admin.vercel.app/"); // Update with your orders page URL
        WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
		 //System.out.print(user);
		userName.sendKeys("admin@example.com");
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("greatstack123");
		driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
		System.out.print("btnclick done");
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     	WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='Orders']"));
		String elementName = "";
		if (landingPageElement != null) {
			elementName = landingPageElement.getText().toString();
			System.out.print(elementName);
			landingPageElement.click();
			System.out.print("clicked");
		}
    }

    @Test
    public void verifyUserCanViewOrder() {
        // Locate the order block div
        WebElement orderDiv = driver.findElement(By.cssSelector("div.grid.grid-cols-1"));

        // ✅ Verify Product List is displayed
        List<WebElement> productList = orderDiv.findElements(By.cssSelector("div > div > p.py-0\\.5"));
        Assert.assertTrue(productList.size() > 0, "Product list should not be empty");

        // ✅ Verify Customer name is displayed
        WebElement customerName = orderDiv.findElement(By.cssSelector("p.font-medium"));
        Assert.assertTrue(customerName.isDisplayed(), "Customer name should be displayed");

        // ✅ Verify Items count is displayed
        WebElement itemsCount = orderDiv.findElement(By.xpath(".//p[contains(text(), 'Items')]"));
        Assert.assertTrue(itemsCount.isDisplayed(), "Items count should be displayed");

        // ✅ Verify Payment method
        WebElement paymentMethod = orderDiv.findElement(By.xpath(".//p[contains(text(), 'Method')]"));
        Assert.assertTrue(paymentMethod.isDisplayed(), "Payment method should be displayed");

        // ✅ Verify Payment status
        WebElement paymentStatus = orderDiv.findElement(By.xpath(".//p[contains(text(), 'Payment')]"));
        Assert.assertTrue(paymentStatus.isDisplayed(), "Payment status should be displayed");

        // ✅ Verify Date
        WebElement dateElement = orderDiv.findElement(By.xpath(".//p[contains(text(), 'Date')]"));
        Assert.assertTrue(dateElement.isDisplayed(), "Date should be displayed");

        // ✅ Verify Price
        WebElement priceElement = orderDiv.findElement(By.xpath(".//p[contains(text(), '$')]"));
        Assert.assertTrue(priceElement.isDisplayed(), "Price should be displayed");

        // ✅ Verify Status Dropdown options
        WebElement statusDropdown = orderDiv.findElement(By.tagName("select"));
        List<WebElement> options = statusDropdown.findElements(By.tagName("option"));
        Assert.assertEquals(options.size(), 5, "Status dropdown should have 5 options");

        // ✅ Optional: Verify specific option exists
        boolean deliveredOptionExists = options.stream()
                .anyMatch(opt -> opt.getText().equals("Delivered"));
        Assert.assertTrue(deliveredOptionExists, "Delivered option should be present");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
