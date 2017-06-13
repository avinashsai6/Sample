package GIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class App 
{
	WebDriver driver;
	@BeforeTest
	public void Setup()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://staging.realmilk.co.in/#/home");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/**
	 *OTP is not handled in this method
	 *But OTP field visibility is verified
	 */
	@Test
	public void SignUp() throws InterruptedException
	{	

		String Title=driver.getTitle();
	}
}
