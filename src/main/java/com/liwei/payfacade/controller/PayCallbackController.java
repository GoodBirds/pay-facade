package com.liwei.payfacade.controller;

import com.liwei.payfacade.service.PayFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * @author liwei
 * @create: 2020/3/17 4:41 下午
 */
@RestController
public class PayCallbackController {

    @Autowired
    private PayFacadeService payFacadeService;

    @PostMapping("/callback")
    public String callback(@RequestBody Map<String, String> verifySignature) {
        return payFacadeService.callback(verifySignature);
    }

}
