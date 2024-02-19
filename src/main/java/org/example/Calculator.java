package org.example;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double num1 = in.nextDouble();
        System.out.println("Введите второе число: ");
        double num2 = in.nextDouble();
        System.out.println("Введите операцию (+, -, *, /): ");
        char operation = in.next().charAt(0);

        double result = 0;

        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                if (num2 != 0){
                    result = num1 / num2;
                }
                else{
                    System.out.println("Деление на ноль!");
                    return;
                }
                break;
            default:
                System.out.println("Неверная операция!");
                return;
        }
        System.out.println("Результат: " + result);
    }
}
