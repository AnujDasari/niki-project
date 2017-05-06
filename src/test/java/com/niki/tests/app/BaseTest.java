package com.niki.tests.app;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.niki.driver.BaseDriver;
import com.niki.pages.DashboardPage;
import com.niki.pages.HelpSectionPage;
import com.niki.pages.SidePanelPage;
import com.niki.utils.ReportNGReport;

public class BaseTest extends BaseDriver {
	/* Before Class */
	@BeforeSuite()
	public void beforeSuite() {
		TestNG tng = new TestNG();
		tng.setOutputDirectory(ReportNGReport.makDir());

	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		appiumStart();
		driver = setupApp();
		dashboardPO = PageFactory.initElements(driver, DashboardPage.class);
		sidePanelPO = PageFactory.initElements(driver, SidePanelPage.class);
		helpSectionPO = PageFactory.initElements(driver,  HelpSectionPage.class);
	}

	/* After Class */
	@AfterClass
	public void afterClass() throws IOException, InterruptedException {
		appiumStop();
	}

	@AfterSuite()
	public void afterSuite() {

	}
}
