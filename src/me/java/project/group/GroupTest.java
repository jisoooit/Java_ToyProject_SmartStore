package me.java.project.group;

public class GroupTest {
    public static void main(String[] args) {
        Groups gs = new Groups();
        int time = 20;
        int pay = 20000;
        gs.setParameter(GroupType.GENERAL, new Parameter(time, pay));
        gs.setParameter(GroupType.VIP, new Parameter(time+10, pay+10000));
        gs.updateParameter(GroupType.GENERAL, new Parameter(time+20, pay+20000));

        System.out.println(gs.getGeneral());
        System.out.println(gs.getVip());
        System.out.println(gs.getVVIP());
    }


}
