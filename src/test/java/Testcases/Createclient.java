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
import Pages.NewQuotePAge;
import Utils.ExcelRead;

public class Createclient extends TestBase{
	Login l;
	HomePage hp;
	ClientManagement cm;
	 NewQuotePAge nqp;
	
	//changes
	
	
		
  @Test
  public void createClient() throws IOException {
	  //Login to application
	
	  ExcelRead er=new ExcelRead("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx");
	 
	  
	  l=new Login(driver);
	  l.setUsername("kripasasidharan@hotmail.com");
	  l.setPassword("Avittom12");
	  l.clickLogin();
	  for (int i=1;i<=er.getrowcount(0);i++)
	  {
		  
	  System.out.println(er.getCelldata(0,i,0));
	  //Click  on Client MAnagement
	  hp=new HomePage(driver);
	  boolean verifyText=hp.verifyText();
	  Assert.assertTrue(verifyText);
	  hp.clickNavigationBar("Client Management");
	  
	  //Start a new Client
	  hp.Start_SearchClient("Start A New Client");
	  
	  //Enter client details and Save
	  
	  cm=new ClientManagement(driver); 
	  cm.setFirstName(er.getCelldata(1,i,0));
	  cm.setLastName(er.getCelldata(1,i,1));
	  cm.setEmail(er.getCelldata(1,i,2));
	  cm.setDOB(er.getCelldata(1,i,3));
	  cm.setPAddress1(er.getCelldata(1,i,4));
	  cm.setPAddress2(er.getCelldata(1,i,5));
	  cm.setPcity(er.getCelldata(1,i,6));
	  cm.setPState(er.getCelldata(1,i,7));
	  cm.setPzip(er.getCelldata(1,i,8));
	  cm.setMAddress1(er.getCelldata(1,i,9));
	  cm.setMAddress2(er.getCelldata(1,i,10));
	  cm.setMcity(er.getCelldata(1,i,11));
	  cm.setMState(er.getCelldata(1,i,12));
	  cm.setMzip(er.getCelldata(1,i,13));
	  cm.setContact(er.getCelldata(1,i,14));
	  cm.createNewQuote();
	  
	  nqp=new NewQuotePAge(driver);
	  Boolean str=nqp.checkclientInfo(er.getCelldata(1,i,0),er.getCelldata(1,i,1),er.getCelldata(1,i,2),er.getCelldata(1,i,3));
	  nqp.setContact(er.getCelldata(1,i,14));
	 // System.out.println(er.getCelldata(2,i,0));
	  nqp.setCoapp(er.getCelldata(2,i,0));
	  
	  nqp.setCoappDetails(er.getCelldata(2,i,1), er.getCelldata(2,i,2), er.getCelldata(2,i,3));
	  	  
	  }
	  hp.logout();
	}
 
  
}
