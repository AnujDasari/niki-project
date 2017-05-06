package com.niki.tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.niki.utils.ReportNGReport;

public class AppTests extends BaseTest {
	@Test(priority=1)
	public void validateDashboard() throws Exception {
		dashboardPO.validateDashboard();
		ReportNGReport.captureScreenshot(driver, "Validate dashboard");

	}

	@Test(priority=2)
	public void cancelAction() throws InterruptedException {
		dashboardPO.initiateAndCancelAction();
	}

	@Test(priority=3)
	public void validateUserInfo() {
		dashboardPO.clickOnBurgerMenu();
		Boolean userInfoStatus = sidePanelPO.validateUserInfo("Anuj Dasari",
				"anuj.dsr@gmail.com", "9900135521", "0");
		if (userInfoStatus.booleanValue() == true) {
			ReportNGReport.captureScreenshot(driver, "User Information");

		} else {
			ReportNGReport.captureScreenshot(driver, "User Information");
			Assert.fail("User details are incorrect!");

		}

	}

	@Test(priority=4)
	public void validateSidePanelOptions() throws InterruptedException {
		dashboardPO.clickOnBurgerMenu();
		ReportNGReport.captureScreenshot(driver, "Burger Menu Clicked");
		sidePanelPO.clickOnAllSidePanelOptions();
		
	}
	
	@Test(priority=5)
	public void validateHelpSection() throws InterruptedException {
		dashboardPO.clickOnHelpButton();
		ReportNGReport.captureScreenshot(driver, "Help Section Expanded");
		helpSectionPO.clickOnHelpIcons();
	}
	
	@Test(priority=6)
	public void exitApplication() {
		dashboardPO.exitApp();
	}
}
