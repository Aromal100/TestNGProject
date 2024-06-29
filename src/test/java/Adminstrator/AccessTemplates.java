package Adminstrator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccessTemplates {
	
	WebDriver driver;
	
	@BeforeTest
	public void logintest() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://aaeb-school.sims.uat.ethiocheno.com/");
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebElement w=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://aaeb-school.sims.uat.ethiocheno.com/signin/index']")));
		w.click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("admin@tria.plc");
		driver.findElement(By.id("SubmitBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("school@dmin");
		driver.findElement(By.id("continueBtn")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void manage() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement Administrator=driver.findElement(By.xpath("//*[@id=\"productsList\"]/div[2]/div[8]/span/a/img"));
		Administrator.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement manage= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menuFontsize label-two-line text-trunctate-two-line'][normalize-space()='Manage']")));
		manage.click();
		WebElement Access=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Access permission templates']")));
		Access.click();
		
		WebElement box1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"select-checkBox\"])[1]")));
		box1.click();
		WebElement box2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"select-checkBox\"])[2]")));
		box2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='deleteButton']")).click();
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}

}
