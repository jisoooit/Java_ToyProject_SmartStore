package me.java.project.menu;

import me.java.project.group.GroupType;
import me.java.project.group.Groups;

import java.util.Scanner;

public class GroupMenu {

    public void groupMenu(Groups gs) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("===============================");
            System.out.println("1. Set Parameter");
            System.out.println("2. View Parameter");
            System.out.println("3. Update Parameter");
            System.out.println("4. Back");
            System.out.println("===============================");

            System.out.print("Choose One: ");
            int parameterSelect = scan.nextInt();
            GroupType gt;


            if (parameterSelect == 4) {
                break;
            } else if (parameterSelect == 1 || parameterSelect ==3) {
                while (true) {
                    System.out.println("** Press 'end', if you want to exit! **");
                    System.out.println("Which group (GENERAL, VIP, VVIP)?");

                    String groupSelect = scan.next();
                    if (groupSelect.equals("end")) {
                        break;
                    }

                    int minimumSpentTime;
                    int minimumTotalPay;


                    if ( groupSelect.equals("GENERAL")){
                        gt=GroupType.GENERAL;
                    } else if(groupSelect.equals("VIP")){
                        gt=GroupType.VIP;
                    } else if(groupSelect.equals("VVIP")){
                        gt=GroupType.VVIP;
                    } else{
                        continue;
                    }


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
                            gs.setTimeParameter(gt,minimumSpentTime);

                        } else if (setSelect == 2) {
                            System.out.print("Input Minimum Total Pay");
                            minimumTotalPay = scan.nextInt();
                            gs.setPayParameter(gt,minimumTotalPay);
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
                    }

                    if ( groupSelect.equals("GENERAL")){
                        gt=GroupType.GENERAL;
                    } else if(groupSelect.equals("VIP")){
                        gt=GroupType.VIP;
                    } else if(groupSelect.equals("VVIP")){
                        gt=GroupType.VVIP;
                    } else{
                        continue;
                    }

                    System.out.println("GroupType: " + groupSelect);
                    System.out.println(gs.getGroupParameter(gt));


                    gs.showAllParameter();
                }
            }
        }
    }

}
