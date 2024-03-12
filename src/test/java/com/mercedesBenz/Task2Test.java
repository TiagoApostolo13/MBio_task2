package com.mercedesBenz;

import com.mercedesBenz.utils.FileUtil;
import com.mercedesBenz.utils.NavigationUtil;
import com.mercedesBenz.pages.CookieBanner;
import com.mercedesBenz.pages.HomePage;
import com.mercedesBenz.pages.LocationModal;
import com.mercedesBenz.pages.VehicleDetail;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@DisplayName(" Validate the negative path of enquiring the highest price at Mercedes-Benz")
public class Task2Test {

    private WebDriver driver;

    public void chooseBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Invalid browser");
        }
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        chooseBrowser(System.getProperty("browser"));
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void task2Test() throws InterruptedException {

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

        //Select specific colour
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

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}



