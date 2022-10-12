package me.java.project;

import me.java.project.customer.CustomerTest;
import me.java.project.group.Groups;
import me.java.project.group.Parameter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

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

                while (true) {
                    System.out.println("===============================");
                    System.out.println("1. Set Parameter");
                    System.out.println("2. View Parameter");
                    System.out.println("3. Update Parameter");
                    System.out.println("4. Back");
                    System.out.println("===============================");

                    System.out.print("Choose One: ");
                    int parameterSelect = scan.nextInt();

                    if (parameterSelect == 4) {
                        break;
                    } else if (parameterSelect == 1) {
                        while (true) {
                            System.out.println("** Press 'end', if you want to exit! **");
                            System.out.println("Which group (GENERAL, VIP, VVIP)?");

                            String groupSelect = scan.next();
                            if (groupSelect.equals("end")) {
                                break;
                            }

                            int minimumSpentTime;
                            int minimumTotalPay;
                            Groups gs = new Groups();
                            while (true) {
                                System.out.println("===============================");
                                System.out.println("1. Minimum Spent Time");
                                System.out.println("2. Minimum Total Pay");
                                System.out.println("3. Back");
                                System.out.println("===============================");

                                System.out.print("Choose One: ");
                                int setSelect = scan.nextInt();

                                if (setSelect == 3) {

                                    break;
                                } else if (setSelect == 1) {
                                    System.out.print("Input Minimum Spent Time: ");
                                    minimumSpentTime = scan.nextInt();

                                } else if (setSelect == 2) {
                                    System.out.print("Input Minimum Total Pay");
                                    minimumSpentTime = scan.nextInt();
                                }

                            }
                        }
                    } else if (parameterSelect == 2) {
                        while (true) {
                            System.out.println("** Press 'end', if you want to exit! **");
                            System.out.println("Which group (GENERAL, VIP, VVIP)?");

                            String groupSelect = scan.next();
                            if (groupSelect.equals("end")) {
                                break;
                            } else {
                                System.out.println("GroupType: " + groupSelect);
                                System.out.println("parameter내용");
                            }
                        }
                    } else if (parameterSelect == 3) {

                    }
                }
            } else if (mainSelect == 2) {
                while (true) {
                    System.out.println("===============================");
                    System.out.println("1. Add Customer Data");
                    System.out.println("2. View Customer Data");
                    System.out.println("3. Update Customer Data");
                    System.out.println("4. Delete Customer Data");
                    System.out.println("5. Back");
                    System.out.println("===============================");

                    System.out.print("Choose One: ");
                    int dataSelect = scan.nextInt();

                    if (dataSelect == 5) {
                        break;
                    } else if (dataSelect == 1) {

                        while (true) {
                            System.out.println("** Press -1, if you want to exit! **");
                            System.out.print("How many customers to input? ");

                            int addCnt = scan.nextInt();

                            if (addCnt == -1) {
                                break;
                            }

                            for (int i = 0; i < addCnt; i++) {
                                System.out.println("=====Customer Info=====");
                                while (true) {

                                    System.out.println("===============================");
                                    System.out.println("1. Customer Name");
                                    System.out.println("2. Customer ID");
                                    System.out.println("3. Customer Spent Time");
                                    System.out.println("4. Customer Total Pay");
                                    System.out.println("5. Back");
                                    System.out.println("===============================");


                                    System.out.print("Choose One: ");
                                    int InfoSelect = scan.nextInt();

                                    if (InfoSelect == 5) {
                                        break;
                                    } else if (InfoSelect == 1) {
                                        System.out.println("Input Customer's Name: ");
                                    } else if (InfoSelect == 2) {
                                        System.out.println("Input Customer's UserID: ");
                                    } else if (InfoSelect == 3) {
                                        System.out.println("Input Customer's Spent Time at Your Store: ");
                                    } else if (InfoSelect == 4) {
                                        System.out.println("Input Customer's Total Payment at Your Store");
                                    }
                                }
                            }
                        }
                    } else if (dataSelect == 2) {
                        System.out.println("=====Customer Info=====");
                    } else if (dataSelect == 3) {
                        System.out.println("Which Customer ()? ");
                    } else if (dataSelect == 4) {
                        System.out.println("Which Customer ()? ");
                    }
                }
            } else if (mainSelect == 3) {
                while (true) {
                    System.out.println("===============================");
                    System.out.println("1. Summary");
                    System.out.println("2. Summary (Sorted By Name)");
                    System.out.println("3. Summary (Sorted By Spent Time");
                    System.out.println("4. Summary (Sorted By Total Payment");
                    System.out.println("5. Back");
                    System.out.println("===============================");

                    System.out.print("Choose One: ");
                    int summarySelect = scan.nextInt();

                    String orderSelect;

                    if (summarySelect == 5) {
                        break;
                    } else if (summarySelect == 1) {
                        System.out.println("============");
                    } else if (summarySelect ==2 ){
                        System.out.println("**Press 'end', if you want to exit! **");
                        System.out.print("Which order (ASCENDING, DESCENDING)? ");
                        orderSelect = scan.next();

                        if (orderSelect.equals("ASCENDING")){
                            System.out.println("ASCENDING");
                        }
                        else if(orderSelect.equals("DESCENDING")){
                            System.out.println("DESCENDING");
                        }
                    } else if (summarySelect == 3){
                        System.out.println("**Press 'end', if you want to exit! **");
                        System.out.print("Which order (ASCENDING, DESCENDING)? ");
                        orderSelect = scan.next();

                        if (orderSelect.equals("ASCENDING")){
                            System.out.println("ASCENDING");
                        }
                        else if(orderSelect.equals("DESCENDING")){
                            System.out.println("DESCENDING");
                        }
                    } else if (summarySelect == 4){
                        System.out.println("**Press 'end', if you want to exit! **");
                        System.out.print("Which order (ASCENDING, DESCENDING)? ");
                        orderSelect = scan.next();

                        if (orderSelect.equals("ASCENDING")){
                            System.out.println("ASCENDING");
                        }
                        else if(orderSelect.equals("DESCENDING")){
                            System.out.println("DESCENDING");
                        }
                    }
                }
            }
        }
    }
}
