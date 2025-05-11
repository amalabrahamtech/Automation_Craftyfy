package pages.adminWebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class adminAuthentication {
    WebDriver driver;

    public adminAuthentication(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String user) {
        try {
            WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
            userName.sendKeys(user);
        } catch (Exception e) {
            System.out.println("Error setting username: " + e.getMessage());
        }
    }

    public void setPassword(String password) {
        try {
            WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
            Password.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error setting password: " + e.getMessage());
        }
    }

    public boolean usernameDisplayed() {
        try {
            WebElement userName = driver.findElement(By.xpath("//input[@type='email']"));
            return userName.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error checking username display: " + e.getMessage());
            return false;
        }
    }

    public boolean passwordDisplayed() {
        try {
            WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
            return Password.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error checking password display: " + e.getMessage());
            return false;
        }
    }

    public boolean loginButtonDisplayed() {
        try {
            WebElement loginButton = driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']"));
            return loginButton.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error checking login button display: " + e.getMessage());
            return false;
        }
    }

    public void loginBtnClick(String user, String password) {
        try {
            setUsername(user);
            setPassword(password);
            driver.findElement(By.xpath("//button[@class='mt-2 w-full py-2 px-4 rounded-md text-white bg-black']")).click();
        } catch (Exception e) {
            System.out.println("Error clicking login button: " + e.getMessage());
        }
    }

    public String IsAuthenticated() {
        try {
            WebElement landingPageElement = driver.findElement(By.xpath("//p[text()='Add Items']"));
            String elementName = "";
            if (landingPageElement != null) {
                elementName = landingPageElement.getText().toString();
                System.out.print(elementName);
                landingPageElement.click();
            }
            return elementName;
        } catch (Exception e) {
            System.out.println("Error verifying authentication: " + e.getMessage());
            return "";
        }
    }

    public String blankEmailFieldValidation() {
        try {
            WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
            emailField.clear();
            emailField.submit();
            return emailField.getAttribute("validationMessage");
        } catch (Exception e) {
            System.out.println("Error in blank email validation: " + e.getMessage());
            return "";
        }
    }

    public String emailFieldformatValidation() {
        try {
            WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
            emailField.sendKeys("asasd");
            emailField.submit();
            return emailField.getAttribute("validationMessage");
        } catch (Exception e) {
            System.out.println("Error in email format validation: " + e.getMessage());
            return "";
        }
    }

    public String passwordBlankFieldValidation() {
        try {
            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.clear();
            passwordField.submit();
            return passwordField.getAttribute("validationMessage");
        } catch (Exception e) {
            System.out.println("Error in blank password validation: " + e.getMessage());
            return "";
        }
    }

    public String InvalidLogin() {
        try {
          //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));

            emailField.clear();
            emailField.sendKeys("asasd@asd");
            passwordField.clear();
            passwordField.sendKeys("asdsf");

            WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
            loginButton.click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            
            WebElement toastMessage = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--error']"));
            return toastMessage.getText();
        } catch (Exception e) {
            System.out.println("Error verifying invalid login: " + e.getMessage());
            return "";
        }
    }
}
