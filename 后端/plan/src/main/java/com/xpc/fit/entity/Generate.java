package com.xpc.fit.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 生成计划的一些细节
 */
@Data
@Entity
public class Generate {
    @Id
    private Integer id;
    /**
     * 性别 女:0  男:1
     */
    private Integer sex;
    /**
     * 目的 减脂:0 增肌:1
     */
    private Integer goal;
    /**
     * 健康状况 优:A 良:B 差:C
     */
    private String health;
    /**
     * 训练方式 健身房:A 哑铃:B 徒手:C
     */
    private String training;
    /**
     * 训练强度 强:A 中:B 弱:C
     */
    private String strength;
    /**
     * 请求对应的用户id
     */
    private Integer personId;
    /**
     * 请求者的ip
     */
    private String ip;
    /**
     * 生成计划的日期
     */
    private String date;
    /**
     * 用户从发起请求至生成完计划 操作的总耗时
     */
    private String costTime;
}
