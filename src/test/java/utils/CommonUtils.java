package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import net.sourceforge.tess4j.*;

import setup.Base;

/*
 * The Commonutils class is to implement appium utility methods
 */
public class CommonUtils extends Base {

	public static String destDir;
	public static DateFormat dateFormat;
	public static String scrPath;
	public static AppiumDriver driver;
	private static WebElement element = null;
	// WebDriverWait wait = new WebDriverWait(driver,20);

	/*
	 * Method to take screenshot
	 */
	public static void takeScreenShot() {
		// Set folder name to store screenshots.
		destDir = "screenshots";
		// Capture screenshot.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// Create folder under project with name "screenshots" provided to
		// destDir.
		new File(destDir).mkdirs();
		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			scrPath = destDir + "/" + destFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method used for toast verification
	 */
	public static String OCR(String ImagePath) {
		String result = null;
		File imageFile = new File(ImagePath);
		ITesseract instance = new Tesseract();
		try {
			result = instance.doOCR(imageFile);

		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	/*
	 * Method used for validating whether webelement is displayed or not
	 */
	public static WebElement findElement(AppiumDriver driver, By expression, String msg) throws Exception {
		
		WebElement element = driver.findElement(expression);
		try {
			
			if (element.isDisplayed()) {
				log.info(msg + " is displayed");
			}
			
				
			return element;

		} catch (Exception e) {
			log.info(msg + " is not displayed");
			takeScreenShot();
			throw (e);

		}

	}

	/*
	 * Method used for validating whether webelement is displayed or not
	 */
	public static List<WebElement> findElements(AppiumDriver driver, By expression, String msg) throws Exception {
		List<WebElement> l = driver.findElements(expression);
		WebElement element = driver.findElement(expression);
		try {
			if (element.isDisplayed()) {
				log.info(msg + " is displayed");

			}
			return l;
		} catch (Exception e) {
			log.info(msg + " is not displayed");
			takeScreenShot();
			throw (e);

		}

	}

	/*
	 * Method used to launch a new app activity
	 */
	public static void launchNewActivity(String packageName, String activityName) {
		driver.runAppInBackground(Duration.ofSeconds(10));
		Activity act = new Activity(packageName, activityName);
		((AndroidDriver) driver).startActivity(act);
	}

	/*
	 * Method used to start or stop Appium server
	 */
	public static void appiumServiceInvocation(String command)
	{
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
										  .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
										  .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
										  .withLogFile(new File(System.getProperty("user.dir") + "//Logs//appiumLogs.txt")));
						
		if(command.equalsIgnoreCase("stop"))
		{
			service.stop();
		}
		else if(command.equalsIgnoreCase("start"))
		{
			service.start();	
		}							  

	}
	
	public static boolean checkElementClickable(By element)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
