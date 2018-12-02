package com.suguowen.avg.model;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

public class RedisTest {
	@Resource(name="redisTemplate")
	RedisTemplate<String, String> redisTemplate;
	
	public void redisTest() {
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
	}
	
	
	public static void main(String[] args) {
		RedisTest redisTest = new RedisTest();
	}
}
