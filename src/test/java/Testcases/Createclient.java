package Testcases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ClientManagement;
import Pages.HomePage;
import Pages.Login;
import Utils.ExcelRead;

public class Createclient {
	Login l;
	HomePage hp;
	ClientManagement cm;
	WebDriver driver;
	
	@BeforeTest
	public void Setup()
	{
		driver=new ChromeDriver();
		driver.get("https://qa.doverbayadmin.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
		
  @Test
  public void createClient() throws IOException {
	  //Login to application
	
	  ExcelRead er=new ExcelRead("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx");
	  
	  
	  l=new Login(driver);
	  l.setUsername("kripasasidharan@hotmail.com");
	  l.setPassword("Avittom12");
	  l.clickLogin();
	  for (int i=1;i<=er.getrowcount("Sheet2");i++)
	  {
	  //Click  on Client MAnagement
	  hp=new HomePage(driver);
	  boolean verifyText=hp.verifyText();
	  Assert.assertTrue(verifyText);
	  hp.clickNavigationBar("Client Management");
	  
	  //Start a new Client
	  hp.Start_SearchClient("Start A New Client");
	  
	  //Enter client details and Save
	  
	  cm=new ClientManagement(driver); 
	  cm.setFirstName(er.getCelldata("Sheet2",i,0));
	  cm.setLastName(er.getCelldata("Sheet2",i,1));
	  cm.setEmail(er.getCelldata("Sheet2",i,2));
	  cm.setDOB(er.getCelldata("Sheet2",i,3));
	  cm.setPAddress1(er.getCelldata("Sheet2",i,4));
	  cm.setPAddress2(er.getCelldata("Sheet2",i,5));
	  cm.setPcity(er.getCelldata("Sheet2",i,6));
	  cm.setPState(er.getCelldata("Sheet2",i,7));
	  cm.setPzip(er.getCelldata("Sheet2",i,8));
	  cm.setMAddress1(er.getCelldata("Sheet2",i,9));
	  cm.setMAddress2(er.getCelldata("Sheet2",i,10));
	  cm.setMcity(er.getCelldata("Sheet2",i,11));
	  cm.setMState(er.getCelldata("Sheet2",i,12));
	  cm.setMzip(er.getCelldata("Sheet2",i,13));
	  cm.setContact(er.getCelldata("Sheet2",i,14));
	  cm.saveClient();
	  	  
	  }
	  hp.logout();
	}
 
  @AfterTest
  public void CloseBrowser()
  {
  	driver.close();
  }
}
