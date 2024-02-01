package general;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.Allure;

import org.testng.Assert;

//public class Setting_Yacht extends Login_Magic_link
public class Setting_Yacht extends Base {
	public TextReport report = new TextReport();

	@Test(priority = 1)
	private static void Sync_data() throws Exception

	{
		try

		{

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 20);

			WebElement Sync_data = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")));

			// Click on Settings
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]")).click();

			// Confirm that you are on Settings page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"Settings\"])[1]")));

			// Print Yacht settings
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Yacht Settings\"]")))
					.click();

			// Confirm that you are on Yacht setting page by clicking on Sync Data
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Sync Data\"]"))).click();

			// Confirm that you are on Sync Data page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Sync Data\"]")));

			// Click on Sync All button to Sync Data
			WebElement Sync_data1 = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Sync All Data\"]")));

			String ActualTitle = Sync_data1.getText();

			Sync_data1.click();

			WebDriverWait wait_sync = new WebDriverWait(driver, 20);

			wait_sync.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Last All Data Sync\"]")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}
}
