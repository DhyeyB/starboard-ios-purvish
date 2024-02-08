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

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class Linking_Transactions extends Login_Magic_link {
//public class Linking_Transactions extends Base {

	@Test(priority = 1)
	private static void Link_Invoice() throws Exception {

		try {

			Home();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")));
			// Click on Transactions
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Transactions\"]")).click();
			// Confirm that You are on Transactions screen if you are getting text as
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"TRANSACTIONS\"]")));
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Click on 1st transactions
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")))
					.click();
			// Click on Link
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Link\"]"))).click();
			// Click & Print on invoice
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeStaticText[@name=\"Invoices\"])[2]")))
					.click();
			// Linked invoice
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=0])[20]"))).click();
			// Wait till you come on invoice details page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Invoice Number\"]")));
			// Click on link button
			driver.findElement(By.xpath("(//*[@index=1])[5]")).click();
			// Click on back button after link the invoice Linked invoice
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Back_White\"]")).click();
			System.out.println("***************  Link invoice updated successfully ********");
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 2)
	private static void Link_Expense_Categories() throws Exception {
		try

		{

			Home();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")));
			// Click on Transactions
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Transactions\"]")).click();
			// Confirm that You are on Transactions screen if you are getting text as
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"TRANSACTIONS\"]")));
			// Click on 1st transaction from the list
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")))
					.click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Click on Link
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Link\"]"))).click();
			// wait for Expense Categories
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Expense Category\"]")))
					.click();
			// Select 1st Expense Category to link
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]"))).click();
			// Click to Save Linked Expense Categories
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")))
					.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Expense Category\"]")));
			System.out.println("***************  Expense category linked successfully ********");
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 3)
	private static void Notes_Add() throws Exception {

		try

		{

			Home();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")));
			// Click on Transactions
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Transactions\"]")).click();
			// Confirm that You are on Transactions screen if you are getting text as
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"TRANSACTIONS\"]")));
			// Click on 1st transaction from the list
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")))
					.click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Click on Notes
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Notes\"]"))).click();
			// Click & Print Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]"))).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Details\"]")));
			// Add notes Title
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeTextField"))).click();
			// Add data added
			driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("Note Title" + " " + timestamp);
			// Click on Description
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeTextView"))).click();
			// Description added
			driver.findElement(By.xpath("//XCUIElementTypeTextView")).sendKeys("Project Description added by scrpit");
			// Clicked on Done button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
			// Clicked on save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Confirmation page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]")));
			System.out.println("***************  Note added successfully ********");
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

}
