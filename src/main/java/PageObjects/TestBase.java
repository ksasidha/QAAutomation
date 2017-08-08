package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	
	WebDriver driver=new ChromeDriver();
	
	public void setup()
	{
		
		 driver.get("https://qa.doverbayadmin.com");
	}
}
