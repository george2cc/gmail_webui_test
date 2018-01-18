package selenium.automation.kenho;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignInTest {
	WebDriver driver = new FirefoxDriver();

	@Test
	public void gmailLoginShouldBeSuccessful() {

		
		// step1 go to gmail website
		driver.get("http://gmail.com");
		System.out.println("at signin page");
		//2. fill in username and click next
		WebElement usernameText = driver.findElement(By.id("identifierId"));
		usernameText.clear();
		usernameText.sendKeys("romancegm@gmail.com");
		WebElement nextButton = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
		nextButton.click();
		//3. fill in password
		System.out.println("at password page");
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		WebElement passwordnameText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		passwordnameText.sendKeys("jovanka99");
		nextButton = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
		nextButton.click();
		//4. verify user did sign in
		WebDriverWait waitInbox = new WebDriverWait(driver, 30); 
		waitInbox.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Inbox")));
		Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("Inbox")).size() > 0 );
		
		//5. click sign
		WebElement profileButton = driver.findElement(By.xpath(".//span[@class='gb_ab gbii']"));
		profileButton.click();
		
		//6. Click signout linkage
		WebElement signOutLinkage = driver.findElement(By.id("gb_71"));
		signOutLinkage.click();
		
		//7. verify user did signed out.
		System.out.println("user did signed out.");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("profileIdentifier")));
		Assert.assertTrue("Signin button should exist",driver.findElements(By.id("profileIdentifier")).size() > 0 );
	}
		//
		@After
		public void tearDown() {
			driver.quit();
		}

}
