import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TechniquestoAutomateAjaxcallsChildWindowsandIFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).build()
				.perform();
		/* Mouse Hover */
		// For Mouse and Keyboard Interaction we are using Action class's object.
		/*
		 * "a.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-
		 * accountList-nav-line-1']"))).build().perform();" moveToElement is a method of
		 * Action class, And it requires Element
		 * "By.xpath("//span[@id='nav-link-accountList-nav-line-1']")" Then we are
		 * Building this & Performing the hover action(means Execution).
		 */
		a.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).contextClick()
				.build().perform();
		/* contextClick() means Right click on Mouse */

		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click()
				.keyDown(Keys.SHIFT).sendKeys("cannon").doubleClick().build().perform();
		/*
		 * Here we are typing something in text box by pressing the "SHIFT" key & Then
		 * doing double click on That.
		 */

		driver.navigate().to(" https://rahulshettyacademy.com/loginpagePractise/");
		eWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")));
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

		Set<String> WindowsID = driver.getWindowHandles(); // By using "getWindowHandles()" we can get both windows ID.
		/* A new window or a new tab always treated as child window in selenium */

		Iterator<String> StartIterate = WindowsID.iterator();// we are using "iterator()" to access or Extract the
																// Parent & Child Window ID.
		String ParentID = StartIterate.next();// By using "next()" method we will able to move into 0th index.
		String ChildID = StartIterate.next();// 1st Index.

		driver.switchTo().window(ChildID);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());

		String text = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim()
				.split("with")[0];
		System.out.println(text);
		driver.switchTo().window(ParentID);// Switching from Child to Parent Window.
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(text);
		/*
		 * In the above code we took the text from child window and then took the mail
		 * id from that text and paste it In child tab's username field
		 */

		driver.navigate().to("https://jqueryui.com/droppable/");

		
		/* So frames are component which are hosted on the web pages. it is specific
		 * container and independent of this html code. So even frame isn't some html
		 * code, but that is separately prepared and hosted it on webpage as a
		 * container or as a box. selenium cannot identify the frames. Hence,
		 * frames in Web application, we cannot handle in a normal fashion. we
		 * need to tell selenium that, hey, this is in frames, so handle it accordingly.
		 * You need to tell to selenium before you deal with frames.. if you don't tell, it will 
		 * automatically think, this Locator is a part of this webbrowser and it will check the 
		 * entire html code & it will not able to find that. But if you tell, just go and check in
		 * a frame, then it's know and check the frames and then it identifies. That is the concept.
		 */

		/* Note:- In 3 way we can find frames
		 *             1. Through WebElement 
		 *             2. Through Index 
		 *             3. Through Id
		 * Frames are always present with "iframe" tagname, in HTML
		 *  */
		
		/*Through Index*/
		System.out.println(driver.findElements(By.tagName("iframe")).size());//We are using Tagname locator here to check the Iframe Tagname
		// and size() method to count the Iframe tags in the webpage.
		//The line "driver.findElements(By.tagName("iframe")).size()" will return count not the Index value.
		
		driver.switchTo().frame(0);/* We are saying to driver to Switching from driver object or normal webelement 
		                              content in page to frame */
		//But Here we are using Index value. i.e 0
		
		
		//driver.switchTo().frame((WebElement) driver.findElements(By.cssSelector("iframe[class='demo-frame']")));
		//Through WebElement 
		//((WebElement) driver.switchTo().frame((WebElement) By.id(""))).click();// Here id we kept as blank because id is not present in iframe html code
		//Through id 
		
		Actions A= new Actions(driver);
		
		  WebElement source =driver.findElement(By.id("draggable"));
		  WebElement target =driver.findElement(By.id("droppable"));
		  
		A.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();//it will switch from frame to normal webpage content
		
	}
}
