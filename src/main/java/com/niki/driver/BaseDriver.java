package com.niki.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.niki.pages.DashboardPage;
import com.niki.pages.HelpSectionPage;
import com.niki.pages.SidePanelPage;

public class BaseDriver {
	protected WebDriver driver;
	protected DashboardPage dashboardPO;
	protected SidePanelPage sidePanelPO;
	protected HelpSectionPage helpSectionPO;

	/* Starting Appium from Console */
	AppiumDriverLocalService service = AppiumDriverLocalService
			.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(
							new File("C:/Program Files (x86)/Appium/node.exe"))//path of node in local
					.withAppiumJS(
							new File(
									"C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js"))); //path of appium.js in local

	/* For Device Only - START APPIUM SERVER */
	protected void appiumStart() {
		if (service.isRunning() == true) {
			service.stop();
			service.start();
		} else {
			service.start();
		}
	}

	/* For Device Only - STOP APPIUM SERVER */
	protected void appiumStop() throws IOException {
		service.stop();
	}

	/**
	 * This method runs scripts in a mobile application
	 **/
	@SuppressWarnings("rawtypes")
	protected WebDriver setupApp() throws MalformedURLException,
			InterruptedException {
		File app = new File("./src/test/resources/apk/app-test-apk.apk");
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("appium-version", "1.4.16.1");
		capabilities.setCapability("automationName", "appium");
		capabilities.setCapability("deviceName", "Nexus");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");
		capabilities.setCapability("appActivity",
				"com.techbins.niki.SplashActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		return driver;
	}
}
