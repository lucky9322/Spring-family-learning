package com.lucky.spring.service.impl;

import com.lucky.spring.model.T;
import com.lucky.spring.service.DataOpeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdd on 2020/7/12
 */
@Service
public class DataOpeServiceImpl implements DataOpeService {

    private Logger logger = LoggerFactory.getLogger(DataOpeServiceImpl.class);

    @Autowired
    private JdbcTemplate template;


    @Override
    public String queryData() {
        String sql = "select * from t where id=1";
        RowMapper<T> data = new BeanPropertyRowMapper<>(T.class);
        T t = template.queryForObject(sql, data);
        return t.toString();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addData() throws Exception{
        List<T> data = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            T item = new T();
            item.setA(i);
            item.setB(i);
            data.add(item);
        }
        for (int i = 0; i < data.size(); i++) {
            String sql = "insert into t(a,b) values (" + data.get(i).getA() + "," + data.get(i).getB() + ")";
            logger.info("sql:{}", sql);
            if (data.get(i).getA() == 1) {
//                throw new NullPointerException("人为抛出运行时异常异常");
                throw new FileNotFoundException("人为抛出非运行时异常");
            }
            template.execute(sql);
        }
        return null;
    }
}
