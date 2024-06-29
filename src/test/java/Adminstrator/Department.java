package Adminstrator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Department extends Login {
	
	@Test
	public void manage() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.get("https://aaeb-school.account.uat.ethiocheno.com/manage");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement manage= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menuFontsize label-two-line text-trunctate-two-line'][normalize-space()='Manage']")));
		manage.click();
	}
	
	@Test//(dependsOnMethods = {"manage"})
	public void dept() throws InterruptedException 
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement dept=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Departments']")));
		dept.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Create Department']//*[name()='svg']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("user_role_name")).sendKeys("Arjun");
		driver.findElement(By.id("user_dept_code")).sendKeys("Arjun");
		Thread.sleep(3000);
		String file="C:\\Users\\reach\\Downloads\\policy.pdf";
		WebElement upload= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user_dept_policy']")));            
		upload.sendKeys(file);
		Thread.sleep(3000);
		driver.findElement(By.id("createRoleButton")).click();
	}

}
