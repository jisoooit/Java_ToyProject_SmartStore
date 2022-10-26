package me.java.project.customer;

import me.java.project.group.GroupType;
import me.java.project.group.Groups;
import me.java.project.group.Parameter;
import me.java.project.menu.OrderType;
import me.java.project.menu.SummaryType;

public class CustomerTest {
    public static void main(String[] args) {
        Customers cs = new Customers(10);


        Customer c = new Customer("jisuuu", "qwert", 5, 10000);
        Customer c2 = new Customer("seunghyeon", "asdfg", 20, 20000);
        Customer c3 = new Customer("backjun", "zxcvb", 30, 30000);
        Customer c4 = new Customer("programus", "zxcvb", 25, 30000);

        Customer c5 = new Customer("auhuhu", "zxcvb", 20, 25000);


        cs.customerAdd(c);
        cs.customerAdd(c2);
        cs.customerAdd(c3);
        cs.customerAdd(c4);
        cs.customerAdd(c5);

//        System.out.println("showC");
//        cs.showCustomers();
//
//        ClassifiedCustomers2 cf = new ClassifiedCustomers2();
//        cf.groupByClass(cs);
//
//        for(Customers css : cf.classifiedArr){
//            System.out.println(css);
//        }
        

        Groups gs = new Groups();
        int time = 10;
        int pay = 10000;
        gs.setParameter(GroupType.GENERAL, new Parameter(time, pay));
//        gs.setParameter(GroupType.VIP, new Parameter(time+10, pay+10000));
        gs.setParameter(GroupType.VVIP, new Parameter(time + 20, pay + 20000));


        System.out.println("여기");
        //ClassifiedCustomers[] classifiedCustomers = cs.groupByClass(gs);
        ClassfiedCustomersGroup ccg = new ClassfiedCustomersGroup();
        ccg.groupByClass(gs, cs);

        ccg.showSummaryCustomers();
//      cs.showSummaryCustomers(classifiedCustomers);

        ccg.sortedByOrder(OrderType.DESCENDING, SummaryType.TIME);
//      cs.sortedByOrder(classifiedCustomers, OrderType.DESCENDING, SummaryType.NAME );

        System.out.println("변경");
        ccg.showSummaryCustomers();
//        cs.showSummaryCustomers(classifiedCustomers);

    }
}
