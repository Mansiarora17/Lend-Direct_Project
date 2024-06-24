package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingCalculateInterestPO;
import com.locators.allPages.FundingDatabasePO;
import com.locators.allPages.FundingInterestPaymentPO;
import com.locators.allPages.FundingManagementAccountsPO;
import com.locators.allPages.FundingNewFacilityPO;
import com.locators.allPages.InvestorPortalProfilePO;
import com.locators.allPages.InvestorPortalSideMenuPO;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.ReportingManagementAccountsPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UsersDatabasePO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class InvestorPortalAccountPage extends Baseclass {

	/**
	 * The "loadCalculateInterestPage" function is used to load the Calculate
	 * Interest page under funding
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 * @since 20.12.2023
	 */
	public static void loadInvestorPortalViewAccountPage()
			throws FileNotFoundException, IOException, InterruptedException {
		// Open the user database page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the database page under users");
		System.out.println("SUB-STEP_0.001 : Opening the database page under users");
		driver.get(AllPagesUrl.userDatabasePage);
		// Wait for the visibility of database page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of users database page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of users database page");
		IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.usernameSearchBox);
		Thread.sleep(3000);
		String IPusername = getDataFromExcel(75);
		// Click on username field and input the username
		IElementActions.clickAndInput_usingXpath(node, driver, UsersDatabasePO.usernameSearchBox, IPusername);
		node.log(Status.INFO, "STEP1 : Username entered by user on the database page");
		System.out.println("STEP1 : Username entered by user on the database page");
		// Click on the edit icon
		IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.editIcon);
		node.log(Status.INFO, "STEP2:Edit icon is visible");
		System.out.println("STEP2 :Edit icon is visible");
		Utils.clickOnMenu(node, driver, UsersDatabasePO.editIcon);
		// Waiting for View Account text to display
		IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.viewAccounttext);
		node.log(Status.INFO, "STEP3:View Account text is visible");
		System.out.println("STEP3 :View Account text is visible");

	}

	public static void investorPortalDashboard() throws FileNotFoundException, IOException, InterruptedException {

		// Click on View account button
		Utils.clickOnMenu(node, driver, UsersDatabasePO.viewAccounttext);
		Thread.sleep(5000);
		// Waiting for Investor Portal Dashboard to display
		IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalProfilePO.ipDashboardHeading);
		node.log(Status.INFO, "STEP4 : Dashboard is visible");
		System.out.println("STEP4 : Dashboard is visible");

	}

	public static void loadIPlDashboard() throws FileNotFoundException, IOException, InterruptedException {

		//Click on Dashboard from side menu
		IElementActions.clickelement_usingXpath(node, driver, InvestorPortalSideMenuPO.iPDashboard);		
		// Waiting for Investor Portal Dashboard to display
		IWaitStrategy.waitForVisiblity(node, driver, InvestorPortalProfilePO.ipDashboardHeading);
		node.log(Status.INFO, "STEP1 : Dashboard is visible");
		System.out.println("STEP1 : Dashboard is visible");

	}

	public static void loginWithIP() throws FileNotFoundException, IOException, InterruptedException {

		// Call the loadLoginPage function from the utils login
		LoginPage.loadLoginPage();
		// Call the userLoginProcess function from the utils login
		LoginPage.userLoginProcess(node, driver, getDataFromExcel(71), getDataFromExcel(72));
		// Waiting for Dashboard to load
		InvestorPortalAccountPage.loadIPlDashboard();

	}

//	public static void getIPUserAccountName() throws InterruptedException, IOException {
//		// Call the loadLoginPage function from the utils login
//		LoginPage.loadLoginPage();
//		// Call the userLoginProcess function from the utils login
//		LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));
//		// Click on the administration
//		Utils.clickOnMenu(node, driver, SideMenuPO.administration);
//		// Click on the users
//		Utils.clickOnMenu(node, driver, SideMenuPO.users);
//		IElementActions.scrollbyJSExecutorUsingElementPath(driver, SideMenuPO.database);
//		// Click on the users database
//		Utils.clickOnMenu(node, driver, SideMenuPO.database);
//		Thread.sleep(3000);
//		String IPusername = getDataFromExcel(71);
//		// Click on username field and input the username
//		IElementActions.clickAndInput_usingXpath(node, driver, UsersDatabasePO.usernameSearchBox, IPusername);
//		node.log(Status.INFO, "STEP1 : Username entered by user on the database page");
//		System.out.println("STEP1 : Username entered by user on the database page");
//		Thread.sleep(3000);
//		// Click on the edit icon
//		IElementActions.clickelement_usingXpath(node, driver, UsersDatabasePO.editIcon);
//		node.log(Status.INFO, "STEP2 : clicked on the edit icon");
//		System.out.println("STEP2 : clicked on the edit icon");
//		
//	}
}
