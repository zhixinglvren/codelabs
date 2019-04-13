package com.spider.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zhixinglvren
 * @date 2019/3/21 21:12
 */
public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static String doGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(10000)
                    .setSocketTimeout(5000).build();
            httpGet.setConfig(requestConfig);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200 ||
                    httpResponse.getStatusLine().getStatusCode() == 302) {
                HttpEntity entity = httpResponse.getEntity();
                return EntityUtils.toString(entity, "utf-8");
            } else {
                logger.error("Request StatusCode={}", httpResponse.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            logger.error("Request Exception={}:", e);
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    logger.error("关闭httpClient失败", e);
                }
            }
        }
        return null;
    }
}
