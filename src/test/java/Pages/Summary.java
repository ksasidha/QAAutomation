package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Summary {
 
	
	@FindBy(id="CustomerReviewed")
	WebElement reviewd;
	
	
  WebDriver driver;
	
	
	public Summary(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHOPremium()
	{
		  String[] premium = null;
		  WebDriverWait wait =new WebDriverWait(driver,60);
		  wait.until(ExpectedConditions.visibilityOf(reviewd));
		  WebElement hiddenDiv1 =driver.findElement(By.id("TotalPremium"));
		  String script1 = "return $('#TotalPremium').val()";
		  String hoPremium = (String) ((JavascriptExecutor) driver).executeScript(script1, hiddenDiv1);
  		return (hoPremium);
	}
	
	public String getHOBasicPremium()
	
	{
		  WebDriverWait wait =new WebDriverWait(driver,60);
		  wait.until(ExpectedConditions.visibilityOf(reviewd));
		  WebElement hiddenDiv2 =driver.findElement(By.id("TotalPremiumBasic"));
		  String script2 = "return $('#TotalPremiumBasic').val()";
		  String hoBasicPremium = (String) ((JavascriptExecutor) driver).executeScript(script2, hiddenDiv2);
		return hoBasicPremium;
	}
	
}
