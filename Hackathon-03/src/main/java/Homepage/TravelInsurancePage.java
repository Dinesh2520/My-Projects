package Homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;

public class TravelInsurancePage extends BaseClass {

	By travel = By.xpath("//p[text()='Travel']");
	By search = By.id("country");
	By germany = By.xpath("//li[@class='search-item' and text()='Germany']");
	By nxt = By.xpath("//button[text()='Next']");
	By no = By.xpath("//label[text()='2']");
	By traveller0 = By.xpath("(//*[@id='feet'])[1]");
	By traveller1 = By.xpath("(//*[@id='feet'])[2]");
	By click = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[1]/div/div/input");
	By start = By.xpath("//button[@aria-label='Jan 27, 2023']");
	By end = By.xpath("//button[@aria-label='Feb 27, 2023']");
	By med = By.id("ped_no");
	By proceed = By.xpath("//button[text()='View plans']");
	By mobile = By.id("mobileNumber");
	By student = By.xpath("//input[@id='student-trip-desktop']");
	By stud_visa1 = By.xpath("//label[text()='Traveller 1 (22 yrs)']");
	By stud_visa2 = By.xpath("//label[text()='Traveller 2 (21 yrs)']");
	By days = By.id("feet");
	By apply = By.xpath("//button[text()='Apply']");
	By sortby = By.xpath("//*[@id=\"root\"]/div/div[2]/ul/li[2]/a");
	By low = By.xpath("//label[text()='Premium low to high']");
	By apply1 = By.xpath("//button[contains(@class,'travel_main_cta') and text()='Apply']");
	By comp = By.xpath("//div[contains(@class,'quotesCard__planName hideSmall')]");
	By pack = By.xpath("//li/p[@class='quotes_plan_name']");
	By price = By.xpath("//span[@class='premiumPlanPrice']");

	public void travel() throws InterruptedException {

		exttest = report.createTest("To Show Student Travel Insurance Plan ");

		driver.findElement(travel).click();
		driver.findElement(search).sendKeys("Germany");
		// wait(20, germany);
		Thread.sleep(3000);
		driver.findElement(germany).click();
		//Thread.sleep(3000);
		driver.findElement(nxt).click();

		driver.findElement(click).click();
		// wait(20, start);
		driver.findElement(start).click();
		//Thread.sleep(2000);
		driver.findElement(end).click();
		driver.findElement(nxt).click();
		driver.findElement(no).click();
		Select age = new Select(driver.findElement(traveller0));
		age.selectByVisibleText("22 years");
		Select age1 = new Select(driver.findElement(traveller1));
		age1.selectByVisibleText("21 years");
		//Thread.sleep(2000);
		driver.findElement(nxt).click();
		driver.findElement(med).click();
		driver.findElement(nxt).click();
		// wait(20, mobile);
		driver.findElement(mobile).sendKeys("9876543210");
		// wait(20, proceed);
		driver.findElement(proceed).click();
		Thread.sleep(5000);
		exttest.log(Status.PASS, "Details are provided Successfully");
		// wait(20, student);
		driver.findElement(student).click();
		// wait(20, stud_visa1);
		driver.findElement(stud_visa1).click();
		driver.findElement(stud_visa2).click();
		Select visadays = new Select(driver.findElement(days));
		visadays.selectByVisibleText("30 Days");
		driver.findElement(apply).click();
		driver.findElement(sortby).click();
		driver.findElement(low).click();
		driver.findElement(apply1).click();
		System.out.println("*****************************************************");
		System.out.println("      The Student Travel Insurance Plans are: ");
		System.out.println("*****************************************************");
		List<WebElement> companies = driver.findElements(comp);
		List<WebElement> prices = driver.findElements(price);
		//Thread.sleep(3000);
		System.out.println(prices.size());

		for (int i = 0; i < 3; i++) {
			System.out.println(companies.get(i).getText() + "-" + prices.get(i).getText());
			System.out.println("---------------------------------------------------");
		}
		exttest.pass("The Insurance Plans are obtained");
	///	Thread.sleep(1000);
	}
}