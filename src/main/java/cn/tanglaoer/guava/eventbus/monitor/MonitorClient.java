package cn.tanglaoer.guava.eventbus.monitor;

import com.google.common.eventbus.EventBus;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @date 2023/4/24
 */
public class MonitorClient {
    public static void main(String[] args) throws Exception {
        EventBus eventBus = new EventBus();
        eventBus.register(new FileChangeListener());
        DirectoryTargetMonitor monitor = new DirectoryTargetMonitor(eventBus, "F:\\demo\\guava-demo\\monitor");
        monitor.startMonitor();
    }
}
