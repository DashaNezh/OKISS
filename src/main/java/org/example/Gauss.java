package org.example;

import java.util.Arrays;

public class Gauss {
    public static void main(String[] args) {
        double[][] A = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };
        double[] B = {1, 2, 3};

        double[] result = gauss(A, B);

        if (result == null) {
            System.out.println("Система несовместна или имеет множество решений");
        } else {
            System.out.println("Решение: " + Arrays.toString(result));
        }
    }

    public static double[] gauss(double[][] A, double[] B) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            forwardElimination(A, B, i, n);
        }

        return backSubstitution(A, B, n);
    }

    private static void forwardElimination(double[][] A, double[] B, int i, int n) {
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
                return;
            }
            return;
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

    private static double[] backSubstitution(double[][] A, double[] B, int n) {
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
