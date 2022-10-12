package me.java.project.customer;

import java.util.Arrays;
import java.util.Comparator;

public class Customers {
    public static final int MAX_CUSTOMER = 10;
    public Customer[] customers;
    int size = 0;  // total customers (saved)
    int capacity = 0;  // total size

    public Customers() {
        customers = new Customer[MAX_CUSTOMER];
        capacity=MAX_CUSTOMER;
        size=0;
    }

    public Customers(int capacity) {
        this.capacity = capacity;
        customers = new Customer[capacity];
        size=0;
    }

    public Customer[] getCleanCustomers(){ //변경은 안되고 read만 할때 사용
        Customer[] cleanArr = Arrays.copyOf(customers,size);
        return cleanArr;
    }

    public void customerAdd(Customer customer) {
        if (size == capacity){
            expandArr();
        }
        customers[size]=customer;
        size++;
    }

    public void customerUpdate(int no, String name, String id, int time, int pay){
        int index = no-1;

        //customer안에 null값인지 아닌지 판별해서 값 수정하는거 넣고 싶은데 serialNum때문에 고민이다.
        if (name != null){
            customers[index].setUserName(name);
        }
        if (id != null){
            customers[index].setUserId(id);
        }
        if (time != 0) {
            customers[index].setSpentTime(time);
        }
        if (time != 0){
            customers[index].setTotalPay(pay);
        }
        //customers[index]=customer;
    }

    public Customer customerDelete(int no){
        int index = no-1;
        Customer deletedData = customers[index];
        customers[index] = null;
        size--;

        if (size > 0) {
            for ( int i = index ; i< size ; i++ ) {
                customers[i] = customers[i+1];
            }
            customers[size]=null; //어차피 모를 마지막이지만 보기싫어서 null해줌
        }

        return  deletedData;
    }

    public Customer get(int no){
        int index = no -1;
        return customers[index];
    }

    public void expandArr(){
        capacity *=2;
        Customer [] origin = Arrays.copyOf(customers,size);
        customers = Arrays.copyOf(origin, capacity);
        //Customer[] newArr = new Customer[capacity];
        //copyArr(newArr, customers, customers.length);

        //copyArr(customers,newArr, newArr.length);
    }

    public void copyArr(Customer[] arr1, Customer[] arr2, int size){
        for(int i=0; i < size; i++) {
            arr1[i] = arr2[i];
        }
    }

    public boolean isEmpty() { return (size==0);}
    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + Arrays.toString(customers) +
                ", size=" + size +
                '}';
    }

    public void sortfunc(){
        Customer[] nameSort = Arrays.copyOf(customers ,size);
       //copyArr(nameSort,customers,size);
        //Arrays.sort(nameSort);
        System.out.println("여기");

        Arrays.sort(nameSort,new ComparatorByNameD());
        for (Customer p: nameSort) {
            System.out.println(p);
        }
    }


}

