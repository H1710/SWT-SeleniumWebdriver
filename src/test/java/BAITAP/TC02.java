package BAITAP;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class TC02 {
    public static void tc02() {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        try {
            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // 2. Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 3. Read the cost of Sony Xperia mobile (which is $100)
            WebElement sonyXperiaPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String sonyXperiaPrice = sonyXperiaPriceElement.getText();

            // 4. Click on Sony Xperia mobile
            WebElement sonyXperiaLink = driver.findElement(By.xpath("//img[@id='product-collection-image-1']"));
            sonyXperiaLink.click();

            // 5. Read the Sony Xperia mobile from the detail page
            WebElement sonyXperiaDetailPriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String sonyXperiaDetailPrice = sonyXperiaDetailPriceElement.getText();

            // 6. Compare Product value in list and details page should be equal ($100)
            if (sonyXperiaPrice.equals(sonyXperiaDetailPrice)) {
                System.out.println("Prices match: " + sonyXperiaPrice);
            } else {
                System.out.println("Prices do not match");
            }
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("E:\\SWT\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\imageTC2.pgn"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
            driver.quit();
        }
    }

}
