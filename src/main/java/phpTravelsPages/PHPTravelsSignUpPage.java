package phpTravelsPages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PHPTravelsSignUpPage {
	WebDriver driver;
	protected WebDriverWait wait;
	protected Actions act;
	
	
	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(name = "phone")
	WebElement phoneNumber;

	@FindBy(name = "email")
	WebElement emailAddress;

	@FindBy(name = "password")
	WebElement signUpPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signUpBtn2;
	
	@FindBy(name = "email")
	WebElement loginEmail;

	@FindBy(name = "password")
	WebElement loginPassword;

	@FindBy(xpath = "//b[@role='presentation']")
	WebElement dropdown;

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[2]")
	WebElement dropdown2item;

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[3]")
	WebElement dropdown3item;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/label[1]")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
	WebElement loginSubmitBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement wrongCredentialsMessage;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/ul[1]/li[4]/a[1]")
	WebElement myProfile;

	@FindBy(name = "firstname")
	WebElement myProfileFirstNameText;

	@FindBy(name = "lastname")
	WebElement myProfileLastNameText;

	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/ul[1]/li[5]/a[1]")
	WebElement logoutBtn;

	public PHPTravelsSignUpPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	public PHPTravelsSignUpPage getULRSignUpPage() {
		String strUrlSignUpPage = driver.getCurrentUrl();
		assertEquals("https://www.phptravels.net/signup", strUrlSignUpPage);
		return this;
	}
	public PHPTravelsSignUpPage enterFirstName(String firstname) {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(firstname);
		return this;
	}

	public PHPTravelsSignUpPage enterLastName(String lastname) {
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(lastname);
		return this;
	}

	public PHPTravelsSignUpPage enterPhone(String phone) {
		wait.until(ExpectedConditions.visibilityOf(phoneNumber));
		phoneNumber.sendKeys(phone);
		return this;
	}

	public String enterEmailAddress(String randomEmail) {
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		emailAddress.sendKeys(randomEmail);
		return randomEmail;
		
	}

	public PHPTravelsSignUpPage enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(signUpPassword));
		signUpPassword.sendKeys(password);
		return this;
	}

	public PHPTravelsSignUpPage selectSecondTypeOfAccount() {
		dropdown.click();
		wait.until(ExpectedConditions.visibilityOf(dropdown2item));
		dropdown2item.click();
		return this;
	}

	public PHPTravelsSignUpPage selectThirdTypeOfAccount() {
		dropdown.click();
		wait.until(ExpectedConditions.visibilityOf(dropdown3item));
		dropdown3item.click();
		return this;
	}

	public PHPTravelsSignUpPage submitForm() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();",signUpBtn2);
		signUpBtn2.click();
		return this;
	}

	public PHPTravelsSignUpPage veryfyErrorMessageAllDataAreMissingSignUp() {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		String textOfMessage = firstName.getAttribute("validationMessage");
		assertEquals("Please fill out this field.", textOfMessage);
		return this;
	}
	public PHPTravelsSignUpPage veryfyErrorMessageLastNameIsMissing() {
		wait.until(ExpectedConditions.visibilityOf(lastName));
		String textOfMessage = lastName.getAttribute("validationMessage");
		assertEquals("Please fill out this field.", textOfMessage);
		return this;
	}
	public PHPTravelsSignUpPage veryfyErrorMessagePhoneIsMissing() {
		wait.until(ExpectedConditions.visibilityOf(phoneNumber));
		String textOfMessage = phoneNumber.getAttribute("validationMessage");
		assertEquals("Please fill out this field.", textOfMessage);
		return this;
	}
	public PHPTravelsSignUpPage veryfyErrorMessageEmailIsMissing() {
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		String textOfMessage = emailAddress.getAttribute("validationMessage");
		assertEquals("Please fill out this field.", textOfMessage);
		return this;
	}
	public PHPTravelsSignUpPage veryfyErrorMessagePasswordIsMissing() {
		wait.until(ExpectedConditions.visibilityOf(signUpPassword));
		String textOfMessage = signUpPassword.getAttribute("validationMessage");
		assertEquals("Please fill out this field.", textOfMessage);
		return this;
	}
	public PHPTravelsSignUpPage veryfyErrorMessageLoginEmailIsMissing() {
		wait.until(ExpectedConditions.visibilityOf(loginEmail));
		String textOfMessage = loginEmail.getAttribute("validationMessage");
		assertEquals("Please fill out this field.", textOfMessage);
		return this;
	}
	public PHPTravelsSignUpPage veryfyErrorMessageLoginPasswordIsMissing() {
		wait.until(ExpectedConditions.visibilityOf(loginPassword));
		String textOfMessage = loginPassword.getAttribute("validationMessage");
		assertEquals("Please fill out this field.", textOfMessage);
		return this;
	}
	
	public PHPTravelsSignUpPage veryfyErrorMessageWrongCredentials() {
		wait.until(ExpectedConditions.visibilityOf(wrongCredentialsMessage));
		String textOfMessage = wrongCredentialsMessage.getText();
		assertEquals( "Wrong credentials. try again!", textOfMessage);
		return this;
	}
	
	public PHPTravelsSignUpPage enterLoginEmail(String randomEmail) {
		wait.until(ExpectedConditions.visibilityOf(loginEmail));
		loginEmail.sendKeys(randomEmail);
		return this;
	}

	public PHPTravelsSignUpPage enterLoginPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(loginPassword));
		loginPassword.sendKeys(password);
		return this;
	}

	public PHPTravelsSignUpPage checkRememberMeBox() {
		wait.until(ExpectedConditions.visibilityOf(rememberMeCheckBox));
		act.moveToElement(rememberMeCheckBox).click().perform();
		return this;
	}

	public PHPTravelsSignUpPage submitLoginForm() {
		wait.until(ExpectedConditions.visibilityOf(loginSubmitBtn));
		loginSubmitBtn.click();
		return this;
	}

	public PHPTravelsSignUpPage clickOnMyProfile() {
		wait.until(ExpectedConditions.visibilityOf(myProfile));	
		myProfile.click();
		return this;
	}

	public PHPTravelsSignUpPage getULRMyProfile() {
		String strUrlSignUpPage = driver.getCurrentUrl();
		assertEquals("https://www.phptravels.net/account/profile", strUrlSignUpPage);
		return this;
	}

	public PHPTravelsSignUpPage getFirstName() {
		wait.until(ExpectedConditions.visibilityOf(myProfileFirstNameText));
		String userFirstName = myProfileFirstNameText.getAttribute("value");
		assertEquals("Stefan", userFirstName);
		return this;
	}

	public PHPTravelsSignUpPage getLastName() {
		wait.until(ExpectedConditions.visibilityOf(myProfileLastNameText));
		String userLastName = myProfileLastNameText.getAttribute("value");
		assertEquals("Tegeltija", userLastName);
		return this;
	}

	public PHPTravelsSignUpPage clickOnLogout() {
		wait.until(ExpectedConditions.visibilityOf(logoutBtn));
		logoutBtn.click();
		return this;
	}

	public PHPTravelsSignUpPage navigateToHomePage() {
		driver.navigate().to("https://www.phptravels.net/");
		return this;
	}
}