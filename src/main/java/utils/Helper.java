package utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class Helper {
	private AndroidDriver driver;
	JavascriptExecutor je;

	public Helper(AndroidDriver driver) {
		this.driver = driver;
		je = (JavascriptExecutor) driver;
	}

	public WebElement waitFor(WebElement el) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement a = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return el;
			}
		});
		return a;
	}

	public void swipe(String direction) {
		int endY = 0;
		Dimension size = driver.manage().window().getSize();

		switch (direction) {
		case "LEFT":
			int startY = (int) (size.height / 4);
			int startX = (int) (size.width * 0.05);
			int endX = (int) (size.width * 0.90);
			new TouchAction(driver).press(PointOption.point(startX, startY))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endX, startY))
					.release().perform();
			break;
		case "RIGHT":
			startY = (int) (size.height / 4);
			startX = (int) (size.width * 0.90);
			endX = (int) (size.width * 0.05);
			new TouchAction(driver).press(PointOption.point(startX, startY))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endX, startY))
					.release().perform();
			break;
		case "UP":
			endY = (int) (size.height * 0.70);
			startY = (int) (size.height * 0.30);
			startX = (int) (size.width / 2);
			new TouchAction(driver).press(PointOption.point(startX, startY))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startX, endY))
					.release().perform();

			break;
		case "DOWN":
			startY = (int) (size.height * 0.70);
			endY = (int) (size.height * 0.30);
			startX = (size.width / 2);
			new TouchAction(driver).press(PointOption.point(startX, startY))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startX, endY))
					.release().perform();

			break;
		}
	}
}
