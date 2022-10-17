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

                GroupMenu gm = new GroupMenu();
                gm.groupMenu(gs);
            } else if (mainSelect == 2) {

                CustomerMenu cm = new CustomerMenu();
                cm.runCustomerMenu(cs);
            } else if (mainSelect == 3) {

                SummaryMenu sm = new SummaryMenu();
                sm.runSummaryMenu(cs,gs);
            }

        }
    }
}
