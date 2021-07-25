package com.company.models;

import java.util.*;

public class OrderLog
{
    private static OrderLog orderLog;

    private Map<String, List<Order>> orderHistory;

    private OrderLog() {
        orderHistory = new HashMap<>();
    }

    public static OrderLog getInstance() {
        if (Objects.nonNull(orderLog)) return orderLog;
        synchronized (OrderLog.class) {
            if (Objects.isNull(orderLog))
                orderLog = new OrderLog();
        }
        return orderLog;
    }

    public void addOrders(User user, List<Order> orders) {
        List<Order> oldHistory = orderHistory.getOrDefault(user.getUserId().toString(), new ArrayList<>());
        oldHistory.addAll(orders);
        orderHistory.put(user.getUserId().toString(), oldHistory);
    }

    public List<Order> getOrderHistory(User user) {
        return orderHistory.getOrDefault(user.getUserId().toString(), new ArrayList<>());
    }
}
