package com.athena.automation.scripts.social.webapp.tests.profile;

import org.testng.annotations.Test;

import com.athena.automation.scripts.social.webapp.page_objects.dashboard.DashBoard_Page;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.links.profile.ProfilePopup;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.profile.calendar.Calendar_Page;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarTests {
	private WebDriver driver;
	private DashBoard_Page dashBoard_Page;
	private Calendar_Page calendarPage;

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {
		this.driver = new ChromeDriver();
		Properties properties = new Properties();
		properties.load(new FileInputStream("path/filename"));
		String baseUrl = properties.getProperty("social.url");
		driver.get(baseUrl);
		dashBoard_Page = new DashBoard_Page(driver);

		ProfilePopup profilePopup = dashBoard_Page.globalNavigation.linksBar.openProfilePopup();
		calendarPage = profilePopup.openCalendar();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

	@Test
	public void calendarDayTest() {
		WebElement monthButton = calendarPage.webElements.month_button();
		Assert.assertTrue(monthButton.getAttribute("class").contains("fc-state-active"), "'Month Button' is not selected by default");

		calendarPage.webElements.day_button().click();

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM d, yyyy");

		String currentDate = sdf.format(now);
		WebElement dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), currentDate, "'Date Label' does not match");

		calendarPage.webElements.prev_button().click();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date yesterday = calendar.getTime();
		String yesterdayDate = sdf.format(yesterday);
		dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), yesterdayDate, "'Date Label' does not match");

		calendarPage.webElements.today_button().click();

		dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), currentDate, "'Date Label' does not match");
	}

	@Test
	public void calendarWeekTest() {
		WebElement monthButton = calendarPage.webElements.month_button();
		Assert.assertTrue(monthButton.getAttribute("class").contains("fc-state-active"), "'Month Button' is not selected by default");

		calendarPage.webElements.week_button().click();
		
		Calendar calendar = Calendar.getInstance();
		String currentWeek = getWeekDays(calendar);
		WebElement dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), currentWeek, "'Date Label' does not match");

		calendarPage.webElements.prev_button().click();

		calendar.add(Calendar.DATE, -7);
		String previousWeek = getWeekDays(calendar);
		dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), previousWeek, "'Date Label' does not match");

		calendarPage.webElements.today_button().click();

		dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), currentWeek, "'Date Label' does not match");
	}

	@Test
	public void calendarMonthTest() {
		WebElement monthButton = calendarPage.webElements.month_button();
		Assert.assertTrue(monthButton.getAttribute("class").contains("fc-state-active"), "'Month Button' is not selected by default");

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");

		String currentDate = sdf.format(now);
		WebElement dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), currentDate, "'Date Label' does not match");

		calendarPage.webElements.prev_button().click();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		Date yesterday = calendar.getTime();
		String yesterdayDate = sdf.format(yesterday);
		dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), yesterdayDate, "'Date Label' does not match");

		calendarPage.webElements.today_button().click();

		dateLabel = calendarPage.webElements.date_label();
		Assert.assertEquals(dateLabel.getText(), currentDate, "'Date Label' does not match");
	}

	private String getWeekDays(Calendar calendar) {		
		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, -1);
		}
		
		Date sunday = calendar.getTime();

		calendar.add(Calendar.DATE, 6);
		Date saturday = calendar.getTime();
		
		SimpleDateFormat startDate_sdf = new SimpleDateFormat("MMM d");
		SimpleDateFormat endDate_sdf = new SimpleDateFormat("MMM d yyyy");

		return startDate_sdf.format(sunday) + " - " + endDate_sdf.format(saturday);
	}
}