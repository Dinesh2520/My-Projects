package Homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class HealthInsurancePage extends BaseClass{
	By list=By.xpath("/html/body/section[2]/div/div/div/div/div[2]/ul/li");
	
	public void list() throws InterruptedException {
		
		exttest = report.createTest("To Display the Health Insurance Menu list");
		
		System.out.println("*****************************************************");
		System.out.println("        The Health Isurance Menu Items are: ");
		System.out.println("*****************************************************");
		List<WebElement> insuranceList=driver.findElements(list);
		for(int j=1;j<insuranceList.size();++j){
			System.out.println(insuranceList.get(j).getText());
		}
		exttest.pass("Health Insurance Menu List is obtained");
	//	Thread.sleep(1000);
	}

}
