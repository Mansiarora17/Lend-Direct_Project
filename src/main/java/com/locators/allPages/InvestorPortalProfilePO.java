package com.locators.allPages;

public interface InvestorPortalProfilePO {

	String ChangePassword = "(//th[@class='ng-star-inserted'])[4]//input";

	String editIcon = "(//button[@mattooltip='Edit'])[1]";

	// Investor Portal change password
	String changePasswordLink = "//li[@class='m-nav__item ng-star-inserted'][2]";
	String changePasswordText = "//h3[contains(text(),'Change Your Password')]";

	String oldPassword = "//input[@id='oldPassword']";
	String newPassword = "//input[@id='newPassword']";
	String confirmPassword = "//input[@id='newPassword_2']";
	String saveButton = "//button[text()=' Save ']";

	String successPopupClose = "//button[text()=' Close ']";

	// Investor Portal edit user >> reset user password page
	String generatePasswordResetLink = "//span[contains(text(),'Generate a Password Reset link')]";
	String copy = "//button//p[text()='Copy']";

	// Investor user profile
	String userprofile = "//a[@class='m-nav__link m-dropdown__toggle ng-star-inserted']";
	String viewpersonalprofile = "//a[@class='m-nav__link']";

	// Investor Portal Dashboard
	String ipDashboardHeading = "//h3[contains(text(),'Dashboard')]";

	// Investor Portal Exit Account view button
	String exitViewButton = "//span[(@class='m-topbar__userpic')]";
	String accountViewMessage = "//span[@class='m-topbar__userpic']//button";

	// View username
	String Username = "//tbody/tr[2]/th[2]";
	
	//Side Chnage Password text
	String MyProfileheader = "//h3[contains(text(), ' My Profile ')]";

}
