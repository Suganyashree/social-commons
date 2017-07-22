package com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.links;

import org.openqa.selenium.WebDriver;

public class LinksBar {
	public LinksBar_Objects webElements;

	public LinksBar(WebDriver driver) {
		this.webElements = new LinksBar_Objects(driver);
	}
	
	
}