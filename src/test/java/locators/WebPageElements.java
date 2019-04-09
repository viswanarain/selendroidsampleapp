package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import pageobjects.WebViewPage;
import utils.CommonUtils;

/*
 * The WebPageElements class is to hold the locator strategy of webelements for web view interaction page
 */

public class WebPageElements implements WebViewPage {

	public WebElement text_inputbox(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.className("android.widget.EditText"), "Name Input box");
	}

	public List<WebElement> preferredCarDropdown(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElements(driver, By.className("android.widget.Spinner"), "car drop down");

	}

	public List<WebElement> selectCar(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElements(driver, By.className("android.widget.CheckedTextView"), "car selection list");
	}

	public List<WebElement> send_button(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElements(driver, By.className("android.widget.Button"),
				"submit button");
	}

	public WebElement webviewheader(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.id("io.selendroid.testapp:id/webviewLocation"), "header text");
	}

	public WebElement spinnerDropDownbutton(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.id("io.selendroid.testapp:id/spinner_webdriver_test_data"),
				"spinner drop down");
	}

	public List<WebElement> selectItem(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElements(driver,
				By.xpath("//android.widget.LinearLayout[1]//android.widget.ListView//android.widget.TextView"),
				"web view list");
	}

	public WebElement targetLink(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.xpath("//android.view.View[@text='I go to a target']"),
				"Target link");
	}

}
