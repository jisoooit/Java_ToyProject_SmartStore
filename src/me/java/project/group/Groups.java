package me.java.project.group;

import static me.java.project.group.GroupType.groupTypes;

public class Groups {
    private static final int DEFAULT = groupTypes.length;
    Group[] groups;
    int size = 0;
    private static Groups allGroups;

    public static Groups getInstance() {
        if (allGroups == null) {
            allGroups = new Groups();
        }
        return allGroups;
    }

    public Groups() {
        groups = new Group[DEFAULT];
    }


    public void groupAdd(Group group) {
        groups[size] = group;
        size++;
    }

    public void setTimeParameter(GroupType gt, int minimumTime) {
        if (groups[gt.ordinal()] == null) {
            groups[gt.ordinal()] = new Group(gt, new Parameter(0, 0));
        }
        groups[gt.ordinal()].setTimeParameter(minimumTime);
    }

    public void setPayParameter(GroupType gt, int minimumPay) {
        if (groups[gt.ordinal()] == null) {
            groups[gt.ordinal()] = new Group(gt, new Parameter(0, 0));
        }
        groups[gt.ordinal()].setPayParameter(minimumPay);

    }


    public void setParameter(GroupType gt, Parameter parameter) {
        if (groups[gt.ordinal()] == null) {
            groups[gt.ordinal()] = new Group(gt, new Parameter(0, 0));
        }
        groups[gt.ordinal()].setParameter(parameter);
    }

    public void updateParameter(GroupType gt, Parameter parameter) {
        groups[gt.ordinal()].setParameter(parameter);
    }

    public Group getGroupParameter(GroupType gt) {
        return groups[gt.ordinal()];
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public void showAllParameter() {
        System.out.println("============================");
        System.out.println("전체 보기");
        System.out.println("============================");
        for (Group g : groups) {
            if (g != null) {
                System.out.println(g.getGroupType());
                System.out.println(g.getParameter());
                System.out.println();
            }
        }
    }

}
