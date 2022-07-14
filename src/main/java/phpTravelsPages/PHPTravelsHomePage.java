package phpTravelsPages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PHPTravelsHomePage {
	WebDriver driver;
	protected WebDriverWait wait;
	protected Actions act;
	
	@FindBy(id = "cookie_stop")
	WebElement acceptCookies;
	
	@FindBy(xpath = "//a[@class='theme-btn theme-btn-small waves-effect']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//a[@class='theme-btn theme-btn-small theme-btn-transparent ml-1 waves-effect']")
	WebElement loginBtn;

	public PHPTravelsHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public PHPTravelsHomePage getULR() {
		String strUrl = driver.getCurrentUrl();
		assertEquals("https://www.phptravels.net/", strUrl);
		return this;
	}
	
	public PHPTravelsHomePage clickOnSignUpBtn() {
		wait.until(ExpectedConditions.visibilityOf(signUpBtn));
		signUpBtn.click();
		return this;
	}
	public PHPTravelsHomePage acceptCookies() {
		 acceptCookies.click();
		 return this;
	}
	public PHPTravelsHomePage clickOnLoginBtn() {
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		loginBtn.click();
		return this;
	}
}