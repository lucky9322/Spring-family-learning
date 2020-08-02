package com.lucky.spring.dao.bar;

import com.lucky.spring.model.bar.TPermission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);

    List<TPermission> queryList();
}