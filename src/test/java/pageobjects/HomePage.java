package pageobjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/*
 * The HomePage interface holds the webelements for Home page of the app
 */
public interface HomePage {

	public WebElement chromeButton(AppiumDriver driver) throws Exception;

	public WebElement textButton(AppiumDriver driver) throws Exception;

	public WebElement textDisplay(AppiumDriver driver) throws Exception;

	public WebElement touchActionButton(AppiumDriver driver) throws Exception;
}
