package com.javaselenium.tests;

import com.javaselenium.base.TestBase;
import com.javaselenium.pages.ElementsPage;
import com.javaselenium.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTests extends TestBase {
    MainPage mainPage;
    ElementsPage elementsPage;
    @Test
    public void AcessarPaginaPrincipal() {
        mainPage = new MainPage();
        mainPage.validarPagina();
    }
    @Test
    public void AcessarElementsPage() {
        elementsPage = new ElementsPage();
        elementsPage.AcessarElementsPage();
        elementsPage.ValidarElementPage();
    }

    @Test
    public void PreencherForm() {
        String name="Jorge";

        elementsPage = new ElementsPage();
        elementsPage.AcessarElementsPage();
        elementsPage.ValidarElementPage();
        elementsPage.AcessarTextBox();
        elementsPage.PreencherForm(name,"jorge@gmail.com","Rua Pirapora","Rua Piripimpa");

        Assertions.assertEquals("Name:"+name,elementsPage.ValidarOutput());
    }

}


