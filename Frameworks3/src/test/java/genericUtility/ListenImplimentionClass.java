package genericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenImplimentionClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		
		String testData=result.getMethod().getMethodName();
		
		System.out.println("___________________excute_______");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./ScreenShot"+testData+".png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
