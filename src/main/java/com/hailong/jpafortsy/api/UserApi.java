package com.hailong.jpafortsy.api;

import com.hailong.jpafortsy.dbmodel.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi  {

    @ApiOperation(value="用户列表", notes="用户列表")
    @RequestMapping(value={"/list"}, method= RequestMethod.GET)
    public List<User> getUsers(String t) {
        List<User> users = new ArrayList<>();
        User e = new User();
        e.setUserName(t);
        users.add(e);
        return users;
    }

    @ApiOperation(value="用户详情", notes="根据id获取用户详情")
    @RequestMapping(value={"/getUser"}, method= RequestMethod.GET)
    public User getUser() throws Exception {
        String str= null;
//        System.out.println(str.length());
            throw new Exception("故意抛出的异常！");
    }

}
