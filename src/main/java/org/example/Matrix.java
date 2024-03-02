package org.example;

import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {
        int[][] array = {
                {5, 3, 1},
                {8, 4, 2},
                {6, 7, 9}
        };

        // Вызываем методы и выводим результаты на экран
        System.out.println("Сумма всех элементов в массиве: " + calculateSumOfArray(array));
        //System.out.println("Отсортированный массив реккурентным типом: ");
        //for (int[] row : array) {
        //    mergeSort(row);
        //}
        //printMatrix(array);
        System.out.println("Отсортированный массив сортировкой суммирования: ");
        int[] sortedArray = countingSortByRowSum(array);
        System.out.println("Отсортированный массив суммирования строк: " + Arrays.toString(sortedArray));
        //System.out.println("\nТранспонированный массив:");
        //for (int[] row : transposeMatrix(array)) {
        //    System.out.println(Arrays.toString(row));
        //}
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

    // Метод для сортировки реккурентным типом
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
            int[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(leftHalf);
            mergeSort(rightHalf);

            int i = 0, j = 0, k = 0;

            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] < rightHalf[j]) {
                    arr[k] = leftHalf[i];
                    i++;
                } else {
                    arr[k] = rightHalf[j];
                    j++;
                }
                k++;
            }

            while (i < leftHalf.length) {
                arr[k] = leftHalf[i];
                i++;
                k++;
            }

            while (j < rightHalf.length) {
                arr[k] = rightHalf[j];
                j++;
                k++;
            }
        }
    }
    // метод для сортировки суммированием
    public static int[] countingSortByRowSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        // Находим максимальную и минимальную сумму в строках
        for (int[] row : matrix) {
            int sum = Arrays.stream(row).sum();
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
        }

        // Создаем массив для подсчета сумм строк
        int[] count = new int[maxSum - minSum + 1];

        // Подсчитываем суммы строк
        for (int[] row : matrix) {
            int sum = Arrays.stream(row).sum();
            count[sum - minSum]++;
        }

        // Восстанавливаем отсортированный массив
        int[] sortedArray = new int[matrix.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sortedArray[index] = i + minSum;
                count[i]--;
                index++;
            }
        }

        return sortedArray;
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

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
