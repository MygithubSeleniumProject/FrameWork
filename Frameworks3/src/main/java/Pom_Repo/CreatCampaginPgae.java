package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatCampaginPgae {
public CreatCampaginPgae(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@alt='Create Campaign...']")
private WebElement PlusImg;
@FindBy(xpath="//input[@name='campaignname']")
private WebElement campaignName;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement save;


public WebElement getPlusImg() {
	return PlusImg;
}

public WebElement getCampaignName() {
	return campaignName;
}
public WebElement getSaveButton() {
return save;
}
//BussinessLogic
public void clickCampagin() {
	PlusImg.click();
}
public void clickCampaginName(String campName) {
	campaignName.sendKeys(campName);
}
public void clickSave() {
	save.click();
}
}