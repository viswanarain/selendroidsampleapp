package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/*
 * The Base class is to hold the initialization of properties, desired capabilities and appiumdriver 
 *
 */

public class Base {

	public static AppiumDriver driver = null;
	Properties prop = new Properties();
	DesiredCapabilities cap = new DesiredCapabilities();
	FileInputStream fis;
	public final static Logger log = Logger.getLogger(Base.class);

	@BeforeSuite
	public AppiumDriver setup() throws IOException, FileNotFoundException {

		// log.info("Suite started");
		log.info("Suite started");
		if (driver == null) {

			fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//utils//config.properties");
			prop.load(fis);

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("automationName", "UiAutomator2");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "8.1");
			cap.setCapability("deviceName", "emulator");
			cap.setCapability("noReset", "true");
			cap.setCapability("newCommandTimeout", "1800");
			cap.setCapability("app",
					System.getProperty("user.dir") + "//src//test//java//utils//selendroid-test-app-0.17.0.apk");
			cap.setCapability("autoGrantPermissions", "true");

			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		return driver;

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
		log.info("Suite completed");
	}
}
