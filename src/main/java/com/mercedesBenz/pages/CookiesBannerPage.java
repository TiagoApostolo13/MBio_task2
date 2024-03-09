package com.mercedesBenz.pages;

import com.mercedesBenz.utils.NavigationUtil;
import org.openqa.selenium.*;


public class CookiesBannerPage {
static WebDriver driver;


public CookiesBannerPage(WebDriver driver) {
        this.driver=driver;
    }


    public static void clickAgreeButton(){

//        JavascriptExecutor js = (JavascriptExecutor) NavigationUtil.getDriver();
//        WebElement solverButton = (WebElement) js.executeScript("return document.querySelector('cmm-cookie-banner.hydrated').shadowRoot.querySelector('wb7-button.button--accept-all')");
//        solverButton.click();
//        WebElement agreeButton = NavigationUtil.getDriver().findElement(By.cssSelector("button--accept-all"));
//        driver.findElement(By.cssSelector(".alert alert-success"));

//        if (agreeButton.isDisplayed()){
//            agreeButton.click();
//        } else {
//            throw new RuntimeException("Agree button was not found");
//        }
    }
}
