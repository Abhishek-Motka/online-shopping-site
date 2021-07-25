package com.company.commands;

import com.company.models.Member;
import com.company.models.Order;
import com.company.models.OrderLog;

import java.util.List;

public class CheckoutCartCommand extends AbstractMemberCommand
{
    @Override
    public boolean execute(String[] args)
    {
        Member member = (Member) getLoggedInUser();
        List<Order> orders = member.checkout();
        OrderLog.getInstance().addOrders(member, orders);
        orders.stream().map(Order::toString).forEach(System.out::println);
        return true;
    }
}
