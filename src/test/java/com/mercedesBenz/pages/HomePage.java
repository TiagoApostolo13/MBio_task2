package com.mercedesBenz.pages;

import com.mercedesBenz.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends NavigationUtil {

    private By colourFilterLocator = By.xpath("//p[contains(text(), 'Colour')]/../../../div");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    public void openFilter() throws InterruptedException {
        System.out.println("Click the filter button");
        Thread.sleep(5000);
        WebElement sidebar = driver.findElement(By.className("sidebar"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sidebar);
        driver.findElement(By.className("filter-toggle")).click();

    }

    public void selectTab() throws InterruptedException {
        System.out.println("Select Tab");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//span[contains(text(), 'Pre-Owned')]/../../button")).click();

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void selectColour() throws InterruptedException {
        // Wait for loader to finish
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dcp-loader']")));
        // Open Colour filter
        System.out.println("colour drop");
        WebElement colourFilter = driver.findElement(colourFilterLocator);
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
    }

    public void selectByPriceDescending() throws InterruptedException {
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
    }


    public void selectMostExpensiveCar() throws InterruptedException {
        // Wait for loader to finish
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dcp-loader']")));
        WebElement expensiveCarLocator = driver.findElement(By.xpath("/html/body/div/div[1]/main/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(expensiveCarLocator)).click();
    }
}

