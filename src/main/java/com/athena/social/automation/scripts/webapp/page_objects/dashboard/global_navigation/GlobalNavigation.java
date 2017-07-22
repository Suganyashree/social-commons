package com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation;

import org.openqa.selenium.WebDriver;

import com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.links.LinksBar;
import com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.menu.MenuBar;

public class GlobalNavigation {
	public LinksBar linksBar;
	public MenuBar menuBar;

	public GlobalNavigation(WebDriver driver) {
		this.linksBar = new LinksBar(driver);
		this.menuBar = new MenuBar(driver);
	}	
}