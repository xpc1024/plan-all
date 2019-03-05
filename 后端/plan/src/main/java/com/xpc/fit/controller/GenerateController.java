package com.xpc.fit.controller;

import com.xpc.fit.entity.Generate;
import com.xpc.fit.result.Result;
import com.xpc.fit.result.SuccessResult;
import com.xpc.fit.service.GenerateService;
import com.xpc.fit.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * 计划
 */
@RestController
@RequestMapping("/plan")
public class GenerateController {
    @Autowired
    private GenerateService generateService;

    @RequestMapping("/generate")
    public Result generate(Generate generate, HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        generate.setIp(IPUtil.getRealIp(request));
        Map<String, String> map = generateService.generate(generate);
        return new SuccessResult(map);
    }

    @RequestMapping("/download")
    public Result download(String path, String name,HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        generateService.download(path, name, response);
        return null;
    }
}
