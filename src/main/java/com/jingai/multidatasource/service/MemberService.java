package com.jingai.multidatasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jingai.multidatasource.entity.MemberEntity;

public interface MemberService extends IService<MemberEntity> {

    IPage<MemberEntity> listByPage(Integer pageIndex, Integer pageSize);
}
