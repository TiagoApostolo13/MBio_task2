package com.mercedesBenz.pages;

import com.mercedesBenz.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehicleDetail extends NavigationUtil {
    public VehicleDetail(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    public void clickEnquireNowButton() {
        //        In the side vehicle details click Enquire Now
        WebElement expertButton = driver.findElement(By.xpath("//button[contains(text(), ' Enquire Now ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(expertButton)).click();
    }

    public void fillEmailInput() throws InterruptedException {
        //        Fill the Contact Details and Account Creation form with invalid data. (e.g. with an invalid email format)
        WebElement inputEmail = driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div[1]/div[7]/div/div[1]/div/div[2]/div/div/div/div/div[1]/form/div/div[3]/wb-input-control/wb-input/input"));
        inputEmail.sendKeys("test.com");
        Thread.sleep(5000);

    }

    public void clickProceedButton() {
        //        Click Proceed and validate the error.
        WebElement proceedButton = driver.findElement(By.xpath("//button[contains(text(), ' Proceed ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
    }

    public void getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//div/p[contains(text(), 'An error has occurred.')]"));
        if (errorMessage.getText().equalsIgnoreCase("An error has occurred.\n" +
                "Please check the following sections:")) {
            System.out.println("ERROR MESSAGE FOUND");
        } else {
            throw new RuntimeException("Error message not found. Expected to find 'An error has occurred.' but was found: " + errorMessage.getText());
        }
    }

}
