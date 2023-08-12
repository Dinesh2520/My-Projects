package Homepage;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;
import Screenshot.captureScreenshot;

public class CarInsurancePage extends BaseClass{
	
	By car=By.xpath("//p[text()='Car']");
	By proceed=By.xpath("//a[@class='btn-proceed']");
	By no=By.xpath("//*[@id='searchInput']/div/input");
	By select=By.xpath("//span[text()='KA01-BANGALORE(Karnataka)']");
	By comp=By.xpath("//input[@placeholder='Search car brand']");
	By brand=By.xpath("//span[text()='ALTO']");
	By fuel=By.id("Petrol");
	By variant=By.xpath("//b[text()='LX (796 cc)']");
	By year=By.xpath("//b[text()='Brand New Car']");
	By name=By.id("name");
	By email=By.id("email");
	By phone=By.id("mobileNo");
	By view=By.xpath("//*[@id='btnLeadDetails']/span");
	By error=By.xpath("//div[@class='msg-error show']");

	
	
	public void car() throws InterruptedException, IOException {
		
		exttest = report.createTest("To Display Error Messages in Car Insurance");
	
		driver.findElement(car).click();
		driver.findElement(proceed).click();
		driver.findElement(no).sendKeys("KA01");
		//wait(20, select);
		driver.findElement(select).click();
		driver.findElement(comp).sendKeys("MARUTI");
		//wait(20, brand);
		driver.findElement(brand).click();
		//Thread.sleep(1000);
		driver.findElement(fuel).click();
		driver.findElement(variant).click();
		driver.findElement(year).click();
		exttest.log(Status.PASS, "Items are being Selected");
		driver.findElement(name).sendKeys("DINESH S");
		driver.findElement(email).sendKeys("batch3");
		driver.findElement(phone).sendKeys("9876543210");	
		driver.findElement(view).click();
		System.out.println("********************************************");
		System.out.println("         The Error Message is: ");
		System.out.println(driver.findElement(error).getText());
		exttest.pass("Errors are obtained");
		captureScreenshot.takeScreenshot("ErrormessageScreenshot");
		//Thread.sleep(1000);
	}
}
