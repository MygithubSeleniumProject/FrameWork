package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//dataProvides == excuting the test scripts in multiple times with diffrent set of data
//when we have huge amount of data to be excuted than we go for data provider concept
//here we are using 2d object array i.e object[][]

public class DataProviderPractice {

	
	@Test(dataProvider="dataProvider_test")
	public void bookTicket(String src,String dst) {
		System.out.println("book tickets from "+src+" to "+dst+"");
	}
		@DataProvider
		public Object[][] dataProvider_test()
		{
			Object[][] objArr=new Object[5][2];  //5 sets and 2 rows
			objArr[0][0]="Bangalore";
			objArr[0][1]="goa";
			
			objArr[1][0]="Bangalore";
			objArr[1][1]="mysore";
			
			objArr[2][0]="Bangalore";
			objArr[2][1]="mangalore";
			
			objArr[3][0]="Bangalore";
			objArr[3][1]="mumbai";
			
			objArr[4][0]="Bangalore";
			objArr[4][1]="kerala";
			return objArr;
		}
			
}

