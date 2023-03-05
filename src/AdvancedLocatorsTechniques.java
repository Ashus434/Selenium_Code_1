import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class AdvancedLocatorsTechniques {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Ashutosh";
		/*System.setProperty("webdriver.chrome.driver", "D:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); */
		System.setProperty("webdriver.edge.driver", "F:/Study/eclipse-workspace/Z_Browser Drivers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// System.setProperty("webdriver.gecko.driver", "D:\\lib\\geckodriver.exe");
		// WebDriver driver =new FirefoxDriver();
		// driver.manage().window().maximize();

		// System.setProperty("webdriver.edge.driver", "D:\\lib\\msedgedriver.exe");
		// WebDriver driver =new EdgeDriver();
		// driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String Password = RetrivePassword(driver);
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
		driver.findElement(By.cssSelector("input[id*='Username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(Password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@name,'box')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		// Logging in Page

		// Tagname Locator will always identify & use the 1st top-left tagname of the
		// webpage. So
		// if we have multiple tag name in a page then it will pickup 1st top-left
		// tagname. Hence
		// we are not using it.(it is not working properly, So i have removed from here)

		System.out.println(driver.findElement(By.xpath("//p[contains(@style,'color: rgb(27, 179, 102);')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(@style,'color: rgb(27, 179, 102);')]")).getText(),
				"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");
		// Assertion we are using to compare to objects(actual, expected). Here we are
		// validating the UI text.

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Log Out']")).click();

		// "Finding WebElement based upon Text by the help of Xpath"(This feature not
		// available for CSSSelector)
		// Syntax:- //TagName[text()='WebElement Text'] or //*[text()='WebElement Text']
		// "*" Stands for any TagName. But if u want to hit exact element then * should
		// not preferable.

		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		System.out
				.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		// Traversing in Sibling only- (Follow the above xpath, this way it is writing)
		/*
		 * Note: Xpath are 2 types 1. Absolute Xpath(it is too long because we have to
		 * write from starting parent tag of html page to expected child tag). 2.
		 * Relative Xpath(it is not long like absolute, because to write this Xpath we
		 * have to directly break or jump into the relative parent tag of that expected
		 * child tag).
		 * 
		 * In Absolute Xpath, at the begging we are using single slash "/" In Relative
		 * Xpath, at the begging we are using double slash "//"
		 */

		System.out.println(
				driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[2]")).getText());
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[2]")).click();
		// Traversing from Child to Parent- (Follow the above xpath, this way it is
		// writing)

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		driver.close(); // It will close the browser.

	}

	public static String RetrivePassword(WebDriver driver) throws InterruptedException {

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();

		String GotTheUIText = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login.
		String[] SplitedText = GotTheUIText.split("'");
		String ExactText = SplitedText[1];
		return ExactText;

	}
}
