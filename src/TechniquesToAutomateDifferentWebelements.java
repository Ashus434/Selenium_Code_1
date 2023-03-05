import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TechniquesToAutomateDifferentWebelements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement staticdropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select dropdown = new Select(staticdropdown);

		/*
		 * Note:- In html code Select tag is mostly used for static dropdown. And
		 * Selenium have a Select class to handle the static dropdown webelement
		 */
		/*
		 * So here we are creating Select class object, so we can use his methods. When
		 * we are creating select class object, we have to inform to that object about
		 * static dropdown location. Hence we have written this line
		 * "WebElement staticdropdown=driver.findElement(By.name("
		 * ctl00$mainContent$DropDownListCurrency"));"
		 */
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(0);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		/*
		 * 3-Ways to select static dropdown values. 1. selectByIndex(); 2.
		 * selectByValue(""); 3. selectByVisibleText("");
		 */

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 1; i < 6; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		Thread.sleep(1000);
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		/*
		 * Here we are just using for loop to do the clicking task multiple times for a
		 * dropdown
		 */

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@text='Bengaluru (BLR)']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@text='Goa (GOI)'])[2]")).click();

		/*
		 * Here, the GOA city is present in both departure & Arrival table, So if we
		 * will write simple xpath to select in Arrival table, then selenium will find 2
		 * matching(one in departure & one in Arrival) & by default it will try to
		 * select the first top left table(departure) value. but real it will not able
		 * to select the GOA city in non of the table(Because in first table city has
		 * already selected and closed).
		 */
		/*
		 * So the solution we used here is just provided the Index value to the whole
		 * Xpath--> By.xpath("(//a[@text='Goa (GOI)'])[2]"))
		 */
		// This is Dynamic Dropdown.

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();

		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Bhopal (BHO)']"))
				.click();
		// This alternative of Xpath Indexing.So it is Parent Xpath to Child Xpath
		// Traverse technique.

		System.out.println(driver.findElement(By.className("ui-state-highlight")).getText());
		driver.findElement(By.className("ui-state-highlight")).click();

		// Or
		// System.out.println(driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")));
		// driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

		/* In Calendar current Date selection. */

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}

		/*
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 */
		/*
		 * Note:- isEnabled() we are using to check if the webelement is enabled or not.
		 * But here Due to UI issue we are using the above workaround to Validate the UI
		 * Element is disabled or enabled.
		 */

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		// AutoSuggestion Code.

		Thread.sleep(3000);
		Assert.assertFalse(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		System.out.println(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		System.out.println(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		// CheckBox & Assertions.
		/*
		 * assertFalse- Always expect false return from the given condition. assertTrue-
		 * Always expect True return from the given condition.
		 * 
		 * if not got the expected false/True then it will fail test it self. (that's
		 * why no need to use syste.out.println to check the true/ false return on
		 * console, if we are using assertiontrue/assertionfalse.
		 * 
		 */

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		// Checkboxes :
		// Here, in cssselector we have taken a common attribute, which is present for
		// all the 6 checkboxes, then we can count
		// the total checkboxes in webpage. An here we used "findElements" instead of
		// "findElement".
		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());

		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("Input[name='enter-name']")).sendKeys("Hey Ashu");
		driver.findElement(By.xpath("//input[@class='btn-style']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		/* Java Alert Handle */
		// Note- java alerts are don't have any HTML code. So you can't inspect it.
		// Hence we are switching
		// the driver from webpage to Java alert by writing "driver.switchTo().alert()"
		// To click on Yes/OK we are using .accept();
		// To click on Cancel/No we are using .dismiss();

	}
}
