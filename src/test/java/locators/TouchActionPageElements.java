package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;
import pageobjects.TouchActionPage;
import utils.CommonUtils;

/*
 * The TouchActionPageElements class is to hold the locator strategy of webelements for touch action page 
 */

public class TouchActionPageElements implements TouchActionPage {

	public WebElement touchActionEventMsg(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.id("io.selendroid.testapp:id/gesture_type_text_view"),
				"Gesture Text");
	}

}
