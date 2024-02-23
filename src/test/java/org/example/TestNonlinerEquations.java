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
    @Test (expectedExceptions= {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message test")
    public void TestBisection() throws Exception{
        final double ep = 1e-5;
        final double a = 0, b = 2;
        final double expectedResult = 1.414;
        final double actualResult;
        final double Delta = 1e-9;
        actualResult = NonlinearEquations.bisection(a, b, ep);
        Assert.assertEquals(actualResult, expectedResult, Delta);
        throw new IOException("Fail Message test");
    }
}
