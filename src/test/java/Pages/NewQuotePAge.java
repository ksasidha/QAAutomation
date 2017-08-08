package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class NewQuotePAge {
  /*@FindBy(id=".//*[@id='ContactsDropDown-list']/div/child::ul/child::li")
  WebElement contact;*/
  
  @FindBy(id="SecondaryPolicyHolder")
  WebElement contact;
  
  @FindBy(id="SFName")
  WebElement SPHFName;
  
  @FindBy(id="SLName")
  WebElement SPHLName;
  
  @FindBy(id="SDob")
  WebElement SPHDob;
  
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
  
}
