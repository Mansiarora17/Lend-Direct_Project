package com.locators.allPages;

public interface UsersDatabasePO {

	String usernameSearchBox = "(//th[@class='ng-star-inserted'])[4]//input";

	String editIcon = "(//button[@mattooltip='Edit'])[1]";

	// Edit user page
	String fixUserAccessIssues = "//span[contains(text(),'Fix User Access Issues')]";

	// Change password
	String changePasswordLink = "//span[contains(text(),'Change Password')]";
	String changePasswordText = "//h3[contains(text(),'Change Your Password')]";

	String oldPassword = "//input[@id='oldPassword']";
	String newPassword = "//input[@id='newPassword']";
	String confirmPassword = "//input[@id='newPassword_2']";
	String saveButton = "//button[text()=' Save ']";

	String successPopupClose = "//button[text()=' Close ']";


	// First name and last name
	String firstName = "//input[@id='firstName']";
	String lastName = "//input[@id='lastName']";

	// Edit user >> reset user password page
	String generatePasswordResetLink = "//span[contains(text(),'Generate a Password Reset link')]";
	String copy = "//butto'[=n//p[text()='Copy']";

	// View Account for Investor Portal
	String viewAccounttext = "//span[contains(text(),'View Account')]";

}
