package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Testcases.TestBase;

public class HomeInterior extends TestBase{
	WebDriver driver;
 
	public HomeInterior(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void setSolidFuel(String solidFuel)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='WoodBurning']"))));
		List <WebElement> SolidFuel=driver.findElements(By.xpath(".//*[@id='WoodBurning']"));	  
		   
		 if (solidFuel.equalsIgnoreCase("yes"))
			 SolidFuel.get(0).click();
		 else
			 SolidFuel.get(1).click();
		
	}
	public void setListinUW(String appList)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='ApplianceListed']"))));
		List <WebElement> AppList=driver.findElements(By.xpath(".//*[@id='ApplianceListed']"));	  
		   
		 if (appList.equalsIgnoreCase("yes"))
			 AppList.get(0).click();
		 else
			 AppList.get(1).click();
		
	}
	
	public void setInstalledProf(String appInst)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='ApplianceInstalled']"))));
		List <WebElement> AppInstalled=driver.findElements(By.xpath(".//*[@id='ApplianceInstalled']"));	  
		   
		 if (appInst.equalsIgnoreCase("yes"))
			 AppInstalled.get(0).click();
		 else
			 AppInstalled.get(1).click();
		
	}
	public void setProperlymaintained(String ventsys)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='VentingSystem']"))));
		List <WebElement> VentingSystem=driver.findElements(By.xpath(".//*[@id='VentingSystem']"));	  
		   
		 if (ventsys.equalsIgnoreCase("yes"))
			 VentingSystem.get(0).click();
		 else
			 VentingSystem.get(1).click();
		
	}
	public void setSameFuelPipe(String woodBurn)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='WoodBurningAppliance']"))));
		List <WebElement> woodBurning=driver.findElements(By.xpath(".//*[@id='WoodBurningAppliance']"));	  
		   
		 if (woodBurn.equalsIgnoreCase("yes"))
			 woodBurning.get(0).click();
		 else
			 woodBurning.get(1).click();
		
	}
	public void setSoleSource(String soleSource)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='SolidFuel']"))));
		List <WebElement> SolidFuel=driver.findElements(By.xpath(".//*[@id='SolidFuel']"));	  
		   
		 if (soleSource.equalsIgnoreCase("yes"))
			 SolidFuel.get(0).click();
		 else
			 SolidFuel.get(1).click();
		
	}
	
	public void setHomeInterior(String solidFuel,String appList,String appInst,String ventsys,String woodBurn,String soleSource)
	{
		setSolidFuel(solidFuel);
		if (solidFuel.equalsIgnoreCase("yes"))
		{
			setListinUW(appList);
			setInstalledProf(appInst);
			setProperlymaintained(ventsys);
			setSameFuelPipe(woodBurn);
			setSoleSource(soleSource);
		}	
		clickNext();
		
	}
	
	
	
}
