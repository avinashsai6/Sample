package GIT.Git_Test;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest 
{
	WebDriver driver;
	public static String driverPath = "C:/Users/avinash.p/Desktop/";
	public static final String USERNAME = "TestingApp22";
	public static final String ACCESS_KEY = "eae0dac2-8b4c-409f-8491-9b82c03f02df";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	@BeforeTest
	public void SetUp() throws MalformedURLException, InterruptedException
	{	
		
		driver = new FirefoxDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	}
	@Test
	public void Login() throws MalformedURLException, InterruptedException
	{
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='ap_email']")).clear();
		driver.findElement(By.xpath(".//*[@id='ap_email']")).sendKeys("avinashsai6@gmail.com");
		driver.findElement(By.xpath(".//*[@id='ap_password']")).sendKeys("9885674494");
		driver.findElement(By.xpath(".//*[@id='signInSubmit']")).click(); 
	}
	
	@Test
	public void ProductSearch(String Product) throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Product);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='nav-logo']/a[1]/span[1]")).click();
		System.out.println("  before get data  ");
		//String s1=driver.findElement(By.xpath(".//*[@id='result_0']/div/div[3]/div[1]/a/h2")).getText();
		//System.out.println("get data  "+s1);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("Your Orders"));
		actions.moveToElement(mainMenu);
		WebElement subMenu = driver.findElement(By.xpath(".//*[@id='nav-item-signout']/span"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}
}
