package ru.geekbrains.javaone.lesson1;

public class LessonOneHomeWork {
    public static void main(String[] args) {
        int i = 264;
        float f = 3.5f;
        boolean bl = true;
        long l = 10000000000000L;
        double d = 22.67;
        byte by = -127;
        short s = 1000;
        char c = 97;
        System.out.println(SimpleExpression(1, 3,5,2));
        System.out.println(Compare(5, 25));
        PositiveOrNegative(6);
        System.out.println(IfNegative(5));
        HelloName("Алекс");
        LeapYear(1500);
    }

    public static float SimpleExpression(int a, int b, int c, int d) {
        float res = (float) (a * (b + (c / d)));
        return res;
    }

    public static boolean Compare (int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        };
        return false;
    }

    public static void PositiveOrNegative (int a) {
         if (a >= 0) {
             System.out.println("Число положительное"); } else {
             System.out.println("Число отрицательное");
         }
    }

    public static boolean IfNegative (int a) {
        if (a < 0) {
            return true;
        } else
            {
        return false;
            }
    }

    public static void HelloName (String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void LeapYear (int year) {
        if (year % 400 == 0) {
            System.out.println("Год високосный");
        }
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}