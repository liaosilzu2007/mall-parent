package com.lzumetal.mall.provider.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzumetal.mall.api.service.UserService;
import com.lzumetal.mall.pojo.User;
import com.lzumetal.mall.StartupApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liaosi
 * @date 2018-08-26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartupApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserTest {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setName("zhangsan");
        user.setPhone("13800138000");
        userService.insert(user);
        System.err.println("新增用户成功！");
        System.out.println(gson.toJson(user));
    }
}
