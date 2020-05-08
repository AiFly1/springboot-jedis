package cn.aiccfly.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisTest {

    //带泛型的模板
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    //不带泛型的模板
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //不带泛型的模板
    @Test
    public void testStringRedisTemplate(){
        //1. 获取Operation对象
        ValueOperations<String, String> oprations = stringRedisTemplate.opsForValue();

        //2. 设置值
        oprations.set("dog","wangwang");

        //3. 获取值
        String dog = oprations.get("dog");
        System.out.println(dog);


    }
    //①带泛型的模板类1
    @Test
    public void testRedisTemplate(){
        //1. 根据要操作的类型获取Operations对象
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();

        //2. 执行操作
        operations.set("cat","mimi");
    }

    //①带泛型的模板类2
    @Test
    public void testRedisTemplateGet(){
        ValueOperations<Object,Object> operations = redisTemplate.opsForValue();
        Object cat = operations.get("cat");
        System.out.println(cat);
    }


}
