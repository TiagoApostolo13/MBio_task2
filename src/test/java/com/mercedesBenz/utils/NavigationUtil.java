package com.mercedesBenz.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationUtil {

    private static String URL = "https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle";

    public NavigationUtil(WebDriver driver){
        this.driver = driver;
    }

    protected WebDriver driver;



    //    Open the Mercedes-Benz Shop used cars in Australian market.
    public void accessTaskPage() throws InterruptedException {
        System.out.println("Open the Mercedes-Benz Shop used cars in Australian market.");
        driver.get(URL);
        //Wait for loader finish
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dcp-loader']")));
        Thread.sleep(7000);
    }






}
