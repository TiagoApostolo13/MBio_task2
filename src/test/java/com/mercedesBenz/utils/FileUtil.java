package com.mercedesBenz.utils;

import com.mercedesBenz.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil extends NavigationUtil {

    public FileUtil(WebDriver driver) {
        super(driver);
    }

    public void saveToFile(){

        // Save the following car details to a file:
        // VIN number
        // Model Year
        String vinNumber = driver.findElement(By.xpath("//li[@class='dcp-vehicle-details-list__item dcp-vehicle-details-list-item']/span[contains(text(), 'VIN')]/../span[2]")).getText();
        String modelYear = driver.findElement(By.xpath("//li[@class='dcp-vehicle-details-list__item dcp-vehicle-details-list-item']/span[contains(text(), 'Model Year')]/../span[2]")).getText();

        System.out.println("VIN " + vinNumber);
        System.out.println("Model YEar " + modelYear);

        try (
                FileWriter writeFile = new FileWriter("src/main/resources/fileData.csv")) {
            writeFile.append("Vin Number: " + vinNumber + "\n");
            writeFile.append("Model Year: " + modelYear);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }



}
