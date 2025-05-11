package pages.adminWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class adminAddProduct {
	WebDriver driver;

	public adminAddProduct(WebDriver driver) {

		this.driver = driver;
	}

	public boolean AddProductTest() {
		try {
			System.out.println("AddProductTest!");
			// AdminWebsiteUsername=admin@example.com
			// AdminWebsitePassword=greatstack123
			WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
			// System.out.print(user);
			userName.sendKeys("admin@example.com");
			WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
			Password.sendKeys("greatstack123");
			driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']"))
					.click();
			System.out.print("btnclick done");
			WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='Add Items']"));
			String elementName = "";
			if (landingPageElement != null) {
				elementName = landingPageElement.getText().toString();
				System.out.print(elementName);
				landingPageElement.click();
				System.out.print("clicked");
			}
			// Locate elements using XPath
			WebElement productName = driver.findElement(By.xpath("//input[@placeholder='Type here']"));
			WebElement productDescription = driver
					.findElement(By.xpath("//textarea[@placeholder='Write content here']"));
			WebElement prodCatdropdownElement = driver.findElement(By.xpath("//select[@class='w-full px-3 py-2']"));

			// Use Select class to choose an option
			Select prodCatdropdown = new Select(prodCatdropdownElement);
			prodCatdropdown.selectByValue("HomeDecor"); //

			// WebElement productCategory =
			// driver.findElement(By.xpath("//select[@class='w-full px-3
			// py-2']/option[@value='HomeDecor']"));
			// WebElement subCategory = driver.findElement(By.xpath("//select[@class='w-full
			// px-3 py-2']/option[@value='ClayItems']"));

			WebElement subCatdropdownElement = driver
					.findElement(By.xpath("//div[p[contains(text(),'Sub category')]]/select"));

			// Use Select class to choose an option
			Select subCatdropdown = new Select(subCatdropdownElement);
			subCatdropdown.selectByValue("ClayItems"); //

			WebElement productPrice = driver.findElement(By.xpath("//input[@placeholder='25']"));
			WebElement productColor = driver.findElement(By.xpath("//p[contains(text(), 'Green')]"));
			WebElement addToBestseller = driver.findElement(By.xpath("//input[@id='bestseller']"));
			WebElement addButton = driver.findElement(By.xpath("//button[text()='ADD']"));

			// Assign values
			productName.sendKeys("Handmade Vase");
			productDescription.sendKeys("Beautiful handcrafted vase for home decor.");
			// productCategory.sendKeys("HomeDecor");
			// subCategory.sendKeys("ClayItems");
			productPrice.sendKeys("250");
			productColor.click(); // Select product color
			addToBestseller.click(); // Select Bestseller checkbox

			// Click Add Button
			addButton.click();
			System.out.println("Toast Message:start ");
			// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Wait for toast notification to appear
			WebElement toastMessage = driver.findElement(
					By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--light Toastify__toast--success']"));
			// wait.until(ExpectedConditions.visibilityOfElementLocated(

			// Capture the text
			String toastText = toastMessage.getText();
			System.out.println("Toast Message: " + toastText);
			// Verify Response
			WebElement responseMessage = driver.findElement(By.xpath("//div[contains(text(), 'Product Added')]"));
			System.out.println("Toast Message: " + responseMessage.getText());
			return true;
			// Assert.assertTrue(responseMessage.isDisplayed(), "Product addition failed!");
			//
			// System.out.println("Product added successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean productnameDisplayed() {

		try {
			boolean productName = driver.findElement(By.xpath("//p[text()='Product name']/following-sibling::input"))
					.isDisplayed();
			return productName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// Product Name input
		// Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Product
		// name']/following-sibling::input")).isDisplayed(), "Product Name is not
		// displayed");

	}

	public boolean productDescriptionDisplayed() {
		try {
			// Product Description textarea
			boolean prodDescription = driver
					.findElement(By.xpath("//p[text()='Product description']/following-sibling::textarea"))
					.isDisplayed();
			// Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Product
			// description']/following-sibling::textarea")).isDisplayed(), "Product
			// Description is not displayed");
			return prodDescription;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean productCategoryDisplayed() {
		try {
			// Category select
			boolean catSelect = driver.findElement(By.xpath("//p[text()='Product category']/following-sibling::select"))
					.isDisplayed();
			// Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Product
			// category']/following-sibling::select")).isDisplayed(), "Category is not
			// displayed");
			return catSelect;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean subCategoryDisplayed() {
		// Subcategory select

		try {
			boolean subCategory = driver.findElement(By.xpath("//p[text()='Sub category']/following-sibling::select"))
					.isDisplayed();
			// Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Sub
			// category']/following-sibling::select")).isDisplayed(), "Sub Category is not
			// displayed");
			return subCategory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean priceDisplayed() {
		try {
			// Price input
			boolean priceInput = driver.findElement(By.xpath("//p[text()='Product Price']/following-sibling::input"))
					.isDisplayed();
			// Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Product
			// Price']/following-sibling::input")).isDisplayed(), "Price is not displayed");
			return priceInput;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean categoryOptionsDisplayed() {

		List<WebElement> categoryOptions = driver
				.findElements(By.xpath("//p[text()='Product category']/following-sibling::select/option"));
		return categoryOptions.size() > 0;
	}

	public boolean subCategoryOptionsDisplayed() {
		try {
			List<WebElement> subCategoryOptions = driver
					.findElements(By.xpath("//p[text()='Sub category']/following-sibling::select/option"));
			return subCategoryOptions.size() > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean productNameRequiredFieldValidation() {
		driver.findElement(By.xpath("//button[text()='ADD']")).click();

		WebElement productNameInput = driver
				.findElement(By.xpath("//p[text()='Product name']/following-sibling::input"));
		@SuppressWarnings("deprecation")
		String nameValidationMessage = productNameInput.getAttribute("validationMessage");

		return nameValidationMessage.length() > 0;

	}

	public boolean productDescriptionRequiredFieldValidation() {
		try {
			driver.findElement(By.xpath("//button[text()='ADD']")).click();

			WebElement descTextarea = driver
					.findElement(By.xpath("//p[text()='Product description']/following-sibling::textarea"));
			String descValidationMessage = descTextarea.getAttribute("validationMessage");
			Assert.assertTrue(descValidationMessage.length() > 0,
					"Validation message for Product Description is not displayed");
			return descValidationMessage.length() > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean emptyPriceScenario() {
		try {
			// Scenario 2: Try with empty price
			WebElement nameInput = driver.findElement(By.xpath("//p[text()='Product name']/following-sibling::input"));
			WebElement descTextarea = driver
					.findElement(By.xpath("//p[text()='Product description']/following-sibling::textarea"));
			WebElement categorySelect = driver
					.findElement(By.xpath("//p[text()='Product category']/following-sibling::select"));
			WebElement subCategorySelect = driver
					.findElement(By.xpath("//p[text()='Sub category']/following-sibling::select"));
			WebElement priceInput = driver
					.findElement(By.xpath("//p[text()='Product Price']/following-sibling::input"));

			// Clear and fill valid data
			nameInput.clear();
			nameInput.sendKeys("Test Product 1");
			descTextarea.clear();
			descTextarea.sendKeys("This is a valid product description.");
			categorySelect.findElement(By.xpath(".//option[@value='HomeDecor']")).click();
			subCategorySelect.findElement(By.xpath(".//option[@value='ClayItems']")).click();
			priceInput.clear();
			driver.findElement(By.xpath("//button[text()='ADD']")).click();
			String priceValidation = priceInput.getAttribute("validationMessage");

			return priceValidation.length() > 0;
			// Assert.assertTrue(priceValidation.length() > 0, "Validation message for Price
			// is not displayed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean emptyProductNameScenario() {

		try {
			WebElement nameInput = driver.findElement(By.xpath("//p[text()='Product name']/following-sibling::input"));
			WebElement descTextarea = driver
					.findElement(By.xpath("//p[text()='Product description']/following-sibling::textarea"));
			WebElement categorySelect = driver
					.findElement(By.xpath("//p[text()='Product category']/following-sibling::select"));
			WebElement subCategorySelect = driver
					.findElement(By.xpath("//p[text()='Sub category']/following-sibling::select"));
			WebElement priceInput = driver
					.findElement(By.xpath("//p[text()='Product Price']/following-sibling::input"));
			// Clear and fill valid data
			nameInput.clear();
			nameInput.sendKeys("Test Product 1");
			descTextarea.clear();
			descTextarea.sendKeys("This is a valid product description.");
			categorySelect.findElement(By.xpath(".//option[@value='HomeDecor']")).click();
			subCategorySelect.findElement(By.xpath(".//option[@value='ClayItems']")).click();
			priceInput.clear();
			priceInput.sendKeys("100");
			// Scenario 3: Try with blank name
			nameInput.clear();
			driver.findElement(By.xpath("//button[text()='ADD']")).click();
			String nameValidation = nameInput.getAttribute("validationMessage");
			return nameValidation.length() > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean emptyProdDescriptionScenario() {
		try {
			// Scenario 4: Try with blank description

			WebElement nameInput = driver.findElement(By.xpath("//p[text()='Product name']/following-sibling::input"));
			WebElement descTextarea = driver
					.findElement(By.xpath("//p[text()='Product description']/following-sibling::textarea"));
			WebElement categorySelect = driver
					.findElement(By.xpath("//p[text()='Product category']/following-sibling::select"));
			WebElement subCategorySelect = driver
					.findElement(By.xpath("//p[text()='Sub category']/following-sibling::select"));
			WebElement priceInput = driver
					.findElement(By.xpath("//p[text()='Product Price']/following-sibling::input"));
			nameInput.clear();
			nameInput.sendKeys("Test Product 1");
			descTextarea.clear();
			descTextarea.sendKeys("This is a valid product description.");
			categorySelect.findElement(By.xpath(".//option[@value='HomeDecor']")).click();
			subCategorySelect.findElement(By.xpath(".//option[@value='ClayItems']")).click();
			priceInput.clear();
			priceInput.sendKeys("100");

			descTextarea.clear();
			driver.findElement(By.xpath("//button[text()='ADD']")).click();
			String descValidation = descTextarea.getAttribute("validationMessage");
			return descValidation.length() > 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
