package com.cryptography.pojo;

/**
 * @author Z_HAO 2020/12/19
 */
public class KnapsackResult extends Knapsack {
    private int id;
    private String encodedMessage;
    private String decodedMessage;

    private int n;
    private int bitCount;

    public KnapsackResult() {
        super();
    }

    public KnapsackResult(Knapsack knapsack) {
        super(knapsack);
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }

    public String getDecodedMessage() {
        return decodedMessage;
    }

    public void setDecodedMessage(String decodedMessage) {
        this.decodedMessage = decodedMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public void setN(int n) {
        this.n = n;
    }

    public int getBitCount() {
        return bitCount;
    }

    public void setBitCount(int bitCount) {
        this.bitCount = bitCount;
    }
}
