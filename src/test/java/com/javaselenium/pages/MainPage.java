package com.javaselenium.pages;

import com.javaselenium.base.PageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainPage extends PageBase {
    By logoBox = By.id("app");

    public void validarPagina(){
       Assertions.assertNotNull(waitForElement(logoBox));
    }



}
