package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Testcases.TestBase;

public class HomeExterior  extends TestBase {
	
	  WebDriver driver;
	
  @FindBy(id="Roof")
  WebElement roof;
  
  
  @FindBy(id="RoofReplaced")
 List<WebElement> roofReplaced;
  
  //RoofCoverTYpe
  @FindBy(xpath="(//span[@class='k-input'])[2]")@CacheLookup
  WebElement spanRoofCoverType;  
  @FindBy(id="CoverType_listbox")@CacheLookup
  WebElement ulRoofCoverType;
  @FindBy(xpath=".//*[@id='CoverType_listbox']/li")@CacheLookup
  List<WebElement> liRoofCoverType;
  
  //Foundationtype
  @FindBy(xpath="(//span[@class='k-input'])[3]")@CacheLookup
  WebElement spanFoundationType;  
  @FindBy(id="FoundationType_listbox")@CacheLookup
  WebElement ulFoundationType;
  @FindBy(xpath=".//*[@id='FoundationType_listbox']/li")@CacheLookup
  List<WebElement> liFoundationType;
  
  //Swimmingpool
  @FindBy(id="SwimmingPool")
 List<WebElement> swimmingPool;
  
//Fence
  @FindBy(id="Fence")
  List<WebElement> Fence;
  //constructor
  public HomeExterior(WebDriver driver)
  {
	  
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  
  //RoofReplaced
  public void setRoofReplaced(String roofReplace)
  {
	  selectRadioOption(roofReplaced, roofReplace);
	  
  }
  
  //RoofReplaced Year
  public void setRoofYear(String roofyear)
  {
	  roof.clear();
	  roof.sendKeys(roofyear);
  }
  
  //Roof Cover Type
  public void setRoofCovertype(String roofCover)
  
  { /* WebDriverWait wait = new WebDriverWait(driver, 30);
     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[2]")))).click();
     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='CoverType_listbox']"))));//changed to xpath on 9/22
     List<WebElement> RoofCoverType=driver.findElements(By.xpath(".//*[@id='CoverType_listbox']/li"));
	    
		for (WebElement Roofcover:RoofCoverType)
		
		{
			String rc=Roofcover.getText();
			if (Roofcover.getText().contains(roofCover))
				{Roofcover.click();
				break;
				}
			
		}*/
		
		selectfromdropdown(60, spanRoofCoverType, ulRoofCoverType, liRoofCoverType, roofCover);
		
  }
  
public void setFoundationType(String Foundation)
  
  { /* WebDriverWait wait = new WebDriverWait(driver, 60);
     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[3]")))).click();
     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='FoundationType_listbox']"))));//changed to xpath on 9/22
     List<WebElement> FoundationType=driver.findElements(By.xpath(".//*[@id='FoundationType_listbox']/li"));
	    
		for (WebElement foundation:FoundationType)
		
		{
			
			if (foundation.getText().contains(Foundation))
				{foundation.click();
				break;
				}
			
		}*/
	selectfromdropdown(60, spanFoundationType, ulFoundationType, liFoundationType, Foundation);
		
  }
public void setSwimmingpool(String swimpool)
{    /*WebDriverWait wait = new WebDriverWait(driver, 30);
     wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='SwimmingPool']"))));
	 List <WebElement> pool=driver.findElements(By.xpath(".//*[@id='SwimmingPool']"));	  
	   
	 if (spool.equalsIgnoreCase("yes"))
		 pool.get(0).click();
	 else
		 pool.get(1).click();*/
	 waitforallelementstobevisible(swimmingPool, 60);
	selectRadioOption(swimmingPool, swimpool);
	
 
}

public void setFence(String fence)
{  /* WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Fence']"))));
	List <WebElement> Fence=driver.findElements(By.xpath(".//*[@id='Fence']"));	  
	   
	 if (fence.equalsIgnoreCase("yes"))
		 Fence.get(0).click();
	 else
		 Fence.get(1).click();*/
	 waitforallelementstobevisible(Fence, 60);
	selectRadioOption(Fence, fence);
}


public void setHomeExterior(String roofReplace,String roofyear,String roofCover,String Foundation,String spool,String fence)
{
	setRoofReplaced(roofReplace);
	if(roofReplace.equalsIgnoreCase("yes")) {
		
		setRoofYear(roofyear);
		
	}
	setRoofCovertype(roofCover);	
	setFoundationType(Foundation);
	setSwimmingpool(spool);
	if(spool.equalsIgnoreCase("yes"))
	{
		setFence(fence);
		
	}
	clickNext();
}
  
}
