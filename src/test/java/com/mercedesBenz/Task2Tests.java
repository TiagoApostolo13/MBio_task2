package com.mercedesBenz;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DisplayName(" Validate the negative path of enquiring the highest price at Mercedes-Benz")
public class Task2Tests {

    private WebDriverWait webDriverWait;

    @Test
    public void testTask2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //    Open the Mercedes-Benz Shop used cars in Australian market.
        System.out.println("Open the Mercedes-Benz Shop used cars in Australian market.");
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle");
        //Wait for loader finish
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("dcp-loader") ));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath ("//div[@class='dcp-loader']") ));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]")));
        // wait for cookie banner get ready
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        WebElement elem = driver.findElement(By.xpath("//*[@id='app']/div[1]/cmm-cookie-banner"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);

        WebElement shadowHost = driver.findElement(By.xpath("//*[@id='app']/div[1]/cmm-cookie-banner"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(By.className("button--accept-all"))));
        WebElement shadowContent = shadowRoot.findElement(By.className("button--accept-all"));
        shadowContent.click();


        //On “Please select your location” fill:

        //Your State:  (e.g. 'New South Wales').
        // Open picker
        driver.findElement(By.tagName("wb-select")).click();

        // Select 'New South Wales'
        WebElement selectElement = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("New South Wales");

        //close picker
        driver.findElement(By.tagName("wb-select")).click();

        // Postal Code:  (e.g. '2007').
        driver.findElement(By.tagName("input")).sendKeys("2007");
        // Purpose: Private.
        driver.findElement(By.className("wb-radio-control__indicator")).click();
        Thread.sleep(3000);
        // Click Continue
        System.out.println("Click Continue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/header/div/div[4]/div[1]/div/div[2]/button")));
        driver.findElement(By.xpath("//*[@id='app']/div[1]/header/div/div[4]/div[1]/div/div[2]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Thread.sleep(3000);

        //        Click the filter button (top-left blue button)
        System.out.println("Click the filter button");
        WebElement sidebar = driver.findElement(By.className("sidebar"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sidebar);
        driver.findElement(By.className("filter-toggle")).click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

//        Select the “Pre-Owned” tab:
        System.out.println("apply the following choices:");
        driver.findElement(By.xpath("//span[contains(text(), 'Pre-Owned')]/../../button")).click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

//       Open colour drop:
        //TODO colocar numa funçao a parte o wait do loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath ("//div[@class='dcp-loader']") ));
        System.out.println("colour drop");
        driver.findElement(By.xpath("//p[contains(text(), 'Colour')]/../../../div")).click();
        Thread.sleep(3000);

        //*[@id="app"]/div[1]/main/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div[4]/div[7]/div/div[1]/p
//        Navigate to the Vehicle Details of the most expensive car on the filtered results.
//        Save the following car details to a file:
//        VIN number
//        Model Year
//        In the side vehicle details click “Enquire Now”
//        Fill the “Contact Details and Account Creation” form with invalid data. (e.g. with an invalid email format)
//        Click "Proceed" and validate the error.

        driver.quit();

    }
}

// TODO IMPROVE
//fazer validações
//Separar implementaçao
//colocar logs
//melhorar tempos de execucao no driver (meter mais lento)
// trocar os waits do loader para wait para o elemento esta visivel


