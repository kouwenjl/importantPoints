package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Controller
public class DemoApplication {
    public static void main(String[] args) {
//        Set<HostAndPort> set=new HashSet<>();
//        HostAndPort hostAndPort=new HostAndPort("10.91.19.31",6612);
//        HostAndPort hostAndPort1=new HostAndPort("10.91.19.31",6611);
//        HostAndPort hostAndPort2=new HostAndPort("10.91.19.31",6613);
//        set.add(hostAndPort);
//        set.add(hostAndPort1);
//        set.add(hostAndPort2);
//        JedisCluster jedisCluster=new JedisCluster(set,5000,2000,5,"Ldyop@10101100","test",new GenericObjectPoolConfig());
//        System.out.println(JSONObject.toJSONString(jedisCluster.hgetAll("ZUGOU.GENERAL.SESSION.5407578c73d341a39209b2a85832d505")));
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostConstruct
    public void getTest() {
        ValueOperations str = redisTemplate.opsForValue();
        HashOperations hash = redisTemplate.opsForHash();
        ListOperations list = redisTemplate.opsForList();
        SetOperations set = redisTemplate.opsForSet();
        ZSetOperations zset = redisTemplate.opsForZSet();


    }
}
