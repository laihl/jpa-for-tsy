package com.hailong.jpafortsy.api;

import com.hailong.jpafortsy.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi  {

//    @Autowired
//    private UserDao userDao;

    @ApiOperation(value="用户列表", notes="用户列表")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = null;
        return users;
    }


}
