package com.liwei.payfacade.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author liwei
 * @create: 2020/3/17 4:27 下午
 */
@Service
@Slf4j
public class LogService {

    /**
     * 日志
     *
     * @param verifySignature
     */
    public void log(Map<String, String> verifySignature) {
        // 获取后台通知的数据，其他字段也可用类似方式获取
        String orderId = verifySignature.get("orderId");
        String price = verifySignature.get("price");
        String qtr = verifySignature.get("qtr");
        log.info("1.第一个模块，打印日志模块:orderId:{},price:{},qtr:{}", orderId, price, qtr);
    }
}
