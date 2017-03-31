package com.tkmdpa.taf.steps;

import com.tkmdpa.taf.pages.AnyPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class AnyPageSteps {

    AnyPage anyPage;

    @Step
    public void checkIfPageIsOpened(String url, String xpath, String defaultUrl){

        if (url.contains("{url}")) {
            assertEquals(anyPage.returnCurrentUrl(), url.replace("{url}", defaultUrl));}
        else {
            anyPage.waitFor(ExpectedConditions.urlContains(url));
            assertEquals(url, anyPage.returnCurrentUrl());
        }

        anyPage.keyPageElementIsVisible(xpath);
    }

    @Step
    public void clearCookiesAndLocalStorage(){
        anyPage.getDriver().manage().deleteAllCookies();
        anyPage.evaluateJavascript("window.localStorage.clear();");
    }

    @Step
    public void quitBrowser(){
        anyPage.getDriver().quit();
    }
}
