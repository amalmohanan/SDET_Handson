package webautomation.cucumber.SdetAssesment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RetailStepDef {
	WebDriver driver;
	String name;
	String updatedName;

	@Given("I navigate to the login page")
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver= new ChromeDriver();	
		driver.get("http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=fOtazgcSDn3hST8dy4F1RPyPR15xQsnO");
		driver.manage().window().maximize();
	}
	@When("I submit username and password")
	public void login() {
		driver.findElement(By.id("input-username")).sendKeys("admin");
		driver.findElement(By.id("input-password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}
	@Then("I should be logged in")
	public void dashboard() throws InterruptedException {
		Assert.assertEquals("Dashboard", driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText());
		Thread.sleep(3000);
	}

	
	@Given("I navigate to coupon page")
	public void i_navigate_to_coupon_page() {
	    // Write code here that turns the phrase above into concrete actions

		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-share-alt fw'])")));
		act.build().perform();
		driver.findElement(By.xpath("(//a[text()='Coupons'])[1]")).click();
		
	}

	@When("I create a coupon from home page")
	public void i_create_a_coupon_from_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@data-original-title='Add New']")).click();
		name = getname();

		driver.findElement(By.id("input-name")).sendKeys(name);
		driver.findElement(By.id("input-code")).sendKeys("1234");
		
		driver.findElement(By.xpath("//button[@data-original-title='Save']")).click();
		
	}

	@Then("I verify that the coupon created")
	public void i_verify_that_the_coupon_created() {
	    // Write code here that turns the phrase above into concrete actions
		String locator="//td[text()='"+name+"']";
	    Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());
	    driver.quit();
	}

	@When("I updating the coupon details")
	public void i_updating_the_coupon_details() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("(//a[@data-original-title='Edit'])[1]")).click();
		updatedName=getname()+"xyz";
		driver.findElement(By.id("input-name")).clear();
		driver.findElement(By.id("input-code")).clear();
		driver.findElement(By.id("input-name")).sendKeys(updatedName);
		driver.findElement(By.id("input-code")).sendKeys("9874");
		driver.findElement(By.xpath("//button[@data-original-title='Save']")).click();
	}

	@Then("I verify that the coupon updated")
	public void i_verify_that_the_coupon_updated() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='"+updatedName+"']")).isDisplayed());
		driver.quit();
	}

	@When("I deleting the coupon details")
	public void i_deleting_the_coupon_details() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("(//input[@name='selected[]'])[1]")).click();
		driver.findElement(By.xpath("//button[@data-original-title='Delete']")).click();
		driver.switchTo().alert().accept();
		
	}
	@Then("I verify that the coupon deleted")
	public void i_verify_that_the_coupon_deleted() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Success: ')]")).isDisplayed());
		driver.quit();
	}
	
	public static String getname() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	}

}
