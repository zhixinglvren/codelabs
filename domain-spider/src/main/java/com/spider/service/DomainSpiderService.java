package com.spider.service;

import java.util.List;

/**
 * @author zhixinglvren
 * @date 2019/3/21 21:25
 */
public interface DomainSpiderService {

    List<String> domainSpiderOfAizan(String ip);

    List<String> domainSpiderOfIp138(String ip);
}
