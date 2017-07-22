package com.athena.social.automation.scripts.webapp.page_objects.dashboard;

import org.openqa.selenium.WebDriver;

public class DashBoard_Page {
	public DashBoard_Page_Objects webElements;

	public DashBoard_Page(WebDriver driver) {
		this.webElements = new DashBoard_Page_Objects(driver);
	}
	
	
}