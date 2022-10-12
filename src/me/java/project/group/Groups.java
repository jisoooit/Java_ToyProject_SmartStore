package me.java.project.group;

import static me.java.project.group.GroupType.groupTypes;

public class Groups {
    Group[] groups = new Group[3];

    public Groups(){
        for(int i =0; i < 3; i++) {
            groups[i] = new Group(groupTypes[i], new Parameter(0,0));
        }
    }

    public void setParameter(GroupType gt, Parameter parameter ){
        groups[gt.ordinal()].setParameter(parameter);
    }

    public void updateParameter(GroupType gt, Parameter parameter ){
        groups[gt.ordinal()].setParameter(parameter);
    }

    public Group getGeneral(){
        return groups[0];
    }

    public Group getVip(){
        return groups[1];
    }

    public Group getVVIP(){
        return groups[2];
    }
//    public static void main(String[] args) {
//        Groups gs = new Groups();
//        for (Group g : gs.groups ){
//            System.out.println(g);
//        }
//    }

}
