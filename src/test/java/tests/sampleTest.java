package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import modules.HomePageModule;
import modules.TouchActionModule;
import modules.WebPageModule;
import setup.Base;

/**
 * The sampleTest class holds test methods related to various functionality in
 * selendroid app
 */

@Listeners(utils.Listeners.class)

public class sampleTest extends Base {

	HomePageModule hpm = new HomePageModule();
	WebPageModule wpm = new WebPageModule();
	TouchActionModule tpm = new TouchActionModule();

	@Test(priority = 1)
	public void webViewTest() throws Exception {
		log.info("### TC 1 - WEB VIEW VALIDATION ###");
		hpm.chromeButtonClick();
		wpm.helloDemoInteraction("samuels", "audi");
	}

	@Test(priority = 2)
	public void clickSourceTest() throws Exception {
		log.info("### TC 2 - CLICK SOURCE VALIDATION ###");
		hpm.chromeButtonClick();
		wpm.clickSourceInteraction();
	}

	@Test(priority = 3)
	public void textValidateTest() throws Exception {
		log.info("### TC 3 - TEXT VALIDATION ###");
		hpm.validateTextBox();
	}

	@Test(priority = 4)
	public void touchactionValidateTest() throws Exception {
		log.info("### TC 4 - TOUCH ACTION GESTURES VALIDATION ###");
		hpm.touchButtonClick();
		tpm.validateTouchActions("tap");
		Thread.sleep(1000);
		hpm.touchButtonClick();
		tpm.validateTouchActions("long press");
	}

}
