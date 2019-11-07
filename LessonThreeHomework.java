package ru.geekbrains.javaone.lesson3;

import java.util.Random;
import java.util.Scanner;

public class LessonThreeHomework {

    public static char[][] gameField;
    public static int fieldSizeY;
    public static int fieldSizeX;

    public static final int DOT_TO_WIN = 4;
    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = '0';
    public static final char EMPTY_DOT = '_';

    public static final Scanner SCAN = new Scanner(System.in);
    public static final Random RAND = new Random();

    public static void main(String[] args) {
        fieldSizeX = 5;
        fieldSizeY = 5;
        initializeField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Выиграл человек!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
            AITurn();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("Выиграл компьютер!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void initializeField() {
        gameField = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                gameField[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print("|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(gameField[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y) {
        return gameField[y][x] == EMPTY_DOT;
    }

    public static void humanTurn () {
            int x, y;
            do {
                System.out.printf("Введите координаты X и Y (от 1 до %d) через %s>>> ", fieldSizeX, "пробел");
                x = SCAN.nextInt() - 1;
                y = SCAN.nextInt() - 1;
            }
            while (!(isCellValid(x, y) || isCellEmpty(x, y)));
            gameField[y][x] = HUMAN_DOT;
        }

     public static void AITurn () {
        int x, y;
        do {
            x = RAND.nextInt(fieldSizeX);
            y = RAND.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
         gameField[y][x] = AI_DOT;
     }

     public static boolean isDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (gameField[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
     }

     //Простая проверка выигрыша для поля 3х3

/*    public static boolean checkDiags(char dot) {
        boolean isDiagRight, isDiagLeft;
        isDiagRight = isDiagLeft = true;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            isDiagRight &= (gameField[i][i] == dot);
            isDiagLeft &= (gameField[DOT_TO_WIN - 1 - i][i] == dot);
        }
        return (isDiagRight || isDiagLeft);
    }

    public static boolean checkLines(char dot) {
        boolean isColumn, isRow;
        for (int v = 0; v < DOT_TO_WIN; v++) {
            isColumn = isRow = true;
            for (int g = 0; g < DOT_TO_WIN; g++) {
                isColumn &= (gameField[v][g] == dot);
                isRow &= (gameField[g][v] == dot);
            }
            if (isColumn || isRow) return true;
        }
        return false;
    }

    public static boolean checkWin(char dot) {
        return checkDiags(dot) || checkLines(dot);
    }*/

//Проверка выигрыша для поля произвольного размера: каждый раз проверяется квадрат "клеток" размера выигрышной последовательности,
//и после проверки происходит смещение по полю, пока не будет достигнут край
     public static boolean checkDiags(char dot, int shiftLeft, int shiftDown) {
        boolean isDiagRight, isDiagLeft;
        isDiagRight = isDiagLeft = true;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            isDiagRight &= (gameField[i + shiftLeft][i + shiftDown] == dot);
            isDiagLeft &= (gameField[DOT_TO_WIN - 1 - i + shiftLeft][i + shiftDown] == dot);
        }
        return (isDiagRight || isDiagLeft);
    }

    public static boolean checkLines(char dot, int shiftLeft, int shiftDown) {
        boolean isColumn, isRow;
        for (int ver = shiftLeft; ver < (DOT_TO_WIN + shiftLeft); ver++) {
            isColumn = isRow = true;
            for (int gor = shiftDown; gor < (DOT_TO_WIN + shiftDown); gor++) {
                isColumn &= (gameField[ver][gor] == dot);
                isRow &= (gameField[gor][ver] == dot);
            }
            if (isColumn || isRow) return true;
        }
        return false;
    }

    public static boolean checkWin(char dot) {
        for (int ver = 0; ver < (fieldSizeY - DOT_TO_WIN + 1); ver++) {
            for (int gor = 0; gor < (fieldSizeX - DOT_TO_WIN + 1); gor++) {
                if (checkDiags(dot, ver, gor) || checkLines(dot, ver, gor)) return true;
            }
        }
        return false;
    }
}
