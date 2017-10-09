package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testcases.TestBase;

public class ClientManagement extends TestBase{
	
	//adding comment to code to
	// changing the doo
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
	
	@FindBy(id="mailAddressModal")
	public
	WebElement mAddressmodal; 
	
	@FindBy(id="dupesModal")
	public
	WebElement cdupesModal; 
	
	@FindBy(xpath=".//*[@id='useEnteredPhys']")
	public	
	WebElement enteredPhys; 
	
	@FindBy(xpath=".//*[@id='useUSPSPhys']")	
	WebElement uspsPhys; 
	
	@FindBy(id="useEnteredMail")
	public	
	WebElement enteredmail;
	@FindBy(id="finalSubmit")
	public	
	WebElement finalsubmit;
	
	  @FindBy(linkText="Client")
	  public WebElement client;
	
	
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
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[2]")))).click();
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='physicalAddress_StateId_listbox']"))));    	   	
       
       List<WebElement> PState= (driver.findElements(By.xpath(".//*[@id='physicalAddress_StateId_listbox']/li")));

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
       
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[3]")))).click();
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='mailingAddress_StateId_listbox']"))));

       List<WebElement> PState= (driver.findElements(By.xpath(".//*[@id='mailingAddress_StateId_listbox']/li")));

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
    
    public void setContact(String Contact)
    {
    	contact.clear();
    	contact.sendKeys(Contact);
    }	
/* public void clickNext()
 {
	 
	 CreateQuote.click();
	String str=driver.getCurrentUrl();
	return str;
 }*/
    
   /* public void createNewQuote() throws Exception
    {
    	CreateQuote.click();
    	 Thread.sleep(500);
         	Boolean paddressvalidation=checkPAValidation();
    	if (paddressvalidation)
    	{  
    		Actions act=new Actions(driver);
    		act.moveToElement(enteredPhys).click(enteredPhys).perform();
    	}
    	Thread.sleep(500);
   	   	Boolean maddressvalidation=checkMAValidation();
   	   	if (maddressvalidation)
   	   	{
   	   	Actions act=new Actions(driver);
		act.moveToElement(enteredmail).click(enteredmail).perform();

   	   	}
   	    Thread.sleep(500);   	   
		Boolean dupesmodal=checkdupesmodal();
		 
		 if (dupesmodal)
		 //{selectDupesModal();}
			 {driver.findElement(By.id("finalSubmit")).click();}
		 
    }*/
 
 public void createNewQuote()
 {
	 CreateQuote.click();
	 
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
	 
	 
	try {
		 Boolean maddressvalidation = checkMAValidation();
		 if (maddressvalidation)
		   	{
		   	Actions act=new Actions(driver);
			act.moveToElement(enteredmail).click(enteredmail).perform();

		   	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   	try
	   	{
	   		Boolean cdupesmodal=checkdupesmodal();
	   		if(cdupesmodal)
	   		{   
	   			Actions act=new Actions(driver);
				act.moveToElement(driver.findElement(By.id("finalSubmit"))).click(driver.findElement(By.id("finalSubmit"))).perform();
	   			
	   		}
	   	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	waitForPageToLoad(10);
 }
		 	 
		    
		 
		/* WebDriverWait wait = new WebDriverWait(driver, 60);
    	wait.until(ExpectedConditions.visibilityOf(pAddressmodal));
    	if (pAddressmodal.isDisplayed())
    	{pAddressValidation();}
    	wait.until(ExpectedConditions.visibilityOf(mAddressmodal));
    	if (mAddressmodal.isDisplayed())
    	{mAddressValidation();}
    	wait.until(ExpectedConditions.visibilityOf(cdupesModal));
    	if (cdupesModal.isDisplayed())
    	{selectDupesModal();}*/
			
    
       
       
   public Boolean checkPAValidation() throws Exception {
	   
	   WebDriverWait wait = new WebDriverWait(driver, 5);//30 seconds work
     	
	    try
	    { wait.until(ExpectedConditions.visibilityOf(pAddressmodal));
	    	if (pAddressmodal.isDisplayed()) {
	    	 return true;}
	     }	 
	    catch(Exception e) {}
	     return false;
   }
   public Boolean checkMAValidation() throws Exception {
	   
	    WebDriverWait wait = new WebDriverWait(driver, 5);//30 seconds work
	   
	     try{
	    	 wait.until(ExpectedConditions.visibilityOf(mAddressmodal));
	    	 if (mAddressmodal.isDisplayed())
	    	 {
	    	 return true;
	         }
	     } 
	     catch (Exception e)
	     {}
	     
		return false;
  }
   public boolean checkdupesmodal() throws Exception
   {
	   
	   WebDriverWait wait = new WebDriverWait(driver, 5); //30 seconds work
	    try
	    {
	    	wait.until(ExpectedConditions.visibilityOf(cdupesModal));
	    	if (cdupesModal.isDisplayed()) {
		   
         return true;}
	    }
	   
	  
		   catch (Exception e)
	    {}
	     return false;}
   
   /*public void paddressValidation()
   {   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.elementToBeClickable(enteredPhys)).click();
	   if (enteredPhys.isDisplayed())
 	   {
		   Actions act=new Actions(driver);
 		  act.moveToElement(enteredPhys).click().build().perform();
 	   }
 	   else 
 	   {Actions act=new Actions(driver);
 	   act.moveToElement( uspsPhys).click();
 	   }
   }
   public void maddressValidation()
   {   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useEnteredMail"))));
	   if (driver.findElement(By.id("useUSPSMail")).isDisplayed())
 	   {
 		   driver.findElement(By.id("useUSPSMail")).click();
 	   }
 	   else 
 	   {
 		   driver.findElement(By.id("useEnteredMail")).click();
 	   }
   }*/
   
    /*public void pAddressValidation()
    {  WebDriverWait wait = new WebDriverWait(driver, 60);
    	if (wait.until(ExpectedConditions.visibilityOf(pAddressmodal)).isDisplayed())
        {
     	   //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("useUSPSPhys"))));
     	   if (driver.findElement(By.id("useUSPSPhys")).isDisplayed())
     	   {
     		   driver.findElement(By.id("useUSPSPhys")).click();
     	   }
     	   else 
     	   {
     		   driver.findElement(By.id("useEnteredPhys")).click();
     	   }
        }
        
    	
    }*/
    /*public void mAddressValidation() {
    	WebDriverWait wait = new WebDriverWait(driver, 60);
    	if (wait.until(ExpectedConditions.visibilityOf(mAddressmodal)).isDisplayed())
        {
     	   if (driver.findElement(By.id("useUSPSMail")).isDisplayed())
     	   {
     		   driver.findElement(By.id("useUSPSMail")).click();
     	   }
     	   else 
     	   {
     		   driver.findElement(By.id("useEnteredMail")).click();
     	   }
        }
        */
    
   /* public void selectDupesModal()
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finalSubmit")))).isDisplayed())
   	 {
   		 
   		 driver.findElement(By.id("finalSubmit")).click();
   	 }
   	 
    }*/
  
   
   public void  createClient(String fname,String lname,String email,String dob,String Paddressln1,String Paddressln2,
		   String Pcity,String Pstate,String Pzip,String Maddressln1,
		   String maddressln2,String Mcity,String Mstate,String Mzip,String phone)
   {
	   setFirstName(fname);
	   setLastName(lname);
	   setEmail(email);
	   setDOB(dob);
	   setPAddress1(Paddressln1);
	   setPAddress2(Paddressln2);
	   setPcity(Pcity);
	   setPState(Pstate);
	   setPzip(Pzip);
	   setMAddress1(Maddressln1);
	   setMAddress2(maddressln2);
	   setMcity(Mcity);
	   setMState(Mstate);
	   setMzip(Mzip);
	   setContact(phone);
	   createNewQuote();	   
	   
	   
   }
   
	
    
}
