package me.java.project.menu;

import me.java.project.exception.ErrorMessage;
import me.java.project.exception.InputRangeException;
import me.java.project.group.GroupType;
import me.java.project.group.Groups;


public class GroupMenu extends Menu {
    private static GroupMenu groupMenu;
    private GroupType gt;
    private Groups allGroups = Groups.getInstance();

    private String[] menus
            = {"Set Parameter", "View Parameter", "Update Parameter", "Back"};

    /* method reflect */
    private String[] methods = {"setParam", "viewParam", "setParam"};

    private GroupMenu() {
    }

    public static GroupMenu getInstance() {
        if (groupMenu == null) {
            groupMenu = new GroupMenu();
        }
        return groupMenu;
    }

    public void setParam() {
        System.out.println("setParam");
        while (true) {
            System.out.println("** Press 'end', if you want to exit! **");
            System.out.println("Which group (GENERAL, VIP, VVIP)?");

            String groupSelect = scanner.next();
            if (groupSelect.equals("end")) {
                break;
            }

            groupSelect = groupSelect.toUpperCase();
            int minimumSpentTime;
            int minimumTotalPay;


            if (groupSelect.equals("GENERAL")) {
                gt = GroupType.GENERAL;
            } else if (groupSelect.equals("VIP")) {
                gt = GroupType.VIP;
            } else if (groupSelect.equals("VVIP")) {
                gt = GroupType.VVIP;
            } else {
                continue;
            }


            while (true) {
                try {
                    System.out.println("===============================");
                    System.out.println("1. Minimum Spent Time");
                    System.out.println("2. Minimum Total Pay");
                    System.out.println("3. Back");
                    System.out.println("===============================");

                    System.out.print("Choose One: ");
                    int setSelect = Integer.parseInt(scanner.next());

                    if (setSelect < 1 || setSelect > 3) {
                        throw new InputRangeException();
                    }

                    if (setSelect == 3) {
                        break;
                    } else if (setSelect == 1) {
                        do {
                            System.out.print("Input Minimum Spent Time: ");
                            minimumSpentTime = Integer.parseInt(scanner.next());
                        } while (minimumSpentTime % 10 != 0);
                        allGroups.setTimeParameter(gt, minimumSpentTime);

                    } else if (setSelect == 2) {
                        do {
                            System.out.print("Input Minimum Total Pay");
                            minimumTotalPay = Integer.parseInt(scanner.next());
                        } while (minimumTotalPay % 100000 != 0);
                        allGroups.setPayParameter(gt, minimumTotalPay);
                    }

                } catch (NumberFormatException e) {
                    System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
                } catch (InputRangeException e) {
                    System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
                }
            }
        }
    }

    public void viewParam() {
        allGroups.showAllParameter();
    }

    public void updateParam() {

    }

    @Override
    public void manage() {
        setInstance(groupMenu);
        setMethods(methods);
        super.manage();
    }

    @Override
    public int dispMenu() {
        setMenus(menus);
        return super.dispMenu();
    }
}
