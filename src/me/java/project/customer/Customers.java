package me.java.project.customer;

import java.util.Arrays;
import java.util.Objects;

public class Customers {
    public static final int DEFAULT_CUSTOMER_SIZE = 10;
    private static Customers allCustomers;
    protected Customer[] customers;
    protected int size = 0;  // total customers (saved)
    protected int capacity = 0;  // total size

    public Customers() {
        customers = new Customer[DEFAULT_CUSTOMER_SIZE];
        capacity = DEFAULT_CUSTOMER_SIZE;
    }

    public Customers(int capacity) {
        this.capacity = capacity;
        customers = new Customer[capacity];
    }

    public Customers(Customer[] customers) {
        this.customers = customers;
    }

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }

    public Customer get(int index) {
        return customers[index];
    }

    public Customer find(String no) {

        return Arrays.stream(customers)
                .filter(Objects::nonNull)
                .filter(c -> c.getSerialNum().equals(no))
                .findFirst()
                .orElse(null);

    }

    public Customer[] getCleanCustomers() { //변경은 안되고 read만 할때 사용
        Customer[] cleanArr = Arrays.copyOf(customers, size);
        return cleanArr;
    }

    public void showCustomers() {
        for (int i = 0; i < size; i++) {
            System.out.println("No" + (i + 1));
            System.out.println(customers[i]);
        }
    }

    public void customerAdd(Customer customer) {
        if (size == capacity) {
            expandArr();
        }
        customers[size] = customer;
        size++;
    }

    public void customerUpdate(int no, String name, String id, int time, int pay) {
        int index = no - 1;

        if (name != null) {
            customers[index].setUserName(name);
        }
        if (id != null) {
            customers[index].setUserId(id);
        }
        if (time != 0) {
            customers[index].setSpentTime(time);
        }
        if (pay != 0) {
            customers[index].setTotalPay(pay);
        }
    }

    public Customer customerDelete(int no) {
        int index = no - 1;
        Customer deletedData = customers[index];
        customers[index] = null;
        size--;

        if (size > 0) {
            for (int i = index; i < size; i++) {
                customers[i] = customers[i + 1];
            }
            customers[size] = null; //어차피 모를 마지막이지만 보기싫어서 null해줌
        }

        return deletedData;
    }


    public void expandArr() {
        capacity *= 2;
        Customer[] origin = Arrays.copyOf(customers, size);
        customers = Arrays.copyOf(origin, capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + Arrays.toString(Arrays.copyOf(customers, size)) +
                ", size=" + size +
                '}';
    }

    public Customer[] getCustomers() {
        return Arrays.copyOf(customers, size);
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }


}

