package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;

    void setupChromeDriver() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("https://storage.googleapis.com/chrome-for-testing-public/125.0.6422.141/win64/chrome-win64.zip", "https://storage.googleapis.com/chrome-for-testing-public/125.0.6422.141/win64/chrome-win64.zip");
        driver = new ChromeDriver();  // Initialize the WebDriver
        driver.manage().window().maximize();
    }

    @Given("User is on the login page")
    public void navigateToLoginPage() {
        setupChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User submit valid credentials")
    public void submitValidCredentials() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void loginSuccessful() throws InterruptedException {
        HomePage home = new HomePage(driver);
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, home.getUrl());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
