#Selenium Tests with Maven

This project contains automated tests using Selenium WebDriver and is configured to be run with Maven.

##Prerequisites

Before running the tests, make sure you have the following installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Maven

##Running the Tests

To run the tests, follow these steps:

1. Clone this repository to your local machine:

git clone https://github.com/TiagoApostolo13/MBio_task2.git

2. Navigate to the project directory:

cd repository-name

3. Run the tests using the following Maven command, specifying the desired browser chrome or firefox (in this example, we are using Chrome):

mvn clean test -Dbrowser=chrome (or firefox)

This will clean previous test results, compile the code, and execute the automated tests in the browser.

##Customization

You can customize the browser and other test settings by editing the pom.xml file and the test source code as needed.
