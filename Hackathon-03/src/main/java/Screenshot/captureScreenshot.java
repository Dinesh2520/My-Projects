package Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseClass.BaseClass;
//Captures the screenshot of error message and stores in Screenshot folder
public class captureScreenshot extends BaseClass {
	public static String takeScreenshot(String fileName) throws IOException{
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File sourcefile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./Screenshots/"+fileName+".png");
		FileUtils.copyFile(sourcefile, destFile);
		return fileName;
		
	}
}
