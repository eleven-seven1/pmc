package com.dvcn.pmc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/28 9:51
 * @description: TODO
 */
@FeignClient("pmc-provider")
@Service
public interface WebService {

    @RequestMapping("/provider/hello")
    String Hello();

}
