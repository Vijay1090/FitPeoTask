package com.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public  org.apache.log4j.Logger logger;
	public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter reporter;
    public ExtentTest test;
	
	public  void initializeBrowser() throws Throwable {
		
	 driver=new ChromeDriver();
	 logger.info("ChromeBrowser opens successfully ....");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 prop=new Properties();
	 
	 
	 File file=new File("common.properties");
     FileInputStream file1=new FileInputStream(file);
      prop.load(file1);
	// File file = new File(System.getProperty("user.dir")+ "src//main//java//Com//configFiles//common.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}

	
	
	}
	

    
    
	@BeforeSuite
	public void starttestCase() throws InterruptedException {

        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        reporter = new ExtentSparkReporter(path);
	}
	
	@AfterSuite
	public void endtestCase() {
		extent.attachReporter(reporter);
		extent.flush();
	}
	
	@BeforeTest	
	public void logGenerator() {
	    logger= org.apache.log4j.Logger.getLogger("***** Amazon Test Case Started *****");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("***** Test Case Starting ****** ");
	}
	

}
