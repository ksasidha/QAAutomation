package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientManagement {

	
	@FindBy(id="firstName")
	WebElement fName;
	
	
	@FindBy(id="lastName")
	WebElement lName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="dob")
	WebElement dob;
	
	@FindBy(id="PAddress1")
	WebElement pAddress1;
	
	@FindBy(id="PAddress2")
	WebElement pAddress2;
	
	@FindBy(id="PCity")
	WebElement pCity;
	
	@FindBy(id="save")
	WebElement saveButton;
	
	@FindBy(xpath="//span[contains(.,'State')]") 
	@CacheLookup private WebElement Pstate;
	@FindBy(xpath="//ul[@id='physicalAddress_StateId_listbox']/li")
	@CacheLookup private WebElement ullist;
	
	@FindBy(id="PZip")
	WebElement pZip;

	@FindBy(id="MAddress1")
	WebElement mAddress1;
	
	@FindBy(id="MAddress2")
	WebElement mAddress2;
	
	@FindBy(id="MCity")
	WebElement mCity;
	
	@FindBy(id="MZip")
	WebElement mZip;
	
	@FindBy(id="contactValue")
	WebElement contact;
	
	@FindBy(id="saveAndNewQuoteNew")
	WebElement CreateQuote;
	
	@FindBy(id="saveNew")
	WebElement saveclient;
	
	@FindBy(id="phyAddressModal")
	public
	WebElement pAddressmodal; 
	
	@FindBy(xpath="//div[@class='form-group']/button[@id='useEnteredPhys']")
	public WebElement useEnteredPhys;
	
	@FindBy(xpath="//div[@class='form-group']/button[@id='useUSPSPhys']")
	public WebElement useUSPSPhys;
	
	@FindBy(id="mailAddressModal")
	public
	WebElement mAddressmodal; 
	@FindBy(xpath="//div[@class='form-group']/button[@id='useEnteredMail']")
	public WebElement useEnteredMail;
	
	@FindBy(xpath="//div[@class='form-group']/button[@id='useUSPSMail']")
	public WebElement useUSPSMail;
	
	@FindBy(id="dupesModal")
	public
	WebElement cdupesModal; 
	
WebDriver driver;
	
	public ClientManagement(WebDriver driver )
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 
	}
	public ClientManagement() {
		// TODO Auto-generated constructor stub
	}
	public void setFirstName(String fname)
	{
		
		fName.clear();
		fName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		
		lName.clear();
		lName.sendKeys(lname);
	}
	
	public void setEmail(String cEmail)
	{
		
		email.clear();
		email.sendKeys(cEmail);
		System.out.println("do it");
	}
	public void setDOB(String dateob)
	{
		
		dob.clear();
		dob.sendKeys(dateob);
	}
	
	public void setPAddress1(String paddress1)
	{
		
		pAddress1.clear();
		pAddress1.sendKeys(paddress1);
	}
	public void setPAddress2(String paddress2)
	{
		
		pAddress2.clear();
		pAddress2.sendKeys(paddress2);
		
	}
	public void setPcity(String pcity)
	{
		
		pCity.clear();
		pCity.sendKeys(pcity);
		
	}
	public void setPState(String state)
    {
       //driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")).click();
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[8]/div[2]/span/span[1]/span[1]")))).click();;
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));    	   	
       
       List<WebElement> PState= (driver.findElements(By.tagName("li")));

         for (WebElement State:PState)
             {
              if (State.getText().equals(state))
                {
            	  State.click();
            	  break;
                 }
              }    
  
      }
	public void setPzip(String pzip)
    {
    	pZip.clear();
    	pZip.sendKeys(pzip);
    }	
	public void setMAddress1(String maddress1)
	{
		
		mAddress1.clear();
		mAddress1.sendKeys(maddress1);
	}
	public void setMAddress2(String maddress2)
	{
		
		mAddress2.clear();
		mAddress2.sendKeys(maddress2);
		
	}
	public void setMcity(String mcity)
	{
		
		mCity.clear();
		mCity.sendKeys(mcity);
		
	}
    public void setMState(String state)
    {
       driver.findElement(By.xpath(".//*[@id='clientForm']/div[1]/div[15]/div[2]/span/span[1]/span[1]")).click();
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));

       List<WebElement> PState= (driver.findElements(By.tagName("li")));

         for (WebElement State:PState)
             {
              if (State.getText().equals(state))
                {
            	  State.click();
            	  break;
                 }
              }    
  
      }
    
    public void setMzip(String mzip)
    {
    	mZip.clear();
    	mZip.sendKeys(mzip);
    	
    }
    
    
    public void setClientinfo(String fname,String lname,String email,String dob)
    {
    	
    	setFirstName(fname);
		setLastName(lname);
		setEmail(email);
		setDOB(dob);
    	
    }
   
    
    public void setpAddress(String paddress1,String paddress2,String pcity,String pstate,String pzip)
	{
		
		setPAddress1(paddress1);
		setPAddress2(paddress2);
		setPcity(pcity);
		setPState(pstate);
		setPzip(pzip);
		
		
		
	}
    
    public void setmAddress(String maddress1,String maddress2,String mcity,String mstate,String mzip )
	{
		
		setMAddress1(maddress1);
		setMAddress2(maddress2);
		setMcity(mcity);
		setMState(mstate);
		setMzip(mzip);
	
		
		
	}
    public void setContact(String Contact)
    {
    	contact.clear();
    	contact.sendKeys(Contact);
    }	
    public void saveAndCreateQuote() throws InterruptedException
    {
    	
    	CreateQuote.click();
    	
    	    	
    	
    	
    	
    }
    public void checkPAModal() 
    {
    	
    	//if (pAddressmodal.isDisplayed())
    	//{
    		
    		//WebDriverWait wait = new WebDriverWait(driver, 10);
    		 //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useEnteredPhys"))));
    		  // if (driver.findElement(By.id("useUSPSPhys")).isDisplayed())
    	 	  // {
    	 		 //  driver.findElement(By.id("useUSPSPhys")).click();
    	 	  // }
    	 	  //// else 
    	 	  // {   
    	 		   
    	 		   
    	 	   //}
    		           			    		
    	}
    	
    
    
    public void checkMAModal() throws InterruptedException
    {
    	
    	//if (mAddressmodal.isDisplayed())
    	//{
    		//WebDriverWait wait = new WebDriverWait(driver, 10);
    		 //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useEnteredMail"))));
    		/*   if (driver.findElement(By.id("useUSPSMail")).isDisplayed())
    	 	   {
    	 		   driver.findElement(By.id("useUSPSMail")).click();
    	 	   }
    	 	   else 
    	 	   {*/
    	//Thread.sleep(100);
    	try
    	{
    	if (driver.findElement(By.xpath(".//button[@id='useEnteredPhys']")).isDisplayed())
		   {
    		//WebDriverWait wait = new WebDriverWait(driver, 10);
   		    // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//button[@id='useEnteredPhys']")))).click();
    		WebElement ele=driver.findElement(By.xpath(".//button[@id='useEnteredPhys']"));
    		Actions act=new Actions(driver);
    		act.moveToElement(ele).click().build().perform();
		   }
    	 		  if (driver.findElement(By.xpath(".//button[@id='useEnteredMail']")).isDisplayed())
    	 		   {driver.findElement(By.xpath(".//button[@id='useEnteredMail']")).click();}
    	 		  
    	 		 if(driver.findElement(By.id("finalSubmit")).isDisplayed())
    	 		{
    	 		       		 driver.findElement(By.id("finalSubmit")).click();}}
    	catch(Exception e)
    	{}
    	 	 //  }
    		            			    		
    	//}
    	
    }
    
    public void checkcdupr()
    {
    	//if (cdupesModal.isDisplayed())
    	//{
    		//WebDriverWait wait = new WebDriverWait(driver, 10);
        	//if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finalSubmit")))).isDisplayed())
       	// {
    	if(driver.findElement(By.id("finalSubmit")).isDisplayed())
{
       		 driver.findElement(By.id("finalSubmit")).click();}
       	// }
    		
    	//}
    	
    	
    }
    
    public void save()
    {
    	
    	saveclient.click();
    	
    	
    }
}
