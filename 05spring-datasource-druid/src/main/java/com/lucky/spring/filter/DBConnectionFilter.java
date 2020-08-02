package com.lucky.spring.filter;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by zhangdd on 2020/7/20
 * <p>
 * 在连接前后打印日志
 */
@Component
public class DBConnectionFilter extends FilterEventAdapter {

    Logger logger = LoggerFactory.getLogger(DBConnectionFilter.class);

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        logger.info("before connection");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        logger.info("after connection");
    }
}
