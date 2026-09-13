package com.ivan.ppois.task_02;

public class Task02 {

    public static double calculateAlpha(double x, double y, double z) {
        double part1 = -Math.sqrt(Math.abs(x)) * Math.log(y);
        double part2 = x - y / 2;
        double part3 = Math.pow(Math.sin(Math.atan(z)), 2);
        return part1 * part2 + part3;
    }
}
