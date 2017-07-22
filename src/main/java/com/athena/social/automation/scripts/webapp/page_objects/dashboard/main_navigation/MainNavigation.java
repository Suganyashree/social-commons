package com.athena.social.automation.scripts.webapp.page_objects.dashboard.main_navigation;

import org.openqa.selenium.WebDriver;

import com.athena.social.automation.scripts.webapp.page_objects.dashboard.main_navigation.menu.MenuBar;

public class MainNavigation {
	public MenuBar menuBar;

	public MainNavigation(WebDriver driver) {
		this.menuBar = new MenuBar(driver);
	}
}