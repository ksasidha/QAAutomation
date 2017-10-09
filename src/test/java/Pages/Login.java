
package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testcases.TestBase;


public class Login extends TestBase{
	WebDriverWait  wait = null;
	WebDriver driver;

	//Email
	@FindBy(id="Email")
	WebElement Email;
	//Password
	@FindBy(id="Password")
	WebElement Pass;
	//LoginButton
	@FindBy(id="btnEnter")
	WebElement logButton;

	@FindBy(xpath=".//*[@id='navbarmenu']/ul/li/a/span[@title='Logout']")
	WebElement logoutButton;    
	//Button to select the agency and Login
	@FindBy(id="btnSelectAgency")
	WebElement select;
	//Primary Agent drop down
	@FindBy(xpath="(//span[@class='k-input'])[1]")
	WebElement spanPrimaryAgent;
	@FindBy(id="userAgencyList_listbox")
	WebElement ulPrimaryAgent;
	@FindBy(xpath=".//*[@id='userAgencyList_listbox']/li")
	List<WebElement> liprimaryAgent;


	public Login(WebDriver driver)
	{ 	this.driver=driver;
	PageFactory.initElements(driver, this);
	}


	public void setUsername(String email) {
		Email.clear();
		Email.sendKeys(email);
	}
	public void setPassword(String pass) {
		Pass.clear();
		Pass.sendKeys(pass);

	}
	public void clickLogin() {

		logButton.click();
	}

	public void setPrimaryAgent(String aor)
	{   
			
    		selectfromdropdown(30, spanPrimaryAgent, ulPrimaryAgent, liprimaryAgent,aor);


	}

	public void checkPrimaryAgentExsists(String aor)
	{

		try{

			WebElement modal=driver.findElement(By.id("modalAgencies"));
			waitforelementtobevisible(modal,5);
			if(modal.isDisplayed())
			{

				setPrimaryAgent(aor);
				waitforelementtobeclickable(select,5);
				select.click();
				waitForPageToLoad(30);
			}
		}
		catch(Exception e) {}


	}

	public  void logintoApplication(String email,String pass,String aor)
	{
		setUsername(email);
		setPassword(pass);
		clickLogin(); 
		checkPrimaryAgentExsists(aor);

	}


}
