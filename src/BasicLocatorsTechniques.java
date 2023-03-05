import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocatorsTechniques {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/////////////////////////// *Section- 05*////////////////////////////////

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Implicit wait- wait till 10 second universally(for each and every step, which
		// will take
		// driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		System.out.println(driver.getCurrentUrl());

		// driver.findElement(By.className("btn")).click();
		// If Class value have space then that should be consider multiple classes & we
		// can use any class.

		// driver.findElement(By.cssSelector("a.register-btn")).click();
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("ashutosh.kar.310@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("65Fg*T");
		driver.findElement(By.cssSelector("button.submit")).click();
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());

		// CSSSelector can be constructed in 3 ways
		// 1. if ID is present then syntax should be tagname#id
		// 2. if ClassName is present then syntax should be tagname.className
		// 3. we can also construct the CSSSelector in customized way-
		// TagName[attribute='value']
		// Note:- We can validate the uniqueness of CSSSelector in Console tab
		// by writing- $('') /*Inside single quote ('') write the Constructed
		// CSSSelector*/

		driver.findElement(By.linkText("Forgot your password?")).click();
		// LinkText locator

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ajit.kar@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text'][1]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Name']:nth-child(2)")).sendKeys("ajit.kar@gmail.com");

		// Xpath
		// 1. the syntax for customized Xpath- //TagName[@attribute='value']
		// Note:- We can validate the uniqueness of Xpath in Console tab
		// by writing- $x('') /*Inside single quote ('') write the Constructed Xpath */
		// Indexing Xpath & CSS Selector
		/* 1. //TagName[@attribute='value'][1] */ // --Xpath.
		/* 2. TagName[attribute='value']:nth-child(2) */ // --CSS Selector.

		driver.findElement(By.xpath("//form/input[3]")).sendKeys("75849921");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("form input:nth-child(4)")).clear();

		// Parent to Child Traverse
		// Note :- We are following the Parent to Child traversing technique, when we
		// don't have
		// any attributes for a web element HTML .
		// For Xpath, Parent to Child Traverse syntax is:-
		/* //ParentTagName/ChildTagName or //ParentTagName/ChildTagName[Index]. */
		// For Xpath, Parent to Child Traverse syntax is:-
		/* ParentTagName ChildTagName or ParentTagName ChildTagName:nth-child(Index). */

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		driver.findElement(By.cssSelector("input[id*='Username']")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[contains(@name,'box')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		// Regular Expressions for CSSselector & Xpath:-
		// Note:- We are using regular expressions when attribute value is dynamic or
		// too long, so
		// in that case we are using static or sub value of that attribute to build
		// regular expression.
		// (For exp we have: type='password', id='passcode', class='password')
		// Syntax for Xpath Regular Expressions:
		// "//TagName[contains(@attribute,'sub/static/common value')]"
		// Syntax for CSSselector Regular Expressions:
		// "TagName[attribute*='sub/static/common value']"
		// Another way of Writing Xpath:
		// "//ParentTagName[@attribute='forgot-pwd-btn-conainer']/ChildTagName[index]"

	}
}
