package cn.tedu.sp04.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sp01.pojo.Item;
import sp01.pojo.Order;
import sp01.pojo.TestRedis;
import sp01.pojo.User;
import sp01.service.OrderService;
import sp01.service.TestRedisService;
import web.util.JsonResult;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class TestRedisController {
    @Autowired
    private TestRedisService testRedisService;
    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/TestRedis")
    public JsonResult<TestRedis> getOrder(Integer id) {
        log.info("get redis, id=" + id);
        String key = "aa:bb:cc:01";
        RLock rLock =redissonClient.getLock(key);
        try{// 尝试加锁，最多等待1秒，上锁以后10秒自动解锁<br>// 没有Watch Dog ，10s后自动释放
            boolean res = rLock.tryLock(10, TimeUnit.SECONDS);
            if(!res){
                 return JsonResult.err("锁未释放");
            }else {
                for (int i = 0; i < 3; i++) {
                    String name = Thread.currentThread().getName();
                    System.out.println("currentThread--->"+name);
                    Thread.currentThread().sleep(10000);
                }
                TestRedis testRedis = testRedisService.selectRedis(id);
                return JsonResult.ok(testRedis);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return JsonResult.err("锁未释放");
        } finally{
            rLock.unlock();
        }
    }


}
