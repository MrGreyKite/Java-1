package ru.geekbrains.javaone.lesson5.zoo;

import ru.geekbrains.javaone.lesson5.Animal;

public class Dog extends Animal {
    private int swimAbility;

    public Dog(String name, int runAbility, float jumpAbility, int swimAbility) {
        super(name, runAbility, jumpAbility);
        this.swimAbility = swimAbility;
    }

    @Override
    protected void run(int lengthToRun) {
        if (getRunAbility() >= lengthToRun) System.out.println("Песик " + name + " пробежал " + lengthToRun + " м.");
        else System.out.println("Песик " + name + " не может пробежать такую дистанцию.");
    }

    @Override
    protected void jump(float heightToJump) {
        if (getJumpAbility() >= heightToJump) System.out.println("Песик " + name + " подпрыгнул на " + heightToJump + " м.");
        else System.out.println("Песик  " + name + " не может подпрыгнуть на такую высоту.");
    }

    @Override
    protected void swim(int lengthToSwim) {
        if (getSwimAbility() >= lengthToSwim) System.out.println("Песик " + name + " проплыл " + lengthToSwim + " м.");
        else System.out.println("Песик " + name + " не может проплыть такую дистанцию.");
    }

    private int getRunAbility() {
        return runAbility;
    }

    private float getJumpAbility() {
        return jumpAbility;
    }

    private int getSwimAbility() {
        return swimAbility;
    }
}
