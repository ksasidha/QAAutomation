package Utils;

import java.io.IOException;

public class inputdata {
	
	public  void inputdata1() throws IOException
	{
		
		
		ExcelRead er=new ExcelRead("C:\\Kripa\\Automation\\Selenium\\Automationqa\\src\\test\\java\\Utils\\Testdata.xlsx");
		
		
		for (int i=1;i<=er.getrowcount(1);i++)
		  { 
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
		  }
		
		
	}
	public inputdata()
	{}

}
