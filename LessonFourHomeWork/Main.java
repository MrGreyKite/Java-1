package ru.geekbrains.javaone.lesson4;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Василий Иванович Петров", "программист", 123456, 60000, 35);
        employees[1] = new Employee("Марина Петровна Савельева", "бухгалтер", 654321, 45000, 50);
        employees[2] = new Employee("Федор Михайлович Михеев", "инженер", 999888, 50000, 40);
        employees[3] = new Employee("Зина Васильевна Зайцева", "стажер", 333333, 25000, 25);
        employees[4] = new Employee("Борис Владимирович Попов", "секретарь", 212121, 55000, 46);

        Employee extraEmployee = new Employee("Иван Дмитриевич Каравай", "заместитель директора", 202020, 100000, 44);

        System.out.println(employees[0].getFullName());
        System.out.println(employees[3].getPosition());

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 40) employees[i].info();
        }

       System.out.println(employees[0].getID());
       System.out.println(employees[1].getID());
       System.out.println(extraEmployee.getID());
       System.out.println(employees[4].getID());


       ifSalaryGrow(employees);
    }

    public static void ifSalaryGrow(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 45) {
                employees[i].salaryUp();
                System.out.println("Зарплата повышена в связи с возрастом! Новая зарплата работника по имени " + employees[i].getFullName() + " составляет: " + employees[i].getSalary());
            }
            else {
                System.out.println("Зарплата работника по имени " + employees[i].getFullName() + " остается прежней: " + employees[i].getSalary() + ". Работник не достиг соответствующего возраста.");
            }
        }
    }
}
