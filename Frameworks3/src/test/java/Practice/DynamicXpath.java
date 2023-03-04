package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) {
		
				//test script for login page of vtiger app
				String Key ="webDriver.chrome.driver";
				//String Value = "C:\\Users\\Santosh sherikar\\Documents\\javaprogram\\santoshi.exe";
				String Value = "./src/main/resources/chromedriver.exe";
			    System.setProperty(Key,Value);
				
			    WebDriver driver = new ChromeDriver();	
			    
			    driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			    driver.get("https://www.makemytrip.com/");
			    
			  
			    driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	String month="March 2023";
	String date ="18";
	driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	
	}
	

}
