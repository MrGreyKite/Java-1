package ru.geekbrains.javaone.lesson4;

public class Employee {
    private String fullName;
    private String position;
    private int phoneNumber;
    private int salary;
    private int age;
    private int ID;
    private static int count = 1;

    Employee(String fullName, String position, int phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        ID = count++;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }

    public void info() {
        System.out.println("ID: " + getID() + "; " + "ФИО: " + getFullName() + "; " + "возраст: " + getAge() + "; " + "должность: " + getPosition() + "; " + "заработная плата: " + getSalary() + "; " + "возраст: " + getAge());
    }

    public int salaryUp() {
        if (getAge() >= 45) {
            this.salary = salary + 4500;
        }
        return salary;
    }
}
