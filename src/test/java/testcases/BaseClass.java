package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	
	public XSSFWorkbook wbook;
	public XSSFSheet sheet;
	
	@BeforeTest
	public void DataSetup() throws IOException {
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");		
		
	}
	
	@AfterTest
	public void DataClean() throws IOException {
		wbook.close();
		
	}
	
	@BeforeMethod
	public void SetUp() {
		// System.setProperty() sets the system property indicated by the specified key and returns the value.
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		// Create an instance of ChromeDriver
		driver = new ChromeDriver();
		
		// Open given web page
		driver.get("https://www.simplilearn.com");
		
		// Maximize window
		driver.manage().window().maximize();
		
		// Putting a wait implicitly
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		
	}
	
	@AfterMethod
	public void TearDown() {
		// Closes the browser
		driver.close();
	
	}
}

