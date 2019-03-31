package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/*
 * The WebViewPage interface holds the webelements for web view interaction page of the app
 */
public interface WebViewPage {

	public WebElement text_inputbox(AppiumDriver driver) throws Exception;

	public List<WebElement> preferredCarDropdown(AppiumDriver driver) throws Exception;

	public List<WebElement> selectCar(AppiumDriver driver) throws Exception;

	public WebElement send_button(AppiumDriver driver) throws Exception;

	public WebElement webviewheader(AppiumDriver driver) throws Exception;

	public WebElement spinnerDropDownbutton(AppiumDriver driver) throws Exception;

	public List<WebElement> selectItem(AppiumDriver driver) throws Exception;

	public WebElement targetLink(AppiumDriver driver) throws Exception;

}
