package phpTravelsSetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import phpTravelsPages.PHPTravelsHomePage;
import phpTravelsPages.PHPTravelsSignUpPage;

public class PHPTravelsSetup {
	RemoteWebDriver driver;
	PHPTravelsHomePage objPHPTravelsHomePage;
	PHPTravelsSignUpPage objPHPTravelsSignUpPage;
	ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
	String r = RandomStringUtils.randomAlphabetic(10);

	@BeforeTest
	public void setup() {
		//Line of code below I'm using to keep driver up to date (there is a script (io.github.bonigarcia) in pom.xml which one I'm using for it)
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		/*Selenium Grid > Za ovo ne znam ni sam da li ce raditi kako treba na Vasem laptopu, 
		ako ne bude obrisite ovaj blok koda, a kod sa linija 34 i 35
		odkomentarisite kako bi sve nadam se radilo
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName("chrome");
		desiredCapabilities.setBrowserName("firefox");   
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.phptravels.net/");
	}

	@Test(priority = 1)
	public void navigate_to_homepage_click_on_signUp_positive_case1() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.acceptCookies()
		.clickOnSignUpBtn();
		
	}

	@Test(priority = 2)
	public void enter_userDetails_positive_case1() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterLastName(configProperties.lastname())
		.enterPhone(configProperties.phone());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "3" + "@gmail.com");
		objPHPTravelsSignUpPage.enterPassword(configProperties.password())
		.submitForm()
		.enterLoginEmail(randomEmail)
		.enterLoginPassword(configProperties.password())
		.checkRememberMeBox()
		.submitLoginForm()
		.clickOnMyProfile()
		.getULRMyProfile()
		.getFirstName()
		.getLastName()
		.clickOnLogout()
		.navigateToHomePage();
	}

	@Test(priority = 3)
	public void navigate_to_homepage_click_on_signUp_positive_case2() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
	
	}

	@Test(priority = 4)
	public void enter_userDetails_positive_case2() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterLastName(configProperties.lastname())
		.enterPhone(configProperties.phone());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "@gmail.com");
		objPHPTravelsSignUpPage.enterPassword(configProperties.password())
		.submitForm()
		.enterLoginEmail(randomEmail)
		.enterLoginPassword(configProperties.password())
		.submitLoginForm()
		.clickOnMyProfile()
		.getULRMyProfile()
		.getFirstName()
		.getLastName()
		.clickOnLogout()
		.navigateToHomePage();
	}

	@Test(priority = 5)
	public void navigate_to_homepage_click_on_signUp_positive_case3() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}

	@Test(priority = 6)
	public void enter_userDetails_positive_case3() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterLastName(configProperties.lastname())
		.enterPhone(configProperties.phone());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "1" + "@gmail.com");
		objPHPTravelsSignUpPage.enterPassword(configProperties.password())
		.selectSecondTypeOfAccount()
		.submitForm()
		.enterLoginEmail(randomEmail)
		.enterLoginPassword(configProperties.password())
		.submitLoginForm()
		.clickOnMyProfile()
		.getULRMyProfile()
		.getFirstName()
		.getLastName()
		.clickOnLogout()
		.navigateToHomePage();
	}

	@Test(priority = 7)
	public void navigate_to_homepage_click_on_signUp_positive_case4() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}

	@Test(priority = 8)
	public void enter_userDetails_positive_case4() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterLastName(configProperties.lastname())
		.enterPhone(configProperties.phone());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "2" + "@gmail.com");
		objPHPTravelsSignUpPage.enterPassword(configProperties.password())
		.selectThirdTypeOfAccount()
		.submitForm()
		.enterLoginEmail(randomEmail)
		.enterLoginPassword(configProperties.password())
		.submitLoginForm()
		.clickOnMyProfile()
		.getULRMyProfile()
		.getFirstName()
		.getLastName()
		.clickOnLogout()
		.navigateToHomePage();
	}

	@Test(priority = 9)
	public void navigate_to_homepage_click_on_veryfyErrorMessageAllDataAreMissingSignUp() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}

	@Test(priority = 10)
	public void enter_userDetails_veryfyErrorMessageAllDataAreMissingSignUp() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.submitForm()
		.veryfyErrorMessageAllDataAreMissingSignUp()
		.navigateToHomePage();
	}
	
	@Test(priority=11)
	public void navigate_to_homepage_click_on_emptyFirstNameField() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}
	
	@Test(priority=12)
	public void enter_userDetails_emptyFirstNameField() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterLastName(configProperties.lastname())
		.enterPhone(configProperties.phone());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "4" + "@gmail.com");
		objPHPTravelsSignUpPage.enterPassword(configProperties.password())
		.submitForm()
		.veryfyErrorMessageAllDataAreMissingSignUp()
		.navigateToHomePage();
	}
	@Test(priority=13)
	public void navigate_to_homepage_click_on_emptyLastNameField() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}
	@Test(priority=14)
	public void enter_userDetails_emptyLastNameField() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterPhone(configProperties.phone());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "3" + "@gmail.com");
		objPHPTravelsSignUpPage.enterPassword(configProperties.password())
		.submitForm()
		.veryfyErrorMessageLastNameIsMissing()
		.navigateToHomePage();
	}
	@Test(priority=15)
	public void navigate_to_homepage_click_on_emptyPhoneField() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}
	@Test(priority=16)
	public void enter_userDetails_emptyPhoneField() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterLastName(configProperties.lastname());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "3" + "@gmail.com");
		objPHPTravelsSignUpPage.enterPassword(configProperties.password())
		.submitForm()
		.veryfyErrorMessagePhoneIsMissing()
		.navigateToHomePage();
	}
	
	@Test(priority=17)
	public void navigate_to_homepage_click_on_emptyEmailField() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}
	@Test(priority=18)
	public void enter_userDetails_emptyEmailField() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterLastName(configProperties.lastname())
		.enterPhone(configProperties.phone())
		.enterPassword(configProperties.password())
		.submitForm()
		.veryfyErrorMessageEmailIsMissing()
		.navigateToHomePage();
	}
	
	@Test(priority=19)
	public void navigate_to_homepage_click_on_emptyPasswordField() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnSignUpBtn();
		
	}
	@Test(priority=20)
	public void enter_userDetails_emptyPasswordField() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.getULRSignUpPage()
		.enterFirstName(configProperties.firstname())
		.enterLastName(configProperties.lastname());
		String randomEmail = objPHPTravelsSignUpPage.enterEmailAddress("tvojEmail" + r + "3" + "@gmail.com");
		objPHPTravelsSignUpPage.enterPhone(configProperties.phone())
		.submitForm()
		.veryfyErrorMessagePasswordIsMissing()
		.navigateToHomePage();
	}
	
	@Test(priority = 21)
	public void navigate_to_homepage_click_on_emptyLoginForm() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnLoginBtn();
		
	}

	@Test(priority = 22)
	public void enter_userDetails__emptyLoginForm() {
		objPHPTravelsSignUpPage.submitLoginForm()
		//Here I have a method for verifying email because if both data are missing, an error message is occurring only in field email.
		.veryfyErrorMessageLoginEmailIsMissing()
		.navigateToHomePage();
	}

	@Test(priority = 23)
	public void navigate_to_homepage_click_on_emptyEmailFieldOnLoginPage() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnLoginBtn();
		
	}

	@Test(priority = 24)
	public void enter_userDetails__emptyEmailFieldOnLoginPage() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.enterLoginPassword(configProperties.password())
		.submitLoginForm()
		.veryfyErrorMessageLoginEmailIsMissing()
		.navigateToHomePage();
	}
	
	@Test(priority = 25)
	public void navigate_to_homepage_click_on_emptyPasswordFieldOnLoginPage() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnLoginBtn();
		
	}

	@Test(priority = 26)
	public void enter_userDetails__emptyPasswordFieldOnLoginPage() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.enterLoginEmail("tvojEmail" + r + "4" + "@gmail.com")
		.submitLoginForm()
		.veryfyErrorMessageLoginPasswordIsMissing()
		.navigateToHomePage();
	}	
	
	@Test(priority = 27)
	public void navigate_to_homepage_click_on_loginWrongCredentials() {
		objPHPTravelsHomePage = new PHPTravelsHomePage(driver);
		objPHPTravelsHomePage.getULR()
		.clickOnLoginBtn();

	}

	@Test(priority = 28)
	public void enter_userDetails__loginWrongCredentials() {
		objPHPTravelsSignUpPage = new PHPTravelsSignUpPage(driver);
		objPHPTravelsSignUpPage.enterLoginEmail("stefantegeltija1992@gmail.com")
		.enterLoginPassword(configProperties.password())
		.submitLoginForm()
		.veryfyErrorMessageWrongCredentials()
		.navigateToHomePage();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}