package com.jingai.multidatasource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jingai.multidatasource.entity.MemberEntity;
import com.jingai.multidatasource.service.MemberService;
import com.jingai.multidatasource.test1.dao.MemberMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    public IPage<MemberEntity> listByPage(Integer pageIndex, Integer pageSize) {
        LambdaQueryWrapper<MemberEntity> queryWrapper = new LambdaQueryWrapper<MemberEntity>();
        queryWrapper.orderByDesc(MemberEntity::getId);
        Page<MemberEntity> page = new Page<>(pageIndex, pageSize);
        return memberMapper.selectPage(page, queryWrapper);
    }

}
