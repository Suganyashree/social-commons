package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksBar_Objects {
	private WebDriver driver;
	private String baseCss = "nav#j-globalNav-bg div#j-links ";

	public LinksBar_Objects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement profile_dropdown(){
		return driver.findElement(By.cssSelector(baseCss + "a.j-globalNavLink span.j-nav-more"));
	}
}