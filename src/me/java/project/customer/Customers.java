package me.java.project.customer;

import me.java.project.group.GroupType;
import me.java.project.group.Groups;
import me.java.project.menu.OrderType;
import me.java.project.menu.SummaryType;

import java.util.Arrays;
import java.util.Comparator;

import static me.java.project.group.GroupType.groupTypes;

public class Customers {
    public static final int MAX_CUSTOMER = 10;
    protected Customer[] customers;
    protected int size = 0;  // total customers (saved)
    protected int capacity = 0;  // total size


    public Customers() {
        customers = new Customer[MAX_CUSTOMER];
        capacity=MAX_CUSTOMER;
    }

    public Customers(int capacity) {
        this.capacity = capacity;
        customers = new Customer[capacity];
    }

    public Customers(Customer[] customers) {
        this.customers=customers;
    }

    public Customer get(int index){
        return customers[index];
    }

    public Customer find(String no){
        for(int i =0; i < customers.length; i++){
            if(customers[i]!=null){
                if(customers[i].getSerialNum().equals(no)){
                    return customers[i];
                }
            }
        }
        return null;
    }

    public Customer[] getCleanCustomers(){ //변경은 안되고 read만 할때 사용
        Customer[] cleanArr = Arrays.copyOf(customers,size);
        return cleanArr;
    }

    public void showCustomers(){
//        Customer[] showCustomer = getCleanCustomers(); // 읽기 버전 customer 배열 가져오기
//        for ( int i=0; i<showCustomer.length;i++){
//            System.out.println("No"+(i+1));
//            System.out.println(showCustomer[i]);
//        }
        for ( int i=0; i<size;i++){
            System.out.println("No"+(i+1));
            System.out.println(customers[i]);
        }
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

        if (name != null){
            customers[index].setUserName(name);
        }
        if (id != null){
            customers[index].setUserId(id);
        }
        if (time != 0) {
            customers[index].setSpentTime(time);
        }
        if (pay != 0){
            customers[index].setTotalPay(pay);
        }
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



    public void expandArr(){
        capacity *=2;
        Customer [] origin = Arrays.copyOf(customers,size);
        customers = Arrays.copyOf(origin, capacity);
    }

    public void copyArr(Customer[] arr1, Customer[] arr2, int size){
        for(int i=0; i < size; i++) {
            arr1[i] = arr2[i];
        }
    }

    public boolean isEmpty() { return (size==0);}

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
                "customers=" + Arrays.toString(Arrays.copyOf(customers,size)) +
                ", size=" + size +
                '}';
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public ClassifiedCustomers[] groupByClass(Groups groups){
        ClassifiedCustomers[] classifiedCustomers = new ClassifiedCustomers[groupTypes.length];

        for (int i = 0; i < groupTypes.length; i++) {
            classifiedCustomers[i] = new ClassifiedCustomers(groupTypes[i]);
        }

        for(int i = 0; i<customers.length; i++) {
            int flag =0;
            for(int j = groupTypes.length-2 ; j >= 0; j--) {
                if (groups.getGroupParameter(groupTypes[j])!=null){ //Groups 초기화를 groups = new Group[DEFAULT]; set 해주지 않은 group은 null이다.
                    int groupTime = groups.getGroupParameter(groupTypes[j]).getParameter().getMinimumTime();
                    int groupPay = groups.getGroupParameter(groupTypes[j]).getParameter().getMinimumPay();
                    if (customers[i]!=null){
                        if (customers[i].getSpentTime() >= groupTime && customers[i].getTotalPay() >= groupPay ) {
                            flag=1;
                            classifiedCustomers[groupTypes[j].ordinal()].customerAdd(customers[i]);
                            break;
                        }
                    }
                }
            }
            if ( flag == 0){
                if(customers[i]!=null){
                    classifiedCustomers[groupTypes[groupTypes.length-1].ordinal()].customerAdd(customers[i]);
                }
            }
        }

        return classifiedCustomers;
    }

    public void showSummaryCustomers(ClassifiedCustomers[] classifiedCustomers){

        for (int i = 0; i < classifiedCustomers.length; i++) {
            System.out.print("[ Class => " + classifiedCustomers[i].getGroup() + " ], ");
            System.out.println("  count => " + classifiedCustomers[i].getSize());

            for (Customer c: Arrays.copyOf(classifiedCustomers[i].getCustomers(), classifiedCustomers[i].getSize())){
                System.out.println(c);
            }
            System.out.println();
            //System.out.println(Arrays.toString(Arrays.copyOf(classifiedCustomers[i].getCustomers(), classifiedCustomers[i].getSize())));
        }
    }

    public void sortedByOrder(ClassifiedCustomers[] classifiedCustomers, OrderType orderType, SummaryType summaryType) {

        for (int i = 0; i < classifiedCustomers.length; i++) {

            if (classifiedCustomers[i] != null) {
                System.out.print("[ Class => " + classifiedCustomers[i].getGroup() + " ], ");
                System.out.println("  count => " + classifiedCustomers[i].getSize());

                Customer[] sortedArr = Arrays.copyOf(classifiedCustomers[i].getCustomers(), classifiedCustomers[i].getSize());

                if ( orderType.equals(OrderType.ASCENDING)){
                    if(summaryType.equals(SummaryType.NAME)){
                        Arrays.sort(sortedArr, new ComparatorByNameA());
                    } else if(summaryType.equals(SummaryType.TIME)){
                        Arrays.sort(sortedArr, new ComparatorByTimeA());
                    } else if(summaryType.equals(SummaryType.PAY)){
                        Arrays.sort(sortedArr, new ComparatorByPayA());
                    }
                } else if(orderType.equals(OrderType.DESCENDING)){
                    if(summaryType.equals(SummaryType.NAME)){
                        Arrays.sort(sortedArr, new ComparatorByNameD());
                    } else if(summaryType.equals(SummaryType.TIME)){
                        Arrays.sort(sortedArr, new ComparatorByTimeD());
                    } else if(summaryType.equals(SummaryType.PAY)){
                        Arrays.sort(sortedArr, new ComparatorByPayD());
                    }
                }

                for (Customer ns : sortedArr) {
                    System.out.println(ns);
                }
                System.out.println();
            }
        }
    }



}

