package general;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.testng.TextReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class Invite_Crew extends Login_Magic_link
//public class Invite_Crew extends Base

{

	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public static void sent_invite() throws Exception {

		try

		{
			Home();

			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")));

			// Click on Settings
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")).click();

			// Confirm that you are on Yacht Settings
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Yacht Settings\"]")));

			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Yacht Settings\"]")).click();

			// Click on Manage crew
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Manage Crew\"]")))
					.click();
			// Confirm that you are on Manage crew page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Active\"]")));

			// Click on Add invite crew button
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//XCUIElementTypeOther[@name=\"person.crop.circle.fill.badge.plus\"]"))).click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Click on Enter Details button
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Enter Details\"]"))).click();

			// Confirm that you are on Send Crew Request page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Send Crew Request\"]")));

			// Add Position name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=7])[2]"))).click();

			driver.findElement(By.xpath("(//*[@index=7])[2]")).sendKeys("QA");

			// Add First name
			driver.findElement(By.xpath("(//*[@index=1])[17]")).click();

			driver.findElement(By.xpath("(//*[@index=1])[17]")).sendKeys("Nia" + timestamp);

			// Add Last name
			driver.findElement(By.xpath("(//*[@index=3])[3]")).click();

			driver.findElement(By.xpath("(//*[@index=3])[3]")).sendKeys("Shah" + timestamp);

			// Add Email
			driver.findElement(By.xpath("(//*[@index=5])[3]")).click();

			String myEmailAddress = "purvish+" + System.nanoTime() + "@Gmail.com";

			driver.findElement(By.xpath("(//*[@index=5])[3]")).sendKeys(myEmailAddress);

			// Clicked on Send Magic link button
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Send Magic Link\"]")).click();

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

}