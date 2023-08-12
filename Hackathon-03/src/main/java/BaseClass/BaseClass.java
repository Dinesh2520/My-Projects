package BaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static ExtentHtmlReporter exthtml;
	public static ExtentTest exttest;
	public static ExtentReports report;

	public void driverSetup() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/ConfigFile/config.properties")); // Loading the properties
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prop.getProperty("browserName").matches("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // Initializing the new chrome driver
		}
		if (prop.getProperty("browserName").matches("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); // Initializing the new firefox driver
		}
		if (prop.getProperty("browserName").matches("msedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); // Initializing the new msedge driver
		}
		driver.manage().window().maximize(); // To maximize the window
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // Waiting time to page the load completely
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // Adding driver waits to timeouts

		exthtml = new ExtentHtmlReporter("extentreport.html");
		report = new ExtentReports();
		report.attachReporter(exthtml);

	}

	public void openUrl() // Method to open URL for smoke test
	{
		driver.get(prop.getProperty("url"));
	}

	// Function to Put Wait
	public void wait(int sec, By locator) {
		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void closeBrowser() // method to close the browser
	{
		report.flush();
		driver.quit(); // To close the browser
	}

}
