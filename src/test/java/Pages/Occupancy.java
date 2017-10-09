package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Testcases.TestBase;

public class Occupancy extends TestBase{
	
	
	 //PropertyType
	@FindBy(xpath="(//span[@class='k-input'])[2]")@CacheLookup
	WebElement spanPropertyType;  
	@FindBy(id="PropertyType_listbox")@CacheLookup
	WebElement ulPropertyType;
	@FindBy(xpath=".//*[@id='PropertyType_listbox']/li")@CacheLookup
	List<WebElement> liPropertyType;
	
	//Number of Units
	@FindBy(id="NumberOfunits")
	WebElement units;
	
	//Dwelling
	@FindBy(xpath="(//span[@class='k-input'])[3]")@CacheLookup
	WebElement spanDwelling;  
	@FindBy(id="Dwelling_listbox")@CacheLookup
	WebElement ulDwelling;
	@FindBy(xpath=".//*[@id='Dwelling_listbox']/li")@CacheLookup
	List<WebElement> liDwelling;
	
	//Boarders
	@FindBy(xpath="(//span[@class='k-input'])[4]")@CacheLookup
	WebElement spanboarders;
	@FindBy(id="Boarders_listbox")@CacheLookup	
	WebElement ulboarders;
	@FindBy(xpath=".//*[@id='Boarders_listbox']/li")@CacheLookup	
	List<WebElement> liBoarders;
	
	//OccupancyStatus
	@FindBy(xpath="(//span[@class='k-input'])[5]")@CacheLookup
	WebElement spanOccupancyStatus;
	@FindBy(id="OccupancyStatus_listbox")@CacheLookup	
	WebElement ulOccupancyStatus;
	@FindBy(xpath=".//*[@id='OccupancyStatus_listbox']/li")@CacheLookup	
	List<WebElement> liOccupancyStatus;
	
	//
	@FindBy(id="Insured")@CacheLookup		
	List <WebElement> Insured;
	
	//
	@FindBy(id="SeasonalSecondary")@CacheLookup	
	List <WebElement> SeasonalSecondary;
	
	@FindBy(id="HomeownersPolicy")
	WebElement hoPolicy;
	
	@FindBy(id="Rent")@CacheLookup	
	List <WebElement> Rent;
	
	//RentedWeeks
	@FindBy(xpath="(//span[@class='k-input'])[6]")@CacheLookup
	WebElement spanRentedWeeks;
	@FindBy(id="Rented_listbox")@CacheLookup	
	WebElement ulRentedWeeks;
	@FindBy(xpath=".//*[@id='Rented_listbox']/li")@CacheLookup	
	List<WebElement> liRentedWeeks;
	
	//Basementdwellings
	@FindBy(id="Basementdwellings")@CacheLookup		
	List <WebElement> Basementdwellings;
	
	//OwnerAnimals
	@FindBy(id="OwnerAnimals")@CacheLookup			
	List <WebElement> OwnerAnimals;
	
	//WildNonDomestic
	@FindBy(id="WildNonDomestic")
	List <WebElement> WildNonDomestic;
	//BiteHistory
	@FindBy(id="BiteHistory")
	List <WebElement> BiteHistory;
	
	//Business
	@FindBy(id="Business")@CacheLookup
	List <WebElement> Business;
	
	//BusinessType
	@FindBy(xpath="(//span[@class='k-input'])[7]")@CacheLookup
	WebElement spanBusinessTypes;
	@FindBy(id="TypeBusiness_listbox")@CacheLookup	
	WebElement ulBusinessType;
	@FindBy(xpath=".//*[@id='TypeBusiness_listbox']/li")@CacheLookup	
		List<WebElement> liBusinessType;
	
	//Clients
	@FindBy(id="Clients")@CacheLookup
	List <WebElement> Clients;
	
	@FindBy(id="ClientVisits")
	WebElement clientVisits;
	
	
	
	
	
	
	@FindBy(id="IncidentalOffice")
	WebElement office;
	
		
	WebDriver driver;
  public Occupancy(WebDriver driver) 
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS );
	  
  }
  
  public void setPropertyType(String propertyType)
  { 
	  /*WebDriverWait wait = new WebDriverWait(driver, 30);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmOccupancy']/div[1]/div[2]/div[1]/span/span/span[1]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[2]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
	  List<WebElement> PropertyType=driver.findElements(By.xpath(".//*[@id='PropertyType_listbox']/li"));

	  for (WebElement ptype:PropertyType)

	  {

		  if (ptype.getText().contains(propertyType))
		  {ptype.click();
		  break;
		  }

	  }*/
   
	  selectfromdropdown(30, spanPropertyType, ulPropertyType, liPropertyType, propertyType);
  }
  public void setNumberUnits(String unit)
  {
	  
	  units.clear();
	  units.sendKeys(unit);
  }
  
  public void setDwelling(String dwelling)
  {
	  /*WebDriverWait wait = new WebDriverWait(driver, 30);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmOccupancy']/div[1]/div[6]/div[1]/span/span/span[1]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[3]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
	  List<WebElement> Dwelling=driver.findElements(By.xpath(".//*[@id='Dwelling_listbox']/li"));

	  for (WebElement dwell:Dwelling)

	  {

		  if (dwell.getText().equals(dwelling))
		  {dwell.click();
		  break;
		  }

	  }*/
	  selectfromdropdown(30, spanDwelling, ulDwelling, liDwelling, dwelling);
	  
	  
  }
  
 /* public void setBoarders(String boarders)
  {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 40);//90 doesnt work sometimes//tried 30 stuck
	  try { //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmOccupancy']/div[1]/div[8]/div[1]/span/span/span[1]")))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[4]"))));
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.xpath("(//span[@class='k-input'])[4]"))).click().perform();
	 }catch(Exception e) {}
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='Boarders_listbox']"))));//changed from tag name to xpath on 9/18
	  List<WebElement> Boarders=driver.findElements(By.xpath(".//*[@id='Boarders_listbox']/li"));

	  for (WebElement roomers:Boarders)

	  {

		  if (roomers.getText().equals(boarders))
		  {roomers.click();
		  break;
		  }

	  }
	  
  }*/
  
  
  public void setBoarders(String boarders)
  {
	 
	  selectfromdropdown(30, spanboarders, ulboarders, liBoarders, boarders); 
	  
	  	
	  
  }
  
  public void setOccupancyStatus(String occupancy)
  {
	  /*WebDriverWait wait = new WebDriverWait(driver, 40);//90 didnt work--30 sometimes doesnt work
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmOccupancy']/div[1]/div[9]/div[1]/span/span/span[1]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[5]"))));
	  Actions act=new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("(//span[@class='k-input'])[5]"))).click().perform();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='OccupancyStatus_listbox']"))));//changed from tag name to xpath on 9/18
	  List<WebElement> OccupancyStatus=driver.findElements(By.xpath(".//*[@id='OccupancyStatus_listbox']/li"));

	  for (WebElement status:OccupancyStatus)

	  {

		  if (status.getText().contains(occupancy))
		  {status.click();
		  break;
		  }

	  }*/
	  
	  selectfromdropdown(30, spanOccupancyStatus, ulOccupancyStatus, liOccupancyStatus, occupancy);
  }
  
  public void setInsured(String insured)
  {
	   /*WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("Insured"))));
		List <WebElement> Insured=driver.findElements(By.id("Insured"));	  
		   
		 if (insured.equalsIgnoreCase("yes"))
			 Insured.get(0).click();
		 else
			 Insured.get(1).click();*/
	//  waitforallelementstobevisible(Insured, 30);
	  selectRadioOption(Insured, insured);
  }
  
  
  public void sethoPolicy(String hopolicy)
  {
	  
	  hoPolicy.clear();
	  hoPolicy.sendKeys(hopolicy);
  }
  
  public void setSeasonalSecondary(String secondary)
  {
	  /*WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("SeasonalSecondary"))));
		List <WebElement> SeasonalSecondary=driver.findElements(By.id("SeasonalSecondary"));	  
		   
		 if (secondary.equalsIgnoreCase("yes"))
			 SeasonalSecondary.get(0).click();
		 else
			 SeasonalSecondary.get(1).click();*/
	 // waitforallelementstobevisible(SeasonalSecondary, 30);
	  selectRadioOption(SeasonalSecondary, secondary);
	  
  }
  public void setRent(String rent)
  {
	  /*WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("Rent"))));
		List <WebElement> Rent=driver.findElements(By.id("Rent"));	  
		   
		 if (rent.equalsIgnoreCase("yes"))
			 Rent.get(0).click();
		 else
			 Rent.get(1).click();*/
	  selectRadioOption(Rent, rent);
	  
  }
  
  public void setRentedWeeks(String weeks)
  {
	  
	 /* WebDriverWait wait = new WebDriverWait(driver, 30);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='trRented']/div[2]/div[1]/span/span/span[1]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[6]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
	  List<WebElement> RentedWeeks=driver.findElements(By.xpath(".//*[@id='Rented_listbox']/li"));

	  for (WebElement rentweeks:RentedWeeks)

	  {

		  if (rentweeks.getText().equals(weeks))
		  {rentweeks.click();
		  break;
		  }

	  }*/
	  selectfromdropdown(30, spanRentedWeeks, ulRentedWeeks, liRentedWeeks, weeks);
	  
  }
  public void setBasementdwellings(String basement)
  {
	 /* WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("Basementdwellings"))));
		List <WebElement> Basementdwellings=driver.findElements(By.id("Basementdwellings"));	  
		   
		 if (basement.equalsIgnoreCase("yes"))
			 Basementdwellings.get(0).click();
		 else
			 Basementdwellings.get(1).click();*/
	 // waitforallelementstobevisible(Basementdwellings, 30);
	  selectRadioOption(Basementdwellings, basement);
	  
  }
  public void setOwnerAnimals(String animals)
  {
	  
	   /* WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("OwnerAnimals"))));
		List <WebElement> OwnerAnimals=driver.findElements(By.id("OwnerAnimals"));	  
		   
		if (animals.equalsIgnoreCase("yes"))
			OwnerAnimals.get(0).click(); 
		 else
			 OwnerAnimals.get(1).click();*/
	//  waitforallelementstobevisible(OwnerAnimals, 30);
	  selectRadioOption(OwnerAnimals, animals);
  }
  public void setWildNonDomestic(String wild)
  
  {
	  /*Actions act=new Actions(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(wildNonDomestic));
		//List <WebElement> WildNonDomestic=driver.findElements(By.id("WildNonDomestic"));	  
		   
		 if (wild.equalsIgnoreCase("yes"))
			
		     act.moveToElement(wildNonDomestic.get(0)).click().perform();
			
		 else
			 act.moveToElement(wildNonDomestic.get(1)).click().perform();*/
	 // fluentWait(WildNonDomestic, 30);
	  selectRadioOptionByAction(WildNonDomestic,wild);
	  
	 
  }
  
  public void setBiteHistory(String bite) 
  {
	  
	    /*WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("BiteHistory"))));
		List <WebElement> BiteHistory=driver.findElements(By.id("BiteHistory"));	  
		   
		 if (bite.equalsIgnoreCase("yes"))
			 BiteHistory.get(0).click();
		 else
			 BiteHistory.get(1).click();*/
	  fluentWait(BiteHistory,30);
	  // selectRadioOptionByAction(BiteHistory, bite);
	 // Thread.sleep(2000);
	  selectRadioOptionByAction(BiteHistory,bite);
  }
  
  public void setBusiness(String business)
  {
	  /*WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("Business"))));
		List <WebElement> Business=driver.findElements(By.id("Business"));	  
		   
		 if (business.equalsIgnoreCase("yes"))
			 Business.get(0).click();
		 else
			 Business.get(1).click();*/
	 // fluentWait(Business, 30);
	 
	  selectRadioOption(Business,business);
  }
  public void setBusinessType(String type)
  {
	  /*WebDriverWait wait = new WebDriverWait(driver, 30);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='trTypeBusiness']/div[1]/span/span/span[1]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='k-input'])[7]")))).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("ul"))));
	  List<WebElement> TypeBusiness=driver.findElements(By.xpath(".//*[@id='TypeBusiness_listbox']/li"));

	  for (WebElement business:TypeBusiness)

	  {

		  if (business.getText().equals(type))
		  {business.click();
		  break;
		  }

	  }*/
	  selectfromdropdown(30, spanBusinessTypes, ulBusinessType, liBusinessType, type);
	  
  }
  public void setOffice(String incioffice)
  {
	  office.clear();
	  office.sendKeys(incioffice);
	  
  }
  public void setClients(String clients)
  {
	  /*WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("Clients"))));
		List <WebElement> Clients=driver.findElements(By.id("Clients"));	  
		   
		 if (clients.equalsIgnoreCase("yes"))
			 Clients.get(0).click();
		 else
			 Clients.get(1).click();*/
	//  waitforallelementstobevisible(Clients, 30);
	  selectRadioOption(Clients, clients);
  }
  public void setClientVisits(String visits)
  {
	  
	  clientVisits.clear();
	  clientVisits.sendKeys(visits);
  }
  
  public void setOccupancy(String propertyType,String unit,String dwelling,String boarders,String occupancy,String insured,String hopolicy,String secondary,String rent,String weeks,String basement,String animals,String wild,String bite,String business,String type,String incioffice,String clients,String visits) 
  {
	 
	  setPropertyType(propertyType);
	  if(propertyType.equalsIgnoreCase("Multi-Family"))
	  {
		  setNumberUnits(unit);
		  
	  }
	  setDwelling(dwelling);
	  setBoarders(boarders);
	  setOccupancyStatus(occupancy);
	  if(occupancy.equalsIgnoreCase("Seasonal/Secondary"))
	  {
		  setInsured(insured);
		  if(insured.equalsIgnoreCase("yes"))
		  {
			  
			  sethoPolicy(hopolicy);
		  }
		  setSeasonalSecondary(secondary);
		  
	  }
	  setRent(rent);
	  if(rent.equalsIgnoreCase("yes"))
	  { setRentedWeeks(weeks);
	  }
	  setBasementdwellings(basement);
	  setOwnerAnimals(animals);
	  
	  if(animals.equalsIgnoreCase("yes"))
	  {
		  setWildNonDomestic(wild);
		  setBiteHistory(bite);
		  
		  
	  }
	  setBusiness(business);
	  if(business.equalsIgnoreCase("yes"))
	  {
		  setBusinessType(type);
		  if(type.equalsIgnoreCase("Incidental office occupancy") || type.equalsIgnoreCase("Other") )
		  {
			  
			  setOffice(incioffice);
		  }
		  setClients(clients);
		  if(clients.equalsIgnoreCase("yes"))
		  {
			  
			  setClientVisits(visits);
		  }
		  
	  }
	  clickNext();
  }
}
