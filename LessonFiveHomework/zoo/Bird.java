package ru.geekbrains.javaone.lesson5.zoo;

import ru.geekbrains.javaone.lesson5.Animal;

    public class Bird extends Animal {

        public Bird(String name, int runAbility, float jumpAbility) {
            super(name, runAbility, jumpAbility);
        }

        @Override
        protected void run(int lengthToRun) {
            if (getRunAbility() >= lengthToRun) System.out.println("Птичка " + name + " пробежала " + lengthToRun + " м.");
            else System.out.println("Птичка " + name + " может пробежать такую дистанцию.");
        }

        @Override
        protected void jump(float heightToJump) {
            if (getJumpAbility() >= heightToJump) System.out.println("Птичка " + name + " подпрыгнула на " + heightToJump + " м.");
            else System.out.println("Птичка " + name + " не может подпрыгнуть на такую высоту.");
        }

        @Override
        protected void swim(int lengthToSwim) {
            System.out.println(name + " не плывет. Птички не умеют плавать, они тонут!");
        }

        private int getRunAbility() {
            return runAbility;
        }

        private float getJumpAbility() {
            return jumpAbility;
        }
    }
