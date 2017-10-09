package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Testcases.TestBase;

public class NewQuotePAge extends TestBase {
	/*@FindBy(id=".//*[@id='ContactsDropDown-list']/div/child::ul/child::li")
  WebElement contact;*/

	/* @FindBy(id="SecondaryPolicyHolder")
  WebElement coapp;*/

	@FindBy(id="FName")
	WebElement fName;

	@FindBy(id="LName")
	WebElement lName; 


	@FindBy(id="EmailAddress")
	WebElement emailAddress;

	@FindBy(id="ClientDOB")
	WebElement clientDOB;

	@FindBy(id="SFName")
	WebElement coappFname;

	@FindBy(id="SLName")
	WebElement coappLname;

	@FindBy(id="SDob")
	WebElement coappDob;

	@FindBy(id="insurance")
	WebElement SFAuto;

	@FindBy(id="AutoPolicy")
	WebElement SFPNAuto;

	@FindBy(id="Flood")
	WebElement flood;

	@FindBy(id="DoverBayClient")
	List<WebElement> DBClient;

	@FindBy(id="DoverBayPolNum")
	WebElement DBPNum;

	@FindBy(id="PriorCarrier")
	WebElement DBPCarr;

	@FindBy(id="bNextFake")
	WebElement nextButton;

	@FindBy(id="SecondaryPolicyHolder")
	List<WebElement> coapplicant;

	@FindBy(id="Insurance")
	List<WebElement> sfAutoPolicy;

	@FindBy(id="Flood")
	List<WebElement> Flood;




	WebDriver driver;

	public NewQuotePAge(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void setApplicanttype() {

		List <WebElement> coapplicant=driver.findElements(By.xpath(".//*[@id='AppType_listbox']/child::li"));	


		if (!coapplicant.get(0).isSelected())
		{
			coapplicant.get(0).isSelected();
		}
	}
	public boolean checkclientInfo(String fname,String lname,String email,String dob)
	{
		String ActualFname = fName.getAttribute("value");
		String ActualLname =lName.getAttribute("value");
		String ActualEmail=emailAddress.getAttribute("value");
		String Actualdob=clientDOB.getAttribute("value");

		if (ActualFname.equals(fname)&&(ActualLname.equals(lname))&&(ActualEmail.equals(email))&&(Actualdob.equals(dob)))
			return true;
		else
			return false;

	}


	public void setContact(String contact)

	{   
		WebDriverWait wait=new WebDriverWait(driver,10);
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmAppPolicyHolder']/div[2]/div[7]/div/span/span/span[1]"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Select Existing Contact Information...']"))));
		//driver.findElement(By.xpath(".//*[@id='frmAppPolicyHolder']/div[2]/div[7]/div/span/span/span[1]")).click();
		driver.findElement(By.xpath("//span[text()='Select Existing Contact Information...']")).click();

		driver.findElement(By.xpath(".//*[@id='ContactsDropDown-list']/div/child::ul/child::li[contains(text(),'"+contact+"')]")).click();	


	}
	public void setCoapp(String coApp) {

		//List <WebElement> coapplicant=driver.findElements(By.id("SecondaryPolicyHolder"));	 

		selectRadioOption(coapplicant,coApp);

		/*if (coApp.equalsIgnoreCase("true"))
	  		coapplicant.get(0).click();
	  	 else
	  		coapplicant.get(1).click();	*/ 
	}

	public void setCoappDetails(String coAppFname,String coAppLname,String coAppdob) {

		// List <WebElement> coapplicant=driver.findElements(By.xpath("SecondaryPolicyHolder"));	 
		coappFname.clear();
		coappFname.sendKeys(coAppFname);

		coappLname.clear();
		coappLname.sendKeys(coAppLname);

		coappDob.clear();
		coappDob.sendKeys(coAppdob);  	 		 

	}

	public void setSFAutoPolicy(String sfAuto)
	{
		
		selectRadioOption(sfAutoPolicy,sfAuto);
	
	}
	public void setSFAutoNumber(String autoNum)
	{

		SFPNAuto.sendKeys(autoNum);
	}
	public void  setFlood(String flood)
	{
	
		selectRadioOption(Flood,flood);

	}
	public void setExDoverBayClient(String dbClient)
	{
		
		selectRadioOption(DBClient,dbClient);

	}
	public void setPriorCarrier(String Pcarrier)
	{
		DBPCarr.sendKeys(Pcarrier);
	}
	public void setDBPolicyNum(String DBPOlicy)
	{
		DBPNum.sendKeys(DBPOlicy);
	}

	public void clickNextButtonIE() throws Exception
	{   
		;
		try { waitforelementtobeclickable(nextButton,2);
				nextButton.click();}catch (Exception e) {}
	}

	public void clickNextButtonChrome() throws Exception
	{   
	
		try { waitforelementtobeclickable(nextButton,2);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", nextButton);}catch (Exception e) {}
		

	}


	public  void setPolicyHolder(String contact,String coApp,String coAppFname,String coAppLname,String coAppdob,String sfAuto,String autoNum,String flood,String dbClient,String DBPOlicy,String Pcarrier) throws Exception
	{   
		setContact(contact);
		setCoapp(coApp);
		if(coApp.equalsIgnoreCase("yes"))
		{
			setCoappDetails(coAppFname,coAppLname,coAppdob);

		}
		setSFAutoPolicy(sfAuto);
		if (sfAuto.equalsIgnoreCase("yes"))
		{
			setSFAutoNumber(autoNum);
		}
		setFlood(flood);
		setExDoverBayClient(dbClient);
		if(dbClient.equalsIgnoreCase("yes"))
		{

			setDBPolicyNum(DBPOlicy);
		}
		else 
		{
			setPriorCarrier(Pcarrier);
		}
		if(driver instanceof ChromeDriver)
		{clickNextButtonChrome();}

		clickNextButtonIE();

	}
}
