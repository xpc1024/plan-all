package com.xpc.fit.service;

import com.xpc.fit.entity.Generate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 生成计划
 */
public interface GenerateService {

    Map<String,String> generate(Generate generate);

    void download(String path, String name, HttpServletResponse response);
}
