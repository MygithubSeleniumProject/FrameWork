package Practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pom_Repo.Home_page;
import genericUtility.Excel_utility;
import genericUtility.Java_utiltiy;
import genericUtility.Property_utility;
import genericUtility.WebDriver_Utility;

public class CampaginWithProduct {
@Test
	public  void CampaginWithProduct() throws Throwable {
		// TODO Auto-generated method stub
		//test script for598 login page of vtiger app
		String Key ="webDriver.chrome.driver";
		//String Value = "C:\\Users\\Santosh sherikar\\Documents\\javaprogram\\santoshi.exe";
		String Value = "./src/main/resources/chromedriver.exe";
	    System.setProperty(Key,Value);
		
	    WebDriver driver = new ChromeDriver();	
	    
	    driver.manage().window().maximize();
	  //fectching data from PropertiesFile
	    Property_utility plib = new Property_utility();
	    String URL = plib.getKeyValue("url");
	    String USERNAME = plib.getKeyValue("username");
	    String PASSWORD = plib.getKeyValue("password");
	  /*  FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");
	    Properties pro = new Properties();
	     pro.load(fis);
	     String URL = pro.getProperty("url");
	   
	    String USN = pro.getProperty("username"); 
	    String PASS = pro.getProperty("password"); */
	  //loginto vtiger application
	    
	   driver.get(URL);
	   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	   driver.findElement(By.id("submitButton")).click();
	   Home_page home =new Home_page(driver);
	    home.clickProduct() ;
	  //driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
	  
	 
	  
	 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	  //random class
	   
	   
	   Java_utiltiy jlib = new Java_utiltiy();
		Random ranNum=new Random();
	   //Random ran = new Random();
	  // int ranNum = ran.nextInt(1000);
	  //fectching data from excelsheet
		/*Excel_utility elib = new Excel_utility();
		String productname = elib.getExcelData("Product", 0, 0)+ranNum;*/
	  FileInputStream fes =new FileInputStream("./src/test/resources/TestData.xlsx");
	   Workbook book=WorkbookFactory.create(fes);
	  Sheet sheetName= book.getSheet("Product");
	  
	  
	  Row rowNum = sheetName.getRow(0)  ;
	  Cell cellNum = rowNum.getCell(0);
	  String productname = cellNum.getStringCellValue()+ranNum;
	  driver.findElement(By.name("productname")).sendKeys(productname);
	  //save
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  
	  
	  driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	   
	 
	 home.ClickCompagin();
	  
	 //driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	
	
	  //fectching data from excelsheet
	   FileInputStream fes1 =new FileInputStream("./src/test/resources/TestData.xlsx");
	   Workbook book1=WorkbookFactory.create(fes1);
	  Sheet sheetName1= book1.getSheet("Organization");
	  Row rowNum1 = sheetName1.getRow(0)  ;
	  Cell cellNum1 = rowNum1.getCell(0);
	  String campaginName = cellNum1.getStringCellValue()+ranNum;
	/*Excel_utility elib1 = new Excel_utility();
	String campaignname= elib1.getExcelData("Campaign", 0, 0);*/
	  
	  driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaginName);
	 
	  driver.findElement(By.xpath("//img[@alt='Select']")).click();
	  
	  
	  //Switching window
	  
	  
	  WebDriver_Utility wlib=new WebDriver_Utility();
	  wlib.switchWindow(driver, "Product&action");
/*Set<String> allId= driver.getWindowHandles();
	//itaration is a loop run the loop which id to take by comparing all ids
	Iterator<String> it = allId.iterator();//
	//hasNext = checkks any value is iterated or not
	while(it.hasNext())//org,prd,ctn,lead
		{
		String wid =it.next();//org
		driver.switchTo().window(wid);//org//prd
		String title = driver.getTitle();
		if(title.contains("Product&action"))
		{
			break;
		}
		
	}*/
	  
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productname);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//a[text()='Phone481']")).click();
	//here the name of the phone will change so we are using dynamic Xpath for the above line
	driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
	Thread.sleep(2000);
	
	  wlib.switchWindow(driver, "Campaign&action");
	
	/*Set<String> allId1= driver.getWindowHandles();
	//itaration is a loop run the loop which id to take by comparing all ids
		Iterator<String> it1 = allId1.iterator();//4
		//hasNext = checkks any value is iterated or not
		while(it1.hasNext())//org,prd,ctn,lead
			{
			String wid =it1.next();//org
			driver.switchTo().window(wid);//org//prd
			String title = driver.getTitle();
			if(title.contains("Campaign&action"))
			{
				break;
			}
			
		}*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		home.ClickSignout(driver);
	}

}
