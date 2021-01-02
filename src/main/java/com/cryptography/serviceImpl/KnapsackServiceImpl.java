package com.cryptography.serviceImpl;

import com.cryptography.mapper.KnapsackMapper;
import com.cryptography.pojo.Cryptor;
import com.cryptography.pojo.Knapsack;
import com.cryptography.pojo.KnapsackResult;
import com.cryptography.service.KnapsackService;
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
        knapsackResult.setEncodedMessage(Cryptor.knapsackEncrypt(knapsack));
        knapsackResult.setDecodedMessage(knapsack.getMessage());
        Cryptor.setResult(knapsackResult , knapsack);
        System.out.println(knapsackResult.getDate());
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
        knapsackResult.setDecodedMessage(Cryptor.knapsackDecrypt(knapsack));
        knapsackResult.setEncodedMessage(knapsack.getMessage());
        Cryptor.setResult(knapsackResult , knapsack);
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
        System.out.println(date);
        return knapsackMapper.findByDate(date);
    }

    @Override
    public KnapsackResult findById(int id) {
        return knapsackMapper.findById(id);
    }

    @Override
    public List<KnapsackResult> findAllByDate() {
        return knapsackMapper.findAllByDate();
    }
}
