package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestMatrix {
    @Test
    void testCalculateSumOfArray(){
        //Arrange - создание текстового окружения
        final int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final int expectedResult = 45;
        final int actualResult;
        //Act - действия (исполнения)
        actualResult = Matrix.calculateSumOfArray(array);
        //Assert - сравнение фактического и ожидаемого результатов
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void testTransposeMatrix(){
        //Arrange - создание текстового окружения
        final int[][] array = {
                {5, 3, 1},
                {8, 4, 2},
                {6, 7, 9}
        };
        final int[][] expectedResult = {
                {5, 8, 6},
                {3, 4, 7},
                {1, 2, 9}
        };
        final int[][] actualResult;
        //Act - действия (исполнения)
        actualResult = Matrix.transposeMatrix(array);
        //Assert - сравнение фактического и ожидаемого результатов
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    void testIsSquareMatrix(){
        //Arrange - создание текстового окружения
        final int[][] array = {
                {5, 3, 1},
                {8, 4, 2},
                {6, 7, 9}
        };
        final boolean expectedResult = true;
        final boolean actualResult;
        //Act - действия (исполнения)
        actualResult = Matrix.isSquareMatrix(array);
        //Assert - сравнение фактического и ожидаемого результатов
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    void testMergeSort() {
        //Arrange - создание текстового окружения
        final int[][] array = {
                {5, 3, 1},
                {8, 4, 2},
                {6, 7, 9}
        };
        final int[][] expectedResult = {
                {1, 3, 5},
                {2, 4, 8},
                {6, 7, 9}
        };
        //Act - действия (исполнения)
        for (final int[] actualResult: array) {
            Matrix.mergeSort(actualResult);
        }
        //Assert - сравнение фактического и ожидаемого результатов
        Assert.assertEquals(array, expectedResult);
    }
    @Test
    void testCountingSortByRowSum (){
        //Arrange - создание текстового окружения
        final int[][] array = {
                {5, 3, 1},
                {8, 4, 2},
                {7, 7, 9}
        };
        final int[] expectedResult = {9, 14, 23};
        final int[] actualResult;
        //Act - действия (исполнения)
        actualResult = Matrix.countingSortByRowSum(array);
        //Assert - сравнение фактического и ожидаемого результатов
        Assert.assertEquals(actualResult, expectedResult);
    }
}
