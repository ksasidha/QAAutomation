package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObjects.ClientManagement;
import Pages.HomePage;
import Pages.Login;
import Utils.ExcelRead;

public class Client extends TestBase{

	Login login;
	HomePage homepage;
	ClientManagement client;
	@Test
	public void CreateClient() throws IOException, InterruptedException
	{
		
		 ExcelRead er=new ExcelRead("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx");
		
		 
			 
		 for (int i=1;i<=er.getrowcount(1);i++)
		 {
			 login=new Login(driver);
			 String email=er.getCelldata(0,1,0);
			 String pass=er.getCelldata(0,1,1);
			 login.logintoApplication(email, pass, pass);
			 client=new ClientManagement(driver);	
			 homepage=new HomePage(driver);


			 String fname=er.getCelldata(1, i, 0);
			 String lname=er.getCelldata(1, i, 1);
			 String Email=er.getCelldata(1, i, 2);
			 String dob=er.getCelldata(1, i, 3);
			 String paddress1=er.getCelldata(1, i, 4);
			 String paddress2=er.getCelldata(1, i, 5);
			 String pcity=er.getCelldata(1, i, 6);
			 String pstate=er.getCelldata(1, i, 7);
			 String pzip=er.getCelldata(1, i, 8);
			 String maddress1=er.getCelldata(1, i, 9);
			 String maddress2=er.getCelldata(1, i, 10);
			 String mcity=er.getCelldata(1, i, 11);
			 String mstate=er.getCelldata(1, i, 12);
			 String mzip=er.getCelldata(1, i, 13);
			 String contact=er.getCelldata(1, i, 14);
		 
		 
		
			 homepage.clickNavigationBar("Client Management");	
			 homepage.Start_SearchClient("Start A New Client");
			 client.setClientinfo(fname, lname, Email, dob);
			 client.setpAddress(paddress1, paddress2, pcity, pstate,pzip);
			 client.setmAddress(maddress1, maddress2, mcity, mstate, mzip);
			 client.setContact(contact);
			 client.saveAndCreateQuote();
			 client.checkPAModal();

			 client.checkMAModal();

			 client.checkcdupr();
			 

			 //homepage.logout();
		 
		 
		}
	}
}
