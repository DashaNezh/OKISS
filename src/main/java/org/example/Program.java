package org.example;

import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Вызываем методы и выводим результаты на экран
        System.out.println("Сумма всех элементов в массиве: " + calculateSumOfArray(array));
        System.out.println("Максимальный элемент в массиве: " + findMaxElement(array));
        System.out.println("Минимальный элемент в массиве: " + findMinElement(array));
        System.out.println("\nТранспонированный массив:");
        for (int[] row : transposeMatrix(array)) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Массив является квадратным: " + isSquareMatrix(array));
    }


    // Метод для расчета суммы всех элементов в двумерном массиве
    public static int calculateSumOfArray(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    // Метод для нахождения максимального элемента в массиве
    public static int findMaxElement(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    // Метод для нахождения минимального элемента в массиве
    public static int findMinElement(int[][] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    // Метод для транспонирования двумерного массива
    public static int[][] transposeMatrix(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        int[][] transposedArray = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedArray[j][i] = array[i][j];
            }
        }

        return transposedArray;
    }

    // Метод для проверки, является ли двумерный массив квадратным
    public static boolean isSquareMatrix(int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int rows = array.length;
        for (int i = 0; i < rows; i++) {
            if (array[i].length != rows) { // Если количество столбцов не равно количеству строк
                return false;
            }
        }
        return true;
    }
}
