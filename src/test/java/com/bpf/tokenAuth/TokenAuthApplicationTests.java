package com.bpf.tokenAuth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bpf.tokenAuth.entity.User;
import com.bpf.tokenAuth.mapper.UserMapper;
import com.bpf.tokenAuth.utils.RedisClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TokenAuthApplication.class})
public class TokenAuthApplicationTests {
    
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private UserMapper userMapper;

	@Test
	public void testRedisClient() {
	    System.out.println(redisClient.set(null, "123"));
	    System.out.println(redisClient.get("asd"));
	    System.out.println(redisClient.remove("asd"));
	}
	
	@Test
	public void TestMapper() {
	    User user = userMapper.findByName("npf");
	}

}
