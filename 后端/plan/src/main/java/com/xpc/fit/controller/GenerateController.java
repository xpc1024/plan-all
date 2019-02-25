package com.xpc.fit.controller;

import com.xpc.fit.entity.Generate;
import com.xpc.fit.result.Result;
import com.xpc.fit.result.SuccessResult;
import com.xpc.fit.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


/**
 * 计划
 */
@RestController
public class GenerateController {
    @Autowired
    private GenerateService generateService;

    @RequestMapping("/generate")
    public Object generate(Generate generate) {
        generateService.generate(generate);
        return new SuccessResult();
    }

    @RequestMapping("/download")
    public Result download(String path, String name, HttpServletResponse response) {
        generateService.download(path, name, response);
        return new SuccessResult();
    }
}
