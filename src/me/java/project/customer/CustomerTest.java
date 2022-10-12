package me.java.project.customer;

import me.java.project.menu.OrderType;

import java.util.Arrays;

public class CustomerTest {
    public static void main(String[] args) {
        Customers cs = new Customers(5);

        Customer c = new Customer("jisuuu","qwert",10,10000);
        Customer c2 = new Customer("seunghyeon","asdfg",20,20000);
        Customer c3 = new Customer("backjun","zxcvb",30,30000);
        Customer c4 = new Customer("programus","zxcvb",25,30000);

        Customer c5 = new Customer("auhuhu","zxcvb",20,25000);


        cs.customerAdd(c);
        cs.customerAdd(c2);
        cs.customerAdd(c3);
        cs.customerAdd(c4);
        cs.customerAdd(c5);

        System.out.println(cs);

        String name=null;
        int time=0;
        cs.customerUpdate(2,  name,"asdfg",time,30000);

       // Customer deleted = cs.customerDelete(1);


        ClassifiedCustomers cf = new ClassifiedCustomers();
        cf.groupByClass(cs);

        for(Customers css : cf.classifiedArr){
            System.out.println(css);
        }

        cf.sortedByName(OrderType.ASCENDING);
        cf.sortedByName(OrderType.DESCENDING);
        cf.sortedByTime(OrderType.ASCENDING);
        cf.sortedByTime(OrderType.DESCENDING);
        cf.sortedByPay(OrderType.ASCENDING);
        cf.sortedByPay(OrderType.DESCENDING);

        //정렬 후
        System.out.println("정렬 후");
        for(Customers css : cf.classifiedArr){
            System.out.println(css);
        }

    }
}
