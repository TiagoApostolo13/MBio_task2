package com.mercedesBenz;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

@DisplayName(" Validate the negative path of enquiring the highest price at Mercedes-Benz")
public class Task2Tests {

    private WebDriverWait webDriverWait;

    @Test
    public void testTask2() throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //    Open the Mercedes-Benz Shop used cars in Australian market.
        System.out.println("Open the Mercedes-Benz Shop used cars in Australian market.");
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle");

        //Wait for loader finish
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dcp-loader']")));
        Thread.sleep(7000);

        // wait for cookie banner get ready
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement elem = driver.findElement(By.xpath("//*[@id='app']/div[1]/cmm-cookie-banner"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);

        // Find agree all button bellow shadow and click
        WebElement shadowHost = driver.findElement(By.xpath("//*[@id='app']/div[1]/cmm-cookie-banner"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        wait.until(ExpectedConditions.visibilityOf(shadowRoot.findElement(By.className("button--accept-all"))));
        WebElement shadowContent = shadowRoot.findElement(By.className("button--accept-all"));
        shadowContent.click();

        // Open "Your State:" dropdown
        driver.findElement(By.tagName("wb-select")).click();
        // Select 'New South Wales'
        WebElement selectElement = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("New South Wales");

        //close "Your state" dropdown
        driver.findElement(By.tagName("wb-select")).click();

        // Insert Postal Code
        driver.findElement(By.tagName("input")).sendKeys("2007");

        // Select checkbox "Purpose: Private"
        driver.findElement(By.className("wb-radio-control__indicator")).click();

        Thread.sleep(3000);

        // Click Continue
        System.out.println("Click Continue");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='app']/div[1]/header/div/div[4]/div[1]/div/div[2]/button"));
        wait.until(d -> continueButton.isDisplayed());
        continueButton.click();

        Thread.sleep(3000);

        // Click the filter button (top-left blue button)
        System.out.println("Click the filter button");
        WebElement sidebar = driver.findElement(By.className("sidebar"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sidebar);
        driver.findElement(By.className("filter-toggle")).click();

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Select the “Pre-Owned” tab:
        System.out.println("apply the following choices:");
        driver.findElement(By.xpath("//span[contains(text(), 'Pre-Owned')]/../../button")).click();

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Open colour filter:
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dcp-loader']")));
        System.out.println("colour drop");
        WebElement colourFilter = driver.findElement(By.xpath("//p[contains(text(), 'Colour')]/../../../div"));
        wait.until(d -> colourFilter.isDisplayed());
        colourFilter.click();
        Thread.sleep(3000);

        //Open colour dropdown
        System.out.println("Open colour dropdown");
        WebElement colourDrop = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div[4]/div[7]/div/div[2]/div/div"));
        wait.until(d -> colourDrop.isDisplayed());
        colourDrop.click();

        // Select x colour
        System.out.println("Select x colour");
        WebElement colourSelected = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div[4]/div[7]/div/div[2]/div/div/ul/li[84]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", colourSelected);
        wait.until(ExpectedConditions.elementToBeClickable(colourSelected));
        colourSelected.click();
        System.out.println("Colour selected: " + colourSelected.getText());

        // Navigate to the Vehicle Details of the most expensive car on the filtered results.
        // Open sorting dropdown
        System.out.println("Open sorting dropdown");
        WebElement header = driver.findElement(By.xpath("//header"));
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, -document.body.scrollHeight)");

        WebElement srpResultLocator = driver.findElement(By.xpath("//*[@id='srp-result']/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", srpResultLocator);

//        wait.until(d -> sortFilter.isDisplayed());
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(3000);
        WebElement sortFilter = driver.findElement(By.xpath("//*[@id='srp-result']/wb-select-control/wb-select"));
        wait.until(ExpectedConditions.elementToBeClickable(sortFilter)).click();

        //Select Price descending
        System.out.println("Select option");
        WebElement selectOption = driver.findElement(By.xpath("/html/body/div/div[1]/main/div[2]/div[1]/div[2]/div[2]/div[2]/wb-select-control/wb-select/select/option[contains(text(), 'Price (descending)')]"));
        selectOption.click();

//        Select the most expensive car
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dcp-loader']")));
        WebElement expensiveCarLocator = driver.findElement(By.xpath("/html/body/div/div[1]/main/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(expensiveCarLocator)).click();

        // Save the following car details to a file:
        // VIN number
        // Model Year
        String vinNumber = driver.findElement(By.xpath("//li[@class='dcp-vehicle-details-list__item dcp-vehicle-details-list-item']/span[contains(text(), 'VIN')]/../span[2]")).getText();
        String modelYear = driver.findElement(By.xpath("//li[@class='dcp-vehicle-details-list__item dcp-vehicle-details-list-item']/span[contains(text(), 'Model Year')]/../span[2]")).getText();

        System.out.println("VIN " + vinNumber);
        System.out.println("Model YEar " +  modelYear);

        try(FileWriter writeFile = new FileWriter("src/main/resources/fileData.csv")) {
            writeFile.append("Vin Number: " + vinNumber + "\n");
            writeFile.append("Model Year: " +modelYear);
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //        In the side vehicle details click “Enquire Now”
        WebElement expertButton = driver.findElement(By.xpath("//button[contains(text(), ' Enquire Now ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(expertButton)).click();

        //        Fill the “Contact Details and Account Creation” form with invalid data. (e.g. with an invalid email format)
        WebElement inputEmail = driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div[1]/div[7]/div/div[1]/div/div[2]/div/div/div/div/div[1]/form/div/div[3]/wb-input-control/wb-input/input"));
       inputEmail.sendKeys("test.com");


        Thread.sleep(10000);




//        Click "Proceed" and validate the error.
        WebElement proceedButton = driver.findElement(By.xpath("//button[contains(text(), ' Proceed ')]"));
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div/p[contains(text(), 'An error has occurred.')]"));

        if (errorMessage.isDisplayed()){
            System.out.println("ERROR MESSAGE FOUND");
        }

        driver.quit();

    }
}

// TODO IMPROVE
//fazer validações
//Separar implementaçao
//colocar logs
//melhorar tempos de execucao no driver (meter mais lento) - rever thread.sleep()
// trocar os waits do loader para wait para o elemento esta visivel
//tem de correr no firefox


