/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.message;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * <code>Receiver</code>
 * </p>
 * Description:
 * 1)defines a method for receiving messages
 * 2)register the Receiver as a message listener
 * @author Mcchu
 * @date 2018/2/24 9:32
 */
@Log4j
public class Receiver {

    // 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
        latch.countDown();
    }
}
