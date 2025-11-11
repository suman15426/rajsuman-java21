 package com.rajsuman.service;

import com.rajsuman.model.TeaOrder;
import com.rajsuman.util.Logger;
import com.rajsuman.util.StringService;

public class TeaOrderService implements Runnable {
    private final TeaOrder order;

    public TeaOrderService(TeaOrder order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            // 🔹 Existing formatted log (used for console + orders.txt)
            String formattedLog = StringService.formatOrderLog(order.customerName(), order.flavor(), order.quantity());
            System.out.println(formattedLog); // This MUST be here
            Logger.logToFile(formattedLog);   // Writes to orders.txt

            // New timestamped log (used for orders.log)
            String timestampedLog = "[" + java.time.LocalDateTime.now() + "] Order from "
                                  + order.customerName() + ": "
                                  + order.quantity() + " x "
                                  + order.flavor();
            Logger.logOrder(timestampedLog); // Writes to orders.log

        } catch (Exception e) {
            System.err.println("Thread error: " + e.getMessage());
        }
    }
}