package com.hnsic.jpa;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String s="{\"s\":\"s\"}";
        Object parse = JSON.parse(s);
        System.out.println(parse);
    }

}
