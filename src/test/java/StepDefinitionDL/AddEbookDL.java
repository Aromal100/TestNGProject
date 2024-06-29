package StepDefinitionDL;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddEbookDL {
	
	WebDriver driver;
	@Given("User is on login page")
	public void user_is_on_login_page() {

		driver = new ChromeDriver();
		driver.get("https://aaeb-school.sims.uat.ethiocheno.com");
	}

	@And("user clicks on the login button")
	public void user_clicks_on_the_login_button() throws InterruptedException {
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebElement w=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://aaeb-school.sims.uat.ethiocheno.com/signin/index']")));
		w.click();
	    
	}

	@Then("user give username as {string} and clicks on the next button")
	public void user_give_username_as_and_clicks_on_the_next_button(String username) throws InterruptedException {
	    
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("SubmitBtn")).click();
	}

	@Then("user need to give password as {string} and clicks on the submit button")
	public void user_need_to_give_password_as_and_clicks_on_the_submit_button(String password) throws InterruptedException {
	    
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("continueBtn")).click();
	}

	@And("user enters the home page")
	public void user_enters_the_home_page() {
	    
		System.out.println("User enters in the login page");
	    
	}
	@Then("user need go to the digital library")
	public void user_need_go_to_the_digital_library() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement digilibrary=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='digitallibrary']")));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", digilibrary);
	    
	}

	@And("click on the add button")
	public void click_on_the_add_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Add']")).click();
	    
	}

	@Then("click on the upload ebook")
	public void click_on_the_upload_ebook() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='uploadd']")).click();
	    
	}

	@And("then user need to upload the file")
	public void then_user_need_to_upload_the_file() throws AWTException, InterruptedException {
		Robot rob = new Robot();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
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
	    
	}

	@Then("need to upload the thumbnail")
	public void need_to_upload_the_thumbnail() throws AWTException, InterruptedException {
		Robot rob = new Robot();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		JavascriptExecutor js= (JavascriptExecutor)driver;
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
