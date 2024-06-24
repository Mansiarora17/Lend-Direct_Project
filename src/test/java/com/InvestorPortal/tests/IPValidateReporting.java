package com.InvestorPortal.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.locators.allPages.InvestorPortalProfilePO;
import com.locators.allPages.InvestorPortalSideMenuPO;
import com.locators.allPages.ReportingPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UsersDatabasePO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IMouseActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.InvestorPortalAccountPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class IPValidateReporting extends Baseclass {

	// TC_IP_Reporting_029
	@Test(priority = 1)
	public void validateReportingSideMenu() throws IOException {
		try {
			extenttest = extent.createTest("Validate Reporting sub-options in side menu")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Login with Investor Portal credentials
			InvestorPortalAccountPage.loginWithIP();

			// Waiting to InvestorPortal Dashboard to load
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			
			// Click on Reporting from side menu
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.iPReporting);

			// Verify the sub options display under Reporting
			node.log(Status.INFO, "STEP2 : Verify that Reporting sub-options is displayed on side menu");
			System.out.println("STEP2 : Verify that Reporting sub-options is displayed on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPReportingSummary,
					"STEP2.1 : BUG:Logged in user is not able to view Dashboard on side menu",
					"STEP2.1 : EXPECTED:Logged in user is able to view Dashboard on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPLoanPortfolio,
					"STEP2.2 : BUG:Logged in user is not able to view Reporting on side menu",
					"STEP2.2 : EXPECTED:Logged in user is able to view Reporting on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPInterest,
					"STEP2.3 : BUG:Logged in user is not able to view Account Balances on side menu",
					"STEP2.3 : EXPECTED:Logged in user is able to view Account Balances on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPCredit,
					"STEP2.4 : BUG:Logged in user is not able to view Documents on side menu",
					"STEP2.4 : EXPECTED:Logged in user is able to view Documents on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPRepayment,
					"STEP2.5 : BUG:Logged in user is not able to view Compliance on side menu",
					"STEP2.5: EXPECTED:Logged in user is able to view Compliance on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPRisk,
					"STEP2.6 : BUG:Logged in user is not able to view Your Details on side menu",
					"STEP2.6 : EXPECTED:Logged in user is able to view Your Details on side menu");

		} catch (AssertionError validateReportingSideMenu) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReportingSideMenu test in IPValidateReporting class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateReportingSideMenu_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingSideMenu.printStackTrace();
			node.fail(validateReportingSideMenu);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateReportingSideMenu) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReportingSideMenu test in IPValidateReporting class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateReportingSideMenu_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingSideMenu.printStackTrace();
			node.fail(validateReportingSideMenu);
			Assert.fail();
			extent.flush();

		}

	}

}
