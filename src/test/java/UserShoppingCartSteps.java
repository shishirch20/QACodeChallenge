package test.java;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserShoppingCartSteps {
	public static WebDriver driver;
	@Given("^User is on Home Page of EBAY$")
	public void user_is_on_Home_Page_EBAY() throws Throwable {
		//Setting up chrome driver properties.
		System.setProperty("webdriver.chrome.driver", "C:\\cucumberTest\\OUside Jar\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.logfile", "C:\\cucumberTest\\OUside Jar\\chromedriver_win32\\chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "False");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com.au/");
		}

	@When("^User Navigate to Product Page$")
	public void user_Navigate_to_Product_Page() throws Throwable {
		//User selects the link on the home page to go to the categories page
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//User selects the particular product from the Menu
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/div[2]/a[2]/div[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//User selects the sub-category in the product
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/div[2]/a[2]/div[1]/img")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//User navigates to the subclass of product ordered.
		driver.findElement(By.xpath("//*[@id=\"w5-xCarousel-x-carousel-items\"]/ul/li[1]/a/p")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//User moves to the final product page which he is bying
		driver.findElement(By.xpath("//*[@id=\"w6-items[2]\"]/div/div[1]/div/a/div/img")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

	@When("^User selects the product and adds to cart$")
	public void user_selects_Product_and_addsToCart() throws Throwable {
		//Clears the default quantity in the text box
		driver.findElement(By.className("qtyInput")).clear();
		driver.findElement(By.className("qtyInput")).sendKeys("2");
		//Add it to the cart
		driver.findElement(By.xpath("//*[@id=\"isCartBtn_btn\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Click on the Add on summary to NO
		driver.findElement(By.xpath("//*[@id=\"ADDON_0\"]/div/div[2]/div/div[4]/div/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	new Select(driver.findElement(By.id("s1-10-big_yard-235710189-172991401895-qty[]_1-1-dropdown"))).selectByVisibleText("2");
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@Then("^User goes to checkout$")
	public void User_goes_Checkout() throws Throwable {
		//User goes to checkout and clicks the purchase
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div/button")).click();
		System.out.println("Checkout Successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Closes the browser.
		driver.close();
	}
}