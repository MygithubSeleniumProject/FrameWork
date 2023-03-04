package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

public 	Login_page(WebDriver driver)
//intialization
//initElement method is used to initialize the webelements.
//pagefactory is  class provided by selenium webdriver to support page object design pattern.
{
	PageFactory.initElements(driver, this);
}
	
//Declaration
@FindBy(name="user_name")
private WebElement userTextField;

@FindBy(name="user_password")
private WebElement PasswordTextField;


@FindBy(id="submitButton")
private WebElement submitButton;
//right click select source select setters and getters select getters
//Getter methods

//returns value to the attributes//setters means only set the values
public WebElement getUserTextField() {
	return userTextField;
}


public WebElement getPasswordTextField() {
	return PasswordTextField;
}


public WebElement getSubmitButton() {
	return submitButton;
}
//Bussiness Logics
public void loginToApp(String username,String password)

{
	userTextField.sendKeys(username);
	PasswordTextField.sendKeys(password);
	submitButton.click();
}



}
