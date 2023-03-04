package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


//used to excute failed test scripts


public class RetryImpClass implements IRetryAnalyzer{
int count=0;
int retrylimit=4;
public boolean retry(ITestResult result) {
	

if(count<retrylimit)
{
count++;
return true;

}
return false;
}
}
