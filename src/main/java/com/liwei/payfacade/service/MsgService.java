package com.liwei.payfacade.service;

import com.liwei.payfacade.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liwei
 * @create: 2020/3/17 4:35 下午
 */
@Service
@Slf4j
public class MsgService {

    /**
     * 发送消息
     */
    public void callMsg() {
        log.info("4.调用消息服务平台服务接口发送消息");
        HttpClientUtils.doPost("msg.com", "调用消息接口");
    }
}
