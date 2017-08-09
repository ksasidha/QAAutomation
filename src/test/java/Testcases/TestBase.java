package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
protected WebDriver driver;
  @BeforeTest
	public void Setup()
	{
		driver=new ChromeDriver();
		driver.get("https://qa.doverbayadmin.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
  
  @AfterTest
  public void CloseBrowser()
  {
  	driver.close();
  }
}
