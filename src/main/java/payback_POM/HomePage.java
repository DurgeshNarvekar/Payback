package payback_POM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import utils.Helper;

public class HomePage {

	boolean isPresent = false;
	Logger log;
	private AndroidDriver driver;
	private Helper H;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		H = new Helper(driver);
	}

	private By ToolBar = By
			.xpath("//android.view.ViewGroup[@resource-id='de.payback.client.android:id/toolbar_native']");

	private By Coupon_Menu = By
			.xpath("//android.widget.FrameLayout[@resource-id='de.payback.client.android:id/coupon_nav_graph']");

	private By Coupon_Name = By.xpath(
			"//androidx.recyclerview.widget.RecyclerView[@resource-id='de.payback.client.android:id/list']/android.widget.FrameLayout[2]//android.widget.TextView[@resource-id='de.payback.client.android:id/incentivation']");

	private By activateNow_Button = By.xpath(
			"//androidx.recyclerview.widget.RecyclerView[@resource-id='de.payback.client.android:id/list']/android.widget.FrameLayout[2]//android.widget.Button[@resource-id='de.payback.client.android:id/golden_button']");

	private By activated_Tab = By.xpath("//android.widget.LinearLayout[contains(@content-desc,'Aktiviert')]");

	private By Activate_icon = By.xpath(
			"//androidx.recyclerview.widget.RecyclerView[@resource-id='de.payback.client.android:id/list']/android.widget.FrameLayout[2]//android.widget.ImageView[@resource-id='de.payback.client.android:id/activated_icon']");

	private By MoreInfo_Button = By.xpath(
			"//androidx.recyclerview.widget.RecyclerView[@resource-id='de.payback.client.android:id/list']/android.widget.FrameLayout[2]//android.widget.Button[@resource-id='de.payback.client.android:id/redeem_online_button']");

	public void isHomePageLoaded() {
		H.waitFor(driver.findElement(ToolBar));
		assertTrue(driver.findElement(ToolBar).isDisplayed());
	}

	public void homepageView() throws InterruptedException {
		Thread.sleep(10000);
		driver.navigate().back();
	}

	public void ClickOnCoupunMenu() {
		H.waitFor(driver.findElement(Coupon_Menu));
		driver.findElement(Coupon_Menu).click();

	}

	public String getCouponName() {
		H.waitFor(driver.findElement(Coupon_Name));
		return driver.findElement(Coupon_Name).getText();
	}

	public void clickOnActivateButton() {
		H.waitFor(driver.findElement(activateNow_Button));
		driver.findElement(activateNow_Button).click();

	}

	public void clickOnActivateTab() {
		H.waitFor(driver.findElement(activated_Tab));
		driver.findElement(activated_Tab).click();
	}

	public void validateActivateCoupun(String CouponName, String MoreInfo) {
		H.waitFor(driver.findElement(Coupon_Name));
		assertEquals(driver.findElement(Coupon_Name).getText(), CouponName);
		assertTrue(driver.findElement(Activate_icon).isDisplayed());
		assertEquals(driver.findElement(MoreInfo_Button).getText(), MoreInfo);

	}
}
