
package general;

import com.codeborne.selenide.testng.TextReport;
import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.qameta.allure.Allure;

public class Base

{
	public TextReport report = new TextReport();

	public static DesiredCapabilities cap = new DesiredCapabilities();

	public static IOSDriver<MobileElement> driver;

	public static void Home() throws Exception

	{
		// Confirm that you are on Home screen
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Wait to load the screen For Home
		WebElement div = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]")));
		// Print that You are on Home screen
		div.click();
	}

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void LoginTOApplication() throws Exception {

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 15 Pro Max");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("udid", "2D8F97C4-F4B4-40FA-92EF-36F53585E263");
		cap.setCapability("app",
				"/Users/apple/Library/Developer/Xcode/DerivedData/testapp-eqlcjdspfzzjswgpsofjosqtsile/Build/Products/Debug-iphonesimulator/Starboard.app");
		cap.setCapability(MobileCapabilityType.NO_RESET, true); // It will always clear the cachess

		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/"), cap);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.activateApp("com.impossible-research.sandbox.Starboard");

		try {

			System.out.println("Installed App found");

			WebElement div1 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name=\"Enter your 5 digit pin.\"]")));

			if (div1.isDisplayed()) {

				// driver.executeScript("mobile:enrollBiometric", ImmutableMap.of("isEnabled",
				// true));

				driver.executeScript("mobile:sendBiometricMatch", ImmutableMap.of("type", "faceId", "match", true));

				WebElement div = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]")));

			}
		}

		catch (Exception e)

		{
			System.out.println(e);
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}

		Home();
	}

	@AfterSuite
	public void TearDown() throws Exception

	{

		// driver.terminateApp("com.impossible_research.sandbox.starboard");

		Reporter.log("==========Application closed==========", true);

	}

}
