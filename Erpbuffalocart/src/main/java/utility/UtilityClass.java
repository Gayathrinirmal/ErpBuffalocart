package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erpbuffalocart.qa.constants.Constants;

public class UtilityClass {
	public WebDriver driver;
	public String Username;
	public String Password;

	
	public void launchBrowser(String address, String browser) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.get(address);
			driver.manage().window().maximize();
			this.implicitWait(20);
			break;
		case "FIREFOX":
			System.setProperty("webdriver.firefox.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(address);
			driver.manage().window().maximize();
			this.implicitWait(20);
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(address);
			driver.manage().window().maximize();
			this.implicitWait(20);
			break;
		default:
			break;
		}
	}

	public WebDriver getWebDriverInstance() {
		return driver;
	}

	public void click(WebElement value) {
		value.click();
	}

	public void sendKeys(By value, String message) {
		driver.findElement(value).sendKeys(message);
	}

	public boolean elementDisplayed(By value) {
		boolean value3 = driver.findElement(value).isDisplayed();
		return value3;
	}

	public boolean elementEnabled(By value) {
		boolean value1 = driver.findElement(value).isEnabled();
		return value1;
	}

	public boolean elementSelected(By value) {
		boolean value2 = driver.findElement(value).isSelected();
		return value2;

	}

	public String gettext(WebElement statusvalue) {
		String result = statusvalue.getText();
		return result;
	}

	public void actionmove(WebElement value) {

		Actions objaction = new Actions(driver);
		objaction.moveToElement(value).click().build().perform();
	}

	public void alertAccept() {
		Alert objectalert = driver.switchTo().alert();
		objectalert.accept();
	}

	public void alertDismiss() {
		Alert objectalert = driver.switchTo().alert();
		objectalert.dismiss();
	}

	public void alertSendkeys(String mymessage) {
		Alert objectalert = driver.switchTo().alert();
		objectalert.sendKeys(mymessage);
		objectalert.accept();
	}

	public void explicitWait(WebElement value, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(((By) value)));
	}

	public void explicitWaitalert() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public String getPropValues() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		this.Username = prop.getProperty("username");
		return Username;
	}

	public void robotFileUpload() throws AWTException {
		Robot rb = new Robot();
		StringSelection str = new StringSelection(Constants.filepathupload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public String takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = Constants.screenShot_path+name +dateName +".png";

		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public void scroll(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

	}

}
