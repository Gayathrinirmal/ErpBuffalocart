package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.erpbuffalocart.qa.constants.Constants;

import pageobject.Homepagedashboard;
import utility.Excelread;
import utility.UtilityClass;

public class Dashboard {
	public WebDriver driver;
	Excelread excelread = new Excelread();
	UtilityClass test = new UtilityClass();
	Homepagedashboard homeobjdash;

	@Test(priority = 14, enabled = true)
	public void notoificationBelliconVerification() throws InterruptedException, IOException {
		
		homeobjdash.username.sendKeys(excelread.readExcel("Details", 1, 0));
		homeobjdash.password.sendKeys("123456");
		homeobjdash.signinhere.click();
		Assert.assertTrue(homeobjdash.bellIcon.isDisplayed());

	}

	@Test(priority = 15, enabled = false)
	public void calendarPageVerification() throws IOException {
		homeobjdash.calendar.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedurlCalendar));
	}

	@Test(priority = 16, enabled = false)
	public void mailboxPageVerification() {
		driver.navigate().to(Constants.expectedUrldash);
		homeobjdash.mailboxbutton.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedurlmailbox));

	}

	@Test(priority = 17, enabled = false)
	public void mailboxFunctionsVerification() throws InterruptedException, AWTException {

		homeobjdash.compose.click();
		Assert.assertTrue(homeobjdash.compose.isDisplayed());
		homeobjdash.discard.click();
		test.explicitWaitalert();
		test.alertAccept();
	}

	@Test(priority = 18, enabled = true)
	public void stockButtonVerification() {
		driver.navigate().to(Constants.expectedUrldash);

		homeobjdash.stockButton.click();
		homeobjdash.items.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(Constants.expectedurlItemlist));

	}

	@Test(priority = 19, enabled = false)
	public void searchboxMenuVerification() throws InterruptedException, IOException {
		driver.navigate().to(Constants.expectedUrldash);

		homeobjdash.searchbox.click();
		Assert.assertTrue(homeobjdash.searchbox.isDisplayed());
		homeobjdash.searchbox.sendKeys(Constants.tasks);
		test.implicitWait(30);

	}

	@Test(priority = 20, enabled = false)
	public void fileUploadVerification() throws InterruptedException, IOException, AWTException {
		driver.navigate().to(Constants.expectedUrldash);
		homeobjdash.filemanager.click();
		test.implicitWait(50);
		test.explicitWait(homeobjdash.fileUpload, 30);
		homeobjdash.fileUpload.click();
		homeobjdash.selectfile.click();
		test.robotFileUpload();

	}

	@Test(priority = 21, enabled = false)
	public void iframeCountVerification() {
		driver.navigate().to(Constants.expectedurlcompose);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int iframecount = frames.size();
		System.out.println("count of iframes" + iframecount);
		Assert.assertTrue(iframecount == 1);
	}

	@Test(priority = 22, enabled = false)
	public void projectStatuschangeVerification() {
		driver.navigate().to(Constants.expectedUrldash);
		homeobjdash.project.click();
		test.implicitWait(30);
		homeobjdash.changeStatus.click();
		homeobjdash.onhold.click();
		String valuefromApplication = homeobjdash.statusvalue.getText();
		Assert.assertTrue(valuefromApplication.contains("On Hold"));

	}

	@Test(priority = 23, enabled = false)
	public void checkboxprojectVerification() throws InterruptedException {
		driver.navigate().to(Constants.expectedurlprojects);
		test.implicitWait(30);
		homeobjdash.checkboxproject.click();
		Assert.assertTrue(homeobjdash.checkboxproject.isEnabled());
	}

	@Test(priority = 24, enabled = false)
	public void calculatorVerification() throws InterruptedException {
		driver.navigate().to(Constants.expectedUrldash);

		homeobjdash.calculator.click();
		homeobjdash.number8.click();
		homeobjdash.plus.click();
		homeobjdash.number2.click();
		homeobjdash.equalto.click();
		int valuefromApllication = Integer.parseInt(homeobjdash.display.getText());
		System.out.println("valuefromApllication" + valuefromApllication + "...");
		Assert.assertTrue(valuefromApllication == Constants.calcuvalue);

	}

	@Test(priority = 25, enabled = false)
	public void calculatorClearVerification() throws InterruptedException {

		homeobjdash.clear.click();

		int valuefromApllication = Integer.parseInt(homeobjdash.display.getText());
		System.out.println("valuefromApllication" + valuefromApllication + "...");
		Assert.assertTrue(valuefromApllication == 0);

	}

	@Test(priority = 26, enabled = false)
	public void activitiesVerification() throws InterruptedException {
		driver.navigate().to(Constants.expectedUrldash);

		homeobjdash.demoactivity.click();

		Assert.assertTrue(homeobjdash.bankdetails.isDisplayed());
	}

	@Test(priority = 27, enabled = false)
	public void invoicemoreInfoVerification() {
		driver.navigate().to(Constants.expectedUrldash);

		homeobjdash.invoicemoreInfo.click();

		Assert.assertTrue(homeobjdash.quickStatus.isDisplayed());

	}

	@Test(priority = 28, enabled = false)
	public void ScrolldowndashVerification() throws InterruptedException {
		driver.navigate().to(Constants.expectedUrldash);

		homeobjdash.demo.click();

		homeobjdash.myDetails.click();

		String value = homeobjdash.tagnamedesignation.getText();
		Assert.assertTrue(value.contains("Undefined Department & Designation"));

	}

	@Test(priority = 29, enabled = false)
	public void bugButtonVerification() throws InterruptedException {
		driver.navigate().to(Constants.expectedUrldash);

		homeobjdash.bugs.click();

		String valueunconfirmed = homeobjdash.unconfirmed.getText();
		Assert.assertTrue(valueunconfirmed.contains("Unconfirmed"));
	}

	@Test(priority = 30, enabled = false)
	public void Verification() throws InterruptedException {
		driver.navigate().to(Constants.expectedUrldash);
		test.scroll(0, 1200);

		homeobjdash.settings.click();

		Assert.assertTrue(homeobjdash.customField.isDisplayed());
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
		homeobjdash = new Homepagedashboard(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
