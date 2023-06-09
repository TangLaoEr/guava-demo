package cn.tanglaoer.guava.eventbus.test;

import cn.tanglaoer.guava.eventbus.internal.MySubscribe;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/4/26
 */
public class MySimpleListener2 {
    @MySubscribe
    public void test1(String x) {
        System.out.println("MySimpleListener2===test1===" + x);
    }

    @MySubscribe(topic = "alex-topic")
    public void test2(Integer x) {
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MySimpleListener2===test2===" + x);
    }

    @MySubscribe(topic = "test-topic")
    public void test3(Integer x) {
        throw new RuntimeException();
    }
}
