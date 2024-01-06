package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CH_NhaSX {
    private WebDriver driver;

    private By usernameSelector = By.id("userName");
    private By passwordSelector = By.id("password");
    private By loginBtn = By.xpath("//span[contains(text(),'Đăng nhập')]");
    private By Cauhinh = By.xpath("//li[@class='ant-menu-submenu ant-menu-submenu-inline ant-menu-submenu-active']//div[@role='menuitem']");
    private By NuocSX = By.xpath("//span[contains(text(),'CH Nước sản xuất')]");
    public CH_NhaSX(WebDriver driver) {
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
    public void clickCauhinh() {
        WebElement loginButtonElement = driver.findElement(Cauhinh);
        loginButtonElement.click();
    }

    public void clickNhaSX() {
        WebElement loginButtonElement = driver.findElement(NuocSX);
        loginButtonElement.click();
    }
    public void inputPassword(String password) {
        password().sendKeys(password);
    }

    public void clickOnLoginBtn() {
        clickLoginBtn();
    }
    public void clickOnCauhinh() {
        clickCauhinh();
    }

    public void clickOnNhaSX() {
        clickNhaSX();
    }
    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        });
    }
    public By getCauhinh() {
        return Cauhinh;
    }

    public By getNuocSX() {
        return NuocSX;
    }
}
