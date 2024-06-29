package DigitalLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddEbook {
	
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
		 }
	
	
	@Test
	public void test() throws InterruptedException, AWTException
	{
		
//		WebElement digilibrary=driver.findElement(By.xpath("//*[@id=\"productsList\"]/div[2]/div[4]/span/a/img"));
//		digilibrary.click();
		Robot rob = new Robot();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement digilibrary=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='digitallibrary']")));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", digilibrary);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Add']")).click();
		driver.findElement(By.xpath("//a[@class='uploadd']")).click();
		Thread.sleep(2000);
		//file upload
		WebElement select= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container_content\"]/div[1]/div[2]/div/div[2]/div[1]/div/button")));
		String file="C:\\Users\\reach\\Downloads\\status (13).pdf";
		select.sendKeys(file);
       StringSelection stringSelection = new StringSelection(file);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
       Thread.sleep(3000);
       rob.keyPress(KeyEvent.VK_CONTROL);
       rob.keyPress(KeyEvent.VK_V);
       rob.keyRelease(KeyEvent.VK_V);
       rob.keyRelease(KeyEvent.VK_CONTROL);
       rob.keyPress(KeyEvent.VK_ENTER);
       rob.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(1500);
       driver.findElement(By.id("author")).sendKeys("JK Rowling");
       driver.findElement(By.id("description")).sendKeys("Harry potter and the goblade of fire");
       driver.findElement(By.id("edition")).sendKeys("JK Rowling");
       driver.findElement(By.id("page_count")).sendKeys("100");
       driver.findElement(By.id("isbn-number")).sendKeys("1234567");
       Thread.sleep(3000);
       driver.findElement(By.xpath("//button[@title='Select Language']//div[@class='filter-option']")).click();
		driver.findElement(By.xpath("//span[@class='text'][normalize-space()='English']")).click();
		driver.findElement(By.id("download")).click();
		
		
		//Thumbnail	
		WebElement thumbnail=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Upload Thumbnail']")));
		//String photo="C:\\Users\\reach\\OneDrive\\Pictures\\Issues\\1.png";
		thumbnail.click();
		Thread.sleep(3000);
		StringSelection stringS = new StringSelection("C:\\Users\\reach\\OneDrive\\Pictures\\Issues\\1.png");
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringS, null);
	       rob.keyPress(KeyEvent.VK_CONTROL);
	       rob.keyPress(KeyEvent.VK_V);
	   
	      // release Contol+V for pasting
	      rob.keyRelease(KeyEvent.VK_CONTROL);
	      rob.keyRelease(KeyEvent.VK_V);
	   
	      // for pressing and releasing Enter
	      rob.keyPress(KeyEvent.VK_ENTER);
	      rob.keyRelease(KeyEvent.VK_ENTER);
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//span[normalize-space()='Upload']")).click();
	     WebElement nextstep= driver.findElement(By.xpath("//button[normalize-space()='Next Step']"));
	      js.executeScript("arguments[0].click()", nextstep);
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//button[@title='Category']//div[@class='filter-option']")).click();
	      driver.findElement(By.xpath("//*[@id=\"upload-form\"]/form/div[2]/div/div/div/div[1]/div/div/div/ul/li[2]/a/span[2]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'Subject')]")).click();
	      driver.findElement(By.xpath("//body//div[@class='yp_side_menu has_side_menu']//div[@class='video_fields']//div//div[@class='pp_mat_input']//li[2]//a[1]")).click();
	      driver.findElement(By.xpath("//*[@id=\"pt-body\"]/div[1]/div/a")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'Grade')]")).click();
	      driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select show-tick show-menu-arrow open']//li[8]//a[1]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'Grade')]")).click();
	      driver.findElement(By.xpath("//*[@id=\"upload-form\"]/form/div[2]/div/div/div/div[5]/ul/li/input")).click();
	      driver.findElement(By.xpath("//*[@id=\"upload-form\"]/form/div[2]/div/div/div/div[5]/ul/li/input")).sendKeys("jjk");
	      rob.keyPress(KeyEvent.VK_ENTER);
	      driver.findElement(By.xpath("//button[@id='preview-btn']")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//button[@id='submit-btn']")).click();
	      
	      
	
	}

}
