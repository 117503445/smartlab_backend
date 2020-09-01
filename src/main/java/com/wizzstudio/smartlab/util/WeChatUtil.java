package com.wizzstudio.smartlab.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;

@Configuration
public class WeChatUtil {
    private static String appid;
    private static String secret;

    // GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    // return openid
    public static String AuthCode2Session(String code) throws Exception {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        System.out.println(url);
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        var httpResponse = httpClient.execute(httpGet);

        var result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        System.out.println(result);

        Map<String, String> map = (Map<String, String>) JSON.parse(result);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().equals("openid")) {
                return entry.getValue();
            }
        }
        throw new Exception("no openid");
    }

    @Value("${wechat.appid}")
    public void setAppid(String appid) {
        WeChatUtil.appid = appid;
    }

    @Value("${wechat.secret}")
    public void setSecret(String secret) {
        WeChatUtil.secret = secret;
    }
}
