package me.java.project.menu;

import me.java.project.customer.ClassifiedCustomers;
import me.java.project.customer.ClassifiedCustomers2;
import me.java.project.customer.Customers;
import me.java.project.group.Groups;

import java.util.Scanner;

public class SummaryMenu {

    public void runSummaryMenu(Customers cs, Groups gs){

        Scanner scan = new Scanner(System.in);
        ClassifiedCustomers[] classifiedCustomers = cs.groupByClass(gs);

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
            OrderType ot;

            if (summarySelect == 5) {
                break;
            } else if (summarySelect == 1) {
                cs.showSummaryCustomers(classifiedCustomers);

            } else if (summarySelect ==2 ){
                System.out.println("**Press 'end', if you want to exit! **");
                System.out.print("Which order (ASCENDING, DESCENDING)? ");
                orderSelect = scan.next();


                if ( orderSelect.equals("ASCENDING")){
                    ot=OrderType.ASCENDING;
                } else if(orderSelect.equals("DESCENDING")){
                    ot=OrderType.DESCENDING;
                }  else{
                    continue;
                }

                cs.sortedByOrder(classifiedCustomers,ot,SummaryType.NAME);

            } else if (summarySelect == 3){
                System.out.println("**Press 'end', if you want to exit! **");
                System.out.print("Which order (ASCENDING, DESCENDING)? ");
                orderSelect = scan.next();

                if ( orderSelect.equals("ASCENDING")){
                    ot=OrderType.ASCENDING;
                } else if(orderSelect.equals("DESCENDING")){
                    ot=OrderType.DESCENDING;
                }  else{
                    continue;
                }

                cs.sortedByOrder(classifiedCustomers,ot,SummaryType.TIME);

            } else if (summarySelect == 4){
                System.out.println("**Press 'end', if you want to exit! **");
                System.out.print("Which order (ASCENDING, DESCENDING)? ");
                orderSelect = scan.next();

                if ( orderSelect.equals("ASCENDING")){
                    ot=OrderType.ASCENDING;
                } else if(orderSelect.equals("DESCENDING")){
                    ot=OrderType.DESCENDING;
                }  else{
                    continue;
                }

                cs.sortedByOrder(classifiedCustomers,ot,SummaryType.PAY);
            }
        }
    }
}
