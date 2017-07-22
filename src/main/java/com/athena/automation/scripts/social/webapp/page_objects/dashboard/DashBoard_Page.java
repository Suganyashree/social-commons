package com.athena.automation.scripts.social.webapp.page_objects.dashboard;

import com.athena.automation.framework.Driver;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.GlobalNavigation;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.main_navigation.MainNavigation;

public class DashBoard_Page {
	public GlobalNavigation globalNavigation;
	public MainNavigation mainNavigation;

	public DashBoard_Page(Driver driver) {
		this.globalNavigation = new GlobalNavigation(driver);
		this.mainNavigation = new MainNavigation(driver);
	}
}