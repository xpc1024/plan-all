package com.xpc.fit.service;

import com.xpc.fit.entity.Person;

import java.util.Map;

/**
 * 收集个人信息
 */
public interface PersonService {
    Map<String,Integer> save(Person person);
}
