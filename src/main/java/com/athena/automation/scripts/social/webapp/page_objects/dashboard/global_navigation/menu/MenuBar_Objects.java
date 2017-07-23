package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.menu;

import org.openqa.selenium.By;

import com.athena.automation.framework.Driver;
import com.athena.automation.framework.support.Element;

import ru.yandex.qatools.allure.annotations.Step;

public class MenuBar_Objects {
	private Driver driver;
	private String baseCss = "nav#j-globalNav-bg ul.j-globalNav ";

	public MenuBar_Objects(Driver driver) {
		this.driver = driver;
	}
	
	@Step
	public Element home_link() throws Exception{
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "li#jive-nav-link-home a"));
	}
}