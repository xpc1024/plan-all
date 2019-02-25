package com.xpc.fit.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.xpc.fit.entity.Generate;
import com.xpc.fit.service.GenerateService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;

/**
 * 生成计划
 */
@Service
public class GenerateServiceImpl implements GenerateService {
    @Override
    public void generate(Generate generate) {

    }

    @Override
    public void download(String path, String name, HttpServletResponse response) {
        try {
            String filePath = "plan/0/0/A/A/A/训练计划.doc";
            BufferedInputStream in = FileUtil.getInputStream(filePath);
//            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + "traning.doc");
            response.getOutputStream().write(IoUtil.readBytes(in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
