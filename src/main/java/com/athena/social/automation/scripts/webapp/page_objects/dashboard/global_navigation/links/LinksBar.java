package com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.links;

import org.openqa.selenium.WebDriver;

import com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.links.profile.ProfilePopup;

public class LinksBar {
	public LinksBar_Objects webElements;
	private WebDriver driver;

	public LinksBar(WebDriver driver) {
		this.driver = driver;
		this.webElements = new LinksBar_Objects(driver);
	}
	
	public ProfilePopup openProfilePopup() {
		webElements.profile_dropdown().click();
		return new ProfilePopup(driver);
	}
}