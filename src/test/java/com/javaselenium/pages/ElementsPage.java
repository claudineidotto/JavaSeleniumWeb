package com.javaselenium.pages;

import com.javaselenium.base.PageBase;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ElementsPage extends PageBase {
    By cssButton = By.cssSelector("path");
    By textBoxButton = By.id("item-0");
    By textBoxName = By.id("userName");
    By textBoxEmail = By.id("userEmail");
    By textBoxAddress = By.id("currentAddress");
    By textBoxPermanentAdress= By.id("permanentAddress");
    By submitButton = By.id("submit");
    By textOutputName = By.id("name");
    By errorSignTextBox= By.xpath("//div[@id=\"userEmail-wrapper\"]//input[@class=\"mr-sm-2 field-error form-control\"]");
     public void AcessarElementsPage(){
      click(cssButton);
    }
    public void ValidarElementPage(){
      Assertions.assertEquals("Text Box", getText(textBoxButton));
    }
    public void AcessarTextBox(){
        click(textBoxButton);
    }
    public void PreencherForm(String name,String email, String currentAddress, String permanentAddress){
       sendText(name,textBoxName);
       sendText(email,textBoxEmail);
       sendText(currentAddress,textBoxAddress);
       sendText(permanentAddress,textBoxPermanentAdress);
       click(submitButton);
    }
    public Boolean ValidarOutputError(){
        waitForElement(errorSignTextBox);
        return true;
    }
    public String ValidarOutput(){
        return getText(textOutputName);
    }


}
