package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinations {
WebDriver driver;	

@Given("I launch chrome browser")
public void launch_chrome() {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
}

@And("I open ornage hrm homepage")
public void open_homepage() {
    driver.get("http://localhost/opencart/upload/");
    driver.manage().window().maximize();
}

@When("Enter username and password")
public void enter_user_pswd() {
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
   driver.findElement(By.name("email")).sendKeys("testuser1@gmail.com");
   driver.findElement(By.name("password")).sendKeys("Test@123");
}

@When("Click on login button")
public void click_login() throws InterruptedException {
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(5000);
}

@Then("User must succefully login to the dashboard")
public void succefully_login() {
	String heading=null;
	try
	{
	heading=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText();
	System.out.println(heading);
	}
	catch (Exception e)
	{
		driver.close();
		Assert.assertTrue(false);
	}
	if(heading=="My Account")
		Assert.assertTrue(true);
}

@Then("Closed browser")
public void closed_browser() throws InterruptedException {
	
	driver.quit();
	System.out.println("Done");
 
}


}
