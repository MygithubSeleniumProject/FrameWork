package genericUtility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility
{
	/*used to switch the window based on window title
	 * 
	 
	 
	 
	 
	 *@author santoshi
	 */
public void switchWindow(WebDriver driver,String PartialWindowTitle) 
{
	Set<String> allId= driver.getWindowHandles();
	//itaration is a loop run the loop which id to take by comparing all ids
	Iterator<String> it = allId.iterator();//
	//hasNext = checkks any value is iterated or not
	while(it.hasNext())//org,prd,ctn,lead
		{
		String wid =it.next();//org
		driver.switchTo().window(wid);//org//prd
		String title = driver.getTitle();
		if(title.contains( PartialWindowTitle))
		{
			break;
		}
}
}

public void moveToElement(WebDriver driver,WebElement element) {
	Actions act =new Actions(driver);
	 act.moveToElement(element).perform();
}
}
