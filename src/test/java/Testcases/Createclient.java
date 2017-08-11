package Testcases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Address;
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
	 Address address;
	
	//changes
	
	
		
  @Test
  public void createClient() throws IOException {
	  //Login to application
	  WebDriverWait wait;
	  ExcelRead er=new ExcelRead("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx");
	 
	  
	  l=new Login(driver);
	  l.setUsername("kripasasidharan@hotmail.com");
	  l.setPassword("Avittom12");
	  l.clickLogin();
	  for (int i=1;i<=er.getrowcount(1);i++)
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
	  //check for physicaladdressvalidation
	  
	  //check for maddressvalidation
  	
	  
	  nqp=new NewQuotePAge(driver);
	  Boolean str=nqp.checkclientInfo(er.getCelldata(1,i,0),er.getCelldata(1,i,1),er.getCelldata(1,i,2),er.getCelldata(1,i,3));
	  nqp.setContact(er.getCelldata(1,i,14));
	 // System.out.println(er.getCelldata(2,i,0));
	  nqp.setCoapp(er.getCelldata(2,i,0));
	  //Set the coapp details if there is coapp else go to SF Auto
	  String coapp=er.getCelldata(2,i,0);
	  if (coapp.equalsIgnoreCase("true"))
			  {
	  nqp.setCoappDetails(er.getCelldata(2,i,1), er.getCelldata(2,i,2), er.getCelldata(2,i,3));
			  }
	  nqp.setSFAutoPolicy(er.getCelldata(2,i,4));
	  
	  //Set SF AUto policy number if it is there
	  String SFAuto=er.getCelldata(2,i,4);
	  if (SFAuto.equalsIgnoreCase("true"))
	  {
		  nqp.setSFAutoNumber(er.getCelldata(2,i,5));
	  }
	  nqp.setFlood(er.getCelldata(2,i,6));
	  nqp.setExDoverBayClient(er.getCelldata(2,i,7));
	  String DBClient=er.getCelldata(2,i,7);
	   if (DBClient.equalsIgnoreCase("true"))
	   {
		   nqp.setDBPolicyNum(er.getCelldata(2,i,8));
	   }
	   else 
		   nqp.setPriorCarrier(er.getCelldata(2,i,9));
	 
	   nqp.clickNext();
	  //Enter address details
	   address=new Address(driver);
	   address.setriskAddress1(er.getCelldata(3,i,0));
	   String riskaddress1=er.getCelldata(3,i,0);
	   address.setriskaddress2(er.getCelldata(3,i,1));
	   address.setriskCity(er.getCelldata(3,i,2));
	   address.setPState(er.getCelldata(3,i,3));
	   address.setriskZip(er.getCelldata(3,i,4));
	   address.setmAddress1(er.getCelldata(3,i,5));
	   String maiingAddress1=er.getCelldata(3,i,5);
	   address.setmaddress2(er.getCelldata(3,i,6));
	   address.setmCity(er.getCelldata(3,i,7));
	   address.setMState(er.getCelldata(3,i,8));
	   address.setmZip(er.getCelldata(3,i,9));
	   //check if the reason for difference in MAiling address needs to be enetered.
	   if (riskaddress1!=maiingAddress1)
	   {
		   
		   address.setMailingAddressDiff(er.getCelldata(3,i,10));
	   }
	   address.setCounty_Parish(er.getCelldata(3,i,11));
	   	   
	  }
	 
	  hp.logout();
	}
 
  
}
