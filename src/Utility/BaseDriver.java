package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.time.Duration;

public class BaseDriver {
    public static Logger adLog = LogManager.getLogger();
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Robot robot;

    @BeforeClass
    public void initialOperations() throws AWTException {
        // System.out.println("Başlangıç işlemleri yapılıyor");

        driver = new ChromeDriver();


        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // 20 sn mühlet: sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        robot = new Robot();
    }

    @AfterClass
    public void closingOperations() {
        // System.out.println("Kapanis işlemleri yapılıyor");

        Tools.wait(3);
        driver.quit();
    }

    @BeforeMethod
    public void BeforeMethod() {
        adLog.info("The method started working");
    }

    @AfterMethod
    public void AfterMethod(ITestResult result) {
        adLog.info(result.getName() + " Method work complete");
        adLog.info(result.getStatus() == 1 ? "Passed" : "Failed");
    }


}
