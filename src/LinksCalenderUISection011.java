import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCalenderUISection011 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		/*Here we are counting links on a webpage by using size() method & searching through tagname locator */
		/*we are using here findElements because here we are counting multiple links*/
		
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
	    /*we are using here findElement, because here we are only trying to identify the footer section & in
	     * webpage footer is always only presents one*/
		System.out.println( footerdriver.findElements(By.tagName("a")).size());
		//we are using footerdriver variable to count links in footer section
		
		
		WebElement columndriver=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		//footer's 1st column we are locating here
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		//we are using columndriver variable to count links in footer's 1st column
		
		
		//Open all the links which are present in first column of the footer
		
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size();i++) {
			
		    String ClickonLinkTab=Keys.chord(Keys.CONTROL, Keys.ENTER);//We are storing this keyboard operation/action in "ClickonLinkTab" String type variable 
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickonLinkTab);
			//"SendKey" we are using for Keyboard operation, Earlier we used this for 
			// typing something through keyboard. Here we are using to click the CTRL+ENTER
			// buttons through Keyboard. 
			Thread.sleep(1000);
		}
		
		//Getting all the opened windows's title.
		Set<String> NumberofWindows = driver.getWindowHandles();// "getWindowHandles()" method will start counting the number of tabs opened in a driver/browser.--Result is 4
		Iterator<String > WindowsIndexValue = NumberofWindows.iterator();//"iterator()" method will start iterating in driver/browser & store all the windows's index value.--But here Result will be 5
	
		while(WindowsIndexValue.hasNext()) { //"hasNext()" method will check, whether is there any next tab is present or not.
			
			
			driver.switchTo().window(WindowsIndexValue.next()); // "next()" method will help the driver to move to the next tab by the help of "WindowsIndexValue" variable.
			System.out.println(driver.getTitle()); //"getTitle()" will collect the window's title.
			Thread.sleep(2000);
		}
	}
}
