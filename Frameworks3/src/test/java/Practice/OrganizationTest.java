package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pom_Repo.Home_page;
import Pom_Repo.Login_page;
import Pom_Repo.OrganizationCreatePage;
import Pom_Repo.Validation;
import genericUtility.BaseClass;
import genericUtility.Excel_utility;
import genericUtility.Java_utiltiy;
import genericUtility.Property_utility;
import io.github.bonigarcia.wdm.WebDriverManager;


//Listeners implimentation
//@Listeners(genericUtility.ListenImplimentionClass.class)

public class OrganizationTest extends BaseClass {
@Test(groups="SmokeTest")
	//retry Analyzer(excute failed test scripts)
//@Test(retryAnalyzer=genericUtility.RetryImpClass.class)
	public void OrganizationTest() throws Throwable {
		//test script for login page of vtiger app
	
	//
			/*	String Key ="webDriver.chrome.driver";
			//	String Value = "C:\\Users\\Santosh sherikar\\Documents\\javaprogram\\santoshi.exe";
			String Value = "./src/main/resources/chromedriver.exe";
			 System.setProperty(Key,Value);
				
			    WebDriver driver = new ChromeDriver();*/
			   
	
			    //fectching data from PropertiesFile
			    
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
			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			    driver.manage().window().maximize();
			    //Fecting data from property file
			  /* String URL = plib.getKeyValue("url");
			   String USERNAME = plib.getKeyValue("username");
			    String PASSWORD = plib.getKeyValue("password");
			  /*  FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");
			    Properties pro = new Properties();
			     pro.load(fis);
			     
			     String URL = pro.getProperty("url");
			   
			    String USN = pro.getProperty("username"); 
			    String PASS = pro.getProperty("password");*/
			    //login to application
			  //  driver.get(URL);
			   // Login_page login = new Login_page(driver);
			   // login.loginToApp(USERNAME, PASSWORD);
				  /* driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				   driver.findElement(By.id("submitButton")).click();*/
			    
			    //clik on organization link
			    
			    
			    Home_page home =new Home_page(driver);
			    home.clickOrganization();
				 //  driver.findElement(By.linkText("Organizations")).click();
			    //click on +
			    
			    OrganizationCreatePage org =new OrganizationCreatePage(driver);
			    org.clickOrgnaization();
				  // driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				   
				 //random class
				   Java_utiltiy jlib = new Java_utiltiy();
				   
					int ranNum= jlib.getRanDomNum();
				   
				   
				 //  Random ran = new Random();
				 //  int ranNum = ran.nextInt(1000);
				 //Fecteching data from excel sheet
					 
					Excel_utility elib = new Excel_utility();
				   String orgName= elib.getExcelData("Organization", 0, 0)+ranNum;
				   /*FileInputStream fes =new FileInputStream("./src/test/resources/TestData.xlsx");
				   Workbook book=WorkbookFactory.create(fes);
				  Sheet sheetName= book.getSheet("Organization");
				  Row rowNum = sheetName.getRow(0)  ;
				  Cell cellNum = rowNum.getCell(0);
				  String orgName = cellNum.getStringCellValue()+ranNum;*/
					//add excel data
				   org.clickOrgnaizationName(orgName);
				  //driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
				  //save
				org.Save();
				 // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				  Thread.sleep(2000);
				//String actData= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			//	String actdata=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
				Validation val =new Validation(driver);
				String actdata = val.orgvalidate(driver, orgName);
				 //Hard Assert 
				 // Assert.assertEquals(orgName, actdata);
				//soft Assert
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(orgName,actdata);
				//java if else statements are not capable to fail the test sripts so we are using assertion to validate the test scripts and fail the scripts
				/* if(actData.contains(orgName)) {
					 System.out.println("pass");
				 }
				 else
				 {
					 System.out.println(driver);
				 }*/
				 
				
				  
		// WebElement signoutImg =	  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			//	Actions act =new Actions(driver);
			// act.moveToElement(signoutImg).perform();
			//	 driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();*/
				 
				 //logout
	//home.ClickSignout(driver);
	soft.assertAll();
	
	}
@Test
public void m1() {
	System.out.println("m1 running");
}
}
