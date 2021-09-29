package testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.erpbuffalocart.qa.constants.Constants;

import pageobject.HomepageLoginpage;
import utility.Excelread;
import utility.UtilityClass;

public class Loginpage {
	public WebDriver driver;
	Excelread excelread = new Excelread();
	UtilityClass test = new UtilityClass();
	Properties prop=new Properties();
	HomepageLoginpage homeobjlogin;
	
	@Test(priority = 1, enabled = true, groups = { "smoke" })
	public void urlVerification() throws InterruptedException {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedUrl));
	}

	@Test(priority = 2, enabled = true)
	public void displayUsernamePassword() throws InterruptedException {

		Assert.assertTrue((homeobjlogin.username.isDisplayed() && homeobjlogin.password.isDisplayed()),
				"username and password are displayed");

	}

	@Test(priority = 3, enabled = true)
	public void loginVerificationcorrectvalues() throws IOException, InterruptedException {
		
		homeobjlogin.username.sendKeys(test.getPropValues());
		//homeobjlogin.username.sendKeys(excelread.readExcel("Details", 1, 0));
		homeobjlogin.password.sendKeys("123456");
		homeobjlogin.signin1.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedUrldash));
		homeobjlogin.demo.click();
		homeobjlogin.logout.click();

	}

	@Test(priority = 4, enabled = false)
	public void loginVerificationInvalidUsername() throws InterruptedException, IOException {

		homeobjlogin.username.sendKeys(excelread.readExcel("Details", 2, 0));
		homeobjlogin.password.sendKeys("123456");
		homeobjlogin.signin2.click();
		String icurrentUrl = driver.getCurrentUrl();
		System.out.println(icurrentUrl);
		Assert.assertFalse(icurrentUrl.contains(Constants.expectedUrldash));

	}

	@Test(priority = 5, enabled = false)
	public void loginVerificationInvalidPassword() throws IOException {

		homeobjlogin.username.sendKeys(excelread.readExcel("Details", 1, 0));
		homeobjlogin.password.sendKeys("1234567");
		homeobjlogin.signin2.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertFalse(currentUrl.contains(Constants.expectedUrldash));
	}

	@Test(priority = 6, enabled = false)
	public void loginVerificationInvalidUserPassword() throws IOException {

		homeobjlogin.username.sendKeys(excelread.readExcel("Details", 2, 0));
		homeobjlogin.password.sendKeys("1234567");
		homeobjlogin.signin2.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertFalse(currentUrl.contains(Constants.expectedUrldash));
	}

	@Test(priority = 7, enabled = false)
	public void loginVerificationwithblankfields() {

		homeobjlogin.username.sendKeys(" ");
		homeobjlogin.password.sendKeys(" ");
		homeobjlogin.signin2.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertFalse(currentUrl.contains(Constants.expectedUrldash));
	}

	@Test(priority = 8, enabled = false)
	public void forgotPasswordVerification() throws InterruptedException, IOException {

		homeobjlogin.forgotpassword.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.forgot_password));
		homeobjlogin.emailid.sendKeys(Constants.emailReset);
		homeobjlogin.submit.click();
		

	}

	@Test(priority = 9, enabled = false)
	public void rememberedPasswordVerification() {
		driver.navigate().to(Constants.forgot_password);
		homeobjlogin.rememberedPassword.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedUrl));

	}

	@Test(priority = 10, enabled = false)
	public void getyourAccountVerification() throws InterruptedException {

		homeobjlogin.geturAccount.click();
		homeobjlogin.companyName.sendKeys("UST");
		homeobjlogin.companyEmail.sendKeys("gaya3@gmail.com");
		homeobjlogin.userName.sendKeys("gaya3");
		homeobjlogin.passWord.sendKeys("gayathri3");
		homeobjlogin.confirmpassWord.sendKeys("gayathri3");
		homeobjlogin.signup.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedUrl));
	}

	@Test(priority = 11, enabled = false)
	public void signinRegisterVerification() throws InterruptedException {
		driver.navigate().to(Constants.expectedUrlregister);
		homeobjlogin.signin3.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedUrl));
	}

	@Test(priority = 12, enabled = false)
	public void loginVerificationrememberme() throws InterruptedException, IOException {

		homeobjlogin.username.sendKeys(excelread.readExcel("Details", 1, 0));
		homeobjlogin.password.sendKeys("123456");
		homeobjlogin.rememberme.click();
		homeobjlogin.signin2.click();
	}

	@Test(priority = 13, enabled = false)
	public void logoutVerification() throws InterruptedException {
		
		homeobjlogin.demo.click();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("homeobjlogin.logout")));
		//test.explicitWait("homeobjlogin.logout",20);
		homeobjlogin.logout.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedUrl));

	}
	 @AfterMethod
		public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
			if (iTestResult.getStatus() == iTestResult.FAILURE) {
				test.takeScreenShotOnFailure(iTestResult.getName());

			}
		}
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browser) {

		String address = Constants.expectedUrl;
		test.launchBrowser(address, browser);
		driver = test.getWebDriverInstance();
		homeobjlogin=new HomepageLoginpage(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	} 
	
}
