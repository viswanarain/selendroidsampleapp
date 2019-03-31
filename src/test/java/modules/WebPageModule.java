package modules;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import locators.WebPageElements;
import setup.Base;

/*
 * The WebPageModule class is to implement business logic related to web view interaction page of the app
 */

public class WebPageModule extends Base {

	WebPageElements web = new WebPageElements();

	public void helloDemoInteraction(String nameInput, String carName) throws Exception {
		Thread.sleep(3000);
		web.text_inputbox(driver).clear();
		Thread.sleep(1000);
		web.text_inputbox(driver).sendKeys(nameInput);
		log.info(nameInput + " is entered");

		web.preferredCarDropdown(driver).get(1).click(); // To click the
															// preferred car
															// drop down
		List<WebElement> list = web.selectCar(driver);
		System.out.println("Number of cars in the list = " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("car present in list = " + list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase(carName)) {

				list.get(i).click();
				break;
			}

		}
		log.info(carName + " is selected");

		web.send_button(driver).click();

		/* Extracting the name and car value from the header */
		int index = web.webviewheader(driver).getText().indexOf("name");
		String extractedString = web.webviewheader(driver).getText().substring(index);
		String[] stringGroup = extractedString.split("&");
		String expectedName = stringGroup[0];
		String expectedcarName = stringGroup[1];
		if (expectedName.contains(nameInput) && expectedcarName.contains(carName)) {
			log.info("Input name and car name is matching");

		} else {
			log.info("Either one of Input name or car name is not matching");
		}

		driver.navigate().back();

	}

	public void clickSourceInteraction() throws Exception {
		web.spinnerDropDownbutton(driver).click();
		List<WebElement> itemList = web.selectItem(driver);

		for (int i = 0; i < itemList.size(); i++) {

			if (itemList.get(i).getText().equalsIgnoreCase("Click Source")) {
				itemList.get(i).click();

				Thread.sleep(5000);
				break;
			}

		}
		log.info("Click Source is selected");

		web.targetLink(driver).click();

		Assert.assertEquals(web.webviewheader(driver).getText(), "file:///android_asset/web/simpleTest.html"); // checking for header text																										// text

		Thread.sleep(1000);

		driver.navigate().back();
	}

}
