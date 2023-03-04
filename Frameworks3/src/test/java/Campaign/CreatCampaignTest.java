package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Pom_Repo.CreatCampaginPgae;
import Pom_Repo.Home_page;
import Pom_Repo.Login_page;
import genericUtility.BaseClass;
import genericUtility.Excel_utility;
import genericUtility.Java_utiltiy;
import genericUtility.Property_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatCampaignTest extends BaseClass  {
@Test(groups={"SmokeTest","RegressionTest"})
	public  void CreatCampaign() throws Throwable {
		 Property_utility plib = new Property_utility();
		   
					/*String BROWSER = plib.getKeyValue("Browser");
					    
					  WebDriver driver;
					    if (BROWSER.equalsIgnoreCase("chrome")) {
					    WebDriverManager.chromedriver().setup();
					    	driver = new ChromeDriver();
					  }
					  else if(BROWSER.equalsIgnoreCase("firefox")) {
					    	WebDriverManager.firefoxdriver().setup();
					    	driver = new FirefoxDriver();
					    }
					    else if (BROWSER.equalsIgnoreCase("edge")) {
					    	WebDriverManager.edgedriver().setup();
					    	driver = new EdgeDriver();
					    }
					    else
					   {
					    	driver=new ChromeDriver();
					   }*/
		//test script for login page of vtiger app
	//	String Key ="webDriver.chrome.driver";
		//String Value = "C:\\Users\\Santosh sherikar\\Documents\\javaprogram\\santoshi.exe";
	//	String Value = "./src/main/resources/chromedriver.exe";
	 //   System.setProperty(Key,Value);
		
	   // WebDriver driver = new ChromeDriver();	
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	  //fectching data from PropertiesFile
	    
	   
	  /*  String URL = plib.getKeyValue("url");
	    String USERNAME = plib.getKeyValue("username");
	    String PASSWORD = plib.getKeyValue("password");
	   /* FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");
	    Properties pro = new Properties();
	     pro.load(fis);
	     String URL = pro.getProperty("url");
	   
	    String USN = pro.getProperty("username"); 
	    String PASS = pro.getProperty("password"); */
	    
	    
	  //Login to apllication  
	  // driver.get(URL);
	 //  Login_page login = new Login_page(driver);
	 //   login.loginToApp(USERNAME, PASSWORD);
	  /* driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	   driver.findElement(By.id("submitButton")).click();*/
	    
	
	
	  
	  Home_page home =new Home_page(driver);
	  home.clickMore();
	    home.ClickCompagin();  
	    // driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	 //  driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
	    CreatCampaginPgae camp = new CreatCampaginPgae(driver);
	    camp.clickCampagin();	
	    
	    
	   // driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	//random class
	//generic utility
	Java_utiltiy jlib = new Java_utiltiy();
	int ranNum =jlib.getRanDomNum();
	  // Random ran = new Random();
	   //int ranNum = ran.nextInt(1000);
	  //fectching data from excelsheet
	
	Excel_utility elib = new Excel_utility();
	   String campaginName = elib.getExcelData("Campaign", 0, 0)+ranNum;
	 /*  FileInputStream fes =new FileInputStream("./src/test/resources/TestData.xlsx");
	   Workbook book=WorkbookFactory.create(fes);
	  Sheet sheetName= book.getSheet("Campaign");
	  Row rowNum = sheetName.getRow(0)  ;
	  Cell cellNum = rowNum.getCell(0);
	  String campaginName = cellNum.getStringCellValue()+ranNum;*/
	  
	 
	 // driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaginName);
	  camp.clickCampaginName(campaginName);
	  //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 camp.clickSave();
	  Thread.sleep(2000);
		// driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 //driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	// home.ClickSignout(driver);
	}



}
