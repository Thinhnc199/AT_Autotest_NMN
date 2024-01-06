
package test;

import org.testng.annotations.Test;
import driver.driverFactory;
import model.pages.CH_NhaSX;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
@Test
public class Test_CH_NhaSX {
    public static void testLoginPage() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://nmn-staging.amazingtech.vn/");

        CH_NhaSX loginPage = new CH_NhaSX(driver);

        loginPage.inputUsername("admin");
        loginPage.inputPassword("12345678");
        loginPage.clickOnLoginBtn();
        loginPage.waitForPageLoad();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getNuocSX()));
            loginPage.clickOnNhaSX();

            captureScreenshot(driver, "Display_NuocSX");
        } catch (TimeoutException e) {
            // Handle TimeoutException or log the exception
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void captureScreenshot(WebDriver driver, String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotLocation = "./src/screenshot/" + fileName + ".png";
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotLocation));
            System.out.println("Screenshot captured and saved to: " + screenshotLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


