package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class TC02 {
    public static void test02() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");

            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);


            WebElement SonyPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String SonyPrice = SonyPriceElement.getText();

            Thread.sleep(2000);


            WebElement SonyXperia = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            SonyXperia.click();

            Thread.sleep(2000);


            WebElement SonyXperiaDetailPriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String SonyPriceDetail = SonyXperiaDetailPriceElement.getText();

            Thread.sleep(2000);


            if (SonyPrice.equals( SonyPriceDetail)) {
                System.out.println("Equal Price: " + SonyPriceDetail);
            } else {
                System.out.println("Prices do not equal.");
            }
            Thread.sleep(2000);

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\SWT\\SWT-SeleniumWebdriver\\src\\test\\java\\BAITAP\\test02.png");

            FileUtils.copyFile(srcFile, new File(png));




        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}



