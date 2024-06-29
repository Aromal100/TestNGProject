package SitePortal;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class page extends AdLogin {
	@Test
	public void pagetest() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.get("https://aaeb-school.sims.uat.ethiocheno.com/site");
	   driver.findElement(By.xpath("//span[normalize-space()='Pages']")).click();
	   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	  WebElement page= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"moduleContainer\"]/div/div[5]/div[1]/div[2]/div[2]/div/div[1]/a/span[2]")));
	page.click();
	}
	
	@Test(dependsOnMethods = {"pagetest"})
	public void pagecreation() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.id("title")).sendKeys("sie");
		driver.findElement(By.xpath("//*[@id=\"my-form\"]/div/div[1]/div/div[3]/div[2]/div/div[3]/div[2]")).sendKeys("sie");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"my-form\"]/div/div[1]/div/div[3]/div[1]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id=\"2\"]/div/img)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("insert_into_page")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"set-featured-img\"]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id=\"4\"]/div/img)[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("set_featured_image")).click();
		
		driver.findElement(By.xpath("//*[@id=\"sliderimages-box\"]/span/span/span")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("(//*[@id=\"4\"]/div/img)[4]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//*[@id=\"7\"]/div/img)[4]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//*[@id=\"8\"]/div/img)[4]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//*[@id=\"40\"]/div/img)[4]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("set_slider_images")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@id=\"publish-loader\"]")).click();
		
		
	}
	
	@Test(dependsOnMethods = {"pagecreation"})
	public void movetomenu() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@onclick=\"toggleSideMenu('site')\"]//*[name()='svg'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"manage_menu_\"]/a/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"accordionPanelsStayOpenExample\"]/div[1]/h2/button")).click();
		driver.findElement(By.id("page-94")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id=\"most-recent\"]/div[2]/button)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"menu-post-body\"]/div[2]/button")).click();
		Thread.sleep(5000);
		driver.get("https://aaeb-school.sims.uat.ethiocheno.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='More']")).click();
	}

}
