package me.java.project.group;

public class Group {
    GroupType groupType;
    Parameter parameter;

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

    @Override
    public String toString() {
        return "Group{" +
                "groupType=" + groupType +
                ", parameter=" + parameter +
                '}';
    }
}
