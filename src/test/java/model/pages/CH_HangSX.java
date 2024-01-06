package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CH_HangSX {
    private WebDriver driver;

    private By usernameSelector = By.id("userName");
    private By passwordSelector = By.id("password");
    private By loginBtn = By.xpath("//span[contains(text(),'Đăng nhập')]");
    private By HangSX = By.xpath("//span[contains(text(),'CH Hãng sản xuất')]");
    public CH_HangSX(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement username() {
        return driver.findElement(usernameSelector);
    }

    public WebElement password() {
        return driver.findElement(passwordSelector);
    }

    public void inputUsername(String username) {
        username().sendKeys(username);
    }

    public void clickLoginBtn() {
        WebElement loginButtonElement = driver.findElement(loginBtn);
        loginButtonElement.click();
    }

    public void clickHangSX() {
        WebElement loginButtonElement = driver.findElement(HangSX);
        loginButtonElement.click();
    }
    public void inputPassword(String password) {
        password().sendKeys(password);
    }

    public void clickOnLoginBtn() {
        clickLoginBtn();
    }

    public void clickOnHangSX() {
        clickHangSX();
    }
    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        });
    }


    public By getHangSX() {
        return HangSX;
    }
}
