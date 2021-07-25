package com.company.commands;

import com.company.models.Order;
import com.company.models.OrderLog;
import com.company.models.User;

import java.util.List;

public class ViewOrderHistoryCommand extends AbstractMemberCommand
{
    @Override
    public boolean execute(String[] args)
    {
        User user = getLoggedInUser();
        List<Order> orders = OrderLog.getInstance().getOrderHistory(user);
        System.out.println("Your order history:");
        orders.stream().map(Order::toString).forEach(System.out::println);
        return true;
    }
}
