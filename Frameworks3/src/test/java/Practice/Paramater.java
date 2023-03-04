package Practice;

import org.testng.annotations.Test;



public class Paramater {
@Test
public void m1()
{
	String BROWSER=System.getProperty("Browser");
	String URL=System.getProperty("url");
	System.out.println(BROWSER);
	System.out.println(URL);
	
}
}