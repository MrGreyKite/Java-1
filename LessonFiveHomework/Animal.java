package ru.geekbrains.javaone.lesson5;

public class Animal {
    protected final String name;
    protected int runAbility;
    protected float jumpAbility;

    protected Animal(String name, int runAbility, float jumpAbility) {
        this.name = name;
        this.runAbility = runAbility;
        this.jumpAbility = jumpAbility;
    }

    protected void run (int lengthToRun) {
    }

    protected void jump (float height) {
    }

    protected void swim (int lengthToSwim) {}
}
