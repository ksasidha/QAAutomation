package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import Utils.ExcelRead;

public class TestBase  {
public static WebDriver driver;
public ExcelRead er;



/*public String username;
public String pass;
public String aor; 
public String fname;
public String lname;
public String email;
public String dob;
public String  paddressln1;
public String paddressln2;
public String pcity;
public String pstate;*/

public String url="https://qa.doverbayadmin.com";

public String browser="IE";

   
    @BeforeTest
 	public void setup()
	{
	     /*System.setProperty("webdriver.ie.drisetver","C:\\Kripa\\Softwares\\IE32Driver\\IEDriverServer.exe");
	     driver=new InternetExplorerDriver();
	    driver=new ChromeDriver();
		driver.get("https://qa.doverbayadmin.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		;*/
	  selectBrowser(browser);
	  geturl(url);
	  	  
	}
  
  public void ReadExcel(String excelname) throws IOException
  {
	  String path=System.getProperty("user.dir") + "\\src\\test\\java\\Utils\\"+excelname;
	   er=new ExcelRead(path);
  }
  public void selectBrowser(String browser)
  {
	  if(browser.equalsIgnoreCase("IE"))
	  {
		  System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
		  driver=new InternetExplorerDriver();		  
	  }
	  else if(browser.equalsIgnoreCase("Chrome"))
	  {
		  System.setProperty("webdriver.Chrome.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
		  driver=new ChromeDriver();		  
	  }
	  
  }
  
  public void geturl(String url)
  {
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
  }
  
	public void clickNext()
	{
		    
		driver.findElement(By.id("bNext")).click();		
		
	}
	
  @AfterTest
  public void CloseBrowser()
  {
  	driver.close();
  }
  
  
  public void waitforelementtobeclickable(WebElement element,long time)
  {
	  WebDriverWait wait=new WebDriverWait(driver,time);
	  wait.until(ExpectedConditions.elementToBeClickable(element));
	  
	  
  }
 
  

  public void waitforelementtobevisible(WebElement element,long time)
  {
	  WebDriverWait wait=new WebDriverWait(driver,time);
	  try {
	  wait.until(ExpectedConditions.visibilityOf(element));	  }
	  catch(Exception e)
	  {
		  
		  System.out.println("Element not found");
	  }
	  
  }
  
  
  public void waitforallelementstobevisible(List<WebElement> element,long time)
  {
	  WebDriverWait wait=new WebDriverWait(driver,time);
	  wait.until(ExpectedConditions.visibilityOfAllElements(element));	  
	  
  }
  
  public WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});

		return element;
	};
  
	  public List<WebElement> fluentWait(final List<WebElement> webElement, int timeinsec) {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			List<WebElement> element = wait.until(new Function<WebDriver, List<WebElement> >() {
				public List<WebElement> apply(WebDriver driver) {
					return webElement;
				}
			});

			return element;
		};
  
  public void selectRadioOption(List<WebElement> locator,String data)
  {
	    // waitforallelementstobevisible(locator,time);
		 
		 if (data.equalsIgnoreCase("yes"))
		 { waitforelementtobeclickable(locator.get(0),10);
			 locator.get(0).click();}
		 else
			 {
			 waitforelementtobeclickable(locator.get(1),10);
			 locator.get(1).click();}
	  
  }
  public void selectRadioOptionByAction(List<WebElement> locator,String data)
  {       Actions act=new Actions(driver);
	    // waitforallelementstobevisible(locator,time);
		 
		 if (data.equalsIgnoreCase("yes"))
		 { //waitforelementtobeclickable(locator.get(0),10);
			 act.moveToElement(locator.get(0)).click().perform();}
		 else
			 {
			// waitforelementtobeclickable(locator.get(1),10);
			 locator.get(1).click();}
	  
  }
  
  public void selectRadioOptionJSCript(List<WebElement> locator,String data)
  {
 	 
	  if (data.equalsIgnoreCase("yes"))
		 { 
		  ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;",  locator.get(0));}
		 else
			 {
			
			 ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;",  locator.get(1));;}
  }
  
/*  public void getListofElements(List<WebElement> locator,String data)
  {
	 // List<WebElement> elements=driver.findElements(locator);
	    
	  for (WebElement element:locator)
			
		{
			//String rc=element.getText();
			if (element.getText().contains(data))
				{element.click();
				break;
				}
			
		}
	  
	  
  }*/
 public void selectfromdropdown(long time,WebElement locator1,WebElement locator2,List<WebElement> locator3,String data)
 {
	 waitforelementtobeclickable(locator1,time);
	 locator1.click();
	 waitforelementtobevisible(locator2,time);
	 //getListofElements(locator3,data);
	 for (WebElement element:locator3)
			
		{
			//String rc=element.getText();
			if (element.getText().contains(data))
				{element.click();
				break;
				}
			
		}
	 
 }
 
 public void selectfromparishdropdown(long time,WebElement locator1,WebElement locator2,List<WebElement> locator3,String data)
 {
	 waitforelementtobeclickable(locator1,time);
	 locator1.click();
	 locator1.click();
	 waitforelementtobevisible(locator2,time);
	 //getListofElements(locator3,data);
	 for (WebElement element:locator3)
			
		{
			//String rc=element.getText();
			if (element.getText().contains(data))
				{element.click();
				break;
				}
			
		}
	
 }
 

 
 
 public void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

		}
	}
  public TestBase()
  {}
  
  
}
