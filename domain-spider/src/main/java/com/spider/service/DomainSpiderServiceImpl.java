package com.spider.service;

import com.spider.utils.HttpUtils;
import org.apache.http.client.methods.HttpGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhixinglvren
 * @date 2019/3/21 21:38
 */
@Service
public class DomainSpiderServiceImpl implements DomainSpiderService {

    private static Logger logger = LoggerFactory.getLogger(DomainSpiderServiceImpl.class);

    @Override
    public List<String> domainSpiderOfAizan(String ip) {
        String host = "dns.aizhan.com";
        String url = "https://" + host + "/" + ip + "/";

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Cookie", "_csrf=64e78ae884b2f7c61eb69d507a619b0ba0c65778204dc1009b9ddfea24290480a%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22wgL4L2-cZ0RvtpiqE-N4flrtSOpck07i%22%3B%7D");
        httpGet.setHeader("DNT", "1");
        httpGet.setHeader("Host", host);
        httpGet.setHeader("Referer", "https://" + host + "/");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        String result = HttpUtils.doGet(httpGet);
        Document document = Jsoup.parse(result);
        if (document == null) {
            logger.error("Jsoup parse get document null!");
        }
        document.getElementsByAttributeValue("class", "table table-striped table-s1");

        return document.getElementsByAttributeValue("rel", "nofollow").eachText();
    }

    @Override
    public List<String> domainSpiderOfIp138(String ip) {
        String host = "site.ip138.com";
        String url = "http://" + host + "/" + ip + "/";

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpGet.setHeader("Cache-Control", "max-age=0");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Cookie", "Hm_lvt_d39191a0b09bb1eb023933edaa468cd5=1553090128; BAIDU_SSP_lcr=https://www.baidu.com/link?url=FS0ccst469D77DpdXpcGyJhf7OSTLTyk6VcMEHxT_9_&wd=&eqid=fa0e26f70002e7dd000000065c924649; pgv_pvi=6200530944; pgv_si=s4712839168; Hm_lpvt_d39191a0b09bb1eb023933edaa468cd5=1553093270");
        httpGet.setHeader("DNT", "1");
        httpGet.setHeader("Host", host);
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        String result = HttpUtils.doGet(httpGet);
        Document document = Jsoup.parse(result);
        if (document == null) {
            logger.error("Jsoup parse get document null!");
        }
        Element listEle = document.getElementById("list");

        return listEle.getElementsByAttributeValue("target", "_blank").eachText();
    }

}
