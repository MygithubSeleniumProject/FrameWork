package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pom_Repo.Home_page;
import genericUtility.Java_utiltiy;
import genericUtility.Property_utility;

public class DeletP {
@Test
	public  void DeletP() throws Throwable {
		// TODO Auto-generated method stub
		//test script for login page of vtiger app
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
	   /* FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");
	    Properties pro = new Properties();
	     pro.load(fis);
	     String URL = pro.getProperty("url");
	   
	    String USN = pro.getProperty("username"); 
	    String PASS = pro.getProperty("password"); */
	    
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
	   //int ranNum = ran.nextInt(1000);
	  //fectching data from excelsheet
	   FileInputStream fes =new FileInputStream("./src/test/resources/TestData.xlsx");
	   Workbook book=WorkbookFactory.create(fes);
	  Sheet sheetName= book.getSheet("Product");
	  Row rowNum = sheetName.getRow(0)  ;
	  Cell cellNum = rowNum.getCell(0);
	  String productname = cellNum.getStringCellValue()+ranNum;
	  
	 
	  driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 
	  driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
	  Alert alt= driver.switchTo().alert();
	  alt.accept();
	  Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 home.ClickSignout(driver) ;
		 
		 // driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();



}



	}


