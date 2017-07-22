package com.athena.social.automation.scripts.webapp.page_objects.dashboard;

import org.openqa.selenium.WebDriver;

import com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.GlobalNavigation;
import com.athena.social.automation.scripts.webapp.page_objects.dashboard.main_navigation.MainNavigation;

public class DashBoard_Page {
	public DashBoard_Page_Objects webElements;
	public GlobalNavigation globalNavigation;
	public MainNavigation mainNavigation;

	public DashBoard_Page(WebDriver driver) {
		this.webElements = new DashBoard_Page_Objects(driver);
		this.globalNavigation = new GlobalNavigation(driver);
		this.mainNavigation = new MainNavigation(driver);
	}
}