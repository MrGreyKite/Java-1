package ru.geekbrains.javaone.lesson2;

import java.util.Arrays;

public class LessonTwoHomeWork {
    public static void main(String[] args) {
        int[] firstArr = new int[5];
        firstArr[0] = 1;
        firstArr[1] = 3;
        firstArr[2] = 5;
        firstArr[3] = 2;
        firstArr[4] = 4;
        System.out.println("Максимальное число в массиве = " + MaxInArray(firstArr));
        System.out.println("Минимальное число в массиве = " + MinInArray(firstArr));

        int[] arrOneZero = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(ReplaceOneZero(arrOneZero)));

        int[] secondArr = new int[8];
        System.out.println(Arrays.toString(fillArray(secondArr)));

        int[] thirdArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(lessThanSixMultiply(thirdArr)));

        int[][] zeroArr = new int[4][4];
        PrintArr(oneDiagonal(zeroArr));

        int[] arrBalance = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(arrBalance));

        int[] forShift = {1, 2, 3, 4, 5, 6};
        int n = 4;
        System.out.println(Arrays.toString(shiftArray(forShift, n)));
    }
//Задача 1. Задать целочисленный массив из элементов 0 и 1.
// Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    public static int[] ReplaceOneZero (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        return arr;
    }

    //Задача 2. Задать пустой целочисленный массив размером 8.
// Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    public static int[] fillArray (int[] arr) {
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 3;
        }
        return arr;
    }

    //Задача 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//Написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    public static int[] lessThanSixMultiply (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        return arr;
    }

    //Задача 4. Задать одномерный массив.
    // Написать методы поиска минимального и максимального элемента;
    public static int MaxInArray (int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int MinInArray (int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

//Задача 5. Создать квадратный целочисленный массив (количество строк и столбцов одинаковое)
// Заполнить его диагональные элементы единицами, используя цикл(ы);
    public static int[][] oneDiagonal (int[][] arr) {
        for (int i = 0, j = (arr.length - 1); i < arr.length; i++, j--) {
            arr[i][j] = 1;
            }
        return arr;
    }

    //Задача 6. Написать метод, в который передается не пустой одномерный целочисленный массив
    //Метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    public static boolean checkBalance (int [] arr) {
        int sumLeft;
        int sumRight;
        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int j = 0; j <= i; j++) sumLeft += arr[j];
            for (int j = i + 1; j < arr.length; j++) sumRight += arr[j];
            if (sumLeft == sumRight) return true;
        }
        return false;
    }
//Задача 7.  Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным)
//Метод должен циклически сместить все элементы массива на n позиций.
    public static int[] shiftArray (int[] arr, int n) {
        int length = arr.length;
        if (n < 0) n = (length - Math.abs(n));
        if (Math.abs(n) > length) n = n - length;
        int[] displaceArr = new int[length];
        System.arraycopy(arr, 0, displaceArr, n, (length - n));
        System.arraycopy(arr, (length - n), displaceArr, 0, n);
        return displaceArr;
    }

    //вспомогательный метод для вывода двумерного массива
    public static void PrintArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
