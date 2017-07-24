package com.athena.automation.framework.tooling;

import org.apache.http.client.fluent.Request;

public class EnvironmentCheck {
    public static int getResponseCode(String url){
        try {
            return Request.Get(url).execute().returnResponse().getStatusLine()
                    .getStatusCode();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return 404;
        }
    }

}
