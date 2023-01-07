package me.java.project.menu;

import me.java.project.customer.ClassfiedCustomersGroup;
import me.java.project.customer.Customers;
import me.java.project.group.Groups;

public class SummaryMenu extends Menu {
    private static SummaryMenu summaryMenu;
    private ClassfiedCustomersGroup classfiedCustomersGroup = ClassfiedCustomersGroup.getInstance();
    private Customers allCustomers = Customers.getInstance();
    private Groups allGroups = Groups.getInstance();


    private String[] menus
            = {"Summary",
            "Summary (Sorted By Name)",
            "Summary (Sorted By Spent Time)",
            "Summary (Sorted By Total Payment)",
            "Back"};

    /* method reflect */
    private String[] methods = {"summary", "sortedByName", "sortedBySpentTime", "sortedByTotalPayment"};

    private SummaryMenu() {
    }

    public static SummaryMenu getInstance() {
        if (summaryMenu == null) {
            summaryMenu = new SummaryMenu();
        }
        return summaryMenu;
    }

    public void summary() {
        classfiedCustomersGroup.groupByClass(allGroups, allCustomers);
        classfiedCustomersGroup.showSummaryCustomers();
    }

    public void sortedBySomething(SummaryType st) {
        classfiedCustomersGroup.groupByClass(allGroups, allCustomers);
        while (true) {
            System.out.println("**Press 'end', if you want to exit! **");
            System.out.print("Which order (ASCENDING, DESCENDING)? ");
            String orderSelect = scanner.next();

            OrderType ot;
            if (orderSelect.equals("end")) {
                break;
            }
            orderSelect = orderSelect.toUpperCase();
            if (orderSelect.equals("ASCENDING")) {
                ot = OrderType.ASCENDING;
                classfiedCustomersGroup.sortedByOrder(ot, st);
                break;
            } else if (orderSelect.equals("DESCENDING")) {
                ot = OrderType.DESCENDING;
                classfiedCustomersGroup.sortedByOrder(ot, st);
                break;
            } else {
                continue;
            }
        }
    }

    public void sortedByName() {
        sortedBySomething(SummaryType.NAME);
    }

    public void sortedBySpentTime() {
        sortedBySomething(SummaryType.TIME);
    }

    public void sortedByTotalPayment() {
        sortedBySomething(SummaryType.PAY);
    }

    @Override
    public void manage() {
        setInstance(summaryMenu);
        setMethods(methods);
        super.manage();
    }

    @Override
    public int dispMenu() {
        setMenus(menus);
        return super.dispMenu();
    }
}
