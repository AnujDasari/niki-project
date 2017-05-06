package com.niki.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends BasePage {
	DashboardPage dashBoard = new DashboardPage(driver);

	public SidePanelPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "userName")
	private WebElement usrName;

	@FindBy(id = "userEmail")
	private WebElement usrEmail;

	@FindBy(id = "userContactNumber")
	private WebElement usrContactNumber;

	@FindBy(id = "userCredit")
	private WebElement usrCredit;

	@FindBy(id = "menuTitle")
	private List<WebElement> options;

	public Boolean validateUserInfo(String username, String email,
			String contactNumber, String creditAmount) {
		String uName = usrName.getText();
		String uEmail = usrEmail.getText();
		String uContactNumber = usrContactNumber.getText();
		String uCredit = usrCredit.getText();
		if (uName.equals(username) && uEmail.equals(email)
				&& uContactNumber.equals(contactNumber)
				&& uCredit.equals(creditAmount)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnAllSidePanelOptions() throws InterruptedException {
		for(int i = 0 ;i < options.size() ; i++) {
			options.get(i).click();
			Thread.sleep(2000);
			driver.navigate().back();
			dashBoard.getBurgerMenu().click();
			Thread.sleep(2000);
		}
	}
}
