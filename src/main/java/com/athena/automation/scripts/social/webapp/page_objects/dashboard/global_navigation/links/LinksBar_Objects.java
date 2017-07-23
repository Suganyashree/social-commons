package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.links;

import org.openqa.selenium.By;

import com.athena.automation.framework.Driver;
import com.athena.automation.framework.support.Element;

import ru.yandex.qatools.allure.annotations.Step;

public class LinksBar_Objects {
	private Driver driver;
	private String baseCss = "nav#j-globalNav-bg div#j-links ";

	public LinksBar_Objects(Driver driver) {
		this.driver = driver;
	}
	
	@Step
	public Element profile_dropdown() throws Exception{
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "a.j-globalNavLink span.j-nav-more"));
	}
}