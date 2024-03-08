//package com.mercedesBenz;
//
//public class Base {
//    public static WebDriver driver;
//
//    @BeforeSuite
//    public void initializeWebDriver() throws IOException {
//        System.setProperty("webdriver.chrome.driver","\src\drivers\chromedriver.exe");
//        driver = new ChromeDriver();
//
//        // To maximize browser
//        driver.manage().window().maximize();
//
//        // Implicit wait
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        // To open Gmail site
//        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo");
//    }

//    @AfterSuite
//    public void quitDriver() {
//        driver.quit();
//    }
//

//}
