package com.cryptography.pojo;

import com.cryptography.util.MathService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Z_HAO 2020/12/19
 */
public class Cryptor {
    public static ArrayList<BigInteger> generatePublicKey(Knapsack knapsack) {
        if(knapsack.getPublicKey() != null && !knapsack.getPublicKey().isEmpty()) {
            return MathService.toKey(knapsack.getPublicKey());
        }
        ArrayList<BigInteger> privateKey = MathService.toKey(knapsack.getSecretKey());
        ArrayList<BigInteger> publicKey = new ArrayList<>();
        for(BigInteger bigInteger: privateKey) {
            publicKey.add(bigInteger.multiply(knapsack.getT()).mod(knapsack.getK()));
        }
        knapsack.setPublicKey(publicKey.toString());
        return publicKey;
    }

    public static ArrayList<BigInteger> generateSecretKey(Knapsack knapsack) {
        return MathService.toKey(knapsack.getSecretKey());
    }

    public static void generateKAndT(Knapsack knapsack) {
        knapsack.setT(new BigInteger(knapsack.gettString()));
        knapsack.setK(new BigInteger(knapsack.getkString()));
    }

    public static String knapsackEncrypt(Knapsack knapsack) {
        generateKAndT(knapsack);
        ArrayList<BigInteger> publicKey = generatePublicKey(knapsack);

        ArrayList<BigInteger> arrayList = new ArrayList<>();
        String []messages = MathService.toBit(knapsack.getMessage());
        int divide = messages.length / knapsack.getN();
        for(int i = 0;i < divide;i ++) {
            int start = i * knapsack.getN();
            int end = start + knapsack.getN();
            BigInteger bigInteger = BigInteger.ZERO;
            for(int j = start , off = 0;j < end;j ++ , off ++) {
                int offset = MathService.bitCount * off;
                for(int k = 0;k < messages[j].length();k ++) {
                    if(messages[j].charAt(k) == '1') {
                        bigInteger = bigInteger.add(publicKey.get(k + offset));
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

    public static String knapsackDecrypt(Knapsack knapsack) {
        generateKAndT(knapsack);
        ArrayList<BigInteger> secretKey = generateSecretKey(knapsack);
        StringBuilder decodedMessage = new StringBuilder();

        ArrayList<BigInteger> encodedMessages = MathService.toKey(knapsack.getMessage());
        for(BigInteger encodedMessage: encodedMessages) {
            BigInteger s = knapsack.getT().modInverse(knapsack.getK()).multiply(encodedMessage).mod(knapsack.getK());
            String x = "";
            for(int i = MathService.bitCount * knapsack.getN() - 1;i >= 0;i --) {
                if(s.compareTo(secretKey.get(i)) >= 0) {
                    x = "1".concat(x);
                    s = s.subtract(secretKey.get(i));
                }
                else {
                    x = "0".concat(x);
                }
            }
            decodedMessage.append(MathService.toString(x));
        }
        return decodedMessage.toString();
    }

    public static void setResult(KnapsackResult knapsackResult , Knapsack knapsack) {
        knapsackResult.setDate(knapsack.getDate());
        knapsackResult.setK(knapsack.getK());
        knapsackResult.setT(knapsack.getT());
        knapsackResult.setkString(knapsack.getK().toString());
        knapsackResult.settString(knapsack.getT().toString());
        knapsackResult.setPublicKey(knapsack.getPublicKey());
        knapsackResult.setN(knapsack.getN());
        knapsackResult.setBitCount(MathService.bitCount);
        knapsackResult.setType(knapsack.getType());
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.setN(2);
        knapsack.setSecretKey("[1, 3, 5, 11, 21, 44, 87, 175, 349, 701, 1403, 2807, 5615, 11231, 22463, 44927, 89855, 179711, 359423, 718847]");
        knapsack.setK(new BigInteger("1437697"));
        knapsack.setT(new BigInteger("43"));
        knapsack.setMessage("[2710928, 2988943, 57792]");
        System.out.println(knapsackDecrypt(knapsack));
    }
}
