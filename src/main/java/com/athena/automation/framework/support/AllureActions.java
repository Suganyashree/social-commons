package com.athena.automation.framework.support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;

public class AllureActions {
    WebDriver webDriver;

    public AllureActions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Attachment
    public byte[] attachScreenshot() {
        webDriver = new Augmenter().augment(webDriver);
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}