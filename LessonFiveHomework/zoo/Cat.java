package ru.geekbrains.javaone.lesson5.zoo;

import ru.geekbrains.javaone.lesson5.Animal;

public class Cat extends Animal {

    public Cat(String name, int runAbility, float jumpAbility) {
        super(name, runAbility, jumpAbility);
    }

    @Override
    protected void run(int lengthToRun) {
        if (getRunAbility() >= lengthToRun) System.out.println("Котик " + name + " пробежал " + lengthToRun + " м.");
        else System.out.println("Котик " + name + " не может пробежать такую дистанцию.");
    }

    @Override
    protected void jump(float heightToJump) {
        if (getJumpAbility() >= heightToJump) System.out.println("Котик " + name + " подпрыгнул на " + heightToJump + " м.");
        else System.out.println("Котик " + name + " не может подпрыгнуть на такую высоту.");
    }

    @Override
    protected void swim(int lengthToSwim) {
        System.out.println(name + " не плывет. Котики не плавают, они боятся воды!");
    }

    private int getRunAbility() {
        return runAbility;
    }

    private float getJumpAbility() {
        return jumpAbility;
    }
}
