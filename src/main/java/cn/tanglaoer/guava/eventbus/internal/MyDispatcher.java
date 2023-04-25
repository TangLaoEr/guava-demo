package cn.tanglaoer.guava.eventbus.internal;

import com.sun.jdi.PrimitiveValue;
import jdk.swing.interop.DispatcherWrapper;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @date 2023/4/25
 */
public class MyDispatcher {
    private final Executor executorService;

    private final MyEventExceptionHandler exceptionHandler;

    public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

    public static final Executor PRE_THREAD_EXECUTOR_SERVICE = PreThreadExecutorService.INSTANCE;

    public MyDispatcher(Executor executorService, MyEventExceptionHandler exceptionHandler) {
        this.executorService = executorService;
        this.exceptionHandler = exceptionHandler;
    }

    public void dispatch(Bus bus, MyRegistry registry, Object event, String topic) {

    }

    public void close() {
        if (executorService instanceof ExecutorService) {
            ((ExecutorService) executorService).shutdown();
        }
    }

    static MyDispatcher newDispatcher(MyEventExceptionHandler exceptionHandler,
                                             Executor executor) {
        return new MyDispatcher(executor, exceptionHandler);
    }

    static MyDispatcher seqDispatcher(MyEventExceptionHandler exceptionHandler) {
        return new MyDispatcher(SEQ_EXECUTOR_SERVICE, exceptionHandler);
    }

    static MyDispatcher preThreadDispatcher(MyEventExceptionHandler exceptionHandler) {
        return new MyDispatcher(PRE_THREAD_EXECUTOR_SERVICE, exceptionHandler);
    }

    private static class SeqExecutorService implements Executor {
        private final static SeqExecutorService INSTANCE = new SeqExecutorService();
        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    private static class PreThreadExecutorService implements Executor {
        private final static SeqExecutorService INSTANCE = new SeqExecutorService();
        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }
}
