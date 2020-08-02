package com.lucky.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by zhangdd on 2020/7/13
 */
@Configuration
@Slf4j
@MapperScan(basePackages = "com.lucky.spring.dao.bar", sqlSessionFactoryRef = "barSqlSessionFactory")
public class BarDataSourceConfig {

    static final String MAPPER_LOCATION = "classpath:mapper/bar/*.xml";

    //=========bar 数据源相关配置 start==================================================

    @Bean
    @ConfigurationProperties("datasource.bar")
    public DataSourceProperties barDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 得到数据源
     *
     * @return
     */
    @Bean("barDataSource")
    public DataSource barDataSource() {
        DataSourceProperties dataSourceProperties = barDataSourceProperties();
        log.info("bar datasource url:{}", dataSourceProperties.getUrl());
        log.info("{}", dataSourceProperties.getType().getName());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean("barSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("barDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }


    /**
     * bar 对应的数据库会话模版
     *
     * @param sessionFactory
     * @return
     */
    @Bean("barSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("barSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }


    @Bean
    @Resource
    public DataSourceTransactionManager barTxManager(@Qualifier("barDataSource") DataSource barDatasource) {
        return new DataSourceTransactionManager(barDatasource);
    }

    //=========bar 数据源相关配置 end==================================================

}
