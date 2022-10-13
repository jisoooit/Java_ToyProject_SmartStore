package me.java.project;

import me.java.project.customer.Customers;
import me.java.project.group.Groups;
import me.java.project.menu.CustomerMenu;
import me.java.project.menu.GroupMenu;
import me.java.project.menu.SummaryMenu;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Groups gs = new Groups();
        Customers cs = new Customers(10);




        System.out.println("========================================");
        System.out.println("Title : SmartStore Customer Segmentation");
        System.out.println("Release Date : 22.10.07");
        System.out.println("Copyright 2022 Jisu All rights reserved");
        System.out.println("========================================");

        while (true) {
            System.out.println("===============================");
            System.out.println("1. Classification Parameter");
            System.out.println("2. Customer Data");
            System.out.println("3. Summary");
            System.out.println("4. Quit");
            System.out.println("===============================");

            System.out.print("Choose One: ");
            int mainSelect = scan.nextInt();

            if (mainSelect == 4) {
                System.out.println("Program Finished");
                break;
            } else if (mainSelect == 1) {

//                while (true) {
//                    System.out.println("===============================");
//                    System.out.println("1. Set Parameter");
//                    System.out.println("2. View Parameter");
//                    System.out.println("3. Update Parameter");
//                    System.out.println("4. Back");
//                    System.out.println("===============================");
//
//                    System.out.print("Choose One: ");
//                    int parameterSelect = scan.nextInt();
//                    GroupType gt;
//
//
//                    if (parameterSelect == 4) {
//                        break;
//                    } else if (parameterSelect == 1 || parameterSelect ==3) {
//                        while (true) {
//                            System.out.println("** Press 'end', if you want to exit! **");
//                            System.out.println("Which group (GENERAL, VIP, VVIP)?");
//
//                            String groupSelect = scan.next();
//                            if (groupSelect.equals("end")) {
//                                break;
//                            }
//
//                            int minimumSpentTime;
//                            int minimumTotalPay;
//
//
//                            if ( groupSelect.equals("GENERAL")){
//                                gt=GroupType.GENERAL;
//                            } else if(groupSelect.equals("VIP")){
//                                gt=GroupType.VIP;
//                            } else if(groupSelect.equals("VVIP")){
//                                gt=GroupType.VVIP;
//                            } else{
//                                continue;
//                            }
//
//
//                            while (true) {
//                                System.out.println("===============================");
//                                System.out.println("1. Minimum Spent Time");
//                                System.out.println("2. Minimum Total Pay");
//                                System.out.println("3. Back");
//                                System.out.println("===============================");
//
//                                System.out.print("Choose One: ");
//                                int setSelect = scan.nextInt();
//
//                                if (setSelect == 3) {
//                                    break;
//                                } else if (setSelect == 1) {
//                                    System.out.print("Input Minimum Spent Time: ");
//                                    minimumSpentTime = scan.nextInt();
//                                    gs.setTimeParameter(gt,minimumSpentTime);
//
//                                } else if (setSelect == 2) {
//                                    System.out.print("Input Minimum Total Pay");
//                                    minimumTotalPay = scan.nextInt();
//                                    gs.setPayParameter(gt,minimumTotalPay);
//                                }
//                            }
//                        }
//                    } else if (parameterSelect == 2) {
//                        while (true) {
//                            System.out.println("** Press 'end', if you want to exit! **");
//                            System.out.println("Which group (GENERAL, VIP, VVIP)?");
//
//                            String groupSelect = scan.next();
//                            if (groupSelect.equals("end")) {
//                                break;
//                            }
//
//                            if ( groupSelect.equals("GENERAL")){
//                                gt=GroupType.GENERAL;
//                            } else if(groupSelect.equals("VIP")){
//                                gt=GroupType.VIP;
//                            } else if(groupSelect.equals("VVIP")){
//                                gt=GroupType.VVIP;
//                            } else{
//                                continue;
//                            }
//
//                            System.out.println("GroupType: " + groupSelect);
//                            System.out.println(gs.getGroupParameter(gt));
//
//
//                            gs.showAllParameter();
//                        }
//                    }
//                }
                GroupMenu gm = new GroupMenu();
                gm.groupMenu(gs);
            } else if (mainSelect == 2) {
//                while (true) {
//                    System.out.println("===============================");
//                    System.out.println("1. Add Customer Data");
//                    System.out.println("2. View Customer Data");
//                    System.out.println("3. Update Customer Data");
//                    System.out.println("4. Delete Customer Data");
//                    System.out.println("5. Back");
//                    System.out.println("===============================");
//
//                    System.out.print("Choose One: ");
//                    int dataSelect = scan.nextInt();
//
//                    if (dataSelect == 5) {
//                        break;
//                    } else if (dataSelect == 1) {
//
//                        while (true) {
//                            System.out.println("** Press -1, if you want to exit! **");
//                            System.out.print("How many customers to input? ");
//
//                            int addCnt = scan.nextInt();
//
//                            if (addCnt == -1) {
//                                break;
//                            }
//
//                            for (int i = 0; i < addCnt; i++) {
//                                String userName=null;
//                                String userId=null;
//                                int spentTime=0;
//                                int totalPay=0;
//
//                                System.out.println("=====Customer Info" + (i+1)+ "=====");
//                                while (true) {
//
//                                    System.out.println("===============================");
//                                    System.out.println("1. Customer Name");
//                                    System.out.println("2. Customer ID");
//                                    System.out.println("3. Customer Spent Time");
//                                    System.out.println("4. Customer Total Pay");
//                                    System.out.println("5. Back");
//                                    System.out.println("===============================");
//
//
//                                    System.out.print("Choose One: ");
//                                    int InfoSelect = scan.nextInt();
//
//
//                                    if (InfoSelect == 5) {
//                                        Customer newCustomer = new Customer(userName,userId,spentTime,totalPay);
//                                        cs.customerAdd(newCustomer);
//                                        break;
//                                    } else if (InfoSelect == 1) {
//                                        System.out.print("Input Customer's Name: ");
//                                        userName= scan.next();
//
//                                    } else if (InfoSelect == 2) {
//                                        System.out.print("Input Customer's UserID: ");
//                                        userId = scan.next();
//
//                                    } else if (InfoSelect == 3) {
//                                        System.out.print("Input Customer's Spent Time at Your Store: ");
//                                        spentTime = scan.nextInt();
//
//                                    } else if (InfoSelect == 4) {
//                                        System.out.print("Input Customer's Total Payment at Your Store");
//                                        totalPay = scan.nextInt();
//
//                                    }
//
//
//                                }
//                            }
//                        }
//                    } else if (dataSelect == 2) {
//                        System.out.println("=====Customer Info=====");
//
//                        cs.showCustomers();
//
//                    } else if (dataSelect == 3) {
//                        int end = cs.getSize();
//                        cs.showCustomers();
//                        System.out.println("Which Customer ("+1+"~"+end+")? ");
//
//                        int updateNo = scan.nextInt();
//
//                        String updateUserName=null;
//                        String updateUserId=null;
//                        int updateSpentTime=0;
//                        int updateTotalPay=0;
//                        while (true) {
//
//                            System.out.println("===============================");
//                            System.out.println("1. Customer Name");
//                            System.out.println("2. Customer ID");
//                            System.out.println("3. Customer Spent Time");
//                            System.out.println("4. Customer Total Pay");
//                            System.out.println("5. Back");
//                            System.out.println("===============================");
//
//
//                            System.out.print("Choose One: ");
//                            int InfoSelect = scan.nextInt();
//
//
//                            if (InfoSelect == 5) {
//                                cs.customerUpdate(updateNo,updateUserName,updateUserId,updateSpentTime,updateTotalPay);
//                                break;
//                            } else if (InfoSelect == 1) {
//                                System.out.print("Input Customer's Name: ");
//                                updateUserName= scan.next();
//
//                            } else if (InfoSelect == 2) {
//                                System.out.print("Input Customer's UserID: ");
//                                updateUserId = scan.next();
//
//                            } else if (InfoSelect == 3) {
//                                System.out.print("Input Customer's Spent Time at Your Store: ");
//                                updateSpentTime = scan.nextInt();
//
//                            } else if (InfoSelect == 4) {
//                                System.out.print("Input Customer's Total Payment at Your Store:  ");
//                                updateTotalPay = scan.nextInt();
//
//                            }
//                        }
//                    } else if (dataSelect == 4) {
//                        int end = cs.getSize();
//                        cs.showCustomers();
//                        System.out.print("Which Customer ("+1+"~"+end+")? ");
//                        int deleteNo = scan.nextInt();
//                        cs.customerDelete(deleteNo);
//                    }
//                }
                CustomerMenu cm = new CustomerMenu();
                cm.runCustomerMenu(cs);
            } else if (mainSelect == 3) {
//                ClassifiedCustomers cf = new ClassifiedCustomers();
//                cf.groupByClass(cs);
//                while (true) {
//                    System.out.println("===============================");
//                    System.out.println("1. Summary");
//                    System.out.println("2. Summary (Sorted By Name)");
//                    System.out.println("3. Summary (Sorted By Spent Time");
//                    System.out.println("4. Summary (Sorted By Total Payment");
//                    System.out.println("5. Back");
//                    System.out.println("===============================");
//
//                    System.out.print("Choose One: ");
//                    int summarySelect = scan.nextInt();
//
//                    String orderSelect;
//                    OrderType ot;
//
//                    if (summarySelect == 5) {
//                        break;
//                    } else if (summarySelect == 1) {
//                        cf.showClassifiedCustomers();
//
//                    } else if (summarySelect ==2 ){
//                        System.out.println("**Press 'end', if you want to exit! **");
//                        System.out.print("Which order (ASCENDING, DESCENDING)? ");
//                        orderSelect = scan.next();
//
//
//                        if ( orderSelect.equals("ASCENDING")){
//                            ot=OrderType.ASCENDING;
//                        } else if(orderSelect.equals("DESCENDING")){
//                            ot=OrderType.DESCENDING;
//                        }  else{
//                            continue;
//                        }
//
//                        cf.sortedByName(ot);
//
//                    } else if (summarySelect == 3){
//                        System.out.println("**Press 'end', if you want to exit! **");
//                        System.out.print("Which order (ASCENDING, DESCENDING)? ");
//                        orderSelect = scan.next();
//
//                        if ( orderSelect.equals("ASCENDING")){
//                            ot=OrderType.ASCENDING;
//                        } else if(orderSelect.equals("DESCENDING")){
//                            ot=OrderType.DESCENDING;
//                        }  else{
//                            continue;
//                        }
//
//                        cf.sortedByTime(ot);
//
//                    } else if (summarySelect == 4){
//                        System.out.println("**Press 'end', if you want to exit! **");
//                        System.out.print("Which order (ASCENDING, DESCENDING)? ");
//                        orderSelect = scan.next();
//
//                        if ( orderSelect.equals("ASCENDING")){
//                            ot=OrderType.ASCENDING;
//                        } else if(orderSelect.equals("DESCENDING")){
//                            ot=OrderType.DESCENDING;
//                        }  else{
//                            continue;
//                        }
//
//                        cf.sortedByPay(ot);
//                    }
//                }
                SummaryMenu sm = new SummaryMenu();
                sm.runSummaryMenu(cs,gs);
            }

        }
    }
}
