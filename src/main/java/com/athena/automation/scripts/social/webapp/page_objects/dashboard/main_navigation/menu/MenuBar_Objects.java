package com.athena.automation.scripts.social.webapp.page_objects.dashboard.main_navigation.menu;

import org.openqa.selenium.By;

import com.athena.automation.framework.Driver;
import com.athena.automation.framework.support.Element;

import ru.yandex.qatools.allure.annotations.Step;

public class MenuBar_Objects {
	private Driver driver;
	private String baseXpath = ".//div[@id='head']//div[@id='main-nav']//";

	public MenuBar_Objects(Driver driver) {
		this.driver = driver;
	}
	
	@Step
	public Element communications_link() throws Exception{
		return driver.getBrowser().findElement(By.xpath(baseXpath + "a[text()='Communications']"));
	}
}