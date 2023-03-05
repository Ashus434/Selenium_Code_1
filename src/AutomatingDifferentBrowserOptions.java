import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AutomatingDifferentBrowserOptions {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		EdgeOptions options=new EdgeOptions();
		options.setAcceptInsecureCerts(true); //"setAcceptInsecureCerts(true)" this method will help us to accept the certificate
		
		//So basically, this Edge options class help us to set the behavior for your Chrome browser.
		//it will tell to the browser to how to behave in a specific conditions.
		
		System.setProperty("webdriver.edge.driver", "F:\\Study\\eclipse-workspace\\Z_Browser Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver(options); //We are passing this to Edge Driver. So it can tell to the browser to how to behave.
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
        /* Above Code is for HTTPS Certification Handling */	
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();// it will delete all the cookies
		/* driver.manage().deleteCookieNamed("SessionKey"); */
		//Here we have to give a particular sessionKey so it will help to delete that specific Cookie not all.
		
		driver.get("https://www.google.com/");
		/* Above Code is for Maximizing window & Deleting cookies */
		
		
		
		
		
	     File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		/* to take the screenshot we have to cast the driver to "TakesSchoot" Object then we have to use the "getScreenshotAs"
		 * method to take the screenshot and also have to mention the output type as FILE format 
		 */
	     
	     FileUtils.copyFile(src, new File("C:\\Users\\karas\\Downloads\\Screenshot.png"));
	     /* "FileUtils" method we are using to copy the file from src to local machine
	      * then we are using copyFile to copy the file then mentioning "src" & path location to save
	      */
	     /* Above 2 lines of Code is for taking screenshot of a WebPage & saving that in Local Machine */
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	}

}
