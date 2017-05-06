package com.niki.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpSectionPage extends BasePage {

	public HelpSectionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	private List<WebElement> helpIcons;

	public void clickOnHelpIcons() throws InterruptedException {
		for (int i = 0; i < helpIcons.size(); i++) {
			helpIcons.get(i).click();
			Thread.sleep(2000);
		}
	}

}
