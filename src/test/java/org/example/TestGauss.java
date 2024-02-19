package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGauss {
    @Test
    void testGauss(){
        final double [][] A = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };
        final double [] B = {1, 2, 3};
        final double [] expectedResult = {0.00, -1.11, 0.33};
        final double[] actualResult;
        final double DELTA = 1e-2;
        actualResult = Gauss.gauss(A, B);
        Assert.assertEquals(actualResult, expectedResult, DELTA);
    }
}