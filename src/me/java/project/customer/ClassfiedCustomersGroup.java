package me.java.project.customer;

import me.java.project.group.GroupType;
import me.java.project.group.Groups;
import me.java.project.menu.OrderType;
import me.java.project.menu.SummaryType;

import java.util.Arrays;

import static me.java.project.group.GroupType.groupTypes;

public class ClassfiedCustomersGroup {
        ClassifiedCustomers[] classifiedCustomers = new ClassifiedCustomers[GroupType.values().length];

        private static ClassfiedCustomersGroup classfiedCustomersGroup;

        public static ClassfiedCustomersGroup getInstance(){
                if (classfiedCustomersGroup == null) {
                        classfiedCustomersGroup = new ClassfiedCustomersGroup();
                }
                return  classfiedCustomersGroup;
        }


        public ClassfiedCustomersGroup(){
                for(int i = 0; i < GroupType.values().length; i++){
                        classifiedCustomers[i] = new ClassifiedCustomers();
                }
        }

        public void groupByClass(Groups groups, Customers cs){

                for (int i = 0; i < groupTypes.length; i++) {
                        classifiedCustomers[i] = new ClassifiedCustomers(groupTypes[i]);
                }

                for(int i = 0; i<cs.customers.length; i++) {
                        int flag =0;
                        for(int j = groupTypes.length-2 ; j >= 0; j--) {
                                if (groups.getGroupParameter(groupTypes[j])!=null){ //Groups 초기화를 groups = new Group[DEFAULT]; set 해주지 않은 group은 null이다.
                                        int groupTime = groups.getGroupParameter(groupTypes[j]).getParameter().getMinimumTime();
                                        int groupPay = groups.getGroupParameter(groupTypes[j]).getParameter().getMinimumPay();
                                        if (cs.customers[i]!=null){
                                                if (cs.customers[i].getSpentTime() >= groupTime && cs.customers[i].getTotalPay() >= groupPay ) {
                                                        flag=1;
                                                        classifiedCustomers[groupTypes[j].ordinal()].customerAdd(cs.customers[i]);
                                                        break;
                                                }
                                        }
                                }
                        }
                        if ( flag == 0){
                                if(cs.customers[i]!=null){
                                        classifiedCustomers[groupTypes[groupTypes.length-1].ordinal()].customerAdd(cs.customers[i]);
                                }
                        }
                }
        }

        public void sortedByOrder(OrderType orderType, SummaryType summaryType) {

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

        public void showSummaryCustomers(){

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
}
