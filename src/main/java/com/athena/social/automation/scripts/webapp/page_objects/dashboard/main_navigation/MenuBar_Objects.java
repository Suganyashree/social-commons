package com.athena.social.automation.scripts.webapp.page_objects.dashboard.main_navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuBar_Objects {
	private WebDriver driver;
	private String baseXpath = ".//div[@id='head']//div[@id='main-nav']//";

	public MenuBar_Objects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement communications_link(){
		return driver.findElement(By.xpath(baseXpath + "a[text()='Communications']"));
	}
}