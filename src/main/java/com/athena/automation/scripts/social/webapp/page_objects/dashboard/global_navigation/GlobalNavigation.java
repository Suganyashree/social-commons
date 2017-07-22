package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation;

import com.athena.automation.framework.Driver;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.links.LinksBar;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.menu.MenuBar;

public class GlobalNavigation {
	public LinksBar linksBar;
	public MenuBar menuBar;

	public GlobalNavigation(Driver driver) {
		this.linksBar = new LinksBar(driver);
		this.menuBar = new MenuBar(driver);
	}	
}