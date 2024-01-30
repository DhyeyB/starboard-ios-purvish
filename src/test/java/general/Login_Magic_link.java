
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
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
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
			WebDriverWait wait = new WebDriverWait(driver, 30);
			// Wait to load the screen For Home
			WebElement div = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Home']")));
			// Print that You are on Home screen
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

			WebDriverWait wait = new WebDriverWait(driver, 100);

			// Enter Your PIN
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Enter your new PIN']")));

			// Click on 1
			driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();

			// Click on 2
			driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();

			// Click on 3
			driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();

			// Click on 4
			driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();

			// Click on 5
			driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();

			// WebDriverWait wait2 = new WebDriverWait(driver, 20);

			WebElement div2 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Confirm your new PIN']")));

			// Click on 1
			driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();

			// Click on 2
			driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();

			// Click on 3
			driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();

			// Click on 4
			driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();

			// Click on 5
			driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='PIN Set Up Successful']")));

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Skip']")))
					.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/head']) [1]")));
			driver.findElement(By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/head']) [1]"))
					.getText();
			driver.findElement(By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/head']) [1]"))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Allow']")))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Home']")));

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
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 15 Pro Max");
			cap.setCapability("automationName", "XCUITest");			
			// cap.setCapability("udid", "2D8F97C4-F4B4-40FA-92EF-36F53585E263");
			cap.setCapability("udid", System.getProperty("udid"));
			// cap.setCapability("app", "/Users/apple/Library/Developer/Xcode/DerivedData/testapp-eqlcjdspfzzjswgpsofjosqtsile/Build/Products/Debug-iphonesimulator/Starboard.app");
			cap.setCapability("app","/Users/runner/work/starboard-ios-purvish/starboard-ios-purvish/app/Starboard.app");
			cap.setCapability(MobileCapabilityType.NO_RESET, true); // It will always clear the cachess
			cap.setCapability("appPackage", "com.impossible-research.sandbox.Starboard"); // Starboard package name
			cap.setCapability("appActivity", "com.impossible-research.sandbox.starboard.ui.splash.view.SplashActivity"); // Starboard login activity
			
			driver = new  IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/"), cap);
			
			driver.findElement(By.id("Allow")).click();


			String magic_link = new send_request().sendRequest();
			
			//driver.activateApp("com.apple.mobilesafari");
			
			driver.navigate().to(magic_link);
			System.out.println(" clicked on magic link");

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
		// driver.terminateApp("com.google.android.gm");

		Reporter.log("==========Gmail Application closed==========", true);

		// driver.terminateApp("com.impossible_research.sandbox.starboard");

		Reporter.log("==========Starboard Application closed==========", true);

	}

}
