package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class driverFactory {
	@SuppressWarnings("deprecation")
	public WebDriver DriverFactory() throws MalformedURLException {
		String currentDir = System.getProperty("user.dir");
		ReadJSON RJ = new ReadJSON();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", RJ.getJSONData("platformName"));
		caps.setCapability("appium:udid", RJ.getJSONData("deviceId"));
		// caps.setCapability("fullReset", props.getProperty("fullReset"));
		caps.setCapability("appium:automationName", RJ.getJSONData("AutomationName"));
		caps.setCapability("appium:appPackage", RJ.getJSONData("appPackage"));
		caps.setCapability("appium:appActivity", RJ.getJSONData("appActivity"));
		caps.setCapability("appium:app", currentDir + "\\src\\main\\resources" + RJ.getJSONData("appPath"));
		WebDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

}
