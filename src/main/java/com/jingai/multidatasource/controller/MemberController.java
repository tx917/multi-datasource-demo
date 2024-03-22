package com.jingai.multidatasource.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jingai.multidatasource.entity.MemberEntity;
import com.jingai.multidatasource.entity.UserEntity;
import com.jingai.multidatasource.service.MemberService;
import com.jingai.multidatasource.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MemberController {

    @Resource
    private MemberService memberService;

    @Resource
    private UserService userService;

    @GetMapping("finduser")
    public IPage<UserEntity> findUser() {
        IPage<UserEntity> page = userService.listByPage(1, 20);
        return page;
    }

    @GetMapping("findmember")
    public IPage<MemberEntity> findMember() {
        IPage<MemberEntity> page = memberService.listByPage(1, 20);
        return page;
    }

}
