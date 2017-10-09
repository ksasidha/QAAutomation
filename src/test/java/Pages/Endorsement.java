package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testcases.TestBase;

public class Endorsement extends TestBase{


	@FindBy(id="ConInterest")
	WebElement contrInterest;

	@FindBy(id="LossAssessments")
	WebElement lossAssessments;

	@FindBy(id="AdditionalInsured")
	WebElement additionalInsured;

	@FindBy(id="LossAssessmentsAmount")
	WebElement covD;

	@FindBy(xpath=".//*[@id='additionalInsuredGrid']/div/a")
	WebElement addAI;

	@FindBy(linkText="Update")
	WebElement update;

	@FindBy(id="FirstName")
	WebElement fname;

	@FindBy(id="LastName")
	WebElement lname;

	@FindBy(id="AddressLine1")
	WebElement addline1;

	@FindBy(id="AddressLine2")
	WebElement addline2;

	@FindBy(id="City")
	WebElement city;

	@FindBy(id="zipcode")
	WebElement zip;

	@FindBy(name="HoaOrCorp")
	WebElement hoaorcorp;

	@FindBy(id="HoaName")
	WebElement hoa;

	@FindBy(id="CropName")
	WebElement corp;
	
	@FindBy(id="bSave")
	WebElement save;
	
	@FindBy(id="bNext")
	WebElement bnext;



	private WebDriver driver;


	public Endorsement(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	public void setContractorsInterest()
	{   
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(contrInterest)).click();;
		
		}
		catch(Exception e) {}
	     

	}
	public void setLossAssessment()
	{   WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.elementToBeClickable(lossAssessments));
	Actions act=new Actions(driver);
	act.moveToElement(lossAssessments).click(lossAssessments).perform();



	}
	public void setCoverageD(String coverageD)
	{    WebDriverWait wait = new WebDriverWait(driver, 60);
	     wait.until(ExpectedConditions.elementToBeClickable(covD));
	     covD.clear();
	     covD.sendKeys(coverageD);

	}
	public void setAdditionalInsured()
	{
		additionalInsured.click();
	} 




	public void setPerson(String firstname,String lastname)
	{   WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.elementToBeClickable(fname));
      wait.until(ExpectedConditions.elementToBeClickable(lname));
      
		fname.clear();
		fname.sendKeys(firstname);

		lname.clear();
		lname.sendKeys(lastname);


	}

	public void setAddress(String addressline1,String aicity,String state, String aizip)
	{

		addline1.clear();
		addline1.sendKeys(addressline1);

		/*addline2.clear();
		addline2.sendKeys(addressline2);	*/	

		city.clear();
		city.sendKeys(aicity);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='additionalAddress']/span/span/span[1]")))).click();
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


		zip.clear();
		zip.sendKeys(aizip);

		
	}
	public void sethoacorp(String aitype,String hoaname,String corpname)
	{

		if(aitype.equalsIgnoreCase("HOA"))
		{ 

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='additionalInsuredForm']/div/span/span/span[1]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
			List<WebElement> Type= (driver.findElements(By.tagName("li")));

			for(WebElement type:Type)
			{

				if (type.getText().equals("Homeowners Association"))

				{type.click();
				break;
				}


			}
			hoa.sendKeys(hoaname); 


		}

		else if(aitype.equalsIgnoreCase("Corp"))
		{ 

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='additionalInsuredForm']/div/span/span/span[1]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
			List<WebElement> Type= (driver.findElements(By.tagName("li")));

			for(WebElement type:Type)
			{

				if (type.getText().equals("Corporation"))

				{type.click();
				break;
				}

			}
			corp.sendKeys(corpname);


		}
		
		



	}

public void setAI()
{     WebDriverWait wait = new WebDriverWait(driver, 5);
	
	try {
	
		wait.until(ExpectedConditions.elementToBeClickable(addAI));
    	 	   
    	 	  Actions act=new Actions(driver);
			  act.moveToElement(addAI).perform();
			  act.click(addAI).perform();
			  
			
    	
			  }catch(Exception e) {
				  
				  System.out.println(e);
			  }
       
    
    
}

public void setPersonorHOAorCorp(String type,String fname,String lname,String hoaname,String corpname )
{
	if (type.equalsIgnoreCase("Person"))
	{
		setPerson(fname,lname);

	}
	else if(type.equalsIgnoreCase("HOA") || type.equalsIgnoreCase("Corp"))
	{   

		
		
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='additionalInsuredForm']/div/div[1]/label")))).click();
		
	try {
		  if(driver.findElement(By.xpath(".//*[@id='additionalInsuredForm']")).isDisplayed())
		  {   
			  WebElement e=driver.findElement(By.xpath(".//*[@id='additionalInsuredForm']/div/div[1]/label"));
			  Boolean b=e.isDisplayed();
			  if(b)
			  {
				  WebDriverWait wait = new WebDriverWait(driver, 40);
				  wait.until(ExpectedConditions.elementToBeClickable(e));
				  Actions act=new Actions(driver);
				  act.moveToElement(e).click(e).perform();
			  } 
		//hoaorcorp.click();
		}
	}
		
		catch(Exception e) {}
	  sethoacorp(type,hoaname,corpname);
}

}

public void clickupdate()
{
	update.click();
    WebDriverWait wait = new WebDriverWait(driver, 3);
    try {
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(".//*[@id='divLoading']/img"))));}catch(Exception e) {		
		}
}

public void save()
{   WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(save));
	save.click();
}

	public void setEndorsements(String conInterest,String Lossassess,String coverageD ,String AddInsured,String numAi,String [][] AI ) throws InterruptedException
	{  
		if(conInterest.equalsIgnoreCase("yes"))
		{
			setContractorsInterest();}

		if(Lossassess.equalsIgnoreCase("yes"))
		{

			setLossAssessment();
			setCoverageD(coverageD);

		}
		if (AddInsured.equalsIgnoreCase("yes"))
		{

			setAdditionalInsured();



		}
		int num=Integer.parseInt(numAi);
		for (int i=0;i<num;i++)

		{
			
			setAI();
			setPersonorHOAorCorp(AI[i][0],AI[i][1],AI[i][2],AI[i][3],AI[i][4]);				
			setAddress(AI[i][5],AI[i][6] ,AI[i][7],AI[i][8]);
			clickupdate();
			//Thread.sleep(1000);
			waitForPageToLoad(5);
			//save();
			
			 
	 }	
		waitforelementtobeclickable(bnext,10);
		clickNext();
		    
	}


	

}



