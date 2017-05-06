package com.niki.tests.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.niki.utils.ReportNGReport;

public class AppTests extends BaseTest {
	@Test
	public void validateDashboard() throws Exception {
		dashboardPO.validateDashboard();
		ReportNGReport.captureScreenshot(driver, "Validate dashboard");

	}

	@Test
	public void cancelAction() throws InterruptedException {
		dashboardPO.initiateAndCancelAction();
	}

	@Test
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

	@Test
	public void validateSidePanelOptions() throws InterruptedException {
		dashboardPO.clickOnBurgerMenu();
		sidePanelPO.clickOnAllSidePanelOptions();
	}
	
	@Test
	public void validateHelpSection() throws InterruptedException {
		dashboardPO.clickOnHelpButton();
		Thread.sleep(2000);
		helpSectionPO.clickOnHelpIcons();
	}
}
