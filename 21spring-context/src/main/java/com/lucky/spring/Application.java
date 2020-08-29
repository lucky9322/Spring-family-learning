package com.lucky.spring;

import com.lucky.spring.config.ManConfig;
import com.lucky.spring.entity.Man;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //getBeanFromResourcesFile();

        //getBeanFromSystemFile();

        getBeanFromAnnotation();

    }

    /**
     * 加载配置文件，获取bean
     */
    private void getBeanFromResourcesFile() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new
                String[]{"applicationContext.xml"});
        Man bean = context.getBean(Man.class);
        bean.work();

        Man man = context.getBean("man", Man.class);
        man.work();
        //是单例模式创建的Bean
        log.info("bean.equals(man):{}", bean.equals(man));

        log.info("bean car status:{}", man.getCar().equals(context.getBean("qqCar")));
    }

    /**
     * FileSystemXmlApplicationContext方法对路径进行了处理:
     * 用绝对路径时,第一个斜杠会被去掉(也是不知道为什么,我勒个去),所以如果是在Linux系统或者max系统下的绝对路径需要
     * 给在绝对路径前再加个斜杠解决问题,代码通过
     * @see FileSystemXmlApplicationContext#getResourceByPath
     */
    private void getBeanFromSystemFile() {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "//Users/lucky/java/spring/21spring-context/src/main/resources/applicationContext.xml");
        Man bean = context.getBean(Man.class);
        bean.work();

        Man man = context.getBean("man", Man.class);
        man.work();
        //是单例模式创建的Bean
        log.info("bean.equals(man):{}", bean.equals(man));

        log.info("bean car status:{}", man.getCar().equals(context.getBean("qqCar")));
    }

    /**
     * 基于注解，获取bean
     */
    private void getBeanFromAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ManConfig.class);

        Man bean = context.getBean(Man.class);
        bean.work();

        Man man = context.getBean("man", Man.class);
        man.work();
        //是单例模式创建的Bean
        log.info("bean.equals(man):{}", bean.equals(man));

        log.info("bean car status:{}", man.getCar().equals(context.getBean("car")));
    }
}
