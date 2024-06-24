package com.InvestorPortal.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.locators.allPages.InvestorPortalProfilePO;
import com.locators.allPages.ReportingPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UsersDatabasePO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.InvestorPortalAccountPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class IPLoginViewAccount extends Baseclass {

	// TC_IP_Login_013
	@Test(priority = 1)
	public void validateViewAccountButtonVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that user is able to 'view account' text  button only for Investor role")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the administration
			Utils.clickOnMenu(node, driver, SideMenuPO.administration);

			// Click on the users
			Utils.clickOnMenu(node, driver, SideMenuPO.users);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, SideMenuPO.database);

			// Click on the users database
			Utils.clickOnMenu(node, driver, SideMenuPO.database);

			Thread.sleep(3000);

			String IPusername = getDataFromExcel(75);

			// Click on username field and input the username
			IElementActions.clickAndInput_usingXpath(node, driver, UsersDatabasePO.usernameSearchBox, IPusername);
			node.log(Status.INFO, "STEP1 : Username entered by user on the database page");
			System.out.println("STEP1 : Username entered by user on the database page");

			// Click on the edit icon
			IElementActions.clickelement_usingXpath(node, driver, UsersDatabasePO.editIcon);
			node.log(Status.INFO, "STEP2 : clicked on the edit icon");
			System.out.println("STEP2 : clicked on the edit icon");

			// Wait for the visibility of edit user page
			IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.viewAccounttext);
			node.log(Status.INFO, "STEP3 : View Account button is visible");
			System.out.println("STEP3 : View Account button is visible");

			// Verify that user is able to view the view account button
			IElementActions.assertTrue_usingXpath(node, driver, UsersDatabasePO.viewAccounttext,
					"STEP4: BUG: Logged in user is not able to view 'view account' text  button only for Investor role",
					"STEP4: PASS: Logged in user is able to view 'view account' text  button only for Investor role");

		} catch (AssertionError validateViewAccountButtonVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateViewAccountButtonVisibility test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateViewAccountButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateViewAccountButtonVisibility.printStackTrace();
			node.fail(validateViewAccountButtonVisibility);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateViewAccountButtonVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateViewAccountButtonVisibility test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateViewAccountButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateViewAccountButtonVisibility.printStackTrace();
			node.fail(validateViewAccountButtonVisibility);
			Assert.fail();
			extent.flush();

		}
	}

	// TC_IP_Login_014
	@Test(priority = 2)
	public void validateIPDashboard() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is redirected to the Investor Portal Dashbaord on clicking on View Account")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			InvestorPortalAccountPage.loadInvestorPortalViewAccountPage();

			// click on View account button
			Utils.clickOnMenu(node, driver, UsersDatabasePO.viewAccounttext);

			// Verify the Investor Portal Dashboard
			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalProfilePO.ipDashboardHeading);
			node.log(Status.INFO, "STEP3 : Dashboard is visible");
			System.out.println("STEP3 : Dashboard is visible");
			IElementActions.assertTrue_usingXpath(node, driver, InvestorPortalProfilePO.ipDashboardHeading,
					"STEP4: BUG: Logged in user is not able to view Investor Portal Dashborad",
					"STEP4: PASS: Logged in user is able to view Investor Portal Dashborad");

		} catch (AssertionError validateIPDashboard) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIPDashboard test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateIPDashboard_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPDashboard.printStackTrace();
			node.fail(validateIPDashboard);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateIPDashboard) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIPDashboard test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateIPDashboard_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPDashboard.printStackTrace();
			node.fail(validateIPDashboard);
			Assert.fail();
			extent.flush();

		}
	}

	// TC_IP_Login_015
	@Test(priority = 3)
	public void validateIPDashboardExitAccountButton() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is view Exit Account View button on top right")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Verify that logged Exit View Account button is displayed on top of dashboard
			// page
			node.log(Status.INFO, "STEP4 : Verify that user is able to view Exit View Account button on top right");
			System.out.println("STEP4 : Verify that user is able to view Exit View Account button on top right");
			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalProfilePO.exitViewButton,
					"STEP5 : BUG:Logged in user is not able to view Exit View Account button on top right",
					"STEP5 : PASS:Logged in user is able to view Exit View Account button on top right");

		} catch (AssertionError validateIPDashboardExitAccountButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIPDashboardExitAccountButton test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIPDashboardExitAccountButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPDashboardExitAccountButton.printStackTrace();
			node.fail(validateIPDashboardExitAccountButton);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateIPDashboardExitAccountButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIPDashboardExitAccountButton test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIPDashboardExitAccountButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPDashboardExitAccountButton.printStackTrace();
			node.fail(validateIPDashboardExitAccountButton);
			Assert.fail();
			extent.flush();

		}
	}

	// TC_IP_Login_016
	@Test(priority = 4)
	public void validateIPExitAccountButtonText() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is view following text on the Exit View button i.e.You are currently viewing login email account")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Waiting to InvestorPortal Dashboard to load
			Thread.sleep(3000);
			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalProfilePO.ipDashboardHeading);
			node.log(Status.INFO, "STEP4 : Dashboard is visible");
			System.out.println("STEP4 : Dashboard is visible");

			String ipUsername = getDataFromExcel(75);

			// Getting text displayed on exist account view button
			String exitViewAccountText = IElementActions.getElementText_usingXpath(node, driver,
					InvestorPortalProfilePO.accountViewMessage);
			System.out.println("exitViewAccountText is equals to " + exitViewAccountText);

			String[] exitViewText = exitViewAccountText.split("Your are curently viewing");

			// Verify that logged Exit View Account button
			node.log(Status.INFO,
					"STEP4 : Verify that user is able to view Exit View Account button has text - Your are curently viewing"
							+ ipUsername + "account");
			System.out.println(
					"STEP4 : Verify that user is able to view Exit View Account button has text - Your are curently viewing"
							+ ipUsername + "account");

			// Verifying the text displayed on the Exit Account view button
			IElementActions.assertContains_usingString(node, driver, exitViewAccountText, "Your are curently viewing",
					"STEP5 : BUG:Logged in user" + ipUsername + "is not able to view Exit View Account button "
							+ exitViewAccountText + " text on top right",
					"STEP5 : PASS: Logged in user" + ipUsername + "is  able to view Exit View Account button "
							+ exitViewAccountText + " text on top right");
			IElementActions.assertContains_usingString(node, driver, exitViewText[1], ipUsername,
					"STEP6 : BUG:Logged in user" + ipUsername + "is not able to view Exit View Account button "
							+ exitViewText[1] + " text on top right",
					"STEP6 : PASS: Logged in user" + ipUsername + "is able to view Exit View Account button "
							+ exitViewText[1] + " text on top right");

		} catch (AssertionError validateIPExitAccountButtonText) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIPExitAccountButtonText test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIPExitAccountButtonText_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPExitAccountButtonText.printStackTrace();
			node.fail(validateIPExitAccountButtonText);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateIPExitAccountButtonText) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIPExitAccountButtonText test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIPExitAccountButtonText_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPExitAccountButtonText.printStackTrace();
			node.fail(validateIPExitAccountButtonText);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_017
	@Test(priority = 5)
	public void validateIPExitAccountButtonAction() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that user is redirected back to Admin dashbaord on clicking on Exit View button.")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Waiting to InvestorPortal Dashboard to load
			Thread.sleep(3000);
			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalProfilePO.ipDashboardHeading);
			node.log(Status.INFO, "STEP4 : Dashboard is visible");
			System.out.println("STEP4 : Dashboard is visible");

			// Click on Exit Account view button
			Utils.clickOnMenu(node, driver, InvestorPortalProfilePO.exitViewButton);

			// Verify that logged user is redirected back to admin dashboard
			node.log(Status.INFO,
					"STEP1 : STEP1 : Verify that user is redirected back to Admin dashbaord on clicking on Exit View button");
			System.out.println(
					"STEP1 : Verify that user is redirected back to Admin dashbaord on clicking on Exit View button");
			IElementActions.assertTrue_usingXpath(extenttest, driver, ReportingPO.headerUsername,
					"STEP2 : BUG:Logged in user name not coming on dashboard page",
					"STEP2 : EXPECTED:Logged in user name is coming on dashboard page");

		} catch (AssertionError validateIPExitAccountButtonAction) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIPExitAccountButtonAction test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIPExitAccountButtonAction_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPExitAccountButtonAction.printStackTrace();
			node.fail(validateIPExitAccountButtonAction);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateIPExitAccountButtonAction) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIPExitAccountButtonAction test in IPLoginViewAccount class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIPExitAccountButtonAction_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIPExitAccountButtonAction.printStackTrace();
			node.fail(validateIPExitAccountButtonAction);
			Assert.fail();
			extent.flush();

		}

	}

}
