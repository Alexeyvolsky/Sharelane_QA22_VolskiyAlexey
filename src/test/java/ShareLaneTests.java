import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ShareLaneTests {
    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void pozitiveZipCodeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }
    @Test
    public void negativeZipCodeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1946");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }
    @Test
    public void pozitiveSignUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
        firstNameInput.sendKeys("Alexey");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Volskiy");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("volskiy_a@tms.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("123456789");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("123456789");
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();
        WebElement accountIsCreated = driver.findElement(By.cssSelector("[class=confirmation_message]"));
        Assert.assertEquals(accountIsCreated.isDisplayed(),true);
    }
    @Test
    public void negativeSignUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
        firstNameInput.sendKeys("Alexey");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Volskiy");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("volskiy.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("123456789");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("123456789");
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();
        passwordInput = driver.findElement(By.name("password1"));
        Assert.assertEquals(passwordInput.isDisplayed(),false);
        WebElement accountIsCreated = driver.findElement(By.cssSelector("[class=confirmation_message]"));
        Assert.assertEquals(accountIsCreated.isDisplayed(),true);
    }
}
