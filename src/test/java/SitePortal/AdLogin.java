package SitePortal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;



public class AdLogin {
	
	WebDriver driver;
	@BeforeTest
	public void seturl()
	{
		
		driver=new ChromeDriver();
		driver.get("https://aaeb-school.sims.uat.ethiocheno.com/");
	}
	
	@org.testng.annotations.Test
	public void login() throws InterruptedException
	{
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebElement w=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://aaeb-school.sims.uat.ethiocheno.com/signin/index']")));
		w.click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("admin@tria.plc");
		driver.findElement(By.id("SubmitBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("eschool@123");
		driver.findElement(By.id("continueBtn")).click();
	}

}
