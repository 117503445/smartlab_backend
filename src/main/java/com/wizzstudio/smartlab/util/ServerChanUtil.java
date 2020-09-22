package com.wizzstudio.smartlab.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ServerChanUtil {
    public static void Push(String serverChan, String text, String desp) throws IOException {
        String url = "https://sc.ftqq.com/" + serverChan + ".send?text=" + text + "&desp=" + desp;
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpClient.execute(httpGet);
    }
}
