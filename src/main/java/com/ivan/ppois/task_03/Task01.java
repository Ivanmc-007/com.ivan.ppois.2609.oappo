package com.ivan.ppois.task_03;

public class Task01 {

    public static void programmingCycleAlgorithms(double a, double b, double h, int n) {
        if (n < 0 || n > 12)
            throw new IllegalArgumentException("Аргумент (" + n + ") выходит за допустимый диапазон [0..12]");

        int steps = (int) Math.round((b - a) / h);
        printConsoleHeadTable();
        for (int i = 0; i <= steps; i++) {
            double x = a + i * h;
            double y = calculateY(x);
            double sum = calculateSum(x, n);
            printConsoleRowTable(x, y, sum);
        }
    }

    private static double calculateY(double x) {
        return Math.pow(Math.E, Math.cos(x)) * Math.cos(Math.sin(x));
    }

    private static double calculateSum(double x, int n) {
        double sum = 0;
        for (int k = 0; k <= n; k++) {
            sum += Math.cos(k * x) / factorial(k);
        }
        return sum;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private static void printConsoleHeadTable() {
        System.out.printf("| %12s | %12s | %12s |%n", "X", "Y(x)", "S(x)");
        System.out.println("----------------------------------------------");
    }

    private static void printConsoleRowTable(double x, double y, double sum) {
        System.out.printf("| %12.4f | %12.6f | %12.6f |%n", x, y, sum);
    }
}
