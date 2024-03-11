package com.mercedesBenz.pages;

import com.mercedesBenz.utils.NavigationUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookieBanner extends NavigationUtil {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    private By cookieBannerLocator = By.xpath("//*[@id='app']/div[1]/cmm-cookie-banner");
    private By acceptAllButtonLocator = By.className("button--accept-all");

    public CookieBanner(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies(){
        // wait for cookie banner get ready
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(cookieBannerLocator));

        // Find agree all button bellow shadow and click
        WebElement shadowHost = driver.findElement(cookieBannerLocator);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(acceptAllButtonLocator)));
        WebElement shadowContent = shadowRoot.findElement(acceptAllButtonLocator);
        shadowContent.click();
    }
}
