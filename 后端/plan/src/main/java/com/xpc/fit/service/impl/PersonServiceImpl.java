package com.xpc.fit.service.impl;

import com.xpc.fit.entity.Person;
import com.xpc.fit.repository.PersonRespository;
import com.xpc.fit.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 收集个人信息
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonRespository personRespository;
    @Override
    public Map<String,Integer> save(Person person) {
        personRespository.save(person);
        Map<String,Integer> map = new HashMap<>();
        map.put("id",person.getId());
        return map;
    }
}
