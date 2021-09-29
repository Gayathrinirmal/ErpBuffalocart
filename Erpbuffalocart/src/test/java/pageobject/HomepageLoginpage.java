package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageLoginpage {
	WebDriver driver;

	public HomepageLoginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(name = "user_name")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath = "//div[@class='nav-wrapper']/ul[2]/li[3]/a/span")
	public WebElement demo;
	
	@FindBy(xpath = "//form[@class='form-horizontal']/div/button")
	public WebElement logout;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/form/button[1]")
	public WebElement signin2;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[2]/form/div[3]/div[2]/a")
	public WebElement forgotpassword;
	
	@FindBy(name = "email_or_username")
	public WebElement emailid;
	
	@FindBy(xpath = "//div[@class='col-xs-4']/button")
	public WebElement submit;
	
	@FindBy(xpath = "//div[@class='col-xs-8']/label/a")
	public WebElement rememberedPassword;
	
	@FindBy(xpath = "//div[@class='panel panel-dark panel-flat left-login-panel']/div[2]/a")
	public WebElement geturAccount;
	
	@FindBy(xpath = "//div[@class='form-group has-feedback']/input")
	public WebElement companyName;
	
	@FindBy(xpath = "//div[@class='panel-body']/form/div[2]/input")
	public WebElement companyEmail;

	@FindBy(xpath = "//div[@class='panel-body']/form/div[4]/input")
	public WebElement userName;
	
	@FindBy(id = "password")
	public WebElement passWord;
	
	@FindBy(id = "password")
	public WebElement confirmpassWord;
	
	@FindBy(xpath = "//div[@class='panel-body']/a")
	public WebElement signup;
	
	@FindBy(xpath = "//div[@class='panel-body']/a")
	public WebElement signin3;
	
	@FindBy(xpath = "//div[@class='checkbox c-checkbox pull-left mt0']/label/span")
	public WebElement rememberme;
	
	@FindBy(xpath = "//div[@class='panel-body']/form/button[1]")
	public WebElement signin1;
}













