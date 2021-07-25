package cn.tedu.sp03.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;


import sp01.pojo.User;
import sp01.service.UserService;
import web.util.JsonUtil;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    /*@Value("${sp.user-service.users}")
    private String userJson;*/

    @Override
    public User getUser(Integer id) {
        String userJson="[{\"id\":7, \"username\":\"abc\",\"password\":\"123\"},{\"id\":8, \"username\":\"def\",\"password\":\"456\"},{\"id\":9, \"username\":\"ghi\",\"password\":\"789\"}]";
        log.info("users json string : " + userJson);
        List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>() {
        });
        for (User u : list) {
            if (u.getId().equals(id)) {
                return u;
            }
        }

        return new User(id, "name-" + id, "pwd-" + id);
    }

    @Override
    public void addScore(Integer id, Integer score) {
        // 这里增加积分
        log.info("user " + id + " - 增加积分 " + score);
    }

}
