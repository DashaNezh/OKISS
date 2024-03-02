package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TestNonlinerEquations {
    @Test (expectedExceptions = {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message test")
    public void TestSimpleIteration() throws Exception{
        final double ep = 1e-5;
        final double x0 = 0.25;
        final double expectedResult = 1.414;
        final double actualResult;
        final double Delta = 1e-3;
        actualResult = NonlinearEquations.simpleIteration(x0, ep);
        Assert.assertEquals(actualResult, expectedResult, Delta);
        throw new IOException("Pass Message test");
    }
    @Test (expectedExceptions= {IOException.class}, expectedExceptionsMessageRegExp = ".* Message .*")
    public void TestNewton() throws Exception{
        final double ep = 1e-5;
        final double x0 = 0.25;
        final double expectedResult = 1.414;
        final double actualResult;
        final double Delta = 1e-3;
        actualResult = NonlinearEquations.newton(x0, ep);
        Assert.assertEquals(actualResult, expectedResult, Delta);
        throw new IOException("Pass Message test");
    }
    @Test
    public void testBisectionPositive() throws IOException {
        final double ep = 1e-5;
        final double a = 0, b = 2;
        final double expectedResult = 1.414;
        final double actualResult;
        final double Delta = 1e-3;

        actualResult = NonlinearEquations.bisection(a, b, ep);

        Assert.assertEquals(actualResult, expectedResult, Delta);
    }
    @Test (expectedExceptions= {IOException.class}, expectedExceptionsMessageRegExp = "Неверный интервал")
    public void testBisection() throws IOException{
        final double ep = 1e-5;
        final double a = 0, b = -2;
        final double actualResult;

        actualResult = NonlinearEquations.bisection(a, b, ep);

    }
}
