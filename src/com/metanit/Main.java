package com.metanit;

/*
11.  Вводится массив целых чисел.  Найти в данном массиве кол-во интервалов убывания
(т.е. подряд идущих элементов, которые монотонно убывают). Например, для массива
{1, 3, -2, 11, 7, 3, 3, 2, 4, 2, 7, 12} ответ равен 4 ({3, -2}, {11, 7, 3}, {3, 2} и {4, 2}).
 */


import java.util.Scanner;

public class Main {

    public static int solution(int[] arr) {
        int k = 0;
        int count = 0;
        int newPosition = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = newPosition; j < i; j++) {
                if (arr[j] > arr[i]) {
                    k++;
                } else if (arr[j] <= arr[i]) {
                    if (k > 0) {
                        count++;
                        k = 0;
                    }
                    newPosition = i;
                }
                if (i == arr.length - 1 && j == i - 1 && arr[j] > arr[i]) {
                    count++;
                }
            }
        }
        return count;
    } // Поиск интервалов

    public static void outArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    } // Вывод массива чисел

    public static int[] inputArr() {

        Scanner input = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Введите элементы для массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        return array;
    } // Пользовательский ввод

    public static void searchIntervals(int[] nums) {
        System.out.print("Кол-во интервалов убывания для массива с элементами: ");
        outArr(nums);
        int a = solution(nums);
        System.out.println("Равно " + a);
        System.out.println("*--------------------------------------------------*");
    }

    public static void main(String[] args) {

        int[] nums_1 = {1, 3, -2, 11, 7, 3, 3, 2, 4, 2, 7, 12};
        int[] nums_2 = {0, 0, 0, 0, 0, 0};
        int[] nums_3 = {-2, -4, -6, -1, -1, -3};
        int[] nums_4 = {1, 3, 21, 34, 85, 100};
        int[] nums_5 = {1, 2, 1, 2, 1, 2, 1};
        int[] nums_6 = {3000000, 12345, 63456, 546777, 644, 2};
        int[] nums_7 = {-1, 56, 23, -2, 5, 6, 9};
        int[] nums_8 = {234};
        int[] nums_9 = {97,91, 84, 56, 23, 21};

        int[] nums_10 = inputArr();

          searchIntervals(nums_1); // 1 проверка из таска
          searchIntervals(nums_2); // 2 все нули
          searchIntervals(nums_3); // 3 только отрицательные числа
          searchIntervals(nums_4); // 4 постоянно возрастающие числа
          searchIntervals(nums_5); // 5 повторяющиеся числа
          searchIntervals(nums_6); // 6 большие числа
          searchIntervals(nums_7); // 7 и отрицательные и положительные числа
          searchIntervals(nums_8); // 8 проверка для одного элемента массива
          searchIntervals(nums_9); // 9 постоянно убывающие числа
          searchIntervals(nums_10); // 10 массив пользователя


    }
}
