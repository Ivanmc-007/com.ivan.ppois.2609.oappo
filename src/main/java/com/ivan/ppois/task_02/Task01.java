package com.ivan.ppois.task_02;

public class Task01 {

    /**
     * Вычисляет значение z1 по заданной формуле.
     * z1 = 1 - 1/4 * sin(2a) * sin(2a) + cos(2a)
     *
     * @param alphaInDegrees угол в ГРАДУСАХ (от 0 до 360)
     * @return результат вычисления z1
     */
    public static double calculateZ1(double alphaInDegrees) {
        // Переводим входящие градусы в радианы для Math.sin/cos
        double alphaInRadians = Math.toRadians(alphaInDegrees);
        return 1 - 0.25 * Math.pow(Math.sin(2 * alphaInRadians), 2) + Math.cos(2 * alphaInRadians);
    }

    /**
     * Вычисляет значение z2 по заданной формуле.
     * z2 = cos(a) * cos(a) + cos(a) * cos(a) * cos(a) * cos(a)
     *
     * @param alphaInDegrees угол в ГРАДУСАХ (от 0 до 360)
     * @return результат вычисления z2
     */
    public static double calculateZ2(double alphaInDegrees) {
        // Переводим входящие градусы в радианы для Math.cos
        double alphaInRadians = Math.toRadians(alphaInDegrees);
        return Math.pow(Math.cos(alphaInRadians), 2) + Math.pow(Math.cos(alphaInRadians), 4);
    }
}
