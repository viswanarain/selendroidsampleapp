package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import locators.HomePageElements;
import pageobjects.HomePage;
import setup.Base;
import utils.CommonUtils;

/*
 * The HomePageModule class is to implement business logic related to home page of the app
 */
public class HomePageModule extends Base {

	HomePageElements hm = new HomePageElements();
	CommonUtils util = new CommonUtils();

	public void chromeButtonClick() throws Exception {
		hm.chromeButton(driver).click();
		log.info("chrome button click is successful");
	}

	public void validateTextBox() throws Exception {
		hm.textButton(driver).click();
		System.out.println("Text = " + hm.textDisplay(driver).getText());
		Assert.assertEquals(hm.textDisplay(driver).getText(), "Text is sometimes displayed");
		log.info("Text validation is successful");
	}

	public void touchButtonClick() throws Exception {
		hm.touchActionButton(driver).click();
		log.info("Touch action button click is successful");
	}

}
