package Practice;

import org.testng.annotations.Test;

public class TestNgPractice {
	//method1
@Test()
//@Test(priority=1)
	public void createContact() {
		System.out.println("created...");
		
		//to fail
	//	int[] arr= {1,2,3};
		//System.out.println(arr[5]);
		
		
	}
//method2
//@Test(dependsOnMethods="createContact")
@Test(invocationCount=2)
public void modifyContact() {
	System.out.println("modify contact...");
}

//method 3

@Test(dependsOnMethods="createContact")
	public void delectContact() {
	System.out.println("delet contact....");
}

}
//priorities
//depends on methods= |
//if one method got failed means dependent methods are going to skips the excution of reamening srcipts
//__________________________________________________________________________________
//invocation count = excuting the test scripts in multiple times with same test data is know as invocation count
//dataProvides == excuting the test scripts in multiple times with diffrent set of data