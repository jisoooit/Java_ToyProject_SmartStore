package me.java.project.customer;

import java.util.Comparator;
import java.util.Objects;

public class Customer implements Comparable<Customer> {
    protected String serialNum;
    protected String userName;
    protected String userId;
    protected int spentTime;
    protected int totalPay;
    private static int total = 0;

    public Customer() {
        total++;
        this.serialNum = String.format("%05d", total);

    }

    public Customer(String userName, String userId, int spentTime, int totalPay) {
        this.userName = userName;
        this.userId = userId;
        this.spentTime = spentTime;
        this.totalPay = totalPay;
        total++;
        this.serialNum = String.format("%05d", total);

    }

    public String getSerialNum() {
        return serialNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) {
        this.spentTime = spentTime;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return spentTime == customer.spentTime && totalPay == customer.totalPay && userName.equals(customer.userName) && userId.equals(customer.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userId, spentTime, totalPay);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "serialNum=" + serialNum +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", spentTime=" + spentTime +
                ", totalPay=" + totalPay +
                '}';
    }


    @Override
    public int compareTo(Customer o) {
        return this.userName.compareTo(o.getUserName());
    }
}

class ComparatorByNameA implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }
}

class ComparatorByNameD implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getUserName().compareTo(o2.getUserName()) * -1;
    }
}

class ComparatorByTimeA implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getSpentTime() - (o2.getSpentTime());
    }
}

class ComparatorByTimeD implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.getSpentTime() - (o1.getSpentTime());
    }
}

class ComparatorByPayA implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getTotalPay() - (o2.getTotalPay());
    }
}

class ComparatorByPayD implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.getTotalPay() - (o1.getTotalPay());
    }
}

