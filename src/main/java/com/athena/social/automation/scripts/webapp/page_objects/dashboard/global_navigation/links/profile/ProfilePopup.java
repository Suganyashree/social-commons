package com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.links.profile;

import org.openqa.selenium.WebDriver;

public class ProfilePopup {
	public ProfilePopup_Objects webElements;

	public ProfilePopup(WebDriver driver) {
		this.webElements = new ProfilePopup_Objects(driver);
	}
	
	
}