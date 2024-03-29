package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNonlinerEquations {
    @Test (groups = "positive")
    public void testSimpleIterationPositive() throws Exception{
        // Arrange - создание текстового окружения
        final double EP = 1e-5;
        final double X0 = 0.25;
        double expectedResult = 1.414;
        double actualResult;
        final double DELTA = 1e-3;
        // Act - действия (исполнение)
        actualResult = NonlinearEquations.simpleIteration(X0, EP);
        // Assert - сравнение фактического и ожидаемого результатов с использованием дельты
        Assert.assertEquals(actualResult, expectedResult, DELTA);
    }
    @Test (expectedExceptions= {NonlinearEquations.IncorrectError.class}, expectedExceptionsMessageRegExp = "Неверная погрешность", groups = "negative")
    public void testSimpleIterationNegative() throws Exception{
        // Arrange - создание текстового окружения
        final double EP = -1e-5;
        final double X0 = 0.25;
        // Act - действия (исполнение)
        NonlinearEquations.simpleIteration(X0, EP);
    }
    @Test (groups = "positive")
    public void testNewtonPositive() throws Exception{
        // Arrange - создание текстового окружения
        final double EP = 1e-5;
        final double X0 = 0.25;
        double expectedResult = 1.414;
        double actualResult;
        final double DELTA = 1e-3;
        // Act - действия (исполнение)
        actualResult = NonlinearEquations.newton(X0, EP);
        // Assert - сравнение фактического и ожидаемого результатов с использованием дельты
        Assert.assertEquals(actualResult, expectedResult, DELTA);
    }
    @Test (expectedExceptions= {NonlinearEquations.IncorrectError.class}, expectedExceptionsMessageRegExp = "Неверная погрешность", groups = "negative")
    public void testNewtonNegative() throws Exception{
        // Arrange - создание текстового окружения
        final double EP = -1e-5;
        final double X0 = 0.25;
        // Act - действия (исполнение)
        NonlinearEquations.newton(X0, EP);
    }
    @Test (groups = "positive")
    public void testBisectionPositive() throws Exception {
        // Arrange - создание текстового окружения
        final double EP = 1e-5;
        final double A = 0, B = 2;
        double expectedResult = 1.414;
        double actualResult;
        final double DELTA = 1e-3;
        // Act - действия (исполнение)
        actualResult = NonlinearEquations.bisection(A, B, EP);
        // Assert - сравнение фактического и ожидаемого результатов с использованием дельты
        Assert.assertEquals(actualResult, expectedResult, DELTA);
    }

    @Test (expectedExceptions= {NonlinearEquations.InvalidInterval.class}, expectedExceptionsMessageRegExp = "Неверный интервал", groups = "negative")
    public void testBisectionNegativeInvalidInterval() throws Exception{
        // Arrange - создание текстового окружения
        final double EP = 1e-5;
        final double A = 0, B = -2;
        // Act - действия (исполнение)
        NonlinearEquations.bisection(A, B, EP);
    }

    @Test (expectedExceptions= {NonlinearEquations.IncorrectError.class}, expectedExceptionsMessageRegExp = "Неверная погрешность", groups = "negative")
    public void testBisectionNegativeIncorrectError() throws Exception{
        // Arrange - создание текстового окружения
        final double EP = -1e-5;
        final double A = 0, B = 2;
        // Act - действия (исполнение)
        NonlinearEquations.bisection(A, B, EP);
    }
}
