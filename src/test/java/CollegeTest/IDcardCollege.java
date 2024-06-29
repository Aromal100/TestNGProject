package CollegeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IDcardCollege {

	
	WebDriver driver;
	
	@BeforeTest
	public void url() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://skilldux.sims.uat.ethiocheno.com/");
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement w=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']")));
		w.click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("altrin.resbee+22@gmail.com");
		driver.findElement(By.id("SubmitBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("continueBtn")).click();
		System.out.println("Admin enters the school");


	}
	
	@Test
	public void IDcard() throws InterruptedException
	{
		Thread.sleep(5000);
	  WebElement id= driver.findElement(By.xpath("//span[normalize-space()='ID Card']"));
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click()", id);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='ID Card Setting']")).click();
		System.out.println("Admin goes to Id card settings");
		System.out.println("Need to create the template");
		driver.findElement(By.xpath("//button[@class='btn btn-green']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"nameOfTheProject-input\"]")).sendKeys("Test");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"widthOfTheProject-input\"]")).sendKeys("500");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"heightOfTheProject-input\"]")).sendKeys("300");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"createNewDesignbtn\"]")).click();
		System.out.println("Id card template created successfully");
		
		
	}
	
	
	
	
	
	
	
	
}
