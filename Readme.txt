										SELENDROID APP AUTOMATION SUITE
										
PROJECT FLOW:

Page object model has been used for this framework where in each web element present in a page has been categorized into different interfaces (Pageobjects is the package name).
Locator strategy for each web element used has been defined in locators package.
Business logic of each scenario used has been defined in modules package.
Some of the generic methods used has been defined in CommonUtils file.
Log4J has been used to populate the console logs.
All Dependencies are mentioned in the POM.xml.
Default TestNG reports have been utilized.

TOOLS USED:

	1: Appium Desktop
	2: Android studio
	3: Eclipse
	4: TestNG 
	5: Maven
	6: UiAutomatorViewer and Appium inspector for locating elements
	

SCENARIOS COVERED:

	* Default Web view validation: To click on chrome button in home page -> pass the name and the preferred car details -> submit the details and validate.
	
	* click source validation : To select "click source" from web view interaction page -> select any one link -> perform header assertion after clicking on link
	
	* Text box validation : To click on text box button in home page -> validate the text displayed
	
	* Touch Action validation : To click on touch action button in home page -> perform some gestures -> ensure the gesture matches with the output displayed
	

STEPS TO RUN:

To Run the project from Terminal below are the steps:
cd to your project location and use the command 'mvn test'


NOTE:

Since the app does not have iOS capability, the framework has been designed for Android alone.



