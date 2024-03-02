package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Gauss {

    public static void main(String[] args) throws IOException {
        double[][] A = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };
        double[] B = {1, 2, 3};

        double[] result = gauss(A, B);

        System.out.println("Решение: " + Arrays.toString(result));


    }

    public static double[] gauss(double[][] A, double[] B) throws IOException {
        int n = A.length;
        // Проверка на совместимость размерности матрицы A и вектора B
        if (n != B.length){
            throw new IOException("Размерность вектора B не совпадает с размерностью матрицы A");
        }
        for (int i = 0; i < n; i++) {
            double maxEl = Math.abs(A[i][i]);
            int maxRow = i;

            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A[k][i]) > maxEl) {
                    maxEl = Math.abs(A[k][i]);
                    maxRow = k;
                }
            }

            double[] temp = A[maxRow];
            A[maxRow] = A[i];
            A[i] = temp;

            double tempB = B[maxRow];
            B[maxRow] = B[i];
            B[i] = tempB;

            if (Math.abs(A[i][i]) < 1e-9) {
                if (Math.abs(B[i]) < 1e-9) {
                    throw new IOException("Система имеет множество решений");
                }
                throw new IOException("Система несовместна");
            }

            for (int k = i + 1; k < n; k++) {
                double c = -A[k][i] / A[i][i];
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        A[k][j] = 0;
                    } else {
                        A[k][j] += c * A[i][j];
                    }
                }
                B[k] += c * B[i];
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = B[i] / A[i][i];
            for (int k = i - 1; k >= 0; k--) {
                B[k] -= A[k][i] * x[i];
            }
        }
        return x;
    }
}
