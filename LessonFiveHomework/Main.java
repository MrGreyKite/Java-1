package ru.geekbrains.javaone.lesson5;

import ru.geekbrains.javaone.lesson5.zoo.*;

public class Main {
    public static void main(String[] args) {
        Animal a = new Cat("Мякнус", 250, 2.5f);
        Animal b = new Bird("Гоша", 4, 0.3f);
        Animal c = new Bird("Соня", 5, 0.2f);
        Animal d = new Cat("Фрося", 150, 1f);
        Animal e = new Horse("Гиппа", 2000, 3f, 110);
        Animal f = new Dog("Бобби", 450, 0.5f, 8);
        Animal g = new Dog("Кусака",600, 0.6f,11);

//        a.run(150);
//        b.run(5);
//        b.jump(0.4f);
//        e.swim(150);

        Animal[] zoo = {a, b, c, d, e, f, g};

        runningZoo(zoo,250);
        swimmingZoo(zoo, 10);
        jumpingZoo(zoo, 0.3f);
    }

    public static void runningZoo(Animal[] zoo, int distance) {
        System.out.println("Животные бегут на дистанцию.");
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run(distance);
        }
        System.out.println("-------");
    }

    public static void swimmingZoo(Animal[] zoo, int distance) {
        System.out.println("Животные плывут на дистанцию.");
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].swim(distance);
        }
        System.out.println("-------");
    }

    public static void jumpingZoo(Animal[] zoo, float distance) {
        System.out.println("Животные прыгают на высоту.");
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].jump(distance);
        }
        System.out.println("-------");
    }
}
