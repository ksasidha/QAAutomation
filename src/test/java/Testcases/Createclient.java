package Testcases;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import Pages.Address;
import Pages.ClientManagement;
import Pages.Coverage;
import Pages.Endorsement;
import Pages.FireProtection;
import Pages.Generalinfo;
import Pages.HomeExterior;
import Pages.HomeInterior;
import Pages.HomePage;
import Pages.Login;
import Pages.LossHistory;
import Pages.NewQuotePAge;
import Pages.Occupancy;
import Pages.SafetyFeatures;
import Pages.Summary;
import Utils.ExcelRead;

public class Createclient extends TestBase  {
	 Login l;
	 HomePage hp;
	 ClientManagement cm;
	 NewQuotePAge nqp;
	 Address address;
	 LossHistory losshistory;
	  
	
	//changes
	
	
		
  @Test
  public void createClient() throws Exception {
	  //Login to application
	  WebDriverWait wait;
	  ExcelRead er=new ExcelRead("C:\\Kripa\\Automation\\Selenium\\Automationqa2\\src\\test\\java\\Utils\\Testdata.xlsx");
	  
	 
	  
	  for (int i=1;i<=er.getrowcount(1);i++)
	  {    
		  
		  String username=er.getCelldata(0, i, 0);
		  String pass=er.getCelldata(0, i, 1);
		  String aor=er.getCelldata(0, i, 2);
		  
		  l=new Login(driver);
		  l.logintoApplication(username, pass, aor);
	   //Click  on Client MAnagement
	  hp=new HomePage(driver);
	 // boolean verifyText=hp.verifyText();
	//  Assert.assertTrue(verifyText);
	  hp.clickNavigationBar("Client Management");
	  
	  //Start a new Client
	  hp.Start_SearchClient("Start A New Client");
	  
	  //Enter client details and Save
	  
	  cm=new ClientManagement(driver); 
	  String currentUrl1=driver.getCurrentUrl();
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
	   
	 
	  /*String fname=er.getCelldata(1,i,0);
	   String lname= er.getCelldata(1,i,1);
	   String email =er.getCelldata(1,i,2);
	   String dob=er.getCelldata(1,i,3);
	 String paddressln1=er.getCelldata(1,i,4);
	 String paddressln2=er.getCelldata(1,i,5);
	String pcity=er.getCelldata(1,i,6);
	 String pstate= er.getCelldata(1,i,7);
	 String pzip= er.getCelldata(1,i,8);
	String maddressln1= er.getCelldata(1,i,9);
	String maddressln2=er.getCelldata(1,i,10);
	 String mcity=er.getCelldata(1,i,11);
	 String mstate=er.getCelldata(1,i,12);
	  String mzip=er.getCelldata(1,i,13);
	  String phone=er.getCelldata(1,i,14);*/
      
	  
	  
//	  cm.createClient(fname, lname, email, dob, paddressln1, paddressln2, pcity, pstate, pzip, maddressln1, maddressln2, mcity, mstate, mzip, contact);
	 
	  nqp=new NewQuotePAge(driver);
	  //Boolean str=nqp.checkclientInfo(er.getCelldata(1,i,0),er.getCelldata(1,i,1),er.getCelldata(1,i,2),er.getCelldata(1,i,3));
	  String contact=er.getCelldata(1,i,14);
	 // String s=String.valueOf(contact);
	  nqp.setContact(contact);
	 // System.out.println(er.getCelldata(2,i,0));
	  nqp.setCoapp(er.getCelldata(2,i,0));
	  //Set the coapp details if there is coapp else go to SF Auto
	  String coapp=er.getCelldata(2,i,0);
	  nqp.setCoapp(coapp);
	  if (coapp.equalsIgnoreCase("yes"))
			  {
		 
	  nqp.setCoappDetails(er.getCelldata(2,i,1), er.getCelldata(2,i,2), er.getCelldata(2,i,3));
			  }
	  nqp.setSFAutoPolicy(er.getCelldata(2,i,4));
	  
	  //Set SF AUto policy number if it is there
	  String SFAuto=er.getCelldata(2,i,4);
	  if (SFAuto.equalsIgnoreCase("yes"))
	  {
		  nqp.setSFAutoNumber(er.getCelldata(2,i,5));
	  }
	  nqp.setFlood(er.getCelldata(2,i,6));
	  nqp.setExDoverBayClient(er.getCelldata(2,i,7));
	  String DBClient=er.getCelldata(2,i,7);
	   if (DBClient.equalsIgnoreCase("yes"))
	   {
		   nqp.setDBPolicyNum(er.getCelldata(2,i,8));
	   }
	   else 
		   nqp.setPriorCarrier(er.getCelldata(2,i,9));
	 
	   nqp.clickNext();
	  //Enter address details
	   address=new Address(driver);
	   String addressurl=driver.getCurrentUrl();
	   String riskaddress1=er.getCelldata(3,i,0);
	   address.setriskAddress1(er.getCelldata(3,i,0));
	   address.setriskaddress2(er.getCelldata(3,i,1));
	   String raddress2=er.getCelldata(3,i,1);
	   address.setriskCity(er.getCelldata(3,i,2));
	   String raddresscity=er.getCelldata(3,i,2);
	   address.setPState(er.getCelldata(3,i,3));
	   String raddressState=er.getCelldata(3,i,3);
	   address.setriskZip(er.getCelldata(3,i,4));
	   String raddresszip=er.getCelldata(3,i,4);
	   address.setmAddress1(er.getCelldata(3,i,5));
	   String mailingAddress1=er.getCelldata(3,i,5);
	   address.setmaddress2(er.getCelldata(3,i,6));
	   String  maddress2=er.getCelldata(3,i,6);
	   address.setmCity(er.getCelldata(3,i,7));
	   String mcity1=er.getCelldata(3,i,7);
	   address.setMState(er.getCelldata(3,i,8));
	   String mstate1=er.getCelldata(3,i,8);
	   address.setmZip(er.getCelldata(3,i,9));
	   String mzip1=er.getCelldata(3,i,9);
	   //check if the reason for difference in MAiling address needs to be entered.
	   if ((riskaddress1!=mailingAddress1)||(raddress2!=maddress2)||(raddresscity!=mcity1)||(raddressState!=mstate1)||(raddresszip!=mzip1))
	   {
		   
		   address.setMailingAddressDiff(er.getCelldata(3,i,10));
	   }
	   address.setCounty_Parish(er.getCelldata(3,i,11));
	   address.SaveandNext();
	   /*String currenturl3=driver.getCurrentUrl();
	   if(addressurl.contentEquals(currenturl3))
	   {
		   address.modaldialog();
	   }*/
	   
	   System.out.println(driver.getWindowHandle());
	//   address.selectValidPaddress();
	  // address.selectValidMaddress();  
	      
	   
	//Loss history
	  losshistory=new LossHistory(driver);
	  String pastConv=er.getCelldata(4,i,0);
	  String prior5yrs=er.getCelldata(4,i,1);
	  String losses5yrs=er.getCelldata(4,i,2);
	  String prior3yrs=er.getCelldata(4,i,3);
	  String losses3yrs=er.getCelldata(4,i,4);
	  String nonweather=er.getCelldata(4,i,5);
	  losshistory.setLosses(pastConv, prior5yrs, losses5yrs, prior3yrs, losses3yrs, nonweather);
	  clickNext();
	  
	  //Property generalinfo
	  Generalinfo geninfo=new Generalinfo(driver);
	  
	  String year=er.getCelldata(5, i, 0);
	  String yearpurchased=er.getCelldata(5, i, 1);
	  String squarefeet=er.getCelldata(5, i, 2);
	  String damage=er.getCelldata(5, i, 3);
	  String landfill=er.getCelldata(5, i, 4);
	  String rdate=er.getCelldata(5, i, 5);
	  String ercost=er.getCelldata(5, i, 6);
	  String rsource=er.getCelldata(5, i, 7);
	  String construction=er.getCelldata(5, i, 8);
	  String story=er.getCelldata(5, i, 9);
	  String prefab=er.getCelldata(5, i, 10);
	  String mobile=er.getCelldata(5, i, 11);
	  String reno=er.getCelldata(5, i, 12);
	  String renoComm=er.getCelldata(5, i, 13);
	
	  geninfo.setGeneralinfo(year, yearpurchased, squarefeet, damage, landfill);
	  geninfo.setEstimatedRC(rdate, ercost, rsource);
	  geninfo.setconstruction_Style(construction, story, prefab, mobile, reno, renoComm);
	  clickNext();
	  HomeExterior homeext=new HomeExterior(driver);
	  
	  String roofReplace=er.getCelldata(6, i, 0);
	  String roofyear=er.getCelldata(6, i, 1);
	  String roofCover=er.getCelldata(6, i, 2);
	  String Foundation=er.getCelldata(6, i, 3);
	  String spool=er.getCelldata(6, i, 4);
	  String fence=er.getCelldata(6, i, 5);	  
	  homeext.setHomeExterior(roofReplace, roofyear, roofCover, Foundation, spool, fence);
	  clickNext();
	  
	  HomeInterior homeint=new HomeInterior(driver);
	  
	  String solidFuel=er.getCelldata(7, i, 0);
	  String appList=er.getCelldata(7, i, 1);
	  String appInst=er.getCelldata(7, i, 2);
	  String ventsys=er.getCelldata(7, i, 3);
	  String woodBurn=er.getCelldata(7, i, 4);
	  String soleSource=er.getCelldata(7, i, 5);

	  homeint.setHomeInterior(solidFuel, appList, appInst, ventsys, woodBurn, soleSource);
	  clickNext();
	  
	  SafetyFeatures safetyFeatures=new SafetyFeatures(driver);
	  String locks=er.getCelldata(8, i, 0);
	  String stationBurglar=er.getCelldata(8, i, 1);
	  String burglarAlarmType=er.getCelldata(8, i, 2);
	  String stationFire=er.getCelldata(8, i, 3);
	  String fireAlarmType=er.getCelldata(8, i, 4);
	  
	  safetyFeatures.setSafteyFeatures(locks, stationBurglar, burglarAlarmType, stationFire, fireAlarmType);
	  clickNext();
	  
	  FireProtection fire=new FireProtection(driver);
	  String cityLimits=er.getCelldata(9, i, 0);
	  String fireDepartment=er.getCelldata(9, i, 1);
	  String fireHydrant=er.getCelldata(9, 1, 2);
	  String dwellingAccessible=er.getCelldata(9, i, 3);
	  
	  fire.setFireProtection(cityLimits, fireDepartment, fireHydrant, dwellingAccessible);
	  clickNext();
	  
	  Occupancy occup=new Occupancy(driver);
	  String propertyType=er.getCelldata(10, i, 0);
	  String unit=er.getCelldata(10, i, 1);
	  String dwelling=er.getCelldata(10, i, 2);
	  String boarders=er.getCelldata(10, i, 3);
	  String occupancy=er.getCelldata(10, i, 4);
	  String insured=er.getCelldata(10,i, 5);
	  String hopolicy=er.getCelldata(10, i, 6);
	  String secondary=er.getCelldata(10, i, 7);
	  String rent=er.getCelldata(10, i, 8);
	  String weeks=er.getCelldata(10, i, 9);
	  String basement=er.getCelldata(10, i, 10);
	  String animals=er.getCelldata(10, i, 11);
	  String wild=er.getCelldata(10, i, 12);
	  String bite=er.getCelldata(10, i, 13);
	  String business=er.getCelldata(11, i, 0);
	  String type=er.getCelldata(11, i, 1);
	  String incioffice=er.getCelldata(11, i, 2);
	  String clients=er.getCelldata(11, i, 3);
	  String visits=er.getCelldata(11, i, 4);
	  
	  occup.setOccupancy(propertyType, unit, dwelling, boarders, occupancy, insured, hopolicy, secondary, rent, weeks, basement, animals, wild, bite, business, type, incioffice, clients, visits);
      clickNext();
      
      
      
	  ////form[@id='additionalInsuredForm']/div/div[@id='personDiv']/input[@id='LastName']

      Coverage cov=new Coverage(driver);
      String effective=er.getCelldata(12, i, 0);
      String liability=er.getCelldata(12, i, 1);
      String medical=er.getCelldata(12, i, 2);
      String hoIncLimits=er.getCelldata(12, i, 3);
      String hobIncLimits=er.getCelldata(12, i, 4);	
      String hoCovB=er.getCelldata(12, i, 5);
      String hobCovB=er.getCelldata(12, i, 6);
      String bol=er.getCelldata(12, i, 7);
      String peril=er.getCelldata(12, i, 8);
      String hurr=er.getCelldata(12, i, 9);
      
      cov.setCoverage(effective, liability, medical, hoIncLimits, hobIncLimits, hoCovB, hobCovB, bol, peril, hurr);
      cov.setClickNext();
	
      
      Endorsement endo=new Endorsement(driver);
      
       
      
      String contractorsInterest=er.getCelldata(13, i, 0);
      String Lossassessment=er.getCelldata(13, i, 1);
      String CovD=er.getCelldata(13, i, 2);
      String Additionalinsured=er.getCelldata(13, i, 3);
      String numAi=er.getCelldata(13, i, 4);
      String AItype1=er.getCelldata(14, i, 0);
      String Fname1=er.getCelldata(14, i, 1);
      String Lname1=er.getCelldata(14, i, 2);
      String HOANAme1=er.getCelldata(14, i,3);
      String CorpNAme1=er.getCelldata(14, i, 4);
      String Addressline1=er.getCelldata(14, i, 5);
      String City1=er.getCelldata(14, i, 6);
      String State1=er.getCelldata(14, i, 7);
      String Zip1=er.getCelldata(14, i, 8);
      String AItype2=er.getCelldata(15, i, 0);
      String Fname2=er.getCelldata(15, i, 1);
      String Lname2=er.getCelldata(15, i, 2);
      String HOANAme2=er.getCelldata(15, i, 3);
      String CorpNAme2=er.getCelldata(15, i, 4);
      String Addressline2=er.getCelldata(15, i, 5);
      String City2=er.getCelldata(15, i, 6);
      String State2=er.getCelldata(15, i, 7);
      String Zip2=er.getCelldata(15, i, 8);
      String AItype3=er.getCelldata(16, i, 0);
      String Fname3=er.getCelldata(16, i, 1);
      String Lname3=er.getCelldata(16, i, 2);
      String HOANAme3=er.getCelldata(16, i,3);
      String CorpNAme3=er.getCelldata(16, i, 4);
      String Addressline3=er.getCelldata(16, i, 5);
      String City3=er.getCelldata(16, i, 6);
      String State3=er.getCelldata(16, i, 7);
      String Zip3=er.getCelldata(16, i, 8);
      
      
      String AI[][] = new String[5][9];
      AI[0][0]=AItype1;
      AI[0][1]=Fname1;
      AI[0][2]=Lname1;
      AI[0][3]=HOANAme1;
      AI[0][4]=CorpNAme1;
      AI[0][5]=Addressline1;
      AI[0][6]=City1;
      AI[0][7]=State1;
      AI[0][8]=Zip1;
      
      AI[1][0]=AItype2;
      AI[1][1]=Fname2;
      AI[1][2]=Lname2;
      AI[1][3]=HOANAme2;
      AI[1][4]=CorpNAme2;
      AI[1][5]=Addressline2;
      AI[1][6]=City2;
      AI[1][7]=State2;
      AI[1][8]=Zip2;
      
            
      AI[2][0]=AItype3;
      AI[2][1]=Fname3;
      AI[2][2]=Lname3;
      AI[2][3]=HOANAme3;
      AI[2][4]=CorpNAme3;
      AI[2][5]=Addressline3;
      AI[2][6]=City3;
      AI[2][7]=State3;
      AI[2][8]=Zip3;
      
          
      
      
      endo.setEndorsements(contractorsInterest,Lossassessment,CovD,Additionalinsured,numAi,AI);
      clickNext();
      
      Summary summary=new Summary(driver);
      String hopremium=summary.getHOPremium();
      String hoBasicPremium=summary.getHOBasicPremium();
      
      
      String expectedhoPremium=er.getCelldata(17, i, 0);
      String expectedhoBasicPremium=er.getCelldata(17, i, 1);
      er.Writetoexcel(17, i, 2, hopremium);
      er.Writetoexcel(17, i, 3, hoBasicPremium);
      
      /*if (hopremium.contains(expectedhoPremium) && hoBasicPremium.contains(expectedhoBasicPremium))
      {
    	  
    	 er.Writetoexcel(17, i, 4, "Pass");
    	  
      }
      
      else 
      {
    	  er.Writetoexcel(17, i, 4, "Fail");
    	  
      }*/
      
      
      
      






	  
	  
	  
	  //
	 
	  
	  }
  
	  
	  
	  hp.logout();
	}


	



 
  
}
