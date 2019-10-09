package com.example.demo.test;

import org.junit.Test;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NewTest {

    @Test
    public void testJedisSingle() {
//1 设置ip地址和端口
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //jedis.select(1);
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "wangxiaoer");
        map.put("age", "kkf");
        map.put("sex", "nan");
        jedis.hmset("user", map);

//2 设置数据
        Set keys = jedis.keys("*");//列出所有的key，查找特定的key如：redis.keys("foo")
        String n = jedis.get("main");
        System.out.println(n);
        Iterator t1 = keys.iterator();
        while (t1.hasNext()) {
            Object obj1 = t1.next();
            System.out.println(obj1);
        }


//4 释放资源
        jedis.close();
    }
}
