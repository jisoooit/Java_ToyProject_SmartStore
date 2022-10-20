package me.java.project;

import me.java.project.customer.ClassfiedCustomersGroup;
import me.java.project.customer.Customer;
import me.java.project.customer.Customers;
import me.java.project.exception.ErrorMessage;
import me.java.project.group.GroupType;
import me.java.project.group.Groups;
import me.java.project.group.Parameter;
import me.java.project.menu.CustomerMenu;
import me.java.project.menu.GroupMenu;
import me.java.project.menu.Menu;
import me.java.project.menu.SummaryMenu;

import java.lang.reflect.InvocationTargetException;

public class SmartStoreApplication {
    private static SmartStoreApplication smartStoreApp;

    private Customers allCustomers = Customers.getInstance();

    private Groups allGroups = Groups.getInstance();

    private ClassfiedCustomersGroup classfiedCustomersGroup = ClassfiedCustomersGroup.getInstance();

    private Menu menu = Menu.getInstance();

    private GroupMenu groupMenu = GroupMenu.getInstance();
    private CustomerMenu customerMenu = CustomerMenu.getInstance();
    private SummaryMenu summaryMenu = SummaryMenu.getInstance();

    private Class[] classes = {GroupMenu.class, CustomerMenu.class, SummaryMenu.class};
    private Object[] instances = {groupMenu, customerMenu, summaryMenu};
    private String[] methods = {"manage", "manage", "manage"};

    private SmartStoreApplication() {}


    public static SmartStoreApplication getInstance() {
        if (smartStoreApp == null) {
            smartStoreApp = new SmartStoreApplication();
        }
        return smartStoreApp;
    }

    public void details() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println("===========================================\n");
    }

    public SmartStoreApplication test() {
        allGroups.setParameter(GroupType.GENERAL, new Parameter(10, 100000));
        allGroups.setParameter(GroupType.VIP, new Parameter(20, 200000));
        allGroups.setParameter(GroupType.VVIP, new Parameter(30,300000));
        for (int i = 0; i < 20; ++i) {
            allCustomers.customerAdd(new Customer("" + (char) (97 + i), (char) (97 + i) + "12345", i * 10, i * 100000));
        }
        return this;
    }

    public void run() {

        details();
        while(true) {
            int choice = menu.dispMenu();
            if (!(choice >= 1 && choice <= methods.length + 1)) { // + 1은 break 포함
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
            if (choice == methods.length + 1) {
                System.out.println(ErrorMessage.END_MSG);
                break; // back
            }
            try {
                int i = choice - 1;
                classes[i].getMethod(methods[i]).invoke(instances[i]);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
