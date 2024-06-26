package com.Reporting.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.ReportingUpdatesPO;
import com.locators.allPages.SideMenuPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class UpdatesRunScriptTest extends Baseclass {
	@Test(priority = 1)
	public void validateRunScript() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when a user successfully runs a manual script, the update is recorded correctly in the reporting module's table.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the reporting
			Utils.clickOnMenu(node, driver, SideMenuPO.reporting);

			// Click on the update
			Utils.clickOnMenu(node, driver, SideMenuPO.update);

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the page");
			System.out.println("STEP1 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingUpdatesPO.runScriptButton);
			node.log(Status.INFO, "STEP2 : Page is visible");
			System.out.println("STEP2 : Page is visible");

			// Click on the run script button
			Utils.clickOnRunScriptButton();

			//
			Utils.refreshPagenTill(node, driver, 30, 2, ReportingUpdatesPO.firstRecordStatus,
					ReportingUpdatesPO.firstRecordStatusInProgress, ReportingUpdatesPO.firstRecordStatusError);

			String expectedTodayDate = Utils.getTodayDateFormatted();

			String actualLaunchDate = IElementActions.getElementText_usingXpath(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			IElementActions.assertContains_usingString(node, driver, actualLaunchDate, expectedTodayDate,
					"STEP3 : BUG: Launch Date is not coming on Reporting Updates page",
					"STEP3 : EXPECTED:  Launch Date is coming on Reporting Updates page");

			String actualScheduled = IElementActions.getElementText_usingXpath(node, driver,
					ReportingUpdatesPO.firstRecordScheduledDate);
			System.out.println("actualScheduled " + actualScheduled);

			IElementActions.assertContains_usingString(node, driver, actualScheduled, "MANUAL",
					"STEP4 : BUG: Scheduled is not coming on Reporting Updates page",
					"STEP4 : EXPECTED: Scheduled is coming on Reporting Updates page");

			// Check the status
			String status = FundingPage.checkStatus(ReportingUpdatesPO.firstRecordStatus,
					ReportingUpdatesPO.firstRecordStatusInProgress, ReportingUpdatesPO.firstRecordStatusError);

			node.log(Status.INFO, "STEP5 : " + status + " appears in status");
			System.out.println("STEP5 : " + status + " appears in status");

			// Verify the entry is added to the table
			IElementActions.assertContains_usingString(node, driver, status, "DONE_SUCCESS",
					"STEP6: BUG:  " + status + " is coming on the record generated by runscript",
					"STEP6 : EXPECTED: DONE_SUCCESS is coming on the record generated by runscript");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRunScript", "Pass", driver);

		} catch (AssertionError validateRunScript) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRunScript test in UpdatesRunScriptTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRunScript_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRunScript.printStackTrace();
			node.fail(validateRunScript);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateRunScript) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRunScript test in UpdatesRunScriptTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRunScript_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRunScript.printStackTrace();
			node.fail(validateRunScript);
			Assert.fail();
			extent.flush();
		}
	}

}
