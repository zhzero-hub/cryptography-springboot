package com.cryptography.util;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Z_HAO 2020/12/19
 */
public class MathService {
    public static final int bitCount = 10;

    /**
     * 将一个int数字转换为二进制的字符串形式。
     * @param num 需要转换的int类型数据
     * @param digits 要转换的二进制位数，位数不足则在前面补0
     * @return 二进制的字符串形式
     */
    public static String toBinary(int num, int digits) {
        int value = 1 << digits | num;
        String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
        return bs.substring(1);
    }

    //将字符串转换为二进制串
    public static String[] toBit(String str) {
        String []ret = new String[str.length()];
        for(int i = 0;i < str.length();i ++) {
            String bitStr = toBinary(str.charAt(i) , bitCount);
            ret[i] = bitStr;
        }
        return ret;
    }

    //将字符串类型的密钥转换为数组
    public static ArrayList<BigInteger> toKey(String str) {
        String substr = str.substring(1 , str.length() - 1);
        String []strings = substr.split(", ");
        ArrayList<BigInteger> arrayList = new ArrayList<>();
        for(String string: strings) {
            arrayList.add(new BigInteger(string));
        }
        return arrayList;
    }

}
