package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
public Home_page(WebDriver driver) {

	PageFactory.initElements(driver, this);
}
@FindBy(linkText="Organizations")
private WebElement OrganizationsLink;

@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
private WebElement ProductLink;

@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
private WebElement moreLink;

@FindBy(xpath="//a[@name='Campaigns']")
private WebElement compaginLink;



@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement SignoutImag;

@FindBy(linkText="Sign Out")
private WebElement Signout;

public WebElement getOrganizationsLink() {
	return OrganizationsLink;
}

public WebElement getProductLink() {
	return ProductLink;
}

public WebElement getMoreLink() {
	return moreLink;
}

public WebElement getCompaginLink() {
	return compaginLink;
}

public WebElement getSignoutImag() {
	return SignoutImag;
}

public WebElement getSignout() {
	return Signout;
}

//Bussiness logic for organization
public void clickOrganization() {
	
	OrganizationsLink.click();
}


public void clickProduct()
{
	ProductLink.click();
}
public void clickMore()
{
	moreLink.click();

}
public void ClickCompagin()
{
	compaginLink.click();

}
//Bussiness logic for signout
public void ClickSignoutimg(WebDriver driver)
{

	
	SignoutImag.click();

}
public void ClickSignout(WebDriver driver)
{
	
	Actions act =new Actions(driver);
	 act.moveToElement(SignoutImag).perform();
	Signout.click();

}



}


