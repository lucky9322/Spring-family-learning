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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by zhangdd on 2020/7/13
 */
@Configuration
@Slf4j
@MapperScan(basePackages = "com.lucky.spring.dao.foo", sqlSessionFactoryRef = "fooSqlSessionFactory")
public class FooDataSourceConfig {


    static final String MAPPER_LOCATION = "classpath:mapper/foo/*.xml";
    //=========foo 数据源相关配置 start==================================================


    @Bean
    @Primary// 该注解是指当有多个相同的bean时，优先使用用@Primary注解的bean
    @ConfigurationProperties("datasource.foo")
    public DataSourceProperties fooDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 返回 foo 对应的数据源
     *
     * @return
     */
    @Bean("fooDataSource")
    @Primary
    public DataSource fooDataSource() {
        DataSourceProperties dataSourceProperties = fooDataSourceProperties();
        log.info("foo datasource url:{}", dataSourceProperties.getUrl());
        log.info("{}", dataSourceProperties.getType().getName());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


    /**
     * 返回foo 对应数据库的会话工厂
     *
     * @param ds
     * @return
     */
    @Bean(name = "fooSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("fooDataSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    /**
     * foo 对应的数据库会话模版
     *
     * @param sessionFactory
     * @return
     */
    @Bean("fooSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("fooSqlSessionFactory") SqlSessionFactory sessionFactory) {
        log.info("sessionFactory:{}", sessionFactory.toString());
        return new SqlSessionTemplate(sessionFactory);
    }

    /**
     * 返回 foo 对应的数据库事务
     *
     * @param fooDatasource
     * @return
     */
    @Bean
    @Primary
    public DataSourceTransactionManager fooTxManager(@Qualifier("fooDataSource") DataSource fooDatasource) {
        return new DataSourceTransactionManager(fooDatasource);
    }

    //=========foo 数据源相关配置 end==================================================


}
