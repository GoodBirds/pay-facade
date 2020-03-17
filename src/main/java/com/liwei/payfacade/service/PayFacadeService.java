package com.liwei.payfacade.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 门面模式，把一些复杂的流程封装成一个接口供给外部用户更简单的使用
 *
 * @author liwei
 * @create: 2020/3/17 4:36 下午
 */
@Service
@Slf4j
public class PayFacadeService {

    @Autowired
    private LogService logService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BonusService bonusService;
    @Autowired
    private MsgService msgService;

    //用户下单成功后，有哪些操作？
    //1.增加支付回调接口日志，验签
    //2.修改订单数据库状态为已支付
    //3.调用积分服务接口增加积分
    //4.调用消息服务平台服务接口发送消息

    /**
     * 支付回调
     *
     * @param verifySignature
     * @return
     */
    public String callback(Map<String, String> verifySignature) {
        // 1.第一步打印日志信息
        logService.log(verifySignature);
        // 2.修改订单状态为已经支付
        paymentService.updatePaymentStatus();
        // 3.调用积分接口增加积分
        bonusService.callBonus();
        // 4.调用消息服务平台提示
        msgService.callMsg();
        return "success";
    }

}
