package general;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import org.apache.commons.digester.annotations.rules.AttributeCallParam.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class More_Module extends Login_Magic_link
//public class More_Module extends Base

{

	@Test(priority = 1)
	public static void Supplier() throws Exception

	{
		try {

			Home();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")));
			// Click on More
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")).click();
			// Wait for Supplier to load
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Suppliers\"]")));
			// Click on Suppliers
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Suppliers\"]")).click();
			// Confirm that You are on Add Supplier screen if you are getting text as Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]")));
			// Click on Add Supplier button
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]")).click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Add Category name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=3])[1]"))).click();
			driver.findElement(By.xpath("(//*[@index=3])[1]")).sendKeys("Supplier" + " " + timestamp);
			// Link Expense Category
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Expense Category\"]")).click();
			// Click on first Exp category
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[6]"))).click();
			// Click on Save Button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Email Addresses:\"]")));
			// Click on Email address field
			driver.findElement(By.xpath("(//*[@index=1])[10]")).click();
			// Email address added
			driver.findElement(By.xpath("(//*[@index=1])[10]")).sendKeys("pandyapurvish7@gmail.com");
			// click on Tel
			driver.findElement(By.xpath("(//*[@index=0])[25]")).click();
			// Select Country Code
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"+213\"]"))).click();
			// Add Mobile number
			driver.findElement(By.xpath("(//*[@index=2])[4]")).click();
			driver.findElement(By.xpath("(//*[@index=2])[4]")).sendKeys("7990446150");
			// Add Supplier Address
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=6])[1]"))).click();
			driver.findElement(By.xpath("(//*[@index=6])[1]")).sendKeys("Ahmedabad");
			// Clicked on Final save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Suppliers\"]")));
			System.out.println("*************** Supplier added successfully ********");

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 2)
	public static void Purchase_Orders() throws Exception

	{
		try

		{

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")));
			// Click on More
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[7]")));
			// Click on POs
			driver.findElement(By.xpath("(//*[@index=1])[7]")).click();
			// Confirm that You are on Add POs screen if you are getting text as Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]")));
			// Add PO button
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]")).click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Add PO title name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=3])[2]"))).click();
			driver.findElement(By.xpath("(//*[@index=3])[2]")).sendKeys("PO" + " " + timestamp);
			// Click on Link Supplier
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Supplier\"]"))).click();
			// Selected on 1st supplier
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]")))
					.click();
			// Clicked on save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// clicked on Total
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]"))).click();
			// Total amount is entered as 99
			driver.findElement(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]"))
					.sendKeys("99");
			// Clicked on Final save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Wait for the page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Purchase Orders\"]")));

			System.out.println("*************** PO added successfully ********");

		}

		catch (Exception e)

		{

			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 3)
	public static void Invoices() throws Exception

	{
		try {

			Home();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")));
			// Click on More
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")).click();
			// Click on Invoice
			driver.findElement(By.xpath("(//*[@index=1])[8]")).click();
			// Confirm that You are on Add Invoice screen if you are getting text as Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]")));
			// Click on Add Invoice button
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]")).click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Add Invoice name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//*[@index=1])[4]")))).click();
			driver.findElement(By.xpath("(//*[@index=1])[4]")).sendKeys("INV" + " " + timestamp);
			// Add Invoice number
			driver.findElement(By.xpath("(//*[@index=2])[3]")).click();
			driver.findElement(By.xpath("(//*[@index=2])[3]")).sendKeys("12" + " " + timestamp);
			// Link Supplier
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Supplier\"]")).click();
			// Selected on 1st supplier
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]"))).click();
			// Clicked on save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// clicked on Total
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]"))).click();
			// Total amount is entered as 99
			driver.findElement(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]"))
					.sendKeys("99");
			// Clicked on Final save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
			// Clicked on Final save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[8]")));
			
			System.out.println("*************** Invoice added successfully ********");

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 4)
	public static void Quotes() throws Exception

	{
		try

		{
			Home();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")));
			// Click on More
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")).click();
			// Print Quotes
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Quotes\"]"))).click();
			// Confirm that You are on Add Quotes screen if you are getting text as Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]"))).click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Add Quotes name
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[1]"))).click();
			driver.findElement(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[1]"))
					.sendKeys("QT" + " " + timestamp);
			// Link Supplier
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Supplier\"]")).click();
			// Selected on 1st supplier
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[5]"))).click();
			// Clicked on save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// clicked on Total
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]"))).click();
			// Total amount is entered as 99
			driver.findElement(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]"))
					.sendKeys("99");
			// Clicked on Done button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
			// Clicked on Final save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Quotes\"]")));
			System.out.println("*************** Quotes added successfully ********");

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 5)
	public static void Projects() throws Exception

	{
		try

		{
			Home();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")));
			// Click on More
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")).click();
			// Print Projects
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Projects\"]"))).click();
			// Confirm that You are on Add Projects screen if you are getting text as Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]"))).click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Add Projects name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeTextField"))).click();
			driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("PJ" + " " + timestamp);
			// Click onDescription
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Description\"]")).click();
			// Description added
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=4])[1]"))).click();
			driver.findElement(By.xpath("(//*[@index=4])[1]")).sendKeys("Project Description added by scrpit");
			// Clicked on Done button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
			// Clicked on save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Click on Project Category
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeImage[@name=\"Right\"])[2]"))).click();
			// Selected on 1st projects Category
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[6]"))).click();
			// Clicked on save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Clicked on Final save button
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")))
					.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Projects\"]"))).click();

			System.out.println("*************** Project added successfully ********");

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 6)

	public static void Reports() throws Exception

	{
		try

		{
			Home();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")));
			// Click on More
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")).click();
			// Print Projects text
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Reports\"]")));
			// Click on Reports
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Reports\"]")).click();
			// Confirm that You are on Add Projects screen if you are getting text as Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]"))).click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Add Report name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeTextField"))).click();
			driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("Report" + " " + timestamp);
			// Clicked on APA
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeImage[@name=\"Right\"])[2]"))).click();
			// Click on 1st APA from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]")))
					.click();
			// Clicked on project save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Clicked on Projects
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeImage[@name=\"Right\"])[3]"))).click();
			// Click on 1st project from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]")))
					.click();//
			// Clicked on project save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Clicked on Expense Category
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeImage[@name=\"Right\"])[4]"))).click();
			// Click on 1st Expense Category from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[8]"))).click();//
			// Clicked on Expense Category save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Clicked on Suppliers to link with reports
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeImage[@name=\"Right\"])[5]"))).click();
			// Click on 1st Supplier from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[8]"))).click();//
			// Clicked on Supplier save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Clicked on Crew Member
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//XCUIElementTypeImage[@name=\"Right\"])[6]"))).click();
			// Click on 1st Crew Member from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[8]"))).click();//
			// Clicked on Crew Member save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Clicked on Run Report button
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Run Report\"]"))).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"None Found.\"]")));

			System.out.println("*************** Report added successfully ********");

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 7)

	public static void Expense_category() throws Exception

	{
		try

		{
			Home();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")));
			// Click on More
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"More\"]")).click();
			// wait for exp category
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=1])[10]")));
			// Click on exp category
			driver.findElement(By.xpath("(//*[@index=1])[10]")).click();
			// Confirm that You are on Add Exp category screen if you are getting text as
			// Add
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Add\"]"))).click();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// Add exp category name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeTextField"))).click();
			driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("exp_cat" + " " + timestamp);
			// Click onDescription
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Description\"]")).click();
			// Description added
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index=4])[1]"))).click();
			driver.findElement(By.xpath("(//*[@index=4])[1]")).sendKeys("Expense category Description added by scrpit");
			// Clicked on Done button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
			// Clicked on save button
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();
			// Clicked on Final save button
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")))
					.click();

			System.out.println("*************** Exp category added successfully ********");

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

}
