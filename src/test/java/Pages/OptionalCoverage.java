package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.TestBase;

public class OptionalCoverage extends TestBase{
	
	@FindBy(id="EQCoverage")
	List<WebElement> eqCoverage;	
	
	@FindBy(xpath="(//span[@class='k-input'])[2]")
	WebElement spanEQDeductile;
	
	@FindBy(id="EarthquakeDeductible_listbox")
	WebElement ulEQDeductile;	
	
	@FindBy(xpath=".//*[@id='EarthquakeDeductible_listbox']/li")
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
		selectRadioOption(30, eqCoverage, earthquake);
	}

	public void setEQDeductible(String deductible)
	{
		selectfromdropdown(30, spanEQDeductile, ulEQDeductile, liEQDeductile, deductible);

	}
	public void setHighRisk(String highRisk)	  
	{

		selectRadioOption(30, highrisk, highRisk);
	}

	public void setMasonaryChimney(String masonarychimney)
	{
		selectRadioOption(30, highRiskMasonryChimney, masonarychimney);

	}
	public void setCripplewall(String cripplewall)
	{

		selectRadioOption(30, highRiskElevatedCrippleWall, cripplewall);
	}
	public void setconstructionmaterial(String material)
	{
		selectRadioOption(30, differentConstructionMaterial, material);
	}
	
	public void setSlope(String slopedegree)
	{
		
		selectRadioOption(30, slope, slopedegree);
	}
	
	public void setCliffdistance(String cliff)
	{
		selectRadioOption(30, cliffDistance, cliff);
		
	}
	
	public void setSolidGround(String solid)
	{
		selectRadioOption(30, solidGround, solid);		
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
