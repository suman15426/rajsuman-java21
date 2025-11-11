package com.rajsuman;

import com.rajsuman.executor.VirtualThreadExecutorProvider;
import com.rajsuman.model.TeaOrder;
import com.rajsuman.service.TeaOrderService;
import com.rajsuman.util.Logger;

import java.util.concurrent.ExecutorService;

public class TeaOrderSimulator {

    // 🔹 Add this at the top of the class
    private static final String[] FLAVORS = {
        "Masala Chai", "Tulsi Green", "Cardamom Bliss", "Ginger Spark", "Rose Elixir"
    };

    private static String getRandomFlavor() {
        int index = (int) (Math.random() * FLAVORS.length);
        return FLAVORS[index];
    }

    public static void main(String[] args) {
        System.out.println("☕ RajSuman Tea Simulation Begins — where every sip tells a story...");
        System.out.println("[INFO] Simulation started at " + java.time.LocalDateTime.now());
        System.out.println("Simulating 1000 student orders... Please wait.\n");

        ExecutorService executor = com.rajsuman.executor.VirtualThreadExecutorProvider.getExecutor();
        Logger.logError("\n--- Simulation Run at " + java.time.LocalDateTime.now() + " ---");
        Logger.logToFile("\n--- Simulation Run at " + java.time.LocalDateTime.now() + " ---");
        for (int i = 1; i <= 1000; i++) {
            try {
            	//if (i == 42) throw new RuntimeException("Simulated failure");

                TeaOrder order = new TeaOrder("Student" + i, getRandomFlavor(), 1);
                executor.submit(new TeaOrderService(order));
            } catch (Exception e) {
                Logger.logError("Failed to submit order for Student" + i + ": " + e.getMessage());
            }
        }


        executor.shutdown();
        executor.shutdown();
        try {System.out.println("Thread.sleep((int)(Math.random() * 100000000000));"); // ← This prints the line literally
            if (!executor.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS)) {
                System.err.println("Some threads didn't finish in time.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}