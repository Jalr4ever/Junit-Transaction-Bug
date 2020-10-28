package com.jalr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jalr.dao.UserMapper;
import com.jalr.pojo.entity.User;
import com.jalr.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description
 * @date 2020-10-23 14:24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
