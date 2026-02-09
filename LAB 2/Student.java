class Human {
    String name;
    int age;

    void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
    }
}

// ПРОИЗВОДНЫЙ КЛАСС
class Student extends Human {
    String group;

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Группа: " + group);
    }
}

// ===============================
// ГЛАВНЫЙ КЛАСС (ИМЯ ФАЙЛА = public class)
// ===============================
public class exercise {

    int classField = 100; // поле класса для задачи 3

    void showScope() {
        int localVar = 50; // локальная переменная
        System.out.println("Поле класса: " + classField);
        System.out.println("Локальная переменная: " + localVar);
    }

    public static void main(String[] args) {

        // ЗАДАЧА 1. Переменные и константы
        int a = 10;
        double b = 3.14;
        boolean c = true;
        final int CONST = 100;

        System.out.println("Задача 1:");
        System.out.println("Целое число a: " + a);
        System.out.println("Дробное число b: " + b);
        System.out.println("Логическая переменная c: " + c);
        System.out.println("Константа CONST: " + CONST);
        System.out.println();

        // ЗАДАЧА 2. Примитивные и ссылочные типы
        int number = 25;            // примитивный тип
        String text = "Hello Java"; // ссылочный тип

        System.out.println("Задача 2:");
        System.out.println("Примитив int: " + number);
        System.out.println("Ссылочный String: " + text);
        System.out.println();

        // ЗАДАЧА 3. Область видимости
        System.out.println("Задача 3:");
        exercise obj = new exercise();
        obj.showScope();
        System.out.println();

        // ЗАДАЧА 4. Наследование
        System.out.println("Задача 4:");
        Student student1 = new Student();
        student1.name = "Алия";
        student1.age = 19;
        student1.group = "ИС-24-22";

        System.out.println("Имя: " + student1.name);
        System.out.println("Возраст: " + student1.age);
        System.out.println("Группа: " + student1.group);
        System.out.println();

        // ЗАДАЧА 5. Переопределение и полиморфизм
        System.out.println("Задача 5:");
        Human person = new Student(); // полиморфизм
        person.name = "Ержанат";
        person.age = 19;
        ((Student) person).group = "ИС-24-22";

        person.displayInfo();
    }
}