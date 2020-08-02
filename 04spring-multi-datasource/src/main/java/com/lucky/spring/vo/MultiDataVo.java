package com.lucky.spring.vo;

import com.lucky.spring.model.bar.TPermission;
import com.lucky.spring.model.foo.Foo;
import lombok.Data;

import java.util.List;

/**
 * Created by zhangdd on 2020/7/14
 */
@Data
public class MultiDataVo {
    private List<TPermission> permissions;
    private List<Foo> foos;

}
