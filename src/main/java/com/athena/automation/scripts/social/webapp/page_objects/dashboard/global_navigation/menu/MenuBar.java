package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.menu;

import org.openqa.selenium.WebDriver;

public class MenuBar {
	public MenuBar_Objects webElements;

	public MenuBar(WebDriver driver) {
		this.webElements = new MenuBar_Objects(driver);
	}
	
	
}