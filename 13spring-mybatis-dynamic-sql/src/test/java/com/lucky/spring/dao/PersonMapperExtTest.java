package com.lucky.spring.dao;

import com.lucky.spring.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhangdd on 2020/8/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonMapperExtTest {

    @Autowired
    PersonMapperExt mapperExt;

    @Test
    public void batchUpdate() throws Exception {
        List<Person> people = new ArrayList<>();
        people.add(new Person());
        if (people.size()<=0){
            return;
        }
        mapperExt.batchUpdate(people);
    }

}