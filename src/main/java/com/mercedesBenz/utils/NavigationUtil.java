package com.mercedesBenz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationUtil {

    private static String URL = "https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle";

    public static WebDriver getDriver() {
        //        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static void openWebsite() {
        getDriver().get(URL);
        getDriver().manage().window().maximize();
    }

    public static void closeDriver(){
        getDriver().close();
    }
}
