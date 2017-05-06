# niki-project
A simple framework to run Functional Test Scripts for Niki mobile application. The framework has been developed using Java, Selenium, TestNG and Appium. 

### Description of Project Files
1. BaseDriver.java : Creates and returns WebDriver instance to run automated tests against the test android app.

2. BasePage.java : BasePage with constructor to initialize driver. This class is Inherited by all Pages of the application. 

3. DashboardPage.java : Dashboard Page page object.

4. HelpSectionPage.java : Help Section Page page object. 

5. SidePanelPage.java : Side Panel Page page object.  

6. HelperManager.java : Contains generic methods to be used across the entire framework.     

7. ReportNGReport.java : Contains ReportNG Report screenshot and report creation functionality.  

8. AppTests.java : Test Class with all test scripts.  

9. BaseTest.java : Base Test class with BeforeSuite and BeforeClass/AfterClass configurations.

### Resources
Screenshots folder - This folder contains the screenshots captured in the test scripts.  
Screenshots are stored at `./Resources/Screenshots`

### Test Report
Test Reports are generated under Resources folder:
1. ReportNG Reports : `./test-output/html/index.html`  

### Running the Framework
To run the scripts:
Right click on testng.xml and run as testng suite.
