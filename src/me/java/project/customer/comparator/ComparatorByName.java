package me.java.project.customer.comparator;

import me.java.project.customer.Customer;
import me.java.project.menu.OrderType;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Customer> {

    public OrderType option;

    public void setOption(OrderType option) {
        this.option = option;
    }

    @Override
    public int compare(Customer o1, Customer o2) {
        if (option.equals(OrderType.ASCENDING)) {
            return o1.getUserName().compareTo(o2.getUserName());
        } else {
            return o1.getUserName().compareTo(o2.getUserName()) * (-1);
        }
    }
}
