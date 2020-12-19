package com.cryptography.serviceImpl;

import com.cryptography.mapper.KnapsackMapper;
import com.cryptography.pojo.Decryptor;
import com.cryptography.pojo.Encryptor;
import com.cryptography.pojo.Knapsack;
import com.cryptography.pojo.KnapsackResult;
import com.cryptography.service.KnapsackService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Z_HAO 2020/12/19
 */
@Service

public class KnapsackServiceImpl implements KnapsackService {
    @Autowired
    private KnapsackMapper knapsackMapper;

    @Override
    public KnapsackResult addByEncode(Knapsack knapsack) {
        KnapsackResult knapsackResult = new KnapsackResult(knapsack);
        knapsackResult.setEncodedMessage(Encryptor.knapsackEncrypt(knapsack));
        knapsackResult.setDecodedMessage(knapsack.getMessage());
        if(knapsackMapper.add(knapsackResult) != 0) {
            return knapsackResult;
        }
        else {
            return null;
        }
    }

    @Override
    public KnapsackResult addByDecode(Knapsack knapsack) {
        KnapsackResult knapsackResult = new KnapsackResult(knapsack);
        knapsackResult.setDecodedMessage(Decryptor.knapsackDecrypt(knapsack));
        knapsackResult.setEncodedMessage(knapsack.getMessage());
        if(knapsackMapper.add(knapsackResult) != 0) {
            return knapsackResult;
        }
        else {
            return null;
        }
    }

    @Override
    public int delete(int id) {
        return knapsackMapper.delete(id);
    }

    @Override
    public List<KnapsackResult> findByDate(String date) {
        return knapsackMapper.findByDate(date);
    }

    @Override
    public KnapsackResult findById(int id) {
        return knapsackMapper.findById(id);
    }
}
