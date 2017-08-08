package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewQuotePAge {
  /*@FindBy(id=".//*[@id='ContactsDropDown-list']/div/child::ul/child::li")
  WebElement contact;*/
  
 /* @FindBy(id="SecondaryPolicyHolder")
  WebElement coapp;*/
  
  @FindBy(id="SFName")
  WebElement coappFname;
  
  @FindBy(id="SLName")
  WebElement coappLname;
  
  @FindBy(id="SDob")
  WebElement coappDob;
  
  @FindBy(id="insurance")
  WebElement SFAuto;
    
  @FindBy(id="AutoPolicy")
  WebElement SFPNAuto;
  
  @FindBy(id="Flood")
  WebElement flood;
  
  @FindBy(id="DoverBayClient")
  WebElement DBClient;
  
  @FindBy(id="DoverBayPolNum")
  WebElement DBPNum;
  
  @FindBy(id="PriorCarrier")
  WebElement DBPCarr;

 WebDriver driver;
  
  public NewQuotePAge(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
}
  public void setContact(String contact)
  {   driver.findElement(By.xpath(".//*[@id='frmAppPolicyHolder']/div[2]/div[7]/div/span/span/span[1]")).click();
	  driver.findElement(By.xpath(".//*[@id='ContactsDropDown-list']/div/child::ul/child::li[contains(text(),'"+contact+"')]")).click();
	  
  }
  public void setCoapp(String coApp) {
	     
	  List <WebElement> coapplicant=driver.findElements(By.xpath(".//*[@id='SecondaryPolicyHolder']"));	  
	   
	  	 if (coApp.equalsIgnoreCase("true"))
	  		coapplicant.get(0).click();
	  	 else
	  		coapplicant.get(1).click();	 
  }
  
  public void setCoappDetails(String coAppFname,String coAppLname,String coAppdob) {
	  
	  List <WebElement> coapplicant=driver.findElements(By.xpath(".//*[@id='SecondaryPolicyHolder']"));	 
	  if (coapplicant.get(0).isSelected())
	     {
  	 		coappFname.sendKeys(coAppFname);
  	 		coappLname.sendKeys(coAppLname);
  	 		coappDob.sendKeys(coAppdob);  	 		 
  	 	 }
}
  
  
  
  
}
