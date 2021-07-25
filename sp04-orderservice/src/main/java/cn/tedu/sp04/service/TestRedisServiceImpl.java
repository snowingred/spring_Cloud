package cn.tedu.sp04.service;

import cn.tedu.sp04.dao.TestRedisDao;
import cn.tedu.sp04.vo.TestRedisVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp01.pojo.TestRedis;
import sp01.service.TestRedisService;

@Service
public class TestRedisServiceImpl implements TestRedisService {

    @Autowired
    private TestRedisDao testRedisDao;

    @Override
    public int insertRedis(TestRedis testRedis) {
        TestRedisVo testRedisVo = new TestRedisVo();
        BeanUtils.copyProperties(testRedis,testRedisVo);
        int row = testRedisDao.insert(testRedisVo);
        return row;
    }

    @Override
    public int updateRedis(TestRedis testRedis) {
        TestRedisVo testRedisVo = new TestRedisVo();
        BeanUtils.copyProperties(testRedis,testRedisVo);
        int row = testRedisDao.updateById(testRedisVo);
        return row;
    }

    @Override
    public TestRedis selectRedis(int id) {
        TestRedisVo testRedisVo = testRedisDao.selectById(id);
        TestRedis testRedis = new TestRedis();
        BeanUtils.copyProperties(testRedisVo,testRedis);
        return testRedis;
    }
}
