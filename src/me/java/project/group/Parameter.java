package me.java.project.group;

import java.util.Objects;

public class Parameter {
    private int minimumTime;
    private int minimumPay;

    public Parameter() {}

    public Parameter(int minimumTime, int minimumPay) {
        this.minimumTime = minimumTime;
        this.minimumPay = minimumPay;
    }

    public int getMinimumTime() {
        return minimumTime;
    }

    public void setMinimumTime(int minimumTime) {
        this.minimumTime = minimumTime;
    }

    public int getMinimumPay() {
        return minimumPay;
    }

    public void setMinimumPay(int minimumPay) {
        this.minimumPay = minimumPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return minimumTime == parameter.minimumTime && minimumPay == parameter.minimumPay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumTime, minimumPay);
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "minimumTime=" + minimumTime +
                ", minimumPay=" + minimumPay +
                '}';
    }
}
