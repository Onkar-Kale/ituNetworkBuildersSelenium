package ituSelenium.NetworkBuilders;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests {
	private WebDriver driver;

//	@Parameters({"browser", "driverPath"})
//	
//	    @BeforeTest
////	This Configuration is ran via testng.xml as the Browser name is passed in testng.xml
//	    public void initDriver(String browser, @Optional("") String driverPath) throws Exception {
//	
//	        System.out.println("You are testing on browser " + browser);
//	
//	        browser = browser.toLowerCase();
//	
//	        if (!driverPath.equals("")) {
//	
//	            System.setProperty("webdriver.chrome.driver", driverPath);
//	
//	        }
//	
//	        if (browser.equals("chrome")) {        
//	
//	            driver = new ChromeDriver();
//	
//	        } else if (browser.equals("firefox")) {
//	        	
//	            driver = new FirefoxDriver();
//	
//	        } else {
//
//	            throw new RuntimeException("Please create a driver for " + browser);
//	
//	        }
//	
//	    }
	
	
	    @BeforeSuite 
//	If  we only Want to use One Browser
	    public void initDriver() throws Exception {
	    	System.setProperty("webdriver.chrome.driver", "/Library/chromedriver");
	        System.out.println("You are testing in Chrome");
	        driver = new ChromeDriver();
//			driver = new FirefoxDriver();
	    }

		public String baseURL = "http://localhost/itunetworkbuilders-ui";
//		public WebDriver driver = new ChromeDriver(); 
		public String expectedTitle = null;
		public String actualTitle = null;

		@BeforeTest
		public void launchBrowser(){
			driver.get(baseURL);
		}
		@Test
		public void verifyHomepageTitle(){
			expectedTitle="Network Builders";
			actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle,expectedTitle);
			  if (expectedTitle.equals(actualTitle))
					
              {
                     System.out.println("Verification Successful - The correct title is displayed on the web page.");
              }

             else

              {
                     System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
              }
		}
		
		@Test
		public void verifyStudentRole() throws InterruptedException{
			WebElement username = driver.findElement(By.name("username"));
			
            username.clear();

            username.sendKeys("admin");

//            WebElement NextButton = driver.findElement(By.id("next"));
//        	
//            NextButton.click();

// enter a valid password in the password textbox
            Thread.sleep(1500);
            
            WebElement password = driver.findElement(By.name("password"));

            password.clear();

            password.sendKeys("admin");

            

// click on the Sign in button

            WebElement SignInButton = driver.findElement(By.id("btn-login"));

            SignInButton.click();

            Thread.sleep(15000);


            
            WebElement logout = driver.findElement(By.partialLinkText("Log Out"));
            logout.click();
            
            WebElement RegisterButton = driver.findElement(By.id("btn-login"));
            RegisterButton.click();
            
            Thread.sleep(15000);
            
		}
		@Test
		public void verifyAdminRole(){
		
		}
		@Test
		public void verifyAlumniRole(){
		
		}
		
		@AfterSuite
		
		    public void quitDriver() throws Exception {
		        driver.quit();		
		    }

//		@DataProvider   We can Use this Object to pass different user credentials while testing
//		
//		    private Object[][] loginCredentials() {
//		
//		        return new Object[][] { { "TestNG" }, { "Selenium" } };
//		
//		    }

}


