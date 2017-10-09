package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.TestBase;

public class OptionalCoverage extends TestBase{
	
	@FindBy(id="EQCoverage")
	List<WebElement> eqCoverage;	
	
	@FindBy(xpath="(//span[@class='k-input'])[2]")
	@CacheLookup
	WebElement spanEQDeductile;
	
	@FindBy(id="EarthquakeDeductible_listbox")
	@CacheLookup
	WebElement ulEQDeductile;	
	
	@FindBy(xpath=".//*[@id='EarthquakeDeductible_listbox']/li")
	@CacheLookup
	List<WebElement> liEQDeductile;
	
		
	@FindBy(id="HighRisk")
	List<WebElement> highrisk;
	
	@FindBy(id="HighRiskMasonryChimney")
	List<WebElement> highRiskMasonryChimney;	
	
	@FindBy(id="HighRiskElevatedCrippleWall")
	List<WebElement> highRiskElevatedCrippleWall;
	
	@FindBy(id="DifferentConstructionMaterial")
	List<WebElement> differentConstructionMaterial;
	
	
	@FindBy(id="Slope")
	List<WebElement> slope;
	
	@FindBy(id="CliffDistance")
	List<WebElement> cliffDistance;
	
	
	@FindBy(id="SolidGround")
	List<WebElement> solidGround;
	
	

	WebDriver driver;
	
	public OptionalCoverage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public void setEQCoverage(String earthquake)
	{
		selectRadioOption(eqCoverage, earthquake);
	}

	public void setEQDeductible(String deductible)
	{
		selectfromdropdown(30, spanEQDeductile, ulEQDeductile, liEQDeductile, deductible);

	}
	public void setHighRisk(String highRisk)	  
	{

		selectRadioOption(highrisk, highRisk);
	}

	public void setMasonaryChimney(String masonarychimney)
	{
		selectRadioOption(highRiskMasonryChimney, masonarychimney);

	}
	public void setCripplewall(String cripplewall)
	{

		selectRadioOption(highRiskElevatedCrippleWall, cripplewall);
	}
	public void setconstructionmaterial(String material)
	{
		selectRadioOption(differentConstructionMaterial, material);
	}
	
	public void setSlope(String slopedegree)
	{
		
		selectRadioOption(slope, slopedegree);
	}
	
	public void setCliffdistance(String cliff)
	{
		selectRadioOption(cliffDistance, cliff);
		
	}
	
	public void setSolidGround(String solid)
	{
		selectRadioOption(solidGround, solid);		
	}
	
	
	
	public void setOptionalCoverage(String earthquake,String deductible,String highRisk,String masonarychimney,String cripplewall,String material,String slopedegree,String cliff,String solid)
	{
		setEQCoverage(earthquake);
		if(earthquake.equalsIgnoreCase("yes"))
		{

			setEQDeductible(deductible);
			setHighRisk(highRisk);
			if(highRisk.equalsIgnoreCase("yes"))
			{
				setMasonaryChimney(masonarychimney);
				setCripplewall(cripplewall);
				setconstructionmaterial(material);
				setSlope(slopedegree);
			}
		setCliffdistance(cliff);
		setSolidGround(solid);
		}
		clickNext();
	}
	
}
