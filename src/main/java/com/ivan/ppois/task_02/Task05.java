package com.ivan.ppois.task_02;

public class Task05 {

    /**
     * Возвращает угол в диапазоне от -pi/2 до pi/2 радиан
     */
    public static double calculateT2(double m, double t) {
        // сумму квадратов
        double sumOfSquares = m * m + t * t;
        double function = 5 * m * m * t + 7 * m * t * t;

        if (sumOfSquares > 0.5) {
            // для арктангенса (arctg)
            return Math.atan(function);
        }
        if (0.1 < sumOfSquares) {
            // для арксинуса (arcsin)
            return Math.asin(function);
        }
        throw new IllegalArgumentException(
                String.format("Invalid arguments m=%f, t=%f. m^2 + t^2 = %f must be greater than 0.1",
                        m, t, sumOfSquares));
    }
}
