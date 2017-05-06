package com.niki.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.niki.utils.HelperManager;
import com.niki.utils.ReportNGReport;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "niki_title_chat")
	private WebElement title;

	@FindBy(className = "android.widget.ImageButton")
	private WebElement burgerMenu;

	@FindBy(id = "edtTxtInputMessage")
	private WebElement chatBox;

	@FindBy(id = "chatListViewLayout")
	private WebElement chatList;

	@FindBy(id = "btnHelp")
	private WebElement helpButton;

	@FindBy(id = "btnSend")
	private WebElement sendMessageButton;

	@FindBy(id = "action_cancel")
	private WebElement cancelButton;

	@FindBy(id = "tvMessage")
	private WebElement alertMessage;

	@FindBy(id = "btnNo")
	private WebElement alertNoButton;

	@FindBy(id = "btnYes")
	private WebElement alertYesButton;
	
	public WebElement getBurgerMenu() {
		return burgerMenu;
	}

	public void validateDashboard() {
		try {
			title.isDisplayed();
			burgerMenu.isDisplayed();
			chatList.isDisplayed();
			chatBox.isDisplayed();
			helpButton.isDisplayed();
			sendMessageButton.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
	}

	public void initiateAndCancelAction() throws InterruptedException {
		chatBox.sendKeys("book a cab");
		sendMessageButton.click();
		HelperManager.explicitWait(cancelButton, driver);
		cancelButton.click();
		Thread.sleep(2000);
		ReportNGReport.captureScreenshot(driver, "Alert Message");
		alertYesButton.click();
	}

	public void clickOnBurgerMenu() {
		burgerMenu.click();
	}

	/* click on help button */
	public void clickOnHelpButton() {
		helpButton.click();
	}

	public void exitApp() {
		driver.navigate().back();
		driver.navigate().back();
	}

}
