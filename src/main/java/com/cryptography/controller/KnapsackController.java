package com.cryptography.controller;

import com.cryptography.pojo.Knapsack;
import com.cryptography.pojo.KnapsackResult;
import com.cryptography.service.KnapsackService;
import com.cryptography.serviceImpl.KnapsackServiceImpl;
import com.cryptography.util.ApiResult;
import com.cryptography.util.ApiResultHandler;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Z_HAO 2020/12/19
 */
@Controller
@CrossOrigin
@RequestMapping("/api/knapsack")
@MapperScan("com.cryptography")

public class KnapsackController {
    @Autowired
    KnapsackService knapsackService = new KnapsackServiceImpl();

    @PostMapping("/encrypt")
    public ApiResult encrypt(@RequestBody Knapsack knapsack) {
        KnapsackResult knapsackResult = knapsackService.addByEncode(knapsack);
        if(knapsackResult != null) {
            return ApiResultHandler.success(knapsack);
        }
        else {
            return ApiResultHandler.buildApiResult(200 , "加密失败" , null);
        }
    }

    @PostMapping("/decrypt")
    public ApiResult decrypt(@RequestBody Knapsack knapsack) {
        KnapsackResult knapsackResult = knapsackService.addByDecode(knapsack);
        if(knapsackResult != null) {
            return ApiResultHandler.success(knapsack);
        }
        else {
            return ApiResultHandler.buildApiResult(200 , "加密失败" , null);
        }
    }

    @GetMapping("/findHistorys/{date}")
    public ApiResult findHistorys(@PathVariable String date) {
        return ApiResultHandler.success(knapsackService.findByDate(date));
    }

    @GetMapping("/findHistory/{id}")
    public ApiResult findHistory(@PathVariable int id) {
        return ApiResultHandler.success(knapsackService.findById(id));
    }
}









