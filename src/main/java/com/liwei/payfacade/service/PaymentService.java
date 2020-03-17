package com.liwei.payfacade.service;

import com.liwei.payfacade.mapper.PaymentTransactionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liwei
 * @create: 2020/3/17 4:32 下午
 */
@Service
@Slf4j
public class PaymentService {

    /**
     * 更新支付状态
     */
    public void updatePaymentStatus(){
        //2. 修改订单数据库状态为已支付
        new PaymentTransactionMapper() {
            @Override
            public void updatePaymentStatus() {
                log.info("2.第二个模块>>>修改订单状态为已经支付>>>>>");
            }
        }.updatePaymentStatus();
    }
}
