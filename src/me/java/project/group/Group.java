package me.java.project.group;

public class Group {
    private GroupType groupType;
    private Parameter parameter;

    public Group() {}

    public Group(GroupType groupType, Parameter parameter) {
        this.groupType = groupType;
        this.parameter = parameter;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    //내가 추가한 것
    public void setTimeParameter(int minimumTime){
        this.parameter.setMinimumTime(minimumTime);
    }

    public void setPayParameter(int minimumPay){
        this.parameter.setMinimumPay(minimumPay);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupType=" + groupType +
                ", parameter=" + parameter +
                '}';
    }
}
