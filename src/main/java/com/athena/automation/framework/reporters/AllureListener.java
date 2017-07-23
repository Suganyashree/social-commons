package com.athena.automation.framework.reporters;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;
import org.testng.internal.Utils;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.utils.AnnotationManager;

public class AllureListener implements IResultListener {

	@Override
	public void onTestFailure(ITestResult result) {
		sendSlackMessage(result);
	}

	private Annotation[] getMethodAnnotations(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotations();
	}

	private Annotation[] getClassAnnotations(ITestResult iTestResult) {
		if (iTestResult.getInstance() == null) {
			return new Annotation[0];
		}
		return iTestResult.getInstance().getClass().getAnnotations();
	}
	
	private void sendSlackMessage(ITestResult result) {
		AnnotationManager am = new AnnotationManager(getMethodAnnotations(result));
		am.setDefaults(getClassAnnotations(result));
		
		Features features = am.getAnnotation(Features.class);
		Stories stories = am.getAnnotation(Stories.class);
		
		StringBuilder slackMessage = new StringBuilder();
		slackMessage.append("*Instant Notification for Failure in Social Commons UI Automation Suite*");
		slackMessage.append("\n\n");
		slackMessage.append(">*Jenkins Build URL* : ").append(System.getenv("BUILD_URL"));
		slackMessage.append("\n");
		slackMessage.append(">*Features* : ").append(Arrays.toString(features.value()));
		slackMessage.append("\n");
		slackMessage.append(">*Stories* : ").append(Arrays.toString(stories.value()));
		slackMessage.append("\n");
		slackMessage.append("\n");
		slackMessage.append("*Failure Exception* : ");
		slackMessage.append("\n");
		slackMessage.append(Utils.shortStackTrace(result.getThrowable(), true));
		SlackNotification.sendMessage(slackMessage);
	}

	@Override
	public void onTestStart(ITestResult result) { }

	@Override
	public void onTestSuccess(ITestResult result) { }
	
	@Override
	public void onTestSkipped(ITestResult result) { }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }

	@Override
	public void onStart(ITestContext context) { }

	@Override
	public void onFinish(ITestContext context) { }

	@Override
	public void onConfigurationSuccess(ITestResult itr) { }

	@Override
	public void onConfigurationFailure(ITestResult result) {
		sendSlackMessage(result);
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) { }
}