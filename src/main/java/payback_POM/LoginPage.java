package payback_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

import utils.Helper;

public class LoginPage {

	boolean isPresent = false;
	Logger log;
	private AndroidDriver driver;
	private Helper H;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		this.H = new Helper(this.driver);
	}

	private By registration_Button = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button[2]");

	private By cookiesMessageAccept_Button = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Button[2]");

	private By paybackTradingCard_RadioButton = By.xpath(
			"//android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]");

	private By continue_Button = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.view.View/android.widget.Button");

	private By emailAddress_Field = By.xpath(
			"//android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText");

	private By agreed_Button = By.xpath("//android.widget.Button[@resource-id=\"mailSectionNextButton\"]");

	private By salutation_Button = By.xpath(
			"//android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[1]");

	private By firstName_Field = By.xpath(
			"//android.view.View[@resource-id='enrollmentData']/android.view.View[5]/android.view.View[1]//android.widget.EditText");

	private By lastName_Field = By.xpath(
			"//android.view.View[@resource-id='enrollmentData']/android.view.View[5]/android.view.View[2]//android.widget.EditText");

	private By address_Field = By
			.xpath("//android.view.View[@resource-id='enrollmentData']/android.view.View[6]//android.widget.EditText");

	private By pinCode_Field = By.xpath(
			"//android.view.View[@resource-id='enrollmentData']/android.view.View[7]/android.view.View[1]//android.widget.EditText");

	private By place_Field = By.xpath(
			"//android.view.View[@resource-id='enrollmentData']/android.view.View[7]/android.view.View[2]//android.widget.EditText");

	private By date_Field = By.xpath("//android.widget.EditText[@resource-id='dobDay']");

	private By month_Field = By.xpath("//android.widget.EditText[@resource-id='dobMonth']");

	private By year_Field = By.xpath("//android.widget.EditText[@resource-id='dobYear']");

	private By continueRegistration_Button = By
			.xpath("//android.widget.Button[@resource-id=\"personalDataSectionNextButton\"]");

	private By createPassword_Field = By.xpath(
			"//android.view.View[@resource-id='enrollmentData']/android.view.View[6]/android.view.View[2]//android.widget.EditText");

	private By continuePasswordCreation_Button = By
			.xpath("//android.widget.Button[@resource-id=\"passwordSectionNextButton\"]");

	private By continueAccountCreation_Button = By.xpath("//android.widget.Button[@text=\"Zustimmen und lospunkten\"]");

	public void clickOnCreateNewAccountButton() {
		H.waitFor(driver.findElement(registration_Button));
		driver.findElement(registration_Button).click();
	}

	public boolean verifyTheCookiesInformation() throws InterruptedException {
		H.waitFor(driver.findElement(cookiesMessageAccept_Button));
		return driver.findElement(cookiesMessageAccept_Button).isDisplayed();
	}

	public void acceptCookies() throws InterruptedException {
		H.waitFor(driver.findElement(cookiesMessageAccept_Button));
		driver.findElement(cookiesMessageAccept_Button).click();
	}

	public void choosePaybackNewTradingCard() throws InterruptedException {
		H.waitFor(driver.findElement(paybackTradingCard_RadioButton));
		driver.findElement(paybackTradingCard_RadioButton).click();
	}

	public void clickOnContinueButton() {
		H.waitFor(driver.findElement(continue_Button));
		driver.findElement(continue_Button).click();
	}

	public void provideEmailAddToGenerateNewAccount(String email) throws InterruptedException {
		H.waitFor(driver.findElement(emailAddress_Field));
		driver.findElement(emailAddress_Field).sendKeys(email);
	}

	public void clickOnAgreedButton() throws InterruptedException {
		H.swipe("DOWN");
		H.waitFor(driver.findElement(agreed_Button));
		driver.findElement(agreed_Button).click();
	}

	public void addDetails() throws InterruptedException {
		H.waitFor(driver.findElement(salutation_Button));
		driver.findElement(salutation_Button).click();
		driver.findElement(firstName_Field).sendKeys("Durgesh");
		driver.findElement(lastName_Field).sendKeys("Narvekar");
		driver.findElement(address_Field).sendKeys("10115 Berlin");
		driver.findElement(pinCode_Field).sendKeys("10115");
		driver.findElement(place_Field).sendKeys("Berlin");
		H.swipe("DOWN");
		driver.findElement(date_Field).sendKeys("13");
		driver.findElement(month_Field).sendKeys("4");
		driver.findElement(year_Field).sendKeys("1993");
		driver.findElement(continueRegistration_Button).click();
		Thread.sleep(2000);
		driver.findElement(continueRegistration_Button).click();
	}

	public void createPassword() {
		H.waitFor(driver.findElement(createPassword_Field));
		driver.findElement(createPassword_Field).sendKeys("Abc@2022");
	}

	public void clickOnContinuePasswordButton() {
		H.waitFor(driver.findElement(continuePasswordCreation_Button));
		driver.findElement(continuePasswordCreation_Button).click();
	}

	public void clickOnAccountCreationButton() {
		H.waitFor(driver.findElement(continueAccountCreation_Button));
		driver.findElement(continueAccountCreation_Button).click();
	}

}
