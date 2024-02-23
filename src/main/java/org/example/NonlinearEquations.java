package org.example;

public class NonlinearEquations {

    public static double f(double x) {
        return x*x - 2; // Пример уравнения f(x) = x^2 - 2
    }

    public static double bisection(double a, double b, double ep) {
        while ((b - a) / 2 > ep) {
            double mid = (a + b) / 2;
            if (f(mid) == 0) {
                return mid;
            } else if (f(a) * f(mid) < 0) {
                b = mid;
            } else {
                a = mid;
            }
        }
        return (a + b) / 2;
    }

    public static double f1(double x) {
        return (2 + x*x) / (2 * x); // Преобразование к виду x = f(x)
    }

    public static double simpleIteration(double x0, double ep) {
        double x_prev = x0;
        int cnt = 0;
        while (cnt < 100) {
            double x_next = f1(x_prev);
            if (Math.abs(x_next - x_prev) < ep) {
                return x_next;
            }
            x_prev = x_next;
            cnt++;
        }
        return x_prev;
    }

    public static double df(double x) {
        return 2 * x; // Производная для метода Ньютона
    }

    public static double newton(double x0, double ep) {
        double x = x0;
        while (true) {
            double x_next = x - f(x) / df(x);
            if (Math.abs(x_next - x) < ep) {
                return x_next;
            }
            x = x_next;
        }
    }

    public static void main(String[] args) {
        double ep = 1e-5; // Точность решения
        double a = 0, b = 2; // Интервал для метода бисекции
        double x0 = 0.25; // Начальное приближение для метода Ньютона и простых итераций

        // Метод простых итераций
        double rootSI = simpleIteration(x0, ep);
        System.out.println("Метод простых итераций: " + rootSI);

        // Метод Ньютона
        double rootNewton = newton(x0, ep);
        System.out.println("Метод Ньютона: " + rootNewton);

        // Метод бисекции
        double rootBisection = bisection(a, b, ep);
        System.out.println("Метод бисекции: " + rootBisection);
    }
}
