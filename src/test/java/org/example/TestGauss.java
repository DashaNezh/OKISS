package org.example;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestGauss {
    @Test
    void testGauss() throws IOException {
        // Arrange - создание текстового окружения
        final double[][] A = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };
        final double[] B = {1, 2, 3};
        final double[] expectedResult = {0.00, -1.11, 0.33};
        final double[] actualResult;
        final double DELTA = 1e-2;
        // Act - действия (исполнение)
        actualResult = Gauss.gauss(A, B);
        // Assert - сравнение фактического и ожидаемого результатов с использованием дельты
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < actualResult.length; i++) {
            softAssert.assertEquals(actualResult[i], expectedResult[i], DELTA, "Element at index " + i + " is not as expected");
        }
    }
    @Test  (expectedExceptions= {IOException.class}, expectedExceptionsMessageRegExp = "Система несовместна")
    void testGaussNonSingularMatrix() throws IOException{
        // Arrange - создание текстового окружения
        final double[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final double[] B = {1, 2, 5};
        // Act - действия (исполнение)
        Gauss.gauss(A, B);
    }
    @Test  (expectedExceptions= IOException.class, expectedExceptionsMessageRegExp = "Размерность вектора B не совпадает с размерностью матрицы A")
    void testGaussIncompatibleMatrices() throws IOException{
        // Arrange - создание текстового окружения
        final double[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final double[] B = {1, 2};
        // Act - действия (исполнение)
        Gauss.gauss(A, B);
    }
    @Test  (expectedExceptions= IOException.class, expectedExceptionsMessageRegExp = "Система имеет множество решений")
    void testGaussManySolutions() throws IOException{
        // Arrange - создание текстового окружения
        final double[][] A = {
                {1, 2, 3},
                {2, 4, 6},
                {4, 7, 7}
        };
        final double[] B = {1, 2, 5};
        // Act - действия (исполнение)
        Gauss.gauss(A, B);
    }
}
