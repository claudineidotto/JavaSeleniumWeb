package com.javaselenium.base;
import com.javaselenium.GlobalParameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public static WebDriver INSTANCE = null;
    @BeforeAll
    public static void beforeSuite(){
    new GlobalParameters();
        //   ExtentReportUtils.createReport();
    }

    @BeforeEach
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        INSTANCE = new ChromeDriver();
        INSTANCE.manage().window().maximize();
        INSTANCE.navigate().to("https://demoqa.com/");
    }
    @AfterEach
    public  void afterTest(){
        INSTANCE.quit();
    }
    @AfterAll
    public static void afterSuite(){
     // gerar extent report
    }
}
