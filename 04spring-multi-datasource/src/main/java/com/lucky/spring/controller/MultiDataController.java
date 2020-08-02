package com.lucky.spring.controller;

import com.lucky.spring.dao.bar.TPermissionMapper;
import com.lucky.spring.dao.foo.FooMapper;
import com.lucky.spring.model.bar.TPermission;
import com.lucky.spring.model.foo.Foo;
import com.lucky.spring.vo.MultiDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangdd on 2020/7/14
 */
@RestController
public class MultiDataController {

    @Autowired
    TPermissionMapper permissionMapper;

    @Autowired
    FooMapper fooMapper;

    @GetMapping("/api/getData")
    public MultiDataVo getData() {
        List<TPermission> tPermissions = permissionMapper.queryList();
        List<Foo> foos = fooMapper.queryList();
        MultiDataVo dataVo = new MultiDataVo();
        dataVo.setFoos(foos);
        dataVo.setPermissions(tPermissions);
        return dataVo;
    }
}
