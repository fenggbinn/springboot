package com.atguigu.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})//相当于Junit4里面的@RunWith注解
 */
@SpringBootTest
@DisplayName("junit5的测试")
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName(){
        System.out.println("测试方法1@dispalyNametest ");
    }
    @Disabled//禁用某一个测试方法
    @Test
    void test2(){
        System.out.println("测试方法2");
    }
    @BeforeEach
    public void testBeforeEach(){
        System.out.println("@BeforeEach测试马上要开始了");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("@AfterEach测试结束啦");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("@BeforeAll所有测试方法之前");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("@AfterAll所有测试都结束啦");
    }

    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        //Thread.sleep(500);
        System.out.println("@Timeout超时测试注解");
    }

    @Test
    void test3_before(){
        System.out.println("输出jdbcTemplate的值："+jdbcTemplate);
    }
    @RepeatedTest(5)
    @Test
    void test3(){
        System.out.println("@RepeatedTest(5)这个测试是测试执行了5次");
    }

    @Disabled
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(2,3);
        assertEquals(5,cal);
        //assertEquals(6,cal);
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2);
    }
    int cal(int i,int j){
        return i+j;
    }

    @DisplayName("假设失败测试")
    @Test
    void testAssu(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    }
}
