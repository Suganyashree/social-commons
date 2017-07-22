package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuBar_Objects {
	private WebDriver driver;
	private String baseCss = "nav#j-globalNav-bg ul.j-globalNav ";

	public MenuBar_Objects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement home_link(){
		return driver.findElement(By.cssSelector(baseCss + "li#jive-nav-link-home a"));
	}
}