package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public Page<User> findAllUser(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<User>)userMapper.selectAll();
    }

    @Override
    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);

    }

    @Override
    public void insertUser(User user) throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        user.setRegisterTime(date);
        if (this.findUser(user.getEmail()).size() == 0) {
            userMapper.insertSelective(user);
        } else {
            throw new Exception("邮箱地址已存在");
        }
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<User> findSearchPage(Integer page, Integer size, User user) {
        PageHelper.startPage(page, size);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (user != null) {
            if (!StringUtil.isEmpty(user.getEmail())) {
                criteria.andLike("email", "%" + user.getEmail() + "%");
            }
        }
        List<User> pageProject = userMapper.selectByExample(example);
        return (Page<User>)pageProject;
    }

    @Override
    public List findUser(String email) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("email", email);
        return userMapper.selectByExample(example);
    }
}
