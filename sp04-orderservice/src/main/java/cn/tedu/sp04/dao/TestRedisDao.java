package cn.tedu.sp04.dao;

import cn.tedu.sp04.vo.TestRedisVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import sp01.pojo.Order;

@Mapper
public interface TestRedisDao extends BaseMapper<TestRedisVo> {
}
