package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Pom_Repo.Home_page;
import Pom_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;







public class BaseClass {
	
public WebDriver driver;
//Listener implimentation	
public static WebDriver sdriver;
	 public Property_utility plib = new Property_utility();
@BeforeSuite
public void BS(){
	System.out.println("DataBase connection");
}
@BeforeTest
public void BT() {
	System.out.println("parellel Excution");
}
@Parameters("BROWSER")
@BeforeClass
public void BC() throws Throwable  {
//public void BC(String BROWSER  )throws Throwable {
	/*String Key ="webDriver.chrome.driver";
	//String Value = "C:\\Users\\Santosh sherikar\\Documents\\javaprogram\\santoshi.exe";
	String Value = "./src/main/resources/chromedriver.exe";
    System.setProperty(Key,Value);
	
    WebDriver driver = new ChromeDriver();*/
  
    //fectching data from PropertiesFile
    
   // Property_utility plib = new Property_utility();
   
  String BROWSER = plib.getKeyValue("Browser");
    
 // WebDriver driver;
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
    }
	
    System.out.println("launching browser");
	//Listerner implimentation
    sdriver=driver;
}
@BeforeMethod
public void BM() throws Throwable  {
	
	
	 String URL = plib.getKeyValue("url");
	    String USERNAME = plib.getKeyValue("username");
	    String PASSWORD = plib.getKeyValue("password");
	   driver.get(URL);
	    Login_page login = new Login_page(driver);
	    login.loginToApp(USERNAME, PASSWORD);
	System.out.println("login to apllication");
}
@AfterMethod
public void AM() {
	Home_page home =new Home_page(driver);
	home.ClickSignout(driver);
	System.out.println("logout to apllication");
}
@AfterClass
public void AC() {
	driver.quit();
	System.out.println("closing browser");
}
@AfterTest
public void AT() {
	System.out.println("closing parellel Excution");
}
@AfterSuite
public void AS(){
	System.out.println(" closing DataBase connection");
}
}