package com.zhang.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.dao.UserDao;
import com.zhang.pojo.User;
import com.zhang.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService{

}
