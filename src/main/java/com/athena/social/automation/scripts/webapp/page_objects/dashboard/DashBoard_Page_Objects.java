package com.athena.social.automation.scripts.webapp.page_objects.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoard_Page_Objects {
	private WebDriver driver;

	public DashBoard_Page_Objects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement top_destination(){
		return driver.findElement(By.linkText("Top Destinations"));
	}
	public WebElement top_destination_more(){
		return driver.findElement(By.linkText("More..."));
	}
	public WebElement commons_home_page(){
		return driver.findElement(By.id("logo"));
	}
	public WebElement ask_hub(){
		return driver.findElement(By.linkText("askHub"));
	}
	public WebElement globalnav_link() {
		return driver.findElement(By.id("j-satNav"));
	}
	public WebElement calendar_link() {
		return driver.findElement(By.linkText("Calendar"));
	}
}