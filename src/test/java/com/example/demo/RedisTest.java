package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;


/**
 * @Auther: admin
 * @Date: 2019/2/15 14:00
 * @Description:
 */
@Slf4j
public class RedisTest {

    @Test
    public void redisTest(){
        Jedis jedis = new Jedis("localhost");
        try {
            jedis.set("runoobkey", "www.runoob.com");
            jedis.lpush("site-list", "Runoob");
            jedis.lpush("site-list", "Google");
            jedis.lpush("site-list", "Taobao");
            /*log.info(jedis.get("runoobkey"));
            // 获取存储的数据并输出
            List<String> list = jedis.lrange("site-list", 0 ,2);
            for(int i=0; i<list.size(); i++) {
                log.info("列表项为: "+list.get(i));
            }*/
            // 获取数据并输出
            Set<String> keys = jedis.keys("*");
            Iterator<String> it=keys.iterator() ;
            while(it.hasNext()){
                String key = it.next();
                System.out.println(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
