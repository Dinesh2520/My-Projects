package TestSuite;

import java.io.IOException;

import org.testng.annotations.Test;

import Homepage.CarInsurancePage;
import Homepage.HealthInsurancePage;
import Homepage.TravelInsurancePage;
public class TravelPage {
	@Test
	public void testing() throws InterruptedException, IOException
	{
		TravelInsurancePage ti= new TravelInsurancePage();
		CarInsurancePage ci= new CarInsurancePage();
		HealthInsurancePage hi= new HealthInsurancePage();
		ti.driverSetup();
		ti.openUrl();
		ti.travel();
		ci.openUrl();
		ci.car();
		hi.openUrl();
		hi.list();
		hi.closeBrowser();
	}
}