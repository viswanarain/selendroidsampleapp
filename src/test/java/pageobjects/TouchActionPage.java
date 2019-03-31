package pageobjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/*
 * The TouchActionPage interface holds the webelements for Touch Action page of the app
 */
public interface TouchActionPage {
	
	public WebElement touchActionEventMsg(AppiumDriver driver) throws Exception;

}
