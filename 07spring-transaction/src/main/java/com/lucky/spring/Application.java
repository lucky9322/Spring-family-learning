package com.lucky.spring;

import com.lucky.spring.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by zhangdd on 2020/7/26
 */
@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {

//        log.info("default transaction manage:{}", transactionTemplate.getTransactionManager().getClass().getSimpleName());
//
//        log.info("count before transaction:{}", getCount());
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                jdbcTemplate.execute("insert into product(name,description) values ('spring boot in action','书籍 spring boot in action') ");
//                log.info("count in transaction:{}", getCount());
//                transactionStatus.setRollbackOnly();
//            }
//        });
//        log.info("count after transaction:{}", getCount());

        try {


//        productService.insertRecord();
//            productService.insertThenRollback();
//        productService.invokeInsertThenRollback();
        productService.insertRecordWhenCrash();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long getCount() {
        return (long) jdbcTemplate.queryForList("select count(*) as cnt from product")
                .get(0).get("cnt");
    }
}