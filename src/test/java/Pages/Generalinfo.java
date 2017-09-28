package Pages;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Testcases.TestBase;

public class Generalinfo extends TestBase{
  

	@FindBy(id="YearBuilt")
	WebElement yearBuilt;
	
	@FindBy(id="YearPurchased")
	WebElement yearPurchased;
	
	@FindBy(id="SquareFootage")
	WebElement squarefootage;
	
	@FindBy(id="ReportDate")
	WebElement reportdate;
	
	@FindBy(xpath=".//*[@id='ReportValue']")
	WebElement ercost;
	
	@FindBy(id="RenovationComments")
	WebElement renoComments;
	
	private WebDriver driver;
	
	public Generalinfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void setYearBuilt(String year)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(yearBuilt));
		yearBuilt.clear();
		yearBuilt.sendKeys(year);
		
	}
	public void setYearPurchased(String yearpurchased)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(yearPurchased));
		yearPurchased.clear();
		yearPurchased.sendKeys(yearpurchased);
	}
	
	public void setSquareFootage(String squarefeet)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(squarefootage));
		squarefootage.clear();
		squarefootage.sendKeys(squarefeet);
	}
	
	public void setpropertydamage(String damage)
	{
		   //WebDriverWait wait = new WebDriverWait(driver, 60);
		  // wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Damage']]"))));
			List <WebElement> Damage=driver.findElements(By.xpath(".//*[@id='Damage']"));	  
			   
			 if (damage.equalsIgnoreCase("yes"))
				 Damage.get(0).click();
			 else
				 Damage.get(1).click();
		
	}
	public void setDwellingBuilt(String landfill)
	{
		
		   WebDriverWait wait = new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Landfill']"))));
			List <WebElement> Landfill=driver.findElements(By.xpath(".//*[@id='Landfill']"));	  
			   
			 if (landfill.equalsIgnoreCase("yes"))
				 Landfill.get(0).click();
			 else
				 Landfill.get(1).click();
		
	}

	public void setReportDate(String rdate)
	{
		   WebDriverWait wait = new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[6]/div[1]/span/span"))));
		  WebElement reportdate=driver.findElement(By.xpath("//*[@id='ReportDate']"));
				
		 driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[6]/div[1]/span/span")).click();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[1].value=arguments[0];",rdate,reportdate);
		 //js.executeScript("document.getElementById('ReportDate').value=rdate;");

		
		/*SimpleDateFormat formatter=new SimpleDateFormat("MMM/dd/yyyy");
		Date dt=new Date(rdate);
		String date=formatter.format(dt);
		String[] date1=date.split("/");
		String day=date1[1];
		String month=date1[0];
		String year=date1[2];		
		int currentyear=Year.now().getValue();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[6]/div[1]/span/span/span/span")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'"+currentyear+"')] [@role='button']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'"+currentyear+"')]")))).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='ReportDate_dateview']/div/table/tbody/tr/td/a"))));
		List<WebElement> years=driver.findElements(By.xpath(".//*[@id='ReportDate_dateview']/div/table/tbody/tr/td/a"));

		for (WebElement yearentered:years)

		{

			if (yearentered.getText().equals(year))
			{
				yearentered.click();
			    break;}

		}*/
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ReportDate_dateview']/div/table/tbody/tr/td/a[contains(text(),'"+month+"')]")))).click();
		/*List<WebElement> months=driver.findElements(By.xpath(".//*[@id='ReportDate_dateview']/div/table/tbody/tr/td/a"));

		for (WebElement monthentered:months)

		{
             String m=monthentered.getText();
			if (m.contains(month))
			{ 
				
				monthentered.click();
					
			    break;
			}

		}*/
		
	/*	
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='ReportDate_dateview']/div/table/tbody/tr/td/a"))));
		List<WebElement> dates=driver.findElements(By.xpath(".//*[@id='ReportDate_dateview']/div/table/tbody/tr/td/a"));

		for (WebElement dateentered:dates)

		{

			if (dateentered.getText().equals(day))
			{
				dateentered.click();
			    break;}

		}*/
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),'"+month+"')]")))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),'"+day+"')]")))).click();
		
		
		
		
	}
	public void setEstimatedReplacementCost(String erCost)
	{   driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[6]/div[2]/span")).click();
		ercost.clear();
		ercost.sendKeys(erCost);
			}
	
	public void setReportSource(String rsource)
	{
		
		/* WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[7]/div[1]/span/span/span[1]")))).click();
	     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='ReportSource_listbox']/li"))));*/
		//List<WebElement> lossnum=driver.findElements(By.tagName("li"));//ul[@id='Losses5yr_listbox']/li
		WebDriverWait wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[7]/div[1]/span/span/span[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[2]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='ReportSource_listbox']/li"))));
	    List<WebElement> reportSource=driver.findElements(By.xpath("//ul[@id='ReportSource_listbox']/li"));
	    
		for (WebElement ReportSource:reportSource)
		
		{
			String str=ReportSource.getText();
			if (ReportSource.getText().contains(rsource))
				{ReportSource.click();
				break;}
			
		}
	}
	public void setConstructionType(String construction)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 60);//30 was not working,90 didnt work sometimes 100 didnt work 120 didnt work 150 didnt work
		 
		 try
		 {//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[9]/div[1]/span/span/span[1]"))));
			 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[3]"))));
			 
			 driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[9]/div[1]/span/span/span[1]")).click();}
		 
		 catch(Exception e) {}
	     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='Construction_listbox']/li"))));
		 //driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[9]/div[1]/span/span/span[1]")).click();
		// driver.findElement(By.xpath("//ul[@id='Construction_listbox']/li"));
		    List<WebElement> constructionType=driver.findElements(By.xpath("//ul[@id='Construction_listbox']/li"));
	    
		for (WebElement Construction:constructionType)
		
		{
			
			if (Construction.getText().contains(construction))
				{Construction.click();
				break;
				}
			
		}
		
		
	}
	public void setNumberOfStories(String story)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmPropGenInfo']/div[1]/div[9]/div[2]/span/span/span[1]")))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[4]")))).click();
	     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='Stores_listbox']/li"))));
		//List<WebElement> lossnum=driver.findElements(By.tagName("li"));//ul[@id='Losses5yr_listbox']/li
	    List<WebElement> Stories=driver.findElements(By.xpath("//ul[@id='Stores_listbox']/li"));
	    
		for (WebElement stories:Stories)
		
		{
			
			if (stories.getText().equals(story))
				{stories.click();
				break;
				}
			
		}
		
		
	}
	public void setPrefabricated(String prefab)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Prefab']"))));
			List <WebElement> Prefabricated=driver.findElements(By.xpath(".//*[@id='Prefab']"));	  
			   
			 if (prefab.equalsIgnoreCase("yes"))
				 Prefabricated.get(0).click();
			 else
				 Prefabricated.get(1).click();
	}
	
	public void setMobileManufactured(String mobile)
	{
		List <WebElement> Mobile=driver.findElements(By.xpath(".//*[@id='Mobile']"));
		if (mobile.equalsIgnoreCase("yes"))
			Mobile.get(0).click();
		 else
			 Mobile.get(1).click();
		
	}
	public void setRenovation(String Reno)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Renovations']"))));
			List <WebElement> Renovation=driver.findElements(By.xpath(".//*[@id='Renovations']"));	  
			   
			 if (Reno.equalsIgnoreCase("yes"))
				 Renovation.get(0).click();
			 else
				 Renovation.get(1).click();
		
	}
	
	public void setRenovationComments(String RenoComm)
	{
		renoComments.clear();
		renoComments.sendKeys(RenoComm);
		
	}
	public void setGeneralinfo(String year,String yearpurchased,String squarefeet,String damage,String landfill)
	{
		
		setYearBuilt(year);
		setYearPurchased(yearpurchased);
		setSquareFootage(squarefeet);
		setpropertydamage(damage);
		setDwellingBuilt(landfill);
		
	}
	
	public void setEstimatedRC(String rdate,String erCost,String rsource)
	{
		
		setReportDate(rdate);
		
		setEstimatedReplacementCost(erCost);
		setReportSource(rsource);
	}
	public void setconstruction_Style(String construction,String story,String prefab,String mobile,String reno,String RenoComm)
	{
		
		setConstructionType(construction);
		setNumberOfStories(story);
		setPrefabricated(prefab);
		if(prefab.equalsIgnoreCase("yes"))
		{
			
			setMobileManufactured(mobile);
		}
		setRenovation(reno);
		if(reno.equalsIgnoreCase("yes"))
		{
			
			setRenovationComments(RenoComm);

		}
		
	}
	
	public void setPropertyGeneralinfo(String year,String yearpurchased,String squarefeet,String damage,String landfill,String rdate,String erCost,String rsource,String construction,String story,String prefab,String mobile,String reno,String RenoComm)
	{  setGeneralinfo(year,yearpurchased,squarefeet,damage,landfill);
	   setEstimatedRC(rdate,erCost,rsource);
	   setconstruction_Style(construction,story,prefab,mobile,reno,RenoComm);
	   clickNext();
	
	
			
	}
	
}

