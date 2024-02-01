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

import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class Add_Location extends Login_Magic_link {
//public class Add_Location extends Base {

	@Test(priority = 1)
	private static void Update_location() throws Exception {
		try {

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")));

			// Click on Transactions

			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Transactions\"]")).click();

			// Confirm that You are on Transactions screen if you are getting text as
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"TRANSACTIONS\"]")));

			// already have address
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[5]")))
					.click();

			// Blank address
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Click on Add/Edit Location
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Add/Edit Location\"]")))
					.click();
			// You are on Add/Edit Location page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Location\"]")));

			MobileElement company_field = driver.findElement(By.xpath("(//*[@index=1])[5]"));

			String test = driver.findElement(By.xpath("(//*[@index=1])[5]")).getText();

			if (!test.equals("Company Name")) {

				// Clear Pre-filled data and update it with time stamp
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]"))).clear();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]")));
				driver.findElement(By.xpath("(//*[@index=1])[5]")).sendKeys("BS" + " " + timestamp);

				// Clicked on Final save button
				driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

				driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Export\"]")));
			}

			else

			{

				// Fill the Location form
				// Company Name

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]")));

				driver.findElement(By.xpath("(//*[@index=1])[5]")).sendKeys("BS" + " " + timestamp);

				// Address 1
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=2])[3]")));
				driver.findElement(By.xpath("(//*[@index=2])[3]")).sendKeys("SP1" + " " + timestamp);

				// Address 2
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=3])[2]")));
				driver.findElement(By.xpath("(//*[@index=3])[2]")).sendKeys("Vasna Area");

				// City
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=4])[2]")));
				driver.findElement(By.xpath("(//*[@index=4])[2]")).sendKeys("Ahmebabad");

				// Country
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=5])[2]")));
				driver.findElement(By.xpath("(//*[@index=5])[2]")).sendKeys("India");

				// Zip/Postal Code
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=6])[2]")));
				driver.findElement(By.xpath("(//*[@index=6])[2]")).sendKeys("380007");

				// Clicked on Final save button
				driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

				driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Export\"]")));
			}
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

}
