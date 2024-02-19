package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculator {
    @Test
    void testAddition(){
        //Arange - создание текстового окружения
        final double NUMBER1 = 2;
        final double NUMBER2 = 3;
        double expectedResult = 5;
        double actualResult;
        final double DELTA = 1e-6;
        //Act - действия (исполнения)
        actualResult = Calculator.addition(NUMBER1, NUMBER2);
        //Assert - сравнение фактического и ожидаемого результатов
        Assert.assertEquals(actualResult, expectedResult, DELTA);
    }
}
