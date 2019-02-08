package test.java;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserFlightBookTestSteps {
	public static WebDriver driver;
	@Given("^User is on Home Page of PHPTRAVELS$")
	public void user_is_on_Home_Page_of_PHPTRAVELS() throws Throwable {
		//This section sets up the property of MOzilla browser and opens the driver.
		System.setProperty("webdriver.gecko.driver", "C:\\cucumberTest\\OUside Jar\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/");
		}

	@When("^User clicks on Flight Booking Page$")
	public void user_clicks_on_Flight_Booking_Page() throws Throwable {
		//User Navigates to the flight booking page.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	

	@And("^User selects the Flight details and clicks on Search$")
	public void user_selects_Flight_Details_and_clicks_On_Search() throws Throwable {
		//User enter the  from flight details
		WebElement element =driver.findElement(By.cssSelector("div[id='s2id_location_from']"));
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(element)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		driver.findElement(By.xpath("/html/body/div[17]/div/input")).sendKeys("Sydney");
		driver.findElement(By.xpath("/html/body/div[17]/ul/li[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//User enter to flight details.
		element =driver.findElement(By.cssSelector("div[id='s2id_location_to']"));
		wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(element)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		driver.findElement(By.xpath("/html/body/div[18]/div/input")).sendKeys("Mel");
		driver.findElement(By.xpath("/html/body/div[18]/ul/li[2]")).click();
		//Picks up the matching airport
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[4]/form/div[9]/div[1]/div/div/ins"));
		element.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[4]/form/div[3]/div/input")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/tbody/tr[2]/td[7]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Selects the flight itinerary
		driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[4]/form/div[6]/button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		}

	
	@When("^User books the Flight$")
	public void user_books_the_Flight() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//User books the flight
		WebElement element =driver.findElement(By.xpath("//*[@id=\"bookbtn\"]"));
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(element)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		}
	
	
	@Then("^User fills form and Confirms the booking$")
	public void User_fills_form_and_confirms_the_Booking() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//User fills the personal particulars form with details of Name, Age Passport number, Address and confirms the details
		driver.findElement(By.name("firstname")).sendKeys("Test1");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("lastname")).sendKeys("Test1");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("Test1@gmail.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("confirmemail")).sendKeys("Test1@gmail.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("phone")).sendKeys("Test1@gmail.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("address")).sendKeys("123 Test Street Sydney");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("passenger[name]")).sendKeys("Test2");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("passenger[age]")).sendKeys("38");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("passenger[passportnumber]")).sendKeys("12345678");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[1]/div[2]/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Closes the browser.
		driver.close();
	}

//////////////////////////////////////////////////////////////////////
}