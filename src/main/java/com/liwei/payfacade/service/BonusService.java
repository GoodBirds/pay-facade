package com.liwei.payfacade.service;

import com.liwei.payfacade.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liwei
 * @create: 2020/3/17 4:28 下午
 */
@Service
@Slf4j
public class BonusService {

    /**
     * 增加积分
     */
    public void callBonus(){
        //3.调用积分服务接口增加积分
        HttpClientUtils.doPost("jifen.com", "积分接口");
        log.info("3.第三个模块>>>调用积分接口打印日志>>>>>");
    }
}
