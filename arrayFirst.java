package ru.gb.task3;

import java.util.Arrays;
import java.util.Scanner;

public class arrayFirst {
    public static int[] arrayForFunc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};//Массив для 6 - 8 подзадач

    public static void main(String[] argv) {
        // Первая подзадача
        int[] arr = {1, 0, 0, 1, 0, 1, 1, 1, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));

// Вторая подзадача
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr2));

// Третья подзадача
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));

// Четвертая подзадача
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива:");
        int a = scanner.nextInt();
        int[][] arr4 = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if ((i == j) || (i == (a - j - 1))) {
                    arr4[i][j] = 1;
                } else {
                    arr4[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            System.out.println(Arrays.toString(arr4[i]));
        }

//Аргументы для функции пятой подзадачи
        System.out.println("Введите количество элементов одномерного массива:");
        int i = scanner.nextInt();
        System.out.println("Введите значение элементов массива:");
        int val = scanner.nextInt();
        System.out.println(Arrays.toString(getArray(i, val)));

        // Вызов функции шестой подзадачи
        System.out.println(Arrays.toString(getMinMax(arrayForFunc)));

        // Вызов функции седьмой подзадачи
        if (getBoarder(arrayForFunc)) {
            System.out.println("Массив имеет границы равенства левая-правая часть");
        } else {
            System.out.println("Массив НЕ имеет границы равенства левая-правая часть");
        }

        //Вызов функции восьмой подзадачи
        int set = 22;
        System.out.println(Arrays.toString(stepArray(set, arrayForFunc)));


    }

    //Функция пятой подзадачи
    public static int[] getArray(int num, int val) {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = val;
        }
        return arr;
    }

    // Функция шестой задачи
    public static int[] getMinMax(int[] a1) {
        int[] b = {a1[0], a1[0]};                  //b[0] - минимальное значение, b[1] - максимальное значение
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] < b[0]) {
                b[0] = a1[i];
            }
            if (a1[i] > b[1]) {
                b[1] = a1[i];
            }
        }
        return b;
    }

    //Функция седьмой подзадачи
    public static boolean getBoarder(int[] a2) {
        int left = 0;
        for (int i = 0; i < a2.length; i++) {
            int right = 0;
            left += a2[i];
            for (int j = i + 1; j < a2.length; j++) {
                right += a2[j];
            }
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    //Функция восьмой подзадачи
    public static int[] stepArray(int n, int[] a3) {
        //n=n%a3.length;
        for (int j=0;j<(Math.abs(n)% a3.length);j++) {
            if(n>0) {
                int c = a3[a3.length - 1];
                for (int i = a3.length - 1; i > 0; i--) {
                    a3[i] = a3[i - 1];
                }
                a3[0] = c;
            }
            else if (n<0){
                int c = a3[0];
                for (int i = 0; i < a3.length-1; i++) {
                    a3[i] = a3[i + 1];
                }
                a3[a3.length-1] = c;
            }
            else {return a3;}
        }
        return a3;


    }


}
