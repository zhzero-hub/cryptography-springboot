package com.cryptography.service;

import com.cryptography.pojo.Knapsack;
import com.cryptography.pojo.KnapsackResult;

import java.util.List;

/**
 * @author Z_HAO 2020/12/19
 */
public interface KnapsackService {
    public KnapsackResult addByEncode(Knapsack knapsack);

    public KnapsackResult addByDecode(Knapsack knapsack);

    public int delete(int id);

    public List<KnapsackResult> findByDate(String date);

    public KnapsackResult findById(int id);
}
