package general;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class Setting_Preference extends Login_Magic_link {
//public class Setting_Preference extends Base {

	@Test(priority = 1)
	private static void Preference() throws Exception

	{
		try

		{
			Home();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement Preference = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")));
			// Click on Settings
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")).click();
			// Confirm that you are on Settings page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"Settings\"])[1]")));
			// Click on Preferences
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Preferences\"]")))
					.click();
			// Confirm that you are on Preferences page : By printing System
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"System\"]")));
			// Click on Date Format button to update
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Date Format\"]")))
					.click();
			// Print Date Format to confirm that you are on edit screen of Date format
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")));
			// Click on Done
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")))
					.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Preferences\"]")))
					.click();

			System.out.println("*************** Preference - 1 Date format updated successfully ********");
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 2)
	private static void Update_mydetails() throws Exception

	{
		try

		{

			Home();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement Preference = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")));
			// Click on Settings
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")).click();
			// Confirm that you are on Settings page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"Settings\"])[1]")));
			// Print My Details
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"My Details\"]"))).click();
			// Confirm that you are on My Details page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"My Details\"]")));
			// Print Edit button
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Edit\"]")))
					.click();
			// Print Address Label to confirm that you are on edit screen of my details
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Address\"]")));
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Click on Address to update
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=6])[1]")));
			driver.findElement(By.xpath("(//*[@index=6])[1]")).clear();
			driver.findElement(By.xpath("(//*[@index=6])[1]")).sendKeys("Ahmedabad" + " " + timestamp);
			// Click on Save
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")))
					.click();
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")))
					.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"My Details\"]")));

			System.out.println("*************** Preference - 2 My details updated successfully ********");
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			Assert.fail(e.getMessage());

		}
	}

}
