package me.java.project.menu;

import me.java.project.customer.Customer;
import me.java.project.customer.Customers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerMenu {
    private static CustomerMenu groupMenu;

    public static CustomerMenu getInstance(){
        if ( groupMenu == null ){
            groupMenu = new CustomerMenu();
        }
        return groupMenu;
    }

    public void runCustomerMenu(Customers cs){

        Pattern pattern = Pattern.compile("^[a-zA-Z]{3,}$");
        Pattern patternId = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{5,12}$");

        Matcher matcher;

        Scanner scan = new Scanner(System.in);
        //Customers cs = new Customers(10);

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
                        String userName=null;
                        String userId=null;
                        int spentTime=0;
                        int totalPay=0;

                        System.out.println("=====Customer Info" + (i+1)+ "=====");
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
                                Customer newCustomer = new Customer(userName,userId,spentTime,totalPay);
                                cs.customerAdd(newCustomer);
                                break;
                            } else if (InfoSelect == 1) {

                                do {
                                    System.out.print("Input Customer's Name: ");
                                    userName= scan.next();
                                    matcher = pattern.matcher(userName);
                                } while (! matcher.find()) ;


                            } else if (InfoSelect == 2) {

                                do {
                                    System.out.print("Input Customer's UserID: ");
                                    userId = scan.next();
                                    matcher = patternId.matcher(userId);
                                } while (! matcher.find()) ;

                            } else if (InfoSelect == 3) {

                                do {
                                    System.out.print("Input Customer's Spent Time at Your Store: ");
                                    spentTime = scan.nextInt();
                                } while (spentTime % 10 !=0);

                            } else if (InfoSelect == 4) {

                                do {
                                    System.out.print("Input Customer's Total Payment at Your Store");
                                    totalPay = scan.nextInt();
                                }while (totalPay % 100000 !=0);

                            }


                        }
                    }
                }
            } else if (dataSelect == 2) {
                System.out.println("=====Customer Info=====");

                cs.showCustomers();

            } else if (dataSelect == 3) {
                int end = cs.getSize();
                cs.showCustomers();
                System.out.println("Which Customer ("+1+"~"+end+")? ");

                int updateNo = scan.nextInt();

                String updateUserName=null;
                String updateUserId=null;
                int updateSpentTime=0;
                int updateTotalPay=0;
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
                        cs.customerUpdate(updateNo,updateUserName,updateUserId,updateSpentTime,updateTotalPay);
                        break;
                    } else if (InfoSelect == 1) {
                        System.out.print("Input Customer's Name: ");
                        updateUserName= scan.next();

                    } else if (InfoSelect == 2) {
                        System.out.print("Input Customer's UserID: ");
                        updateUserId = scan.next();

                    } else if (InfoSelect == 3) {
                        System.out.print("Input Customer's Spent Time at Your Store: ");
                        updateSpentTime = scan.nextInt();

                    } else if (InfoSelect == 4) {
                        System.out.print("Input Customer's Total Payment at Your Store:  ");
                        updateTotalPay = scan.nextInt();

                    }
                }
            } else if (dataSelect == 4) {
                int end = cs.getSize();
                cs.showCustomers();
                System.out.print("Which Customer ("+1+"~"+end+")? ");
                int deleteNo = scan.nextInt();
                cs.customerDelete(deleteNo);
            }
        }
    }
}
