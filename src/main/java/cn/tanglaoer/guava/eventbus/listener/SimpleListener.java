package cn.tanglaoer.guava.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @date 2023/4/23
 */
public class SimpleListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleListener.class);

    @Subscribe
    public void doAction(final String event) {
        if (LOGGER.isInfoEnabled()) {
           LOGGER.info("Received event [{}] and will task a action", event);
        }
    }
}
