package com.rajsuman.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExecutorProvider {
    private static final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    public static ExecutorService getExecutor() {
        return executor;
    }
}