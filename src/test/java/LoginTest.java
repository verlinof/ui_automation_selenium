import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    @Test
    public void loginTC1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\marim\\Documents\\Kuliah\\Semester 4\\Praktikum pengujian perangkat lunak\\driver_automation_testing\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);

        // Login to the Web
        login.enterUsername("student");
        login.enterPassword("Password123");
        login.clickLogin();

        // Verifying the URL
        home.getSuccessMessage();
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(expectedUrl, home.getUrl());

        driver.quit();
    }
}
