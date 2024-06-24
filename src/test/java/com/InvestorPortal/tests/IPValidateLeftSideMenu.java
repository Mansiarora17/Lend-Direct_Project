package com.InvestorPortal.tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.locators.allPages.InvestorPortalProfilePO;
import com.locators.allPages.InvestorPortalSideMenuPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.InvestorPortalAccountPage;
import com.qa.utils.Utils;

public class IPValidateLeftSideMenu extends Baseclass {

	// TC_IP_Login_018
	 @Test(priority = 1)
	public void validateDashboardSideMenu() throws IOException {
		try {
			extenttest = extent.createTest("Verify user can access dashboard from left hand menu.")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Login with Investor Portal credentials
			InvestorPortalAccountPage.loginWithIP();

			// Waiting to InvestorPortal Dashboard to load
			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalProfilePO.ipDashboardHeading);
			node.log(Status.INFO, "STEP1 : Dashboard is visible");
			System.out.println("STEP1 : Dashboard is visible");
			
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Click on your details from side menu
			IElementActions.clickelement_usingXpath(node, driver, InvestorPortalSideMenuPO.iPYourDetails);
			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalSideMenuPO.iPYourDetailsHeading);
			node.log(Status.INFO, "STEP2 : Your Details in heading is visible");
			System.out.println("STEP2 : Your Details in heading is visible");

			// Verify that logged user is able to redirect to Dashboard from side menu
			node.log(Status.INFO, "STEP3 : Verify that logged in user can access dashboard from left hand menu.");
			System.out.println("STEP3 : Verify that logged in user can access dashboard from left hand menu.");

			// Click on dashboard from side menu
			IElementActions.clickelement_usingXpath(node, driver, InvestorPortalSideMenuPO.iPDashboard);
			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalProfilePO.ipDashboardHeading,
					"STEP4 : BUG:Logged in user is not able to view Dashboard on side menu",
					"STEP4 : EXPECTED:Logged in user is able to view Dashboard on side menu");

			System.out.println(driver.getCurrentUrl());

		} catch (AssertionError validateDashboardSideMenu) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDashboardSideMenu test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDashboardSideMenu_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDashboardSideMenu.printStackTrace();
			node.fail(validateDashboardSideMenu);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateDashboardSideMenu) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDashboardSideMenu test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDashboardSideMenu_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDashboardSideMenu.printStackTrace();
			node.fail(validateDashboardSideMenu);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_019
	// @Test(priority = 2)
//	public void validateDashboardFacilityData() throws IOException {
//		try {
//			extenttest = extent.createTest(
//					"Verify that user is able to view the data on the dashboard for the facilities assigned to the Investor")
//					.assignCategory(investorportal_tag + "_" + env);
//			node = extenttest.createNode("Report");
//
//			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalSideMenuPO.iPYourDetailsHeading);
//			node.log(Status.INFO, "STEP1 : Your Details in heading is visible");
//			System.out.println("STEP1: Your Details in heading is visible");
//
//			// Verify that logged user is able to view following menu under the Side Menu
//			node.log(Status.INFO, "STEP4 : Verify that logged in user can access dashboard from left hand menu.");
//			System.out.println("STEP4 : Verify that logged in user can access dashboard from left hand menu.");
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDashboard,
//					"STEP4.1 : BUG:Logged in user is not able to view Dashboard on side menu",
//					"STEP4.1 : EXPECTED:Logged in user is able to view Dashboard on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPReporting,
//					"STEP4.2 : BUG:Logged in user is not able to view Reporting on side menu",
//					"STEP4.2 : EXPECTED:Logged in user is able to view Reporting on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPAccountBalances,
//					"STEP4.3 : BUG:Logged in user is not able to view Account Balances on side menu",
//					"STEP4.3 : EXPECTED:Logged in user is able to view Account Balances on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDocuments,
//					"STEP4.4 : BUG:Logged in user is not able to view Documents on side menu",
//					"STEP4.4 : EXPECTED:Logged in user is able to view Documents on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPCompliance,
//					"STEP4.5 : BUG:Logged in user is not able to view Compliance on side menu",
//					"STEP4.5: EXPECTED:Logged in user is able to view Compliance on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPYourDetails,
//					"STEP4.6 : BUG:Logged in user is not able to view Your Details on side menu",
//					"STEP4.6 : EXPECTED:Logged in user is able to view Your Details on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPFacilityTerms,
//					"STEP4.7 : BUG:Logged in user is not able to view Facility Terms on side menu",
//					"STEP4.7 : EXPECTED:Logged in user is able to view Facility Terms on side menu");
//
//		} catch (AssertionError validateSideMenu) {
//
//			node.log(Status.INFO,
//					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSideMenu test in IPValidateLeftSideMenu class");
//
//			// Take the failed case screenshot
//			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSideMenu_Fail");
//			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));
//
//			validateSideMenu.printStackTrace();
//			node.fail(validateSideMenu);
//			Assert.fail();
//			extent.flush();
//		}
//
//		catch (Exception validateSideMenu) {
//
//			node.log(Status.INFO,
//					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSideMenu test in IPValidateLeftSideMenu class");
//
//			// Take the failed case screenshot
//			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSideMenu_Fail");
//			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));
//
//			validateSideMenu.printStackTrace();
//			node.fail(validateSideMenu);
//			Assert.fail();
//			extent.flush();
//
//		}
//
//	}

	// TC_IP_Login_020
	 @Test(priority = 3)
	public void validateSideMenuOptions() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is able to view options in the side menu")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Loading Investor Portal dashboard
			InvestorPortalAccountPage.loadIPlDashboard();

			// Verify that logged user is able to view following menu under the Side Menu
			node.log(Status.INFO, "STEP2 : Verify that logged in user can access dashboard from left hand menu.");
			System.out.println("STEP2 : Verify that logged in user can access dashboard from left hand menu.");
			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDashboard,
					"STEP2.1 : BUG:Logged in user is not able to view Dashboard on side menu",
					"STEP2.1 : EXPECTED:Logged in user is able to view Dashboard on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPReporting,
					"STEP2.2 : BUG:Logged in user is not able to view Reporting on side menu",
					"STEP2.2 : EXPECTED:Logged in user is able to view Reporting on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPAccountBalances,
					"STEP2.3 : BUG:Logged in user is not able to view Account Balances on side menu",
					"STEP2.3 : EXPECTED:Logged in user is able to view Account Balances on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDocuments,
					"STEP2.4 : BUG:Logged in user is not able to view Documents on side menu",
					"STEP2.4 : EXPECTED:Logged in user is able to view Documents on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPCompliance,
					"STEP2.5 : BUG:Logged in user is not able to view Compliance on side menu",
					"STEP2.5: EXPECTED:Logged in user is able to view Compliance on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPYourDetails,
					"STEP2.6 : BUG:Logged in user is not able to view Your Details on side menu",
					"STEP2.6 : EXPECTED:Logged in user is able to view Your Details on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPFacilityTerms,
					"STEP2.7 : BUG:Logged in user is not able to view Facility Terms on side menu",
					"STEP2.7 : EXPECTED:Logged in user is able to view Facility Terms on side menu");

		} catch (AssertionError validateSideMenuOptions) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSideMenuOptions test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSideMenuOptions_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSideMenuOptions.printStackTrace();
			node.fail(validateSideMenuOptions);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateSideMenuOptions) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSideMenuOptions test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSideMenuOptions_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSideMenuOptions.printStackTrace();
			node.fail(validateSideMenuOptions);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_021
	 @Test(priority = 4)
	public void validateTopRightHeader() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is able to view the User Account name with a View Personal Profile and Logout options")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Loading Investor Portal dashboard
			InvestorPortalAccountPage.loadIPlDashboard();

			// Click on user name in top right header
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.iPheaderUsername);
			node.log(Status.INFO, "STEP2 : Clicked on user name in top right header");
			System.out.println("STEP2: Clicked on user name in top right header");

			// Clicked on View Personal Profile button
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.ViewProfileViewbutton);
			node.log(Status.INFO, "STEP3 : Clicked on View Personal Profile");
			System.out.println("STEP3: Clicked on View Personal Profile");

			// Fetching username from My Profile page
			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalProfilePO.MyProfileheader);
			String UserNameText = IElementActions.getElementText_usingXpath(node, driver,
					InvestorPortalProfilePO.Username);

			// Updating username in the excel
			updateDataOnExcel(76, UserNameText);
			node.log(Status.INFO, "STEP4 : Updated" + UserNameText + "in the excel");
			System.out.println("STEP4 : Updated" + UserNameText + "in the excel");
			System.out.println(getDataFromExcel(76));

			// Click on Header to fetch the details
			IElementActions.clickelement_usingXpath(node, driver, InvestorPortalSideMenuPO.iPheaderUsername);
			String hedaerdetails = IElementActions.getElementText_usingXpath(node, driver,
					InvestorPortalSideMenuPO.topRightHeader);
			String[] UserName = hedaerdetails.split("mitali.jaiswal@unthinkable.co");
			System.out.println(UserName[0] + UserName[1]);

			node.log(Status.INFO,
					"STEP5 : user is able to view the User Account name with a View Personal Profile and Logout options");
			System.out.println(
					"STEP5 : user is able to view the User Account name with a View Personal Profile and Logout options");

			// Verify Username of logged user
			IElementActions.assertEquals_usingString(node, driver, getDataFromExcel(76).strip(), UserName[0].strip(),
					"STEP6 : BUG:Logged in user is not able to view Username on top right header ",
					"STEP6 : EXPECTED:Logged in user is able to view Username on top right header");

			IElementActions.assertEquals_usingString(node, driver, "View Personal Profile", UserName[1].strip(),
					"STEP7 : BUG:Logged in user is not able to view 'View Personal Profile' text on top right header ",
					"STEP7 : EXPECTED:Logged in user is able to view 'View Personal Profile' text on top right header");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.logOut,
					"STEP8 : BUG:Logged in user is not able to view Logout button on top right header",
					"STEP8 : EXPECTED:Logged in user is able to view Logout button on top right header");

		} catch (AssertionError validateTopRightHeader) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTopRightHeader test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTopRightHeader_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTopRightHeader.printStackTrace();
			node.fail(validateTopRightHeader);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateTopRightHeader) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTopRightHeader test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTopRightHeader_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTopRightHeader.printStackTrace();
			node.fail(validateTopRightHeader);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_022
	 @Test(priority = 5)
	public void validateMyProfilePage() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is redirected to the My Profile view on clicking on View Personal Profile option")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Loading Investor Portal dashboard
			InvestorPortalAccountPage.loadIPlDashboard();

			// Click on user name in top right header
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.iPheaderUsername);
			node.log(Status.INFO, "STEP2 : Clicked on user name in top right header");
			System.out.println("STEP2: Clicked on user name in top right header");

			// Clicked on View Personal Profile button
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.ViewProfileViewbutton);
			node.log(Status.INFO, "STEP3 : Clicked on View Personal Profile");
			System.out.println("STEP3: Clicked on View Personal Profile");

			// Wait till the page lad completely
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			node.log(Status.INFO, "STEP4 : user is able to view My Profile page");
			System.out.println("STEP4 : user is able to view  My Profile page");

			// Verify that logged user is able to view My profile in the header
			node.log(Status.INFO,
					"STEP5 : Verify that user is redirected to the My Profile view on clicking on View Personal Profile option");
			System.out.println(
					"STEP5 :Verify that user is redirected to the My Profile view on clicking on View Personal Profile option");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalProfilePO.MyProfileheader,
					"STEP6 : BUG:Logged in user is not able to view My Profile in the header",
					"STEP6 : EXPECTED:Logged in user is able to view My Profile in the header");

		} catch (AssertionError validateMyProfilePage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMyProfilePage test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMyProfilePage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMyProfilePage.printStackTrace();
			node.fail(validateMyProfilePage);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateMyProfilePage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMyProfilePage test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMyProfilePage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMyProfilePage.printStackTrace();
			node.fail(validateMyProfilePage);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_023
	 @Test(priority = 6)
	public void validateLogout() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is redirected to the My Profile view mode on clicking on View Personal Profile option")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Loading Investor Portal dashboard
			InvestorPortalAccountPage.loadIPlDashboard();

			// Click on user name in top right header
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.iPheaderUsername);
			node.log(Status.INFO, "STEP2 : Clicked on user name in top right header");
			System.out.println("STEP2: Clicked on user name in top right header");

			// Clicked on View Personal Profile button
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.logOut);
			node.log(Status.INFO, "STEP3 : Clicked on logout button text");
			System.out.println("STEP3: Clicked on logout button text");

			// Wait till the page load completely
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			node.log(Status.INFO, "STEP4 : user is able to view My Profile page");
			System.out.println("STEP4 : user is able to view  My Profile page");

			// Verify that logged user is redirected to login URL on clicking logout button
			node.log(Status.INFO, "STEP5 : Verify that user is redirected to the login URL");
			System.out.println("STEP5 :Verify that user is redirected to the login URL");

			String loginURL = IElementActions.getCurrentUrl(node, driver);
			IElementActions.assertEquals_usingString(node, driver, "https://www.lenddirect.io/", loginURL,
					"STEP6 : BUG:Logged in user is not redirected to the login URL",
					"STEP6 : EXPECTED:Logged in user is redirected to the login URL");

		} catch (AssertionError validateLogout) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLogout test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLogout_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLogout.printStackTrace();
			node.fail(validateLogout);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateLogout) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLogout test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLogout_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLogout.printStackTrace();
			node.fail(validateLogout);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_024
	 @Test(priority = 7)
	public void validateLogoAndIcon() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that user is able to view the Lend Direct logo with a hamburger icon")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			InvestorPortalAccountPage.loginWithIP();
			
			// Loading Investor Portal dashboard
			InvestorPortalAccountPage.loadIPlDashboard();

			// Verifying Lend Direct logo and hamburger icon at side menu
			node.log(Status.INFO,
					"STEP2 : Verify that user is able to view the Lend Direct logo with a hamburger icon");
			System.out.println("STEP2 :Verify that user is able to view the Lend Direct logo with a hamburger icon");

			boolean logoPresent = IElementActions.isElementAvailable(node, driver, InvestorPortalSideMenuPO.lDLogo);
			IElementActions.assertTrue_usingboolean(node, driver, logoPresent,
					"STEP3 : BUG:Logged in user is not able to view Lend Direct Logo",
					"STEP3 : EXPECTED:Logged in user is able to view Lend Direct Logo");

			IElementActions.assertTrue_usingXpath(node, driver, InvestorPortalSideMenuPO.hamburger,
					"STEP4 : BUG:Logged in user is not able to view hamburger icon at the side menu",
					"STEP4 : EXPECTED:Logged in user is able to view hamburger icon at the side menu");

		} catch (AssertionError validateLogoAndIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLogoAndIcon test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLogoAndIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLogoAndIcon.printStackTrace();
			node.fail(validateLogoAndIcon);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateLogoAndIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLogoAndIcon test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLogoAndIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLogoAndIcon.printStackTrace();
			node.fail(validateLogoAndIcon);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_025
	 @Test(priority = 8)
	public void validateDashboardOption() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that user is redirected to the Dashboard on clicking on Lend Direct logo")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Loading Investor Portal dashboard
			InvestorPortalAccountPage.loadIPlDashboard();

			// Click on your details from side menu
			IElementActions.clickelement_usingXpath(node, driver, InvestorPortalSideMenuPO.iPYourDetails);
			IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalSideMenuPO.iPYourDetailsHeading);
			node.log(Status.INFO, "STEP2 : Your Details in heading is visible");
			System.out.println("STEP2 : Your Details in heading is visible");

			// Verifying user is redirected to Dashboard on clicking on Lend Direct Logo
			node.log(Status.INFO,
					"STEP3 : Verify that user is able to view the Lend Direct logo with a hamburger icon");
			System.out.println("STEP3 :Verify that user is able to view the Lend Direct logo with a hamburger icon");

			// Clicking on Lend direct Logo
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.lDLogo);

			IElementActions.assertTrue_usingXpath(node, driver, InvestorPortalSideMenuPO.iPDashboard,
					"STEP4 : BUG:Logged in user is not able to view hamburger icon at the side menu",
					"STEP4 : EXPECTED:Logged in user is able to view hamburger icon at the side menu");

		} catch (AssertionError validateDashboardOption) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDashboardOption test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDashboardOption_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDashboardOption.printStackTrace();
			node.fail(validateDashboardOption);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateDashboardOption) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDashboardOption test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDashboardOption_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDashboardOption.printStackTrace();
			node.fail(validateDashboardOption);
			Assert.fail();
			extent.flush();

		}

	}

	// TC_IP_Login_026
	@Test(priority = 9)
	public void validateHamburgerIcon() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is able to open and close the side menu on clicking on the hamburger icon")
					.assignCategory(investorportal_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Loading Investor Portal dashboard
			InvestorPortalAccountPage.loadIPlDashboard();
			
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			node.log(Status.INFO, "STEP2 : Page loaded completely");
			System.out.println("STEP2 : Page loaded completely");

			// Clicking on Hambuuger icon
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.hamburger);
			node.log(Status.INFO, "STEP3 : Clicking on the hamburger icon");
			System.out.println("STEP3 : Clicking on the hamburger icon");
			

			// Verify on clicking on hamburger icon at side menu open and closes
			node.log(Status.INFO,
					"STEP4 : Verify that user is able to open and close the side menu on clicking on the hamburger icon");
			System.out.println(
					"STEP4 : Verify that user is able to open and close the side menu on clicking on the hamburger icon");

			IElementActions.assertEqualsFalse_usingString(node, driver, "Dashboard", InvestorPortalSideMenuPO.iPDashboard,
					"STEP4.1 : BUG:Logged in user is able to view Dashboard on side menu",
					"STEP4.1 : EXPECTED:Logged in user is not able to view Dashboard on side menu");
			
			IElementActions.assertEqualsFalse_usingString(extenttest, driver,"Reporting", InvestorPortalSideMenuPO.iPReporting,
					"STEP4.2 : BUG:Logged in user is able to view Reporting on side menu",
					"STEP4.2 : EXPECTED:Logged in user is not able to view Reporting on side menu");

			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Account Balances", InvestorPortalSideMenuPO.iPAccountBalances,
					"STEP4.3 : BUG:Logged in user is able to view Account Balances on side menu",
					"STEP4.3 : EXPECTED:Logged in user is not able to view Account Balances on side menu");

			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Documents", InvestorPortalSideMenuPO.iPDocuments,
					"STEP4.4 : BUG:Logged in user is able to view Documents on side menu",
					"STEP4.4 : EXPECTED:Logged in user is not able to view Documents on side menu");

			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Compliance", InvestorPortalSideMenuPO.iPCompliance,
					"STEP4.5 : BUG:Logged in user is able to view Compliance on side menu",
					"STEP4.5: EXPECTED:Logged in user is not able to view Compliance on side menu");

			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Your Details", InvestorPortalSideMenuPO.iPYourDetails,
					"STEP4.6 : BUG:Logged in user is able to view Your Details on side menu",
					"STEP4.6 : EXPECTED:Logged in user is not able to view Your Details on side menu");

			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Facility Terms", InvestorPortalSideMenuPO.iPFacilityTerms,
					"STEP4.7 : BUG:Logged in user is able to view Facility Terms on side menu",
					"STEP4.7 : EXPECTED:Logged in user is not able to view Facility Terms on side menu");

			// Again click on Hambuuger icon
			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.hamburger);
			node.log(Status.INFO, "STEP5 : Clicking on the hamburger icon again");
			System.out.println("STEP5 : Clicking on the hamburger icon again");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDashboard,
					"STEP5.1 : BUG:Logged in user is not able to view Dashboard on side menu",
					"STEP5.1 : EXPECTED:Logged in user is able to view Dashboard on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPReporting,
					"STEP5.2 : BUG:Logged in user is not able to view Reporting on side menu",
					"STEP5.2 : EXPECTED:Logged in user is able to view Reporting on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPAccountBalances,
					"STEP5.3 : BUG:Logged in user is not able to view Account Balances on side menu",
					"STEP5.3 : EXPECTED:Logged in user is able to view Account Balances on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDocuments,
					"STEP5.4 : BUG:Logged in user is not able to view Documents on side menu",
					"STEP5.4 : EXPECTED:Logged in user is able to view Documents on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPCompliance,
					"STEP5.5 : BUG:Logged in user is not able to view Compliance on side menu",
					"STEP5.5: EXPECTED:Logged in user is able to view Compliance on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPYourDetails,
					"STEP5.6 : BUG:Logged in user is not able to view Your Details on side menu",
					"STEP5.6 : EXPECTED:Logged in user is able to view Your Details on side menu");

			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPFacilityTerms,
					"STEP5.7 : BUG:Logged in user is not able to view Facility Terms on side menu",
					"STEP5.7 : EXPECTED:Logged in user is able to view Facility Terms on side menu");

		} catch (AssertionError validateHamburgerIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHamburgerIcon test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHamburgerIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHamburgerIcon.printStackTrace();
			node.fail(validateHamburgerIcon);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateHamburgerIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHamburgerIcon test in IPValidateLeftSideMenu class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHamburgerIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHamburgerIcon.printStackTrace();
			node.fail(validateHamburgerIcon);
			Assert.fail();
			extent.flush();

		}

	}
	
	// TC_IP_Login_027
	// Having a bug which is deferred Bug_98
	
	//TC_IP_Login_028
//	@Test(priority = 10)
//	public void validateDashboardData() throws IOException {
//		try {
//			extenttest = extent.createTest(
//					"Verify that user is able to open and close the side menu on clicking on the hamburger icon")
//					.assignCategory(investorportal_tag + "_" + env);
//			node = extenttest.createNode("Report");
//
//			InvestorPortalAccountPage.loginWithIP();
//
//			// Loading Investor Portal dashboard
//			InvestorPortalAccountPage.loadIPlDashboard();
//			
//			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
//			node.log(Status.INFO, "STEP2 : Page loaded completely");
//			System.out.println("STEP2 : Page loaded completely");
//
//			// Clicking on Hambuuger icon
//			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.hamburger);
//			node.log(Status.INFO, "STEP3 : Clicking on the hamburger icon");
//			System.out.println("STEP3 : Clicking on the hamburger icon");
//			
//
//			// Verify on clicking on hamburger icon at side menu open and closes
//			node.log(Status.INFO,
//					"STEP4 : Verify that user is able to open and close the side menu on clicking on the hamburger icon");
//			System.out.println(
//					"STEP4 : Verify that user is able to open and close the side menu on clicking on the hamburger icon");
//
//			IElementActions.assertEqualsFalse_usingString(node, driver, "Dashboard", InvestorPortalSideMenuPO.iPDashboard,
//					"STEP4.1 : BUG:Logged in user is able to view Dashboard on side menu",
//					"STEP4.1 : EXPECTED:Logged in user is not able to view Dashboard on side menu");
//			
//			IElementActions.assertEqualsFalse_usingString(extenttest, driver,"Reporting", InvestorPortalSideMenuPO.iPReporting,
//					"STEP4.2 : BUG:Logged in user is able to view Reporting on side menu",
//					"STEP4.2 : EXPECTED:Logged in user is not able to view Reporting on side menu");
//
//			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Account Balances", InvestorPortalSideMenuPO.iPAccountBalances,
//					"STEP4.3 : BUG:Logged in user is able to view Account Balances on side menu",
//					"STEP4.3 : EXPECTED:Logged in user is not able to view Account Balances on side menu");
//
//			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Documents", InvestorPortalSideMenuPO.iPDocuments,
//					"STEP4.4 : BUG:Logged in user is able to view Documents on side menu",
//					"STEP4.4 : EXPECTED:Logged in user is not able to view Documents on side menu");
//
//			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Compliance", InvestorPortalSideMenuPO.iPCompliance,
//					"STEP4.5 : BUG:Logged in user is able to view Compliance on side menu",
//					"STEP4.5: EXPECTED:Logged in user is not able to view Compliance on side menu");
//
//			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Your Details", InvestorPortalSideMenuPO.iPYourDetails,
//					"STEP4.6 : BUG:Logged in user is able to view Your Details on side menu",
//					"STEP4.6 : EXPECTED:Logged in user is not able to view Your Details on side menu");
//
//			IElementActions.assertEqualsFalse_usingString(extenttest, driver, "Facility Terms", InvestorPortalSideMenuPO.iPFacilityTerms,
//					"STEP4.7 : BUG:Logged in user is able to view Facility Terms on side menu",
//					"STEP4.7 : EXPECTED:Logged in user is not able to view Facility Terms on side menu");
//
//			// Again click on Hambuuger icon
//			Utils.clickOnMenu(node, driver, InvestorPortalSideMenuPO.hamburger);
//			node.log(Status.INFO, "STEP5 : Clicking on the hamburger icon again");
//			System.out.println("STEP5 : Clicking on the hamburger icon again");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDashboard,
//					"STEP5.1 : BUG:Logged in user is not able to view Dashboard on side menu",
//					"STEP5.1 : EXPECTED:Logged in user is able to view Dashboard on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPReporting,
//					"STEP5.2 : BUG:Logged in user is not able to view Reporting on side menu",
//					"STEP5.2 : EXPECTED:Logged in user is able to view Reporting on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPAccountBalances,
//					"STEP5.3 : BUG:Logged in user is not able to view Account Balances on side menu",
//					"STEP5.3 : EXPECTED:Logged in user is able to view Account Balances on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPDocuments,
//					"STEP5.4 : BUG:Logged in user is not able to view Documents on side menu",
//					"STEP5.4 : EXPECTED:Logged in user is able to view Documents on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPCompliance,
//					"STEP5.5 : BUG:Logged in user is not able to view Compliance on side menu",
//					"STEP5.5: EXPECTED:Logged in user is able to view Compliance on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPYourDetails,
//					"STEP5.6 : BUG:Logged in user is not able to view Your Details on side menu",
//					"STEP5.6 : EXPECTED:Logged in user is able to view Your Details on side menu");
//
//			IElementActions.assertTrue_usingXpath(extenttest, driver, InvestorPortalSideMenuPO.iPFacilityTerms,
//					"STEP5.7 : BUG:Logged in user is not able to view Facility Terms on side menu",
//					"STEP5.7 : EXPECTED:Logged in user is able to view Facility Terms on side menu");
//
//		} catch (AssertionError validateHamburgerIcon) {
//
//			node.log(Status.INFO,
//					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHamburgerIcon test in IPValidateLeftSideMenu class");
//
//			// Take the failed case screenshot
//			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHamburgerIcon_Fail");
//			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));
//
//			validateHamburgerIcon.printStackTrace();
//			node.fail(validateHamburgerIcon);
//			Assert.fail();
//			extent.flush();
//		}
//
//		catch (Exception validateHamburgerIcon) {
//
//			node.log(Status.INFO,
//					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHamburgerIcon test in IPValidateLeftSideMenu class");
//
//			// Take the failed case screenshot
//			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHamburgerIcon_Fail");
//			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));
//
//			validateHamburgerIcon.printStackTrace();
//			node.fail(validateHamburgerIcon);
//			Assert.fail();
//			extent.flush();
//
//		}
//
//	}
}
