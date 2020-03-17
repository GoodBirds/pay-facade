package com.liwei.payfacade.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liwei
 * @create: 2020/3/17 4:25 下午
 */
@Slf4j
public class HttpClientUtils {

    public static String doPost(String url, String text) {
        log.info(">>>Url:{},text:{}", url, text);
        return "success";
    }
}
