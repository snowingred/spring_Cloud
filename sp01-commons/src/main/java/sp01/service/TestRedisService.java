package sp01.service;

import sp01.pojo.TestRedis;

public interface TestRedisService {
   int insertRedis(TestRedis testRedis);
   int updateRedis(TestRedis testRedis);
   TestRedis  selectRedis(int id);
}
