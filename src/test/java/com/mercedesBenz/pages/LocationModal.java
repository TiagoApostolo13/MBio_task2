package com.mercedesBenz.pages;

import com.mercedesBenz.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocationModal extends NavigationUtil {

    private By dropdownSelectorLocator = By.tagName("wb-select");
    private By postalCodeInputLocator = By.tagName("input");
    private By checkBoxLocator = By.className("wb-radio-control__indicator");

    public LocationModal(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    public void selectStateDropdown(String option){
         driver.findElement(dropdownSelectorLocator).click();
         // Select 'New South Wales'
         WebElement selectElement = driver.findElement(By.tagName("select"));
         Select select = new Select(selectElement);
         select.selectByVisibleText(option);

         //close "Your state" dropdown
         driver.findElement(dropdownSelectorLocator).click();
     }

    public void insertPostalCode(String option){
        driver.findElement(postalCodeInputLocator).sendKeys(option);
    }

    public void selectCheckBox(){
        driver.findElement(checkBoxLocator).click();
    }


    public void clickContinue() throws InterruptedException {
        System.out.println("Click Continue");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='app']/div[1]/header/div/div[4]/div[1]/div/div[2]/button"));
        wait.until(d -> continueButton.isDisplayed());
        continueButton.click();

        Thread.sleep(3000);
    }


}
