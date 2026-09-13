package com.ivan.ppois.task_02;

public class Task03 {

    public static double calculateY(double z) {
        double x;
        if (z < -1) {
            x = (-z) / 3;
        } else {
            x = Math.abs(z);
        }
        return Math.log(x + 0.5) + (Math.pow(Math.E, x) - Math.pow(Math.E, -x));
    }
}
