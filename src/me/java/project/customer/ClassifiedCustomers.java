package me.java.project.customer;

import me.java.project.group.GroupType;
import me.java.project.menu.OrderType;

import java.util.Arrays;

import static me.java.project.group.GroupType.groupTypes;

public class ClassifiedCustomers {
    Customers[] classifiedArr = new Customers[GroupType.values().length + 1]; //3 일반적인걸로 바꿔라

    public ClassifiedCustomers() {
        for (int i = 0; i < GroupType.values().length; i++) {
            classifiedArr[i] = new Customers();
        }
    }

    public void groupByClass(Customers customerArr) {

        for (Customers css : classifiedArr) {
            System.out.println(css);
        }

        for (Customer customer : customerArr.getCleanCustomers()) {
            if (customer.getSpentTime() >= 30 && customer.getTotalPay() >= 30000) {
                classifiedArr[GroupType.VVIP.ordinal()].customerAdd(customer);

            } else if (customer.getSpentTime() >= 20 && customer.getTotalPay() >= 20000) {
                classifiedArr[GroupType.VIP.ordinal()].customerAdd(customer);
            } else if (customer.getSpentTime() >= 10 && customer.getTotalPay() >= 10000) {
                classifiedArr[GroupType.GENERAL.ordinal()].customerAdd(customer);
            } else {
                classifiedArr[classifiedArr.length - 1].customerAdd(customer);
            }
        }

    }

    public void sortedByName(OrderType orderType) {

        for (int i = 0; i < classifiedArr.length; i++) {

            if (classifiedArr[i] != null) {
                System.out.println("===================================");

                //classifiedArr[i].customers = Arrays.copyOf(classifiedArr[i].customers, classifiedArr[i].size); 이걸로 하면 원래 배열이 바뀜. 그래서 복사함. 근데 깊복 안된다고 하지 않았음?
                System.out.println(groupTypes[i]);
                Customer[] newArr = Arrays.copyOf(classifiedArr[i].customers,classifiedArr[i].size);
                if (orderType.equals(OrderType.ASCENDING)){
                    Arrays.sort(newArr);
                }
                else if(orderType.equals(OrderType.DESCENDING)){
                    Arrays.sort(newArr,new ComparatorByNameD());
                }
                for (Customer ns : newArr) {
                    System.out.println(ns);
                }
            }
        }
    }

    public void sortedByTime(OrderType orderType) {

        for (int i = 0; i < classifiedArr.length; i++) {

            if (classifiedArr[i] != null) {

                System.out.println("===================================");
                System.out.println(groupTypes[i]);
                Customer[] newArr = Arrays.copyOf(classifiedArr[i].customers,classifiedArr[i].size);
                if (orderType.equals(OrderType.ASCENDING)){
                    Arrays.sort(newArr, new ComparatorByTimeA());
                }
                else if(orderType.equals(OrderType.DESCENDING)){
                    Arrays.sort(newArr,new ComparatorByTimeD());
                }
                for (Customer ns : newArr) {
                    System.out.println(ns);
                }
            }
        }
    }

    public void sortedByPay(OrderType orderType) {

        for (int i = 0; i < classifiedArr.length; i++) {

            if (classifiedArr[i] != null) {
                System.out.println("===================================");

                System.out.println(groupTypes[i]);
                Customer[] newArr = Arrays.copyOf(classifiedArr[i].customers,classifiedArr[i].size);
                if (orderType.equals(OrderType.ASCENDING)){
                    Arrays.sort(newArr,new ComparatorByPayA());
                }
                else if(orderType.equals(OrderType.DESCENDING)){
                    Arrays.sort(newArr,new ComparatorByPayD());
                }
                for (Customer ns : newArr) {
                    System.out.println(ns);
                }
            }
        }
    }
}


