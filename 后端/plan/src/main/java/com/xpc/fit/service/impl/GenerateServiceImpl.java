package com.xpc.fit.service.impl;

import cn.hutool.core.io.IoUtil;
import com.xpc.fit.entity.Generate;
import com.xpc.fit.exception.ExceptionEnum;
import com.xpc.fit.exception.MyException;
import com.xpc.fit.repository.GenerateRepository;
import com.xpc.fit.service.GenerateService;
import com.xpc.fit.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成计划
 */
@Service
public class GenerateServiceImpl implements GenerateService {
    @Resource
    private GenerateRepository generateRepository;
    private static final String FOLDER_NAME = "plan";
    //    private static final String SEPARATOR = File.separator;
    private static final String SEPARATOR = "/";
    private final static Logger logger = LoggerFactory.getLogger(GenerateServiceImpl.class);

    @Override
    public Map<String, String> generate(Generate generate) {
        String path = SEPARATOR + generate.getSex() + SEPARATOR + generate.getGoal() + SEPARATOR + generate.getHealth() + SEPARATOR + generate.getTraining() + SEPARATOR + generate.getStrength() + SEPARATOR;
        Map<String, String> map = new HashMap<>();
        map.put("path", path);
        generateRepository.save(generate);
        return map;
    }

    @Override
    public void download(String path, String name, HttpServletResponse response) {
        try {
            String filePath = FOLDER_NAME + path + name;
            ClassPathResource resource = new ClassPathResource(filePath);
            BufferedInputStream in = new BufferedInputStream(resource.getInputStream());
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(name, "UTF-8"));
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");
            response.getOutputStream().write(IoUtil.readBytes(in));
        } catch (Exception e) {
            logger.error("下载压缩包失败:", e);
            throw new MyException(ExceptionEnum.DOWNLOAD_FAIL);
        }
    }
}
