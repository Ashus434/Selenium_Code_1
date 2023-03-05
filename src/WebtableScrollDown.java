import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class WebtableScrollDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.edge.driver", "F:\\Study\\eclipse-workspace\\Z_Browser Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		/*For webpage & webtableScroll down selenium don't have any feature 
		 * so by the help of JavascriptExecutor we can perform this action. JavascriptExecutor is a class 
		 * and we are creating it's object here. then we are casting our driver to JavascriptExecutor. so now 
		 * our driver is aware that he will go ahead and execute the javascript & that knowledge will be placed in
		 * the js object reference.  
		 */
		
		
		js.executeScript("window.scrollBy(0, 700)");
		/*"window.scrollBy(0, 700)" is a javaScript command we have to run in browser-->console
		 * and by hit and trail we have to check the appropriate number(500 or 600 or 700) to 
		 * check At what number the window is scrolling down and perfectly displaying the webtable.
		 */
		  /* here we are scrolling down the window first*/
		
		
		Thread.sleep(2000);
		
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		/*"document.querySelector(".tableFixHead").scrollTop=5000" with this command we can scrollTop
		 * the WebTable rows and get scroll down. this command also we have to check in browser-->console
		 * "tableFixHead" is the className of wetable.
		 * 
		 */
		  /* Then here we are scrolling down the webtable */
		
		
		
		
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		
		for(int i=0; i<values.size(); i++) {
			
			sum = sum + Integer.parseInt(values.get(i).getText());//"values.get(i).getText()" return type
			// is string so we are converting to integer by the help of "Integer.parseInt".
		}
		
		System.out.println(sum);
		
		/* We are taking all the 4rth column's value and doing the summation */
		
		
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		
		
	}

}
