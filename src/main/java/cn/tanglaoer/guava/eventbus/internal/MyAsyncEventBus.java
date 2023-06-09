package cn.tanglaoer.guava.eventbus.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/4/26
 */
public class MyAsyncEventBus extends MyEventBus {
    public MyAsyncEventBus(String busName, MyEventExceptionHandler exceptionHandler,
                           ThreadPoolExecutor executor) {
        super(busName, exceptionHandler, executor);
    }

    public MyAsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName, null, executor);
    }

    public MyAsyncEventBus(ThreadPoolExecutor executor) {
        this("default-async", null, executor);
    }

    public MyAsyncEventBus(MyEventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        this("default-async", exceptionHandler, executor);
    }

}
