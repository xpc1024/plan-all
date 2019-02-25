package com.xpc.fit.service;

import com.xpc.fit.entity.Generate;

import javax.servlet.http.HttpServletResponse;

/**
 * 生成计划
 */
public interface GenerateService {
    void generate(Generate generate);
    void download(String path, String name, HttpServletResponse response);
}
