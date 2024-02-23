package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestProgram {
    @Test (expectedExceptions = {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message test")
    void TestCalculateSumOfArray() throws Exception{
        final int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final int expectedResult = 45;
        final int actualResult;
        final double Delta = 1e-6;
        actualResult = Program.calculateSumOfArray(array);
        Assert.assertEquals(actualResult, expectedResult, Delta);
        throw new IOException("Pass Message test");
    }
    @Test (expectedExceptions = {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message test")
    void TestFindMaxElement() throws Exception{
        final int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final int expectedResult = 9;
        final int actualResult;
        final double Delta = 1e-6;
        actualResult = Program.findMaxElement(array);
        Assert.assertEquals(actualResult, expectedResult, Delta);
        throw new IOException("Pass Message test");
    }
    @Test (expectedExceptions = {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message test")
    void TestFindMinElement() throws Exception{
        final int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final int expectedResult = 1;
        final int actualResult;
        final double Delta = 1e-6;
        actualResult = Program.findMinElement(array);
        Assert.assertEquals(actualResult, expectedResult, Delta);
        throw new IOException("Pass Message test");
    }
    @Test (expectedExceptions = {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message test")
    void TestTransposeMatrix() throws Exception{
        final int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final int[][] expectedResult = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 1}
        };
        final int[][] actualResult;
        actualResult = Program.transposeMatrix(array);
        Assert.assertEquals(expectedResult, actualResult);
        throw new IOException("Pass Message test");
    }
    @Test (expectedExceptions = {IOException.class}, expectedExceptionsMessageRegExp = "Pass Message test")
    void TestIsSquareMatrix() throws Exception{
        final int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final boolean expectedResult = true;
        final boolean actualResult;
        actualResult = Program.isSquareMatrix(array);
        Assert.assertEquals(actualResult, expectedResult);
        throw new IOException("Fail Message test");
    }
}
