/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * <code>Receiver</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/2/24 14:42
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public void receiveMessage111(String message) {
        System.out.println("Received111 <" + message + ">");
        // 当我们调用一次CountDownLatch的countDown方法时，N就会减1，
        // CountDownLatch的await会阻塞当前线程，直到N变成零，这里的N=1
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}