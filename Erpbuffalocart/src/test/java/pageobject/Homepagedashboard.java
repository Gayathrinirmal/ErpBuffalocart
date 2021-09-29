package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepagedashboard {
	WebDriver driver;

	public Homepagedashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@class='dropdown dropdown-list notifications']/a/em")
	public WebElement bellIcon;

	@FindBy(xpath = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span")
	public WebElement calendar;

	@FindBy(xpath = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[3]/a/span")
	public WebElement mailboxbutton;

	@FindBy(xpath = "//div[@class='col-md-12']/form/div/div[1]/div/a[2]")
	public WebElement compose;

	@FindBy(xpath = "//*[@id='form']/div/div/div[2]/button")
	public WebElement discard;

	@FindBy(xpath = "//div[@class='aside-inner']/nav/ul[2]/li[9]/a/span")
	public WebElement stockButton;

	@FindBy(xpath = "//*[@id='stock']/li[2]/a/span")
	public WebElement items;

	@FindBy(xpath = "//*[@id='s-menu']")
	public WebElement searchbox;

	@FindBy(xpath = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[4]/a/span")
	public WebElement filemanager;

	@FindBy(xpath = "//*[@id='elfinder']/div[1]/div[3]/div[3]/span[1]")
	public WebElement fileUpload;

	@FindBy(xpath = "//*[@id='elfinder']/div[12]/div[2]/div/div[3]")
	public WebElement selectfile;

	@FindBy(xpath = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[5]/a/span")
	public WebElement project;

	@FindBy(xpath = "//*[@id='table_0']/td[6]/div/button")
	public WebElement changeStatus;

	@FindBy(xpath = "//*[@id='table_0']/td[6]/div/ul/li[4]/a")
	public WebElement onhold;

	@FindBy(xpath = "//*[@id='table_0']/td[6]/span")
	public WebElement statusvalue;

	@FindBy(xpath = "//*[@id='table_0']/td[1]/div/label/span")
	public WebElement checkboxproject;

	@FindBy(xpath = "//div[@class='panel-body']/form/button[1]")
	public WebElement signinhere;

	@FindBy(name = "user_name")
	public WebElement username;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "/html/body/div[1]/section/div/div[1]/div/a")
	public WebElement clockin;

	@FindBy(xpath = "//div[@class='nav-wrapper']/ul[2]/li[3]/a/span")
	public WebElement demo;

	@FindBy(xpath = "//div[@class='nav-wrapper']/ul[2]/li[4]/a/em")
	public WebElement calculator;

	@FindBy(xpath = "//*[@id='idCalculadorabtns']/div[2]/input")
	public WebElement number8;

	@FindBy(xpath = "//*[@id=\\\"idCalculadorabtns\\\"]/div[4]/input")
	public WebElement plus;

	@FindBy(xpath = "//*[@id='idCalculadorabtns']/div[10]/input")
	public WebElement number2;

	@FindBy(xpath = "//*[@id='idCalculadorabtns']/div[15]/input")
	public WebElement equalto;

	@FindBy(xpath = "//*[@id='idCalculadoratxtResultado']")
	public WebElement display;

	@FindBy(xpath = "//*[@id='idCalculadoraBorrar']")
	public WebElement clear;

	@FindBy(xpath = "//*[@id='user-block']/div/div[1]/div/img")
	public WebElement demoactivity;

	@FindBy(xpath = "//div[@class='row mt-lg']/div[1]/ul/li[2]/a")
	public WebElement bankdetails;

	@FindBy(xpath = "//*[@id='2']/div/div[1]/div[1]/div/div[2]/div/small/a")
	public WebElement invoicemoreInfo;
	
	@FindBy(xpath = "//*[@id='quick_state']/i")
	public WebElement quickStatus;

	@FindBy(xpath = "//ul[@class='dropdown-menu animated zoomIn']/li[2]/div[2]/a")
	public WebElement myDetails;
	
	@FindBy(xpath = "//div[@class='cover-photo bg-cover']/div/div[2]/p[2]")
	public WebElement tagnamedesignation;

	@FindBy(xpath = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[7]/a/span")
	public WebElement bugs;
	
	@FindBy(xpath = "//*[@id='unconfirmed']")
	public WebElement unconfirmed;
	
	@FindBy(xpath = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[28]/a/span")
	public WebElement settings;
	
	@FindBy(xpath = "/html/body/div[1]/section/div/div[2]/div/div/div/div/ul/li[7]/a")
	public WebElement customField;

}
