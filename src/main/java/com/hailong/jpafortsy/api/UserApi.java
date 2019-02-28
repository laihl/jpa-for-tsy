package com.hailong.jpafortsy.api;

import com.hailong.jpafortsy.bean.ResultAll;
import com.hailong.jpafortsy.dao.UserDao;
import com.hailong.jpafortsy.dao.UserDaoTemplat;
import com.hailong.jpafortsy.dbmodel.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi  {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value="用户列表", notes="用户列表")
    @RequestMapping(value={"/list"}, method= RequestMethod.GET)
    public List<User> getUsers(String t) {

        return null;
    }

    @ApiOperation(value="用户详情", notes="根据id获取用户详情")
    @RequestMapping(value={"/getUser"}, method= RequestMethod.GET)
    public User getUser() throws Exception {
        String str= null;
//        System.out.println(str.length());
            throw new Exception("故意抛出的异常！");
    }

    @ApiOperation(value="新增用户", notes="---")
    @RequestMapping(value={"/add"}, method= RequestMethod.GET)
    @Transactional
    public ResultAll add(String name) throws Exception {
        User user = new User();
        user.setUserName(name);
        userDao.addUser(user);
        if(true){
            //事务测试
            throw new RuntimeException("test");
        }
        return new ResultAll();
    }
    @Autowired
    private UserDaoTemplat templat;
    @ApiOperation(value="新增用户2", notes="UserDaoTemplat ;")
    @RequestMapping(value={"/add2"}, method= RequestMethod.GET)
    @Transactional
    public ResultAll add2(String name) throws Exception {
        User user = new User();
        user.setUserName(name);
        templat.addUser(user);
//        throw new RuntimeException("test");
        return new ResultAll();
    }

}
