package general;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codeborne.selenide.testng.TextReport;
import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.qameta.allure.Allure;
import util.send_request;

public class Login_Magic_link

{

	public TextReport report = new TextReport();

	static DesiredCapabilities cap = new DesiredCapabilities();

	public static IOSDriver<MobileElement> driver;

	public static void Home() throws Exception

	{
		try

		{
			// Confirm that you are on Home screen
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// Wait to load the screen For Home
			WebElement div = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]")));
			// Click on Home screen
			div.click();

		} catch (Exception e)

		{

			System.out.println(e);
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}
	}

	public static void login() throws Exception

	{

		try

		{

			WebDriverWait wait = new WebDriverWait(driver,100);
			System.out.println("Installed App found and it is on Enter new PIN screen");
			// On Enter new PIN screen
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name=\"Enter your new PIN\"]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"1\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"2\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"3\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"4\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"5\"]")))
					.click();

			System.out.println("*************** First Five pin set successfully ********");

			// On Confirm your PIN page
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name=\"Confirm your new PIN\"]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"1\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"2\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"3\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"4\"]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"5\"]")))
					.click();
			System.out.println("*************** Second Five pin set successfully ***********");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"Skip\"]"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@index=0])[15]"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]")));
			
			System.out.println("*************** Login magic link has been worked successfully ********");

		}

		catch (Exception e1)

		{

			System.out.println(e1);
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}

	}

	@BeforeSuite
	public void LoginTOApplication() throws Exception {
		try

		{
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
			cap.setCapability("automationName", "XCUITest");
			cap.setCapability("wdaLaunchTimeout", 120000);
			//cap.setCapability("udid", "2D8F97C4-F4B4-40FA-92EF-36F53585E263"); // local
			cap.setCapability("udid", System.getProperty("udid")); //server
			//cap.setCapability("app","/Users/apple/Library/Developer/Xcode/DerivedData/testapp-eqlcjdspfzzjswgpsofjosqtsile/Build/Products/Debug-iphonesimulator/Starboard 4.app"); // local
			cap.setCapability("app","/Users/runner/work/starboard-ios-purvish/starboard-ios-purvish/app/Starboard 4.app"); //server
			cap.setCapability(MobileCapabilityType.NO_RESET, true); // It will always clear the cachess
			cap.setCapability("appPackage", "com.impossible-research.sandbox.Starboard"); // Starboard package name
			cap.setCapability("appActivity", "com.impossible-research.sandbox.starboard.ui.splash.view.SplashActivity"); // Starboard app activity
			cap.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);

			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/"), cap);
			WebDriverWait wait = new WebDriverWait(driver,50);
			System.out.println(" Application Installed & Allow permission has been given ");
			// Click on SKIP
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name=\"Skip\"]"))).click();
			// Magic link requested
			String magic_link = new send_request().sendRequest();
			driver.navigate().to(magic_link);
			System.out.println("*************** Magic link has been sent successfully ********");

		}

		catch (Exception e2)

		{

			System.out.println(e2);
			String pageSource = driver.getPageSource();
			System.out.println(pageSource);
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}

		login();

	}

	@AfterSuite
	public void TearDown() throws Exception

	{

		driver.terminateApp("com.impossible-research.sandbox.Starboard");

		Reporter.log("==========Starboard Application closed==========", true);

	}

}