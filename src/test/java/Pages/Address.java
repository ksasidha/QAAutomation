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

import Testcases.TestBase;

/**
 * @author ksasidharan
 *
 */
public class Address extends TestBase {
    WebDriver driver;

@FindBy(id="LAddress1")
WebElement  rAddress1;

@FindBy(id="LAddress2")
WebElement  rAddress2;

@FindBy(id="LCity")
WebElement  rCity;

@FindBy(id="LCode1")
WebElement  rzip;

@FindBy(id="MAddress1")
WebElement  mAddress1;

@FindBy(id="MAddress2")
WebElement  mAddress2;

@FindBy(id="MCity")
WebElement  mCity;

@FindBy(id="MCode1")
WebElement  mzip;

@FindBy(id="DiffMailingAddressReason")
WebElement  diffMailingAddress;

@FindBy(xpath=".//*[@class='sweet-alert showSweetAlert visible']")
WebElement sweetAlert;

@FindBy(className="confirm")
WebElement confirm;

@FindBy(id="bNext")
WebElement next;

@FindBy(id="phyAddressModal")
public
WebElement pAddressmodal; 

@FindBy(id="mailAddressModal")
public
WebElement mAddressmodal; 

@FindBy(xpath="//button[contains(., 'Ok')]")
public
WebElement okButton; 

@FindBy(xpath=".//*[@id='useEnteredPhys']")
public	
WebElement enteredPhys; 

@FindBy(id="useEnteredMail")
public	
WebElement enteredmail;

@FindBy(xpath="(//span[@class='k-input'])[6]")
public	
WebElement spanparish;

@FindBy(xpath="//ul[@id='LParish_listbox']")
public	
WebElement ulparish;

@FindBy(xpath="//ul[@id='LParish_listbox']/li")
public	
List<WebElement> liparish;
  
public Address(WebDriver driver) {
	  
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  
  }

public void setriskAddress1(String address1) 
{
	rAddress1.clear();
	rAddress1.sendKeys(address1);
	

}
public Boolean checkAddressExists() throws InterruptedException 
{
	//Thread.sleep(100);
	WebDriverWait wait = new WebDriverWait(driver, 5);

	try{
		wait.until(ExpectedConditions.visibilityOf(sweetAlert));
		if (sweetAlert.isDisplayed())
		{return true;}
	}

	catch(Exception e){}


	return false;
	
}
public void clicksweetalert()
{
	confirm.click();
}

public void setriskaddress2(String address2) throws Exception 
{  
	
	rAddress2.clear();
	try 
	{
	Boolean dupaddress=checkAddressExists();
	   if (dupaddress)
	   {  	   
		  clicksweetalert();
	   }
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	rAddress2.sendKeys(address2);

}
public void setriskCity(String city)
{
	rCity.clear();
	rCity.sendKeys(city);

}

public void setriskZip(String zip)
{
	rzip.clear();
	rzip.sendKeys(zip);

}

public void setmAddress1(String address1)
{
	mAddress1.clear();
	mAddress1.sendKeys(address1);

}
public void setmaddress2(String address2)
{
	    mAddress2.clear();
		mAddress2.sendKeys(address2);

}
public void setmCity(String city)
{
	mCity.clear();
	mCity.sendKeys(city);

}

public void setmZip(String zip)
{
	mzip.clear();
	mzip.sendKeys(zip);

}
public void setMailingAddressDiff(String diff) {
	diffMailingAddress.clear();
	diffMailingAddress.sendKeys(diff);
}


public void setPState(String state)
{
   //driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
   WebDriverWait wait = new WebDriverWait(driver, 10);
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[3]")))).click();
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='LState_listbox']"))));

   List<WebElement> PState= (driver.findElements(By.xpath(".//*[@id='LState_listbox']/li")));

     for (WebElement State:PState)
         {
          if (State.getText().equals(state))
            {
        	  State.click();
        	  break;
             }
          }    

  }
public void setMState(String state)
{
   //driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
   WebDriverWait wait = new WebDriverWait(driver, 10);
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[5]")))).click();
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='MState_listbox']"))));

   List<WebElement> PState= (driver.findElements(By.xpath(".//*[@id='MState_listbox']/li")));

     for (WebElement State:PState)
         {
          if (State.getText().equals(state))
            {
        	  State.click();
        	  break;
             }
          }    

  }
public Boolean checkPAValidation() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 1);

	//Thread.sleep(500);
	try
	{   wait.until(ExpectedConditions.visibilityOf(pAddressmodal));
	if (pAddressmodal.isDisplayed()) {
		return true;}
	}	 
	catch(Exception e) {}
	return false;
}
public Boolean checkMAValidation() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 1);

	// Thread.sleep(500);
	try{wait.until(ExpectedConditions.visibilityOf(mAddressmodal));
	if (mAddressmodal.isDisplayed())
	{
		return true;
	}
	} 
	catch (Exception e)
	{}

	return false;
}
public void paddressValidation() throws InterruptedException
{      WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useEnteredPhys"))));
if (driver.findElement(By.id("useUSPSPhys")).isDisplayed())
{
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("useUSPSPhys")))).click();
}
else 
{
	driver.findElement(By.id("useEnteredPhys")).click();
}
}
public void maddressValidation() throws InterruptedException
{       WebDriverWait wait = new WebDriverWait(driver, 40);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useEnteredMail"))));
	
	   if (driver.findElement(By.id("useUSPSMail")).isDisplayed())
	   {
		   driver.findElement(By.id("useUSPSMail")).click();
	   }
	   else 
	   {
		   driver.findElement(By.id("useEnteredMail")).click();
	   }
}
/*public void setCounty_Parish(String county)
{
	
       WebDriverWait wait=new WebDriverWait(driver,5);
       //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmAppAddress']/div[2]/div[12]/div/span/span/span[1]")))).click();
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[6]")))).click();
       driver.findElement(By.xpath("(//span[@class='k-input'])[6]")).click();
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='LParish_listbox']"))));//changed the tagname to xpath on 9/18
	   List<WebElement> county1= (driver.findElements(By.xpath(".//*[@id='LParish_listbox']/li")));

	   for (WebElement parish:county1)
       {
        if (parish.getText().contains(county))

          {
        parish.click();
        break;
           }
        }   

}*/

public void setCounty_ParishIE(String county)
{
	selectfromdropdown(20, spanparish, ulparish, liparish, county);

}

public void setCounty_ParishChrome(String county)
{
	selectfromparishdropdown(20, spanparish, ulparish, liparish, county);

}


/*public void setCounty_Parish(String county)
{
//driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
  WebDriverWait wait = new WebDriverWait(driver, 10);
  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmAppAddress']/div[2]/div[12]/div/span/span/span[1]")))).click();
  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));

  List<WebElement> county1= (driver.findElements(By.tagName("li")));

    for (WebElement parish:county1)
        {
         if (parish.getText().equalsIgnoreCase(county))

           {
         parish.click();
            }
         }    

}
*/

public void checkPAModal() 
{
	
	if (pAddressmodal.isDisplayed())
	{
		
		   WebDriverWait wait = new WebDriverWait(driver, 10);
		   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useEnteredPhys"))));
		   if (driver.findElement(By.id("useUSPSPhys")).isDisplayed())
	 	   {
	 		   driver.findElement(By.id("useUSPSPhys")).click();
	 	   }
	 	   else 
	 	   {
	 		   driver.findElement(By.id("useEnteredPhys")).click();
	 	   }
		           			    		
	}
	
	
	
	
}

public void checkMAModal()
{
	
	if (mAddressmodal.isDisplayed())
	{
		   WebDriverWait wait = new WebDriverWait(driver, 10);
		   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useEnteredMail"))));
		   if (driver.findElement(By.id("useUSPSMail")).isDisplayed())
	 	   {
	 		   driver.findElement(By.id("useUSPSMail")).click();
	 	   }
	 	   else 
	 	   {
	 		   driver.findElement(By.id("useEnteredMail")).click();
	 	   }
		            			    		
	}
	
}
public void SaveandNext() throws InterruptedException
{ 
	//waitforelementtobeclickable(next,10);
	next.click();
	//Thread.sleep(300);
	
	/*try {
		  waitforelementtobeclickable(confirm, 5);
		  if(confirm.isDisplayed())
		  {
			  
			  confirm.click();
			  next.click();
		  }
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}*/
	try {
		Boolean paddressvalidation=checkPAValidation();
		if (paddressvalidation)
	 	{  
	 		Actions act=new Actions(driver);
	 		act.moveToElement(enteredPhys).click(enteredPhys).perform();
	 	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Boolean maVAlidation;
	try {
		maVAlidation = checkMAValidation();
		if (maVAlidation)
		{
			Actions act=new Actions(driver);
			act.moveToElement(enteredmail).click(enteredmail).perform();
			
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
public void modaldialog() throws Exception {
	
	
	//Thread.sleep(1000);
	
	Boolean paVAlidation= checkPAValidation();
	if (paVAlidation)
	{
		paddressValidation();
		
	}
	
	Boolean maVAlidation=checkMAValidation();
	if (maVAlidation)
	{
		maddressValidation();
		
	}

/*if (okButton.isDisplayed())
	
{
	okButton.click();
	
}*/
	   
}


public void selectValidPaddress()
{
	WebElement enteredPhys=driver.findElement(By.xpath("//div[@id='phyAddressModal']//button[contains(.,'Use Entered Address' )]"));//div[@id='phyAddressModal']//button[contains(.,'Use Entered Address' )]
	WebElement uspsPhys=driver.findElement(By.xpath("//div[@id='phyAddressModal']//button[contains(.,'Use USPS Address' )]")); ////div[@id='phyAddressModal']//button[contains(.,'Use USPS Address' )]
	if (uspsPhys.isDisplayed())
	{

		uspsPhys.click();

	}
	else

		if (enteredPhys.isDisplayed())
		{

			enteredPhys.click();

		}
}


public void selectValidMaddress()
{   
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	WebElement enteredMail=driver.findElement(By.id("//div[@id='mailAddressModal']//button[contains(.,'Use Entered Address' )]"));//div[@id='mailAddressModal']//button[contains(.,'Use Entered Address' )]
	wait.until(ExpectedConditions.elementToBeClickable(enteredMail));
	WebElement uspsMail=driver.findElement(By.id("//div[@id='mailAddressModal']//button[contains(.,'Use USPS Address' )]"));
	/*if (uspsMail.isDisplayed())
	{

		uspsMail.click();

	}
	else*/

		if (enteredMail.isDisplayed())
		{

			enteredMail.click();

		}
}

public void setRiskAddress(String address1,String address2,String city,String pstate,String riskZip,String maddress1,String maddress2,String mcity,String mstate,String mzip,String parish,String mailingdiffreason) throws Exception
{
	setriskAddress1(address1);
	setriskaddress2(address2);
	setriskCity(city);
	setPState(pstate);
	setriskZip(riskZip);
	setmAddress1(maddress1);
	setmaddress2(maddress2);
	setmCity(mcity);
	setMState(mstate);
	setmZip(mzip);
	if ((address1!=maddress1)||(address2!=maddress2)||(city!=mcity)||(pstate!=mstate)||(riskZip!=mzip))
	   {
		   
		   setMailingAddressDiff(mailingdiffreason);
	   }
	if(driver instanceof ChromeDriver)
	{
		setCounty_ParishChrome(parish);
	}
	setCounty_ParishIE(parish);
	SaveandNext();	
	waitForPageToLoad(5);
	//waitforelementtobevisible(driver.findElement(By.id("Convictions")),90);

}

	
}
