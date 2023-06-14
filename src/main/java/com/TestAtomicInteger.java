package com;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YeeDer
 * @since 2023/6/14 PM 12:04
 **/
public class TestAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        do {
            int i = atomicInteger.incrementAndGet();
            System.out.println("i = " + i + " atomicInteger.get = " + atomicInteger.get());
            System.out.println("========");
        } while (atomicInteger.get() != 5);


    }
}
