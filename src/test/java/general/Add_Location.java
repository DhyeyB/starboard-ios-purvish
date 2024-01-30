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

//public class Add_Location extends Login_test {
public class Add_Location extends Base {

	@Test(priority = 1)
	private static void Update_location() throws Exception {
		try {

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")));

			// Click on Transactions

			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Transactions\"]")).click();

			System.out.println("**********---------- Clicked on Transactions    **********----------");

			// Confirm that You are on Transactions screen if you are getting text as
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"TRANSACTIONS\"]")));
			System.out.println(
					"**********---------- Confirm that You are on Transactions screen    **********----------");

			// Click on 1st transaction from the list
			// wait.until(ExpectedConditions.visibilityOfElementLocated(
			// By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]"))).click();
			// //already have address
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[5]")))
					.click(); // blank address

			System.out.println("**********---------- Click on 1st transaction from the list    **********----------");

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Click on Add/Edit Location
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Add/Edit Location\"]")))
					.click();
			System.out.println("**********---------- Click on Add/Edit Location    **********----------");

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Location\"]")));
			System.out.println("**********---------- You are on Add/Edit Location page    **********----------");

			MobileElement company_field = driver.findElement(By.xpath("(//*[@index=1])[5]"));

			String test = driver.findElement(By.xpath("(//*[@index=1])[5]")).getText();
			System.out.println("**********----------" + test + "**********----------");

			if (!test.equals("Company Name")) {

				// Clear Pre-filled data and update it with time stamp
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]"))).clear();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]")));
				driver.findElement(By.xpath("(//*[@index=1])[5]")).sendKeys("BS" + " " + timestamp);

				System.out.println("**********---------- Company name updated **********----------");

				// Clicked on Final save button
				driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

				driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Export\"]")));
				System.out.println("**********---------- Add location updated **********----------");
			}

			else

			{

				// Fill the Location form
				// Company Name

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]")));

				driver.findElement(By.xpath("(//*[@index=1])[5]")).sendKeys("BS" + " " + timestamp);

				System.out.println("**********---------- Company name updated **********----------");

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
				System.out.println("**********---------- Add location Added successfully **********----------");

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
