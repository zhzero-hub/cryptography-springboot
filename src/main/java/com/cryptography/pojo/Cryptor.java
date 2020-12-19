package com.cryptography.pojo;

import com.cryptography.util.MathService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Z_HAO 2020/12/19
 */
public class Cryptor {
    public static String knapsackEncrypt(Knapsack knapsack) {
        ArrayList<BigInteger> privateKey = MathService.toKey(knapsack.getSecretKey());
        ArrayList<BigInteger> publicKey = new ArrayList<>();
        for(BigInteger bigInteger: privateKey) {
            publicKey.add(bigInteger.multiply(knapsack.getT()).mod(knapsack.getK()));
        }
        knapsack.setPublicKey(publicKey.toString());

        ArrayList<BigInteger> arrayList = new ArrayList<>();
        String []messages = MathService.toBit(knapsack.getMessage());
        int divide = messages.length / knapsack.getN();
        for(int i = 0;i < divide;i ++) {
            int start = i * knapsack.getN();
            int end = start + knapsack.getN();
            BigInteger bigInteger = BigInteger.ZERO;
            for(int j = start;j < end;j ++) {
                for(int k = 0;k < messages[j].length();k ++) {
                    if(messages[j].charAt(k) == '1') {
                        bigInteger = bigInteger.add(publicKey.get(k));
                    }
                }
            }
            arrayList.add(bigInteger);
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for(int i = divide * knapsack.getN();i < messages.length;i ++) {
            for(int k = 0;k < messages[i].length();k ++) {
                if(messages[i].charAt(k) == '1') {
                    bigInteger = bigInteger.add(publicKey.get(k));
                }
            }
        }
        if(!bigInteger.equals(BigInteger.ZERO)) {
            arrayList.add(bigInteger);
        }
        return arrayList.toString();
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.setN(2);
        knapsack.setSecretKey("[1, 3, 5, 11, 21, 44, 87, 175, 349, 701]");
        knapsack.setK(new BigInteger("1590"));
        knapsack.setT(new BigInteger("43"));
        knapsack.setMessage("hello");
        System.out.println(knapsackEncrypt(knapsack));
    }
}
