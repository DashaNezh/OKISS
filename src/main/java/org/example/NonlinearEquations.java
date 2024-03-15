package org.example;

public class NonlinearEquations {

    public static double f(double x) {
        return x*x - 2; // Пример уравнения f(x) = x^2 - 2
    }

    public static double bisection(double a, double b, double ep) throws Exception {
        if (a >= b){
            throw new InvalidInterval("Неверный интервал");
        }
        if (ep < 0){
            throw new IncorrectError("Неверная погрешность");
        }

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
        return (2+x*x)/(2*x); // Преобразование к виду x = f(x)
    }

    public static double simpleIteration(double x0, double ep) throws Exception{
        if (ep < 0){
            throw new IncorrectError("Неверная погрешность");
        }
        double xPrev = x0;
        int count = 0;
        while (count < 200) {
            double xNext = f1(xPrev);
            if (Math.abs(xNext - xPrev) < ep) {
                return xNext;
            }
            xPrev = xNext;
            count++;
        }
        return xPrev;
    }

    public static double df(double x) {
        return 2 * x; // Производная для метода Ньютона
    }

    public static double newton(double x0, double ep) throws Exception{
        if (ep < 0){
            throw new IncorrectError("Неверная погрешность");
        }
        double x = x0;
        while (true) {
            double xNext = x - f(x) / df(x);
            if (Math.abs(xNext - x) < ep) {
                return xNext;
            }
            x = xNext;
        }
    }

    public static void main(String[] args) throws Exception {
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
    public static class InvalidInterval extends Exception{
        public InvalidInterval(String message){
            super(message);
        }
    }
    public static class IncorrectError extends  Exception{
        public IncorrectError(String message){
            super(message);
        }
    }
}
