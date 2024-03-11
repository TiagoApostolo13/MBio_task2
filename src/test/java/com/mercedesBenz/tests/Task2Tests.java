package com.mercedesBenz.tests;

import com.mercedesBenz.FileUtil;
import com.mercedesBenz.NavigationUtil;
import com.mercedesBenz.pages.CookieBanner;
import com.mercedesBenz.pages.HomePage;
import com.mercedesBenz.pages.LocationModal;
import com.mercedesBenz.pages.VehicleDetail;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

@DisplayName(" Validate the negative path of enquiring the highest price at Mercedes-Benz")
public class Task2Tests {


    @Test
    public void testTask2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //    Open the Mercedes-Benz Shop used cars in Australian market.
        NavigationUtil navigation = new NavigationUtil(driver);
        navigation.accessTaskPage();

        // Accept cookies
        CookieBanner cookieBannerPage = new CookieBanner(driver);
        cookieBannerPage.acceptCookies();

        // Select State
        LocationModal locationModal = new LocationModal(driver);
        locationModal.selectStateDropdown("New South Wales");
        locationModal.insertPostalCode("2007");

        // Select checkbox Private
        locationModal.selectCheckBox();

        //Click Continue
        locationModal.clickContinue();

        //
        HomePage homePage = new HomePage(driver);
        homePage.openFilter();
        homePage.selectTab();
        homePage.selectColour();

        Thread.sleep(3000);

        homePage.selectByPriceDescending();

        // Navigate to the Vehicle Details of the most expensive car on the filtered results.
        homePage.selectMostExpensiveCar();

        // Save car details to a file:
        FileUtil fileUtil = new FileUtil(driver);
        fileUtil.saveToFile();

        VehicleDetail vehicleDetail = new VehicleDetail(driver);
        vehicleDetail.clickEnquireNowButton();
        vehicleDetail.fillEmailInput();
        vehicleDetail.clickProceedButton();
        vehicleDetail.getErrorMessage();


        Thread.sleep(10000);
        driver.quit();

    }
}

// TODO IMPROVE
//fazer validações

//colocar logs
//melhorar tempos de execucao no driver (meter mais lento) - rever thread.sleep()
// trocar os waits do loader para wait para o elemento esta visivel


