package PaybackTest.definations;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import payback_POM.HomePage;
import payback_POM.LoginPage;
import utils.ReadJSON;
import utils.driverFactory;

public class Definations {

	private AndroidDriver driver;
	private ReadJSON RJ;
	private LoginPage LP;
	private HomePage HP;
	private driverFactory df;
	private static String CoupanName;
	private ExtentReports EX;
	private ExtentTest test;

	String currentDir = System.getProperty("user.dir");

	@Before
	public void setup() {
		System.out.println("Executed 1st");
		RJ = new ReadJSON();
		EX = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Spark1.html");
		EX.attachReporter(spark);
		test = EX.createTest("Activate Coupoun Test");
	}

	@Given("Initialise Payback Application")
	public void Initialise_AppLication() throws InterruptedException, MalformedURLException, ClassNotFoundException {
		ExtentTest node = test.createNode(new GherkinKeyword("Given"), "Initialize Payback Application",
				"Perform test setup and APP Launch.");
		node.log(Status.INFO, "Applocation initialization started.");
		try {
			driverFactory df = new driverFactory();
			driver = (AndroidDriver) df.DriverFactory();
			LP = new LoginPage(driver);
			HP = new HomePage(driver);
			node.log(Status.PASS, "Payback Application Sucessfull.");
		} catch (Exception e) {
			node.log(Status.FAIL, e.toString());
		}
	}

	@And("Payback Application is Launched")
	public void validateAPPStatus() throws ClassNotFoundException {
		ExtentTest node = test.createNode(new GherkinKeyword("And"), "Payback Application is Launched",
				"Validate is Application is launched or Not.");
		node.log(Status.INFO, "Validation for Application is started.");
		try {

			ApplicationState state = driver.queryAppState(RJ.getJSONData("appPackage"));
			System.out.println(state);
			assertEquals(state.toString(), "RUNNING_IN_FOREGROUND");
			node.log(Status.PASS, "Application Is Running.");
		} catch (Exception e) {

			node.log(Status.FAIL, e.toString());
			driver.close();

		}
	}

	@And("Start Registration Proccess")
	public void RegisterUser() throws InterruptedException, ClassNotFoundException {
		ExtentTest node = test.createNode(new GherkinKeyword("And"), "Start Registration Proccess",
				"Enter User details for account creation.");
		node.log(Status.INFO, "User Registration process is started.");
		try {
			LP.clickOnCreateNewAccountButton();
			node.log(Status.INFO, "Register Button.");
			LP.acceptCookies();
			node.log(Status.INFO, "Accepted Cookies.");
			LP.choosePaybackNewTradingCard();
			node.log(Status.INFO, "Selected Trading Card.");
			LP.clickOnContinueButton();
			node.log(Status.INFO, "Clicked on Continue Button.");
			Date d = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("hhmmss");
			String strDate = formatter.format(d);
			LP.provideEmailAddToGenerateNewAccount("durgesh." + strDate + "@yahoo.com");
			node.log(Status.INFO, "Entered Email Address.");
			LP.clickOnAgreedButton();
			node.log(Status.INFO, "Clicked on Continue Button.");
			LP.addDetails();
			node.log(Status.INFO, "Entered User details and clicked on continue button.");
			LP.createPassword();
			node.log(Status.INFO, "Entered Password.");
			LP.clickOnContinuePasswordButton();
			node.log(Status.INFO, "Clicked in continue button.");
			LP.clickOnAccountCreationButton();
			node.log(Status.INFO, "Clicked in Create account button.");
			node.log(Status.INFO, "User Registration process Completed.");
		} catch (Exception e) {

			node.log(Status.FAIL, e.toString());
			driver.close();

		}
	}

	@When("Validate if user is registered successfully")
	public void validateIfRegistarionSucessfull() throws ClassNotFoundException {
		ExtentTest node = test.createNode(new GherkinKeyword("When"), "Validate if user is registered successfully",
				"Validate whether user is registered sucessfully or not.");
		node.log(Status.INFO, "Validation started.");
		try {

			HP.homepageView();
			HP.isHomePageLoaded();
			node.log(Status.PASS, "User is Registered sucessfully.");
		} catch (Exception e) {

			node.log(Status.FAIL, e.toString());
			driver.close();
		}
	}

	@Then("Activate Coupon")
	public void activateCoupon() throws ClassNotFoundException {
		ExtentTest node = test.createNode(new GherkinKeyword("Then"), "Activate Coupon",
				"Activate Coupon from Coupon menu.");
		node.log(Status.INFO, "Activate Coupan Started.");
		try {
			HP.ClickOnCoupunMenu();
			node.log(Status.INFO, "Clicked on Coupon Menu");
			CoupanName = HP.getCouponName();
			node.log(Status.INFO, "Saved Coupon name for futher Validation.");
			HP.clickOnActivateButton();
			node.log(Status.INFO, "Clicked on Activate Coupon Button.");
			node.log(Status.PASS, "Activate Coupon Ended.");
		} catch (Exception e) {

			node.log(Status.FAIL, e.toString());
			driver.close();
		}
	}

	@And("Validate coupon is activated")
	public void validateIfCouponIsActivated() throws ClassNotFoundException {
		ExtentTest node = test.createNode(new GherkinKeyword("And"), "Validate activated Coupon",
				"Validated Active coupon is present in Activated Tab or Not.");
		node.log(Status.INFO, "Validation for Active coupan started.");
		try {
			HP.clickOnActivateTab();
			node.log(Status.INFO, "Clicked on Activated Tab.");
			HP.validateActivateCoupun(CoupanName, "MEHR INFOS");
			node.log(Status.PASS, "Validation for Activated coupon successfull. ");
		} catch (Exception e) {

			node.log(Status.FAIL, e.toString());
			driver.close();
		}
	}

	@After
	public void TearDown() {
		System.out.println("last Executed");
		driver.quit();
		EX.flush();

	}
}
