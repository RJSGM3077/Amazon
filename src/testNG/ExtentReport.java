package testNG;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport 
{
	WebDriver driver;
	ExtentReports extentReport;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;

	@Test
	public void openGoogle() throws IOException
	{
		testCase = extentReport.createTest("Verify Google Title");
		testCase.log(Status.INFO, "Navigating to Google");
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Google"))
		{
			testCase.log(Status.PASS, "Actual Title is Pass");
			System.out.println("Passed");
		}
		else
		{
			testCase.log(Status.FAIL, "Actual Title is fail");
			System.out.println("Failed");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("Google.png");
			FileHandler.copy(sourceFile, destinationFile);
			
		}
	}
	
	@Test
	public void openBing() throws IOException
	{
		testCase = extentReport.createTest("Verify Bing Title");
		testCase.log(Status.INFO, "Navigating to Bing");
		driver.get("https://www.Bing.com/");
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Bing"))	
		{
			testCase.log(Status.PASS, "Actual Title is Pass");
			System.out.println("Passed");
		}
		else
		{
			testCase.log(Status.FAIL, "Actual Title is fail");
			System.out.println("Failed");
			//Take screenshot snippet
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("Bing.png");
			FileHandler.copy(sourceFile, destinationFile);
		}
	}
	
	@Test
	public void openWikipiedia() throws IOException
	{
		testCase = extentReport.createTest("Verify Wikepedia Title");
		testCase.log(Status.INFO, "Navigating to Wikepedia");
		driver.get("https://www.wikipedia.com/");
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("wikipedia"))	
		{
			testCase.log(Status.PASS, "Actual Title is Pass");
			System.out.println("Passed");
		}
		else
		{
			testCase.log(Status.FAIL, "Actual Title is fail");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("Wikipedia.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("Wikipedia.png");
			//addScreenCaptureFromBase64String("Wikipedia.png");
			
		}
	}
	
	@BeforeSuite
	public void launchBrowser()
	{
		extentReport=new ExtentReports();
		htmlReporter=new ExtentHtmlReporter("htmlReporter.html");
		extentReport.attachReporter(htmlReporter);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
		extentReport.flush();
	}
}
