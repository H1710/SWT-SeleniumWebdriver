package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
@Test
public class TC01 {
    public static void test01() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");
            String demo = driver.findElement(By.cssSelector("h2")).getText();
            System.out.println(demo);
            try {
                AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", demo);


            } catch (Error e) {
                e.printStackTrace();
            }


            Thread.sleep(2000);

            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);
            new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
            Thread.sleep(2000);


            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\SWT\\SWT-SeleniumWebdriver\\src\\test\\java\\BAITAP\\test01.png");

            FileUtils.copyFile(srcFile, new File(png));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}