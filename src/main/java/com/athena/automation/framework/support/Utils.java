package com.athena.automation.framework.support;

public class Utils {
	public static String getResourcesPath() {
		String workingDir = System.getProperty("user.dir");
		if (!workingDir.contains("target"))
			workingDir = workingDir + getFileSeperator() + "target" + getFileSeperator();
		if (!workingDir.endsWith(getFileSeperator()))
			workingDir = workingDir + getFileSeperator();
		return workingDir;
	}
	
	public static String getFileSeperator() {
		return System.getProperty("file.separator");
	}
}