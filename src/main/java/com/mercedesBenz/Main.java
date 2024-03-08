package com.mercedesBenz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

//    public static void main(String[] args) {
//	// write your code here
//    }

    public static void main(String[] args)  {

        //Instantiating chrome driver
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();

        //Opening web application
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle");

        //close cookies
        driver.findElement(By.className("button button--accept-all wb-button hydrated")).click();
        //open picker
        driver.findElement(By.id("u92xeep4z")).click();
        // Select state
        driver.findElement(By.xpath("//*[@id='u92xeep4z']/option[4]")).click();


        //Locating the username & password and passing the credentials
//        driver.findElement(By.id("userName")).sendKeys("gunjankaushik");
//        driver.findElement(By.id("password")).sendKeys("Password@123");

        //Click on the login button
//        driver.findElement(By.id("login")).click();

        //Print the web page heading
//        System.out.println("The page title is : " +driver.findElement(By.xpath("//*[@id=\"app\"]//div[@class=\"main-header\"]")).getText());

        //Click on Logout button
//        driver.findElement(By.id("submit")).click();

        //Close driver instance
        driver.quit();
    }
}
