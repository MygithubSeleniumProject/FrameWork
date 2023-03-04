package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
/*@Test
public void CreatContact() {
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("Step3");
	//hardAssert
	Assert.assertEquals("A", "A");
	System.out.println("Step4");
	System.out.println("Step5");
}
@Test
public void ModifyContact() {
	System.out.println("step6");
	System.out.println("Step7");
}*/
	@Test
	public void Creat() {
		String expname="santoshi";
		String actName="santoshi";
		Assert.assertEquals(expname, actName);
	}
}
