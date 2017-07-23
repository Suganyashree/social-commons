package com.athena.automation.framework.reporters;

import java.io.FileInputStream;
import java.util.Properties;

import com.athena.automation.framework.support.Utils;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

class SlackNotification {
	public static void sendMessage(StringBuilder slackMessage) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(Utils.getResourcesPath() + "environment.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String slackNotificationEnabled = properties.getProperty("notification.slack");
		if (slackNotificationEnabled != null) {
			if (slackNotificationEnabled.equalsIgnoreCase("TRUE")) {
				SlackApi api = new SlackApi("https://hooks.slack.com/services/AAA/BBB/CCC");
				api.call(new SlackMessage("#dummy", "Automation", slackMessage.toString()));
			}
		}
	}
}