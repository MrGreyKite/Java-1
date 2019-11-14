package ru.geekbrains.javaone.lesson5.zoo;

import ru.geekbrains.javaone.lesson5.Animal;

public class Horse extends Animal {
    private int swimAbility;

    public Horse(String name, int runAbility, float jumpAbility, int swimAbility) {
        super(name, runAbility, jumpAbility);
        this.swimAbility = swimAbility;
    }

    @Override
    protected void run(int lengthToRun) {
        if (getRunAbility() >= lengthToRun) System.out.println("Лошадка " + name + " пробежала " + lengthToRun + " м.");
        else System.out.println("Лошадка " + name + " не может пробежать такую дистанцию.");
    }

    @Override
    protected void jump(float heightToJump) {
        if (getJumpAbility() >= heightToJump) System.out.println("Лошадка " + name + " подпрыгнула на " + heightToJump + " м.");
        else System.out.println("Лошадка " + name + " не может подпрыгнуть на такую высоту.");
    }

    @Override
    protected void swim(int lengthToSwim) {
        if (getSwimAbility() >= lengthToSwim) System.out.println("Лошадка " + name + " проплыла " + lengthToSwim + " м.");
        else System.out.println("Лошадка " + name + " не может проплыть такую дистанцию.");
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
