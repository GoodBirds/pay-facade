package com.liwei.payfacade.service;

import com.liwei.payfacade.mapper.PaymentTransactionMapper;
import com.liwei.payfacade.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 传统支付回调service，代码耦合度高，层次不明
 *
 * @author liwei
 * @create: 2020/3/17 4:16 下午
 */
@Slf4j
@Service
public class PayCallbackService {

    //用户下单成功后，有哪些操作？
    //1.增加支付回调接口日志，验签
    //2.修改订单数据库状态为已支付
    //3.调用积分服务接口增加积分
    //4.调用消息服务平台服务接口发送消息

    public String callback(Map<String, String> verifySignature) {
        // 1.第一步打印日志信息
        // 获取后台通知的数据，其他字段也可用类似方式获取
        String orderId = verifySignature.get("orderId");
        String price = verifySignature.get("price");
        String qtr = verifySignature.get("qtr");
        log.info("1.第一个模块，打印日志模块:orderId:{},price:{},qtr:{}", orderId, price, qtr);
        // 2.修改订单状态为已经支付
        new PaymentTransactionMapper() {
            @Override
            public void updatePaymentStatus() {
                log.info(">>>修改订单状态为已经支付>>>>>");
            }
        }.updatePaymentStatus();
        // 3.调用积分接口增加积分
        HttpClientUtils.doPost("jifen.com", "积分接口");
        // 4.调用消息服务平台提示
        HttpClientUtils.doPost("msg.com", "调用消息接口");
        return "success";
    }
}
