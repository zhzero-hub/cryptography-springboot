package com.cryptography.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Z_HAO 2020/12/19
 */
public class Knapsack {
    private String message;
    private String secretKey;//私钥
    private String publicKey;//公钥
    private BigInteger t , k;
    private String date;

    public Knapsack() {

    }

    public Knapsack(Knapsack knapsack) {
        message = knapsack.message;
        secretKey = knapsack.secretKey;
        publicKey = knapsack.publicKey;
        t = knapsack.t;
        k = knapsack.k;
        date = knapsack.date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public BigInteger getT() {
        return t;
    }

    public void setT(BigInteger t) {
        this.t = t;
    }

    public BigInteger getK() {
        return k;
    }

    public void setK(BigInteger k) {
        this.k = k;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
