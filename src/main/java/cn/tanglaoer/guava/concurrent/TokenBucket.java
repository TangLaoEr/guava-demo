package cn.tanglaoer.guava.concurrent;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 令牌桶
 * @author <a href="https://github.com/TangLaoEr">tks</a>
 * @Date 2023/4/28
 */
public class TokenBucket {
    private AtomicInteger phoneNumber = new AtomicInteger(0);

    private final static int LIMIT = 100;

    private RateLimiter rateLimiter = RateLimiter.create(10);

    private final int saleLimit;

    public TokenBucket() {
        this(LIMIT);
    }

    public TokenBucket(int limit) {
        this.saleLimit = limit;
    }

    public int buy() {

        Stopwatch started = Stopwatch.createStarted();
        boolean success = rateLimiter.tryAcquire(10, TimeUnit.SECONDS);
        if (success) {
            if (phoneNumber.get() >= saleLimit) {
                throw new IllegalStateException("Not any phone can be sale, please wait to next time.");
            }
            int phoneNo = phoneNumber.getAndIncrement();
            handleOrder();
            System.out.println(Thread.currentThread() + " user get the Mi phone: " + phoneNo + ",ELT:" + started.stop());
            return phoneNo;
        }else {
            started.stop();
            throw new RuntimeException("Sorry, occur exception when buy phone");
        }
    }

    private void handleOrder() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
