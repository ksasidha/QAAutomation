package Testcases;

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
import Pages.OptionalCoverage;
import Pages.SafetyFeatures;
import Pages.Summary;

public class TC_CreateQuote extends TestBase{
	
	Login login;
	HomePage homepage;
	ClientManagement client;
	NewQuotePAge policyholder;
	Address address;
	LossHistory losses;
	Generalinfo generalinfo;
	HomeExterior homeexterior;
	HomeInterior homeinterior;
	SafetyFeatures safetyfeatures;
	FireProtection fireprotection;
	Occupancy occupancy;
	Coverage coverage;
	Endorsement endorsement;
	Summary summary;
	OptionalCoverage optionalCoverage;
	
	
	
	
	@Test
	public void createValidQuote() throws Exception
	{
		
		ReadExcel("TestData.xlsx");	
		//1.Login as an agent.
		//2.Click on the Client MAnagement link and select the start a client option
		//3.Create a Client.
		//4.Create a quote.
		
		
		
		
		for (int i=1;i<er.getrowcount(0);i++)
				{
		String username=er.getCelldata(0,i,0);
		String password=er.getCelldata(0,i,1);	
		String aor=er.getCelldata(0,i,2);
		
		String fname=er.getCelldata(1,i,0);
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
		String phone=er.getCelldata(1,i,14);
		String coapp=er.getCelldata(2,i,0);
		String coappFname=er.getCelldata(2,i,1);
		String coappLname=er.getCelldata(2,i,2);
		String coappDob=er.getCelldata(2,i,3);
		String sfAutoPolicy=er.getCelldata(2,i,4);
		String sfAutopolicynum=er.getCelldata(2,i,5);
		String flood=er.getCelldata(2,i,6);
		String exDoverBayClient=er.getCelldata(2,i,7);
		String dbClientPolicyNum=er.getCelldata(2,i,8);
		String priorCarrier=er.getCelldata(2,i,9);
		String riskaddress1=er.getCelldata(3,i,0);
		String raddress2=er.getCelldata(3,i,1);
		String raddresscity=er.getCelldata(3,i,2);
		String raddressState=er.getCelldata(3,i,3);
		String raddresszip=er.getCelldata(3,i,4);
		String mailingAddress1=er.getCelldata(3,i,5);
		String  maddress2=er.getCelldata(3,i,6);
		String mcity1=er.getCelldata(3,i,7);
		String mstate1=er.getCelldata(3,i,8);
		String mzip1=er.getCelldata(3,i,9);
		String mailingaddressdiffreason=er.getCelldata(3,i,10);
		String parish_county=er.getCelldata(3,i,11);
		String pastConv=er.getCelldata(4,i,0);
	  String prior5yrs=er.getCelldata(4,i,1);
	  String losses5yrs=er.getCelldata(4,i,2);
	  String prior3yrs=er.getCelldata(4,i,3);
	  String losses3yrs=er.getCelldata(4,i,4);
	  String nonweather=er.getCelldata(4,i,5);
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
	  String roofReplace=er.getCelldata(6, i, 0);
	  String roofyear=er.getCelldata(6, i, 1);
	  String roofCover=er.getCelldata(6, i, 2);
	  String Foundation=er.getCelldata(6, i, 3);
	  String spool=er.getCelldata(6, i, 4);
	  String fence=er.getCelldata(6, i, 5);	
	  String solidFuel=er.getCelldata(7, i, 0);
	  String appList=er.getCelldata(7, i, 1);
	  String appInst=er.getCelldata(7, i, 2);
	  String ventsys=er.getCelldata(7, i, 3);
	  String woodBurn=er.getCelldata(7, i, 4);
	  String soleSource=er.getCelldata(7, i, 5);
	  String locks=er.getCelldata(8, i, 0);
	  String stationBurglar=er.getCelldata(8, i, 1);
	  String burglarAlarmType=er.getCelldata(8, i, 2);
	  String stationFire=er.getCelldata(8, i, 3);
	  String fireAlarmType=er.getCelldata(8, i, 4);
	  String cityLimits=er.getCelldata(9, i, 0);
	  String fireDepartment=er.getCelldata(9, i, 1);
	  String fireHydrant=er.getCelldata(9, 1, 2);
	  String dwellingAccessible=er.getCelldata(9, i, 3);
	  String propertyType=er.getCelldata(10, i, 0);
	  String unit=er.getCelldata(10, i, 1);
	  String dwelling=er.getCelldata(10, i, 2);
	  String boarders=er.getCelldata(10, i, 3);
	  String occupancystatus=er.getCelldata(10, i, 4);
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
      
      String earthquake=er.getCelldata(13, i, 0);
	  String deductible=er.getCelldata(13, i, 1);
	  String highRisk=er.getCelldata(13, i, 2);
	  String masonarychimney=er.getCelldata(13, i, 3);
	  String cripplewall=er.getCelldata(13, i, 4);
	  String material=er.getCelldata(13, i, 5);
	  String slopedegree=er.getCelldata(13, i, 5);
	  String cliff=er.getCelldata(13, i, 6);
	  String solid=er.getCelldata(13, i, 7);
	  String contractorsInterest=er.getCelldata(14, i, 0);
      String Lossassessment=er.getCelldata(14, i, 1);
      String CovD=er.getCelldata(14, i, 2);
      String Additionalinsured=er.getCelldata(14, i, 3);
      String numAi=er.getCelldata(14, i, 4);
      String AItype1=er.getCelldata(15, i, 0);
      String Fname1=er.getCelldata(15, i, 1);
      String Lname1=er.getCelldata(15, i, 2);
      String HOANAme1=er.getCelldata(15, i,3);
      String CorpNAme1=er.getCelldata(15, i, 4);
      String Addressline1=er.getCelldata(15, i, 5);
      String City1=er.getCelldata(15, i, 6);
      String State1=er.getCelldata(15, i, 7);
      String Zip1=er.getCelldata(15, i, 8);
      String AItype2=er.getCelldata(16, i, 0);
      String Fname2=er.getCelldata(16, i, 1);
      String Lname2=er.getCelldata(16, i, 2);
      String HOANAme2=er.getCelldata(16, i, 3);
      String CorpNAme2=er.getCelldata(16, i, 4);
      String Addressline2=er.getCelldata(16, i, 5);
      String City2=er.getCelldata(16, i, 6);
      String State2=er.getCelldata(16, i, 7);
      String Zip2=er.getCelldata(16, i, 8);
      String AItype3=er.getCelldata(17, i, 0);
      String Fname3=er.getCelldata(17, i, 1);
      String Lname3=er.getCelldata(17, i, 2);
      String HOANAme3=er.getCelldata(17, i,3);
      String CorpNAme3=er.getCelldata(17, i, 4);
      String Addressline3=er.getCelldata(17, i, 5);
      String City3=er.getCelldata(17, i, 6);
      String State3=er.getCelldata(17, i, 7);
      String Zip3=er.getCelldata(17, i, 8);
      
      
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
      
        //login as an agent
		
		login=new Login(driver);
		login.logintoApplication(username, password, aor);
		
	   
		
		//Start a new Client
		homepage=new HomePage(driver);
		homepage.startNewClient();
	   
		
		//Create a Client in ClientManagement
		client=new ClientManagement(driver);			
		client.createClient(fname, lname, email, dob, paddressln1, paddressln2, pcity, pstate, pzip, maddressln1, maddressln2, mcity, mstate, mzip, phone);	
		
		
		//Create a quote
		  
		/*policyholder=new NewQuotePAge(driver);
		address =new Address(driver);
		losses=new LossHistory(driver);
		generalinfo=new Generalinfo(driver);
		homeexterior=new HomeExterior(driver);
		homeinterior=new HomeInterior(driver);
		safetyfeatures=new SafetyFeatures(driver);
		fireprotection=new FireProtection(driver);
		occupancy=new Occupancy(driver);
		coverage=new Coverage(driver);
		summary=new Summary(driver);
		endorsement=new Endorsement(driver);
		optionalCoverage=new OptionalCoverage(driver);*/
		
		
		
		
		policyholder=new NewQuotePAge(driver);
		policyholder.setPolicyHolder(phone, coapp, coappFname, coappLname, coappDob, sfAutoPolicy, sfAutopolicynum, flood, exDoverBayClient, dbClientPolicyNum, priorCarrier);
		address =new Address(driver);
		address.setRiskAddress(riskaddress1, raddress2, raddresscity,raddressState,raddresszip, mailingAddress1, maddress2, mcity1, mstate1, mzip1, parish_county, mailingaddressdiffreason);
		losses=new LossHistory(driver);
		losses.setLosses(pastConv, prior5yrs, losses5yrs, prior3yrs, losses3yrs, nonweather);
		generalinfo=new Generalinfo(driver);
		generalinfo.setPropertyGeneralinfo(year, yearpurchased, squarefeet, damage, landfill, rdate, ercost, rsource, construction, story, prefab, mobile, reno, renoComm);
		homeexterior=new HomeExterior(driver);
		homeexterior.setHomeExterior(roofReplace, roofyear, roofCover, Foundation, spool, fence);
		homeinterior=new HomeInterior(driver);
		homeinterior.setHomeInterior(solidFuel, appList, appInst, ventsys, woodBurn, soleSource);
		safetyfeatures=new SafetyFeatures(driver);
		safetyfeatures.setSafteyFeatures(locks, stationBurglar, burglarAlarmType, stationFire, fireAlarmType);
		fireprotection=new FireProtection(driver);
		fireprotection.setFireProtection(cityLimits, fireDepartment, fireHydrant, dwellingAccessible);
		occupancy=new Occupancy(driver);
		occupancy.setOccupancy(propertyType, unit, dwelling, boarders, occupancystatus, insured, hopolicy, secondary, rent, weeks, basement, animals, wild, bite, business, type, incioffice, clients, visits);
		coverage=new Coverage(driver);
		coverage.setCoverage(effective, liability, medical, hoIncLimits, hobIncLimits, hoCovB, hobCovB, bol, peril, hurr);
		if(raddressState.equalsIgnoreCase("SC"))
		{   optionalCoverage=new OptionalCoverage(driver);
			optionalCoverage.setOptionalCoverage(earthquake, deductible, highRisk, masonarychimney, cripplewall, material, slopedegree, cliff, solid);
		}
		endorsement=new Endorsement(driver);
		endorsement.setEndorsements(contractorsInterest, Lossassessment, CovD, Additionalinsured, numAi, AI);
		
		homepage.logout();
				}
	
	}

}
