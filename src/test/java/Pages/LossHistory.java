package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LossHistory {
  
	WebDriver driver;
@FindBy(id="Convictions")
WebElement pastCon;

@FindBy(id="Prior5yrs")
WebElement prior5yrs;

@FindBy(id="Prior3yrs")
WebElement prior3yrs;

@FindBy(id="bNext")
WebElement next;

public LossHistory(WebDriver driver) 
   {this.driver=driver;
     PageFactory.initElements(driver, this);
   }

public  void setPastConv(String pastconv)
{
		List <WebElement> passConv=driver.findElements(By.xpath(".//*[@id='Convictions']"));	  
	   System.out.println(passConv.size());
 	 if (pastconv.equalsIgnoreCase("yes"))
 		passConv.get(0).click();
 	 else
 		passConv.get(1).click();	 
}

public void setPrior5yrs(String pfiveyrs)
{  WebDriverWait wait = new WebDriverWait(driver, 60);
   wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Prior5yrs']"))));
	List <WebElement> prior=driver.findElements(By.xpath(".//*[@id='Prior5yrs']"));	  
	   
	 if (pfiveyrs.equalsIgnoreCase("yes"))
		prior.get(0).click();
	 else
		prior.get(1).click();

}
public void setlosses5yrs(String losses)
{    WebDriverWait wait = new WebDriverWait(driver, 60);
	 //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='tr5yr']/div[2]/div[1]/span/span/span[1]")))).click();
     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[2]")))).click();

     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='Losses5yr_listbox']/li"))));
	//List<WebElement> lossnum=driver.findElements(By.tagName("li"));//ul[@id='Losses5yr_listbox']/li
    List<WebElement> lossnum=driver.findElements(By.xpath("//ul[@id='Losses5yr_listbox']/li"));
    
	for (WebElement lossNum:lossnum)
	
	{
		
		if (lossNum.getText().equals(losses))
			{lossNum.click();
			break;}
		
	}
	
}

public void setPrior3yrs(String pthreeyrs)
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(".//*[@id='Prior3yrs']"))));
	List <WebElement> prior3=driver.findElements(By.xpath(".//*[@id='Prior3yrs']"));
	   
	 if (pthreeyrs.equalsIgnoreCase("yes"))
	 {   prior3.get(0).click();}
	 else
	 { prior3.get(1).click();}

}

public void setlosses3yrs(String losses)
{   WebDriverWait wait = new WebDriverWait(driver, 60);
    //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='tr3yr']/div[2]/div[1]/span/span/span[1]")))).click();
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[3]")))).click();
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
	List<WebElement> lossnum=driver.findElements(By.tagName("li"));
	for (WebElement lossNum:lossnum)
			{
		
		if (lossNum.getText().equals(losses))
		{lossNum.click();
		break;}
	}
	
}

public void setnonweather3yrs(String losses)
{
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	 try{wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='trWeather']/div[2]/div[1]/span/span/span[1]")))).click();}catch(Exception e) {}
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
	List<WebElement> lossnum=driver.findElements(By.tagName("li"));
	for (WebElement lossNum:lossnum)
		
	{
		
		if (lossNum.getText().equals(losses))
			{lossNum.click();
		break;}
	}
	
}
public void clickNext()
{
	next.click();

}
public void setLosses(String pastConv,String prior5yrs,String losses5,String prior3yrs,String  losses3,String nonweather)
{
	setPastConv(pastConv);
	setPrior5yrs(prior5yrs);
	if (prior5yrs.equalsIgnoreCase("yes"))
	{
		setlosses5yrs(losses5);
		setPrior3yrs(prior3yrs);
		if (prior3yrs.equalsIgnoreCase("yes"))
		{
			setlosses3yrs(losses3);
			setnonweather3yrs(nonweather);
			
		}
	}
	clickNext();
	
}


}
