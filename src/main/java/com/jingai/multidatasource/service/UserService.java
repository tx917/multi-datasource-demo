package com.jingai.multidatasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jingai.multidatasource.entity.UserEntity;

public interface UserService extends IService< UserEntity> {

    IPage<UserEntity> listByPage(Integer pageIndex, Integer pageSize);

}
