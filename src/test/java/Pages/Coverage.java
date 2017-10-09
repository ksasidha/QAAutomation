package Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.Test;

import Testcases.TestBase;

public class Coverage extends TestBase{
	
	@FindBy(id="CoverageA")
	WebElement CoverageA;
	
	@FindBy(xpath="//td/span/span/input[@id='IncreasedLimits']")
	WebElement hoIncreasedLimits;
	
	@FindBy(xpath="//td/span/span/input[@id='IncreasedLimitsBasic']")
	WebElement hobIncreasedLimits;
	
	@FindBy(xpath="//td/span/span/input[@id='CoverageB']")
	WebElement hoCoverageB;
	
	@FindBy(xpath="//td/span/span/input[@id='CoverageBBasic']")
	WebElement hoCoverageBBasic ;
	
	
	@FindBy(id="btnNext")
	WebElement next ;
	
	
	WebDriver driver;
	  public Coverage(WebDriver driver) 
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
		  
	  }
	  
	  public void setPolicyEffectivedate(String effective)
	  {
		  
		     WebElement peffectivedate=driver.findElement(By.xpath(".//*[@id='PolicyEffDate']"));
			 Date dt= new Date();
			 SimpleDateFormat sm = new SimpleDateFormat("MM/dd/yyyy");
			 driver.findElement(By.xpath(".//*[@id='PolicyEffDate']")).click();
		
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[1].value=arguments[0];",sm.format(dt),peffectivedate);
	  }
      
	  
	  public void setCoverageA(String covA)
	  {
		  
		  CoverageA.clear();
		  CoverageA.sendKeys(covA);
		 
	  }
	  
	  public void setLiablity(String liability)
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[7]/div/span/span/span[1]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[2]"))));
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.xpath("(//span[@class='k-input'])[2]"))).click().perform();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Liability_listbox']"))));//changed from tag name to xpath on 9/18
		  List<WebElement> Liability=driver.findElements(By.xpath(".//*[@id='Liability_listbox']/li"));

		  for (WebElement liab:Liability)

		  {
               
			  if (liab.getText().contains(liability))
			  {liab.click();
			  break;
			  }

		  }
	  }
	  
	  public void setMedical(String medical)
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		  try{
			  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[9]/div/span/span/span[1]")))).click();
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[3]"))));
			  Actions act=new Actions(driver);
			  act.moveToElement(driver.findElement(By.xpath("(//span[@class='k-input'])[3]"))).click().perform();
		  }catch(Exception e) {}
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Payment_listbox']"))));//changed from tag name to xpath on 9/18
		  List<WebElement> Payment=driver.findElements(By.xpath(".//*[@id='Payment_listbox']/li"));

		  for (WebElement pay:Payment)

		  {

			  if (pay.getText().contains(medical))
			  {pay.click();
			  break;
			  }

		  }
	  }
	  
	  public void sethoIncreasedLimits(String hoIncLimits)
	  {   
		  driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[10]/div/table/tbody/tr[3]/td[3]/span[1]/span")).click();
		  hoIncreasedLimits.clear();
		  hoIncreasedLimits.sendKeys(hoIncLimits);
		  
	  }
	  
	  public void sethobIncreasedLimits(String hobIncLimits)
	  {
		  driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[10]/div/table/tbody/tr[3]/td[4]/span[1]/span")).click();
		  hobIncreasedLimits.clear();
		  hobIncreasedLimits.sendKeys(hobIncLimits);
		  
	  }
	  
	  public void sethoCoverageB(String hoCovB)
	  {
		  driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[10]/div/table/tbody/tr[5]/td[3]/span[1]/span")).click();
		  hoCoverageB.clear();
		  hoCoverageB.sendKeys(hoCovB);
		  
	  }
	  
	  public void sethobCoverageB(String hobCovB)
	  {
		  driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[10]/div/table/tbody/tr[5]/td[4]/span[1]/span")).click();
		  hoCoverageBBasic.clear();
		  hoCoverageBBasic.sendKeys(hobCovB);
		  
	  }
	  
	  public void setBOL(String bol)
	  {
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		 // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[10]/div/table/tbody/tr[7]/td[2]/span/span/span[1]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[4]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
		  List<WebElement> Ordinance=driver.findElements(By.xpath(".//*[@id='Ordinance_listbox']/li"));

		  for (WebElement ord:Ordinance)

		  {

			  if (ord.getText().equals(bol))
			  {ord.click();
			  break;
			  }

		  }
		  
		  
	  }
	  
	  public void setPolicydeduct(String peril)
	  {
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		 // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[13]/div/span/span/span[1]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[5]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Perils_listbox']"))));//changed the tagname to xpath on 9/18
		  List<WebElement> Perils=driver.findElements(By.xpath(".//*[@id='Perils_listbox']/li"));

		  for (WebElement perils:Perils)

		  {

			  if (perils.getText().equals(peril))
			  {perils.click();
			  break;
			  }

		  }
		  
		  
	  }
	  
	  public void setHurricane(String hurr)
	  {
		  WebDriverWait wait = new WebDriverWait(driver, 60);
		 // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmCovStandard']/div[1]/div[15]/div/span/span/span[1]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[6]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='HurricaneDuration_listbox']"))));//changed the tagname to xpath on 9/18
		  List<WebElement> HurricaneDuration=driver.findElements(By.xpath(".//*[@id='HurricaneDuration_listbox']/li"));

		  for (WebElement hurricane:HurricaneDuration)

		  {

			  if (hurricane.getText().equals(hurr))
			  {hurricane.click();
			  break;
			  }

		  }
		  
		  
	  }
	  
	  public void setCoverage(String effective,String liability,String medical,String hoIncLimits,String hobIncLimits,String hoCovB,String hobCovB,String bol,String peril,String hurr) throws InterruptedException
	  {
		  setPolicyEffectivedate(effective);
		  setLiablity(liability);
		  setMedical(medical);
		  sethoIncreasedLimits(hoIncLimits);
		  sethobIncreasedLimits(hobIncLimits);
		  sethoCoverageB(hoCovB);
		  sethobCoverageB(hobCovB);
		  setBOL(bol);
		  setPolicydeduct(peril);
		  setHurricane(hurr);	
		  setClickNext();
		  
	  }
	  
	  public void setClickNext() throws InterruptedException
	  {
		  next.click();
		 /* WebDriverWait wait = new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(".//*[@id='divLoading']/img"))));*/
		  waitForPageToLoad(10);
	  }
}
