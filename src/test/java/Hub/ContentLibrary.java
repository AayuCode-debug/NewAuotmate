package Hub;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.xml.crypto.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContentLibrary{
	
	static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws AWTException, InterruptedException {

		//System.setProperty("webDriver.chrome.driver","C:\\Users\\AyushChouksey\\Downloads\\chromedriver.exe");
		
		//maximiseMode
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//navigateTo another URL
		//driver.navigate().to("https://us.lsquared.com");
		
		driver.get("https://rc.lsquared.com");
		//driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();	
		
		driver.findElement(By.id("email")).sendKeys("ayush.chouksey@47billion.com");
		driver.findElement(By.id("password")).sendKeys("Ayush@123");
		driver.findElement(By.className("btn")).click();
		
		driver.findElement(By.xpath("//*[text()='Continue']/self::*")).click();
		
		//left panel
		driver.findElement(By.xpath("//a[@id='leftPanel']/child::*")).click();
		
		//content library
		driver.findElement(By.xpath("//a[@uib-tooltip='Content Library']/child::*")).click();

		
		//create content folder
		driver.findElement(By.xpath("//*[text()='Create Folder']")).click();
		driver.findElement(By.id("label")).sendKeys("Content-Folder");
		driver.findElement(By.xpath("//*[text()='Create']/child::*")).click();
		Thread.sleep(3000);
		
		//Sort the folder
		driver.findElement(By.id("sorting")).click();
        WebElement sorting = driver.findElement(By.xpath("(//div[@class='pull-right dropdown open']/ul/li/a[text()='Descending'])[3]"));
		sorting.click();
		Thread.sleep(2000);
		
		//open content folder
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@data-type='folder'][1]"))).doubleClick().build().perform();
		Thread.sleep(1000);

		
		//upload content 
		driver.findElement(By.xpath("//*[text()='Add New Content']")).click();

		WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));

	    // Provide file paths you want to upload
		 String [] filePaths = {
				    "C:\\Users\\AyushChouksey\\Downloads\\1704370099.8849-wallpapersden-com-a-glitchy-retro-wave-sunrise-500x500.jpg",
					"C:\\Users\\AyushChouksey\\Downloads\\what-we-do-.png",
					"C:\\Users\\AyushChouksey\\Downloads\\Philips_Signature_Series_Trimmers_Limited_Virat_Kohli_Edition.mp4",
					"C:\\Users\\AyushChouksey\\Downloads\\samplepptx2.pptx",
					"C:\\Users\\AyushChouksey\\Downloads\\sample2.pdf",
					"C:\\Users\\AyushChouksey\\Downloads\\maninder_buttar_sakhiyaan_full-song_mixsingh_new_punjabi_songs_2018_latest-punjabi_video_song.mp3"
				};

		  for (String filePath : filePaths) {
	            try {
	                // Send the file path to the file input element
	                fileInput.sendKeys(filePath);
	                // Optionally, add a delay to see the upload happening
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
		 
	     //call content method        
//		  selectContent select = new selectContent(); 
//		  select.Content1(driver);

		
		Thread.sleep(2000);
		 driver.findElement(By.id("contentUploadBtn")).click();
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement ToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-bind-html='message']")));	
		
		String Message = ToastMessage.getText().trim();
		System.out.println("Toast Message: " + Message); 


/*		
		Thread.sleep(2000);
		
		//System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='message']")).getText());
		//Thread.sleep(2000);
				
		//update folder
/*		driver.findElement(By.xpath("//*[@data-type='folder'][1]")).click();
		driver.findElement(By.xpath("//section/div/ul/span[1]")).click();
		driver.findElement(By.xpath("//ul/span/ul/li[2]")).click();
	    driver.findElement(By.xpath("//input[@id='label']")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "Folder");
	  //driver.findElement(By.xpath("//input[@id='label']")).clear();
	    driver.findElement(By.xpath("//section/div/span/button[1]")).click();
	    Thread.sleep(2000);
	    System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='message']")).getText());
	  //System.out.pridriver.findElement(By.xpath("//div[@ng-bind-html='message']")).getText()ntln(driver.findElement(By.xpath("//div[@ng-if='hasErr']")).getText());   //validation message
	   
	    //Delete content folder
		driver.findElement(By.xpath("//*[@data-type='folder'][1]")).click();
		driver.findElement(By.xpath("//section/div/ul/span[11]")).click();
		
		//WebDriverWait w = new WebDriverWait(driver,2);
		//w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//section/footer/button[1]"))));
				
				
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section/footer/button[1]")).click();
		//Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='message']")).getText());
		
		//Move/copy
		driver.findElement(By.xpath("//*[@data-type='folder'][1]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//section/div/ul/span[1]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/span/ul/li[3]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//div/label[2]")).click();
		driver.findElement(By.xpath("//section/footer/span/button[1]")).click();
		//Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='message']")).getText());
		
		//Archive folder
		driver.findElement(By.xpath("//*[@data-type='folder'][1]")).click();
		driver.findElement(By.xpath("//section/div/ul/span[1]")).click();
		driver.findElement(By.xpath("//ul/span/ul/li[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section/footer/button[1]")).click();
		//Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='message']")).getText());
		
		//Archive content tab
		//driver.findElement(By.xpath("//ul[@role='tablist']/child::*[4]")).click();
		
		//Create widget
        driver.findElement(By.xpath("//*[text()='Add New Content']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Create Widget']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector("#wSBox")).sendKeys("youtube");
		driver.findElement(By.className("youTube")).click();
		driver.findElement(By.id("playListId")).sendKeys("https://www.youtube.com/watch?v=xOMMV_qXcQ8");
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		//Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='message']")).getText());
*/	
		//search for widget
//		driver.findElement(By.xpath("//input[@id='searchBox']")).sendKeys("Youtube");
	
	}

}
