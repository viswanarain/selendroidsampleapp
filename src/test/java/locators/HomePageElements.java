package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import pageobjects.HomePage;
import utils.CommonUtils;

/*
 * The HomePageElements class is to hold the locator strategy for webelements of home page 
 */

public class HomePageElements implements HomePage {

	public WebElement chromeButton(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		// return
		// driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
		return CommonUtils.findElement(driver, By.id("io.selendroid.testapp:id/buttonStartWebview"), "chrome button");
	}

	public WebElement textButton(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.id("io.selendroid.testapp:id/visibleButtonTest"),
				"Display text view box");

	}

	public WebElement textDisplay(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.id("io.selendroid.testapp:id/visibleTextView"), "Display of text");
	}

	public WebElement touchActionButton(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		return CommonUtils.findElement(driver, By.id("io.selendroid.testapp:id/touchTest"), "Touch Action button");
	}

}
