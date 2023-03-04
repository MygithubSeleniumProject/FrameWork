package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {
public OrganizationCreatePage(WebDriver driver) {

	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement PlusImg;


@FindBy(xpath="//input[@name='accountname']")
private WebElement organizationName;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement SaveButton;

public WebElement getPlusImg() {
	return PlusImg;
}

public WebElement getorganizationName() {
	return organizationName;
}

public WebElement getSaveButton() {
	return SaveButton;
}

//Bussiness Logic for+img
public void clickOrgnaization() {
	PlusImg.click();
}
//orgname
public void clickOrgnaizationName(String orgname) {
	organizationName.sendKeys(orgname);
}
//save
public void Save() {
	
	SaveButton.click();
}
}
