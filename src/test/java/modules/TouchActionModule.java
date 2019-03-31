package modules;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import locators.TouchActionPageElements;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;

import org.testng.Assert;

import setup.Base;

/*
 * The TouchActionModule class is to implement business logic related to touch action gesture page of the app
 */
public class TouchActionModule extends Base {

	TouchActionPageElements tapm = new TouchActionPageElements();

	public void validateTouchActions(String action1) throws Exception {
		TouchAction touch = new TouchAction(driver);

		if (action1.equalsIgnoreCase("tap")) {
			touch.tap(element(tapm.touchActionEventMsg(driver))).perform();
			Assert.assertEquals(tapm.touchActionEventMsg(driver).getText(), "SINGLE TAP CONFIRMED");
			log.info("Single Tap done");
			driver.navigate().back();

		} else if (action1.equalsIgnoreCase("long press")) {

			touch.longPress(ElementOption.element(tapm.touchActionEventMsg(driver))).perform();
			Assert.assertEquals(tapm.touchActionEventMsg(driver).getText(), "LONG PRESS");
			log.info("Long press done");
			driver.navigate().back();
		}
	}

}
