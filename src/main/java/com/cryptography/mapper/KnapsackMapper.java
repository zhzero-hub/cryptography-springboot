package com.cryptography.mapper;

import com.cryptography.pojo.Knapsack;
import com.cryptography.pojo.KnapsackResult;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Z_HAO 2020/12/19
 */
@Mapper
@Service

public interface KnapsackMapper {
    @Select("select * from knapsack where date = #{date}")
    public List<KnapsackResult> findByDate(String date);

    @Select("select * from knapsack where id = #{id}")
    public KnapsackResult findById(int id);

    @Options(useGeneratedKeys = true , keyProperty = "id")
    @Insert("insert into knapsack(message , k , t , publicKey , secretKey , encodedMessage , decodedMessage , date)" +
            "values(#{message} , #{k} , #{t} , #{publicKey} , #{secretKey} , #{encodedMessage} , #{decodedMessage} , #{date})")
    public int add(KnapsackResult knapsackResult);

    @Delete("delete from knapsack where id = #{id}")
    public int delete(int id);

}
