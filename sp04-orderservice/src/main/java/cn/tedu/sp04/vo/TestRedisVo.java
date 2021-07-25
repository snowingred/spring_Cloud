package cn.tedu.sp04.vo;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import sp01.pojo.Item;
import sp01.pojo.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="test_redis")
public class TestRedisVo {
    @TableId(value = "id")
    private String id;
    private String name;
}
