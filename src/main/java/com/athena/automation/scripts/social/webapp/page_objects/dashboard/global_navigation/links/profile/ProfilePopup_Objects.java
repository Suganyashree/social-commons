package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.links.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePopup_Objects {
	private WebDriver driver;
	private String baseXpath = ".//nav[@id='j-globalNav-bg']//div[@id='j-links']//section[@class='j-user-profile']/..//";

	public ProfilePopup_Objects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement calendar_link(){
		return driver.findElement(By.cssSelector(baseXpath + "a[text()='Calendar']"));
	}
}