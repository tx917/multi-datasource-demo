package com.jingai.multidatasource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jingai.multidatasource.entity.UserEntity;
import com.jingai.multidatasource.service.UserService;
import com.jingai.multidatasource.test2.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Resource
    private UserMapper userMapper;

    public IPage<UserEntity> listByPage(Integer pageIndex, Integer pageSize) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>();
//        queryWrapper.orderByDesc(UserEntity::getId);
        Page<UserEntity> page = new Page<>(pageIndex, pageSize);
        return userMapper.selectPage(page, queryWrapper);
    }

}
