package me.java.project.customer;

import me.java.project.group.GroupType;
import me.java.project.group.Groups;
import me.java.project.menu.OrderType;

import java.util.Arrays;

import static me.java.project.group.GroupType.groupTypes;

public class ClassifiedCustomers extends Customers{
    protected GroupType groupType;

    public ClassifiedCustomers() {super();}

    public ClassifiedCustomers(GroupType groupType){
        super();
        this.groupType=groupType;
    }

    public ClassifiedCustomers(int capacity, GroupType groupType) {
        super(capacity);
        this.groupType = groupType;
    }

    public ClassifiedCustomers(Customer[] customers, GroupType groupType) {
        super(customers);
        this.groupType = groupType;
    }

    public GroupType getGroup() { return groupType; }

    public void setGroup(GroupType groupType){
        this.groupType = groupType;
    }





    @Override
    public String toString() {
        return "ClassifiedCustomers{" +
                "groupType=" + groupType +
                ", customers=" + Arrays.toString(customers) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
