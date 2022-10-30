package me.java.project.customer.comparator;

import me.java.project.customer.Customer;
import me.java.project.menu.OrderType;

import java.util.Comparator;

public class ComparatorByPay implements Comparator<Customer> {
    public OrderType option;

    public void setOption(OrderType option) {
        this.option = option;
    }

    @Override
    public int compare(Customer o1, Customer o2) {
        if (option.equals(OrderType.ASCENDING)) {
            return o1.getTotalPay() - (o2.getTotalPay());
        } else {
            return o2.getTotalPay() - (o1.getTotalPay());
        }
    }
}
