package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.links.profile;

import org.openqa.selenium.By;

import com.athena.automation.framework.Driver;
import com.athena.automation.framework.support.Element;

import ru.yandex.qatools.allure.annotations.Step;

public class ProfilePopup_Objects {
	private Driver driver;
	private String baseXpath = ".//nav[@id='j-globalNav-bg']//div[@id='j-links']//section[@class='j-user-profile']/..//";

	public ProfilePopup_Objects(Driver driver) {
		this.driver = driver;
	}
	
	@Step
	public Element calendar_link() throws Exception{
		return driver.getBrowser().findElement(By.xpath(baseXpath + "a[text()='Calendar']"));
	}
}