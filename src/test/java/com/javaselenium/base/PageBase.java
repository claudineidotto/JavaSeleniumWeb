package com.javaselenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.javaselenium.base.TestBase.INSTANCE;

public class PageBase {

    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    protected JavascriptExecutor javaScriptExecutor = null;
    public static int TIMEOUT_DEFAULT;
    public PageBase(){
        TIMEOUT_DEFAULT = Integer.parseInt("1");
        wait = new WebDriverWait(INSTANCE,TIMEOUT_DEFAULT);
        driver = INSTANCE;
        javaScriptExecutor = (JavascriptExecutor) driver;
    }

    protected WebElement waitForElement(By locator){
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    private void waitUntilPageReady(){
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= 5)
        {
            String documentState = javaScriptExecutor.executeScript("return document.readyState").toString();
            if (documentState.equals("complete")){
                timeOut.stop();
                break;
            }
        }
    }
    protected String getText(By locator){
        String text = waitForElement(locator).getText();
      //  ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        return text;
    }
    protected String getClassValue(By locator){
        String classValue = waitForElement(locator).getTagName().getClass().toString();        //  ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        return classValue;
    }
    protected void  click (By locator){
        waitForElement(locator).click();
    }
    protected void sendText(String text,By locator){
        waitForElement(locator).sendKeys(text);
    }

}
