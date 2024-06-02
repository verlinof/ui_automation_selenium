package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By successMessage = By.xpath("//*[@class='post-title']");
    public void getSuccessMessage() {
        driver.findElement(successMessage).isDisplayed();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
