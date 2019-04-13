package com.spider.web;

import com.spider.service.DomainSpiderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhixinglvren
 * @date 2019/3/21 21:12
 */
@RestController
public class DomainSpiderController {

    private static Logger logger = LoggerFactory.getLogger(DomainSpiderController.class);

    @Autowired
    private DomainSpiderService domainSpiderService;

    /**
     * @param ip 119.75.217.109
     * @return
     */
    @RequestMapping("/spider/{ip}")
    @ResponseBody
    public List<String> domainSpider(@PathVariable("ip") String ip) {
        long startTime = System.currentTimeMillis();
        List<String> domains = domainSpiderService.domainSpiderOfIp138(ip);
        if(domains == null || domains.size() == 0) {
            domains = domainSpiderService.domainSpiderOfAizan(ip);
        }
        long endTime = System.currentTimeMillis();

        logger.info("完成爬虫任务总耗时：{}s", (endTime - startTime) / 1000);

        return domains;
    }
}
