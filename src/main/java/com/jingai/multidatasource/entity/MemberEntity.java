package com.jingai.multidatasource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("tb_member")
public class MemberEntity {

    private int id;

    private String name;

    private int age;

    private Date createTime;
}
