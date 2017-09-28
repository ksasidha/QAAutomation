package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testcases.TestBase;

public class SafetyFeatures extends TestBase{
  public WebDriver driver;



public  SafetyFeatures(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  
  }

public void setLocksDeadbolt(String locks)

{
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Locks']"))));
	List <WebElement> Locks=driver.findElements(By.xpath(".//*[@id='Locks']"));	  
	   
	 if (locks.equalsIgnoreCase("yes"))
		 Locks.get(0).click();
	 else
		 Locks.get(1).click();
}
public void setBurglarAlarm(String stationBurglar)
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='StationBurglar']"))));
	List <WebElement> StationBurglar=driver.findElements(By.xpath(".//*[@id='StationBurglar']"));	  
	   
	 if (stationBurglar.equalsIgnoreCase("yes"))
		 StationBurglar.get(0).click();
	 else
		 StationBurglar.get(1).click();
	
}

public void setBurglarAlarmType(String burglarAlarmType)
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='BurglarAlarmType']"))));
	List <WebElement> BurglarAlarmType=driver.findElements(By.xpath(".//*[@id='BurglarAlarmType']"));	  
	 if (burglarAlarmType.equalsIgnoreCase("local"))
	 {
		 BurglarAlarmType.get(0).click();
	 }
	 else if (burglarAlarmType.equalsIgnoreCase("central"))
	 {
		 BurglarAlarmType.get(1).click();
		 
	 }
	 else if (burglarAlarmType.equalsIgnoreCase("both"))
	 {
		 
		 BurglarAlarmType.get(2).click();
	 }
}




public void setFireAlarm(String stationFire)
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='StationFire']"))));
	List <WebElement> StationFire=driver.findElements(By.xpath(".//*[@id='StationFire']"));	  
	   
	 if (stationFire.equalsIgnoreCase("yes"))
		 StationFire.get(0).click();
	 else
		 StationFire.get(1).click();
}

public void setFireAlarmType(String fireAlarmType)
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='FireAlarmType']"))));
	List <WebElement> FireAlarmType=driver.findElements(By.xpath(".//*[@id='FireAlarmType']"));	  
	if (fireAlarmType.equalsIgnoreCase("local"))
	 {
		FireAlarmType.get(0).click();
	 }
	 else if (fireAlarmType.equalsIgnoreCase("central"))
	 {
		 FireAlarmType.get(1).click();
		 
	 }
	 else if (fireAlarmType.equalsIgnoreCase("both"))
	 {
		 
		 FireAlarmType.get(2).click();
	 }
	 

}

public void setSafteyFeatures(String locks,String stationBurglar,String burglarAlarmType,String stationFire,String fireAlarmType)
{
	setLocksDeadbolt(locks);
	setBurglarAlarm(stationBurglar);
	if (stationBurglar.equalsIgnoreCase("yes"))
	{
		setBurglarAlarmType(burglarAlarmType);
	}
	setFireAlarm( stationFire);
	if (stationFire.equalsIgnoreCase("yes"))
	{
		setFireAlarmType(fireAlarmType);
	}
	clickNext();
}

}


