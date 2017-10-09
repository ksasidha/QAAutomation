package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testcases.TestBase;


public class FireProtection extends TestBase{
	
	@FindBy(id="FireDepartment")
	WebElement distance;
	WebDriver driver;
  public FireProtection(WebDriver driver) 
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  
  }

  public void setCityLimits(String cityLimits)
  {
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='CityLimits']"))));
		List <WebElement> CityLimits=driver.findElements(By.xpath(".//*[@id='CityLimits']"));	  
		   
		 if (cityLimits.equalsIgnoreCase("yes"))
			 CityLimits.get(0).click();
		 else
			 CityLimits.get(1).click();
	  
  }
  public void setfireDepartment(String fireDepartment)
  {
	  distance.clear();
	  distance.sendKeys(fireDepartment);
  }
  public void setFireHydrant(String fireHydrant)
  {
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='FireHydrant']"))));
		List <WebElement> FireHydrant=driver.findElements(By.xpath(".//*[@id='FireHydrant']"));	  
		   
		 if (fireHydrant.equalsIgnoreCase("yes"))
			 FireHydrant.get(0).click();
		 else
			 FireHydrant.get(1).click();
	  
  
  }
  public void setDwellingAccessible(String dwellingAccessible)
  {
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='DwellingAccessible']"))));
		List <WebElement> DwellingAccessible=driver.findElements(By.xpath(".//*[@id='DwellingAccessible']"));	  
		   
		 if (dwellingAccessible.equalsIgnoreCase("yes"))
			 DwellingAccessible.get(0).click();
		 else
			 DwellingAccessible.get(1).click();
	  
  }
  
  public void setFireProtection(String  cityLimits,String fireDepartment,String fireHydrant,String dwellingAccessible)
    {
	  
	  setCityLimits(cityLimits);
	  setfireDepartment(fireDepartment);
	  setFireHydrant(fireHydrant);
	  setDwellingAccessible(dwellingAccessible);
	  clickNext();
	  
  }
}

