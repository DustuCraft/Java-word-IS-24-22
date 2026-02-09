import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Сумма и среднее арифметическое двух чисел
        // Пример: 4 и 6 → сумма = 10, среднее = 5
        System.out.println("1) Сумма и среднее арифметическое двух чисел");
        System.out.println("Подсказка: введите два числа (например: 4 6)");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double sum = a + b;
        double avg = sum / 2;
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее арифметическое: " + avg);

        // 2. Площадь и периметр прямоугольника
        // Пример: длина = 5, ширина = 3 → S = 15, P = 16
        System.out.println("\n2) Площадь и периметр прямоугольника");
        System.out.println("Подсказка: введите длину и ширину (например: 5 3)");
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        double areaRect = length * width;
        double perimeter = 2 * (length + width);
        System.out.println("Площадь прямоугольника: " + areaRect);
        System.out.println("Периметр прямоугольника: " + perimeter);

        // 3. Площадь круга
        // Пример: r = 2 → S = 12.56
        System.out.println("\n3) Площадь круга");
        System.out.println("Подсказка: введите радиус круга (например: 2)");
        double r = sc.nextDouble();
        final double PI = 3.14;
        double areaCircle = PI * r * r;
        System.out.println("Площадь круга: " + areaCircle);

        // 4. Перевод температуры из Цельсия в Фаренгейт
        // Пример: 0°C → 32°F
        System.out.println("\n4) Перевод температуры из Цельсия в Фаренгейт");
        System.out.println("Подсказка: введите температуру в °C (например: 0)");
        double celsius = sc.nextDouble();
        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println("Температура в Фаренгейтах: " + fahrenheit);

        // 5. Расстояние при равномерном движении
        // Пример: v = 60 км/ч, t = 2 ч → S = 120 км
        System.out.println("\n5) Расстояние при равномерном движении");
        System.out.println("Подсказка: введите скорость и время (например: 60 2)");
        double v = sc.nextDouble();
        double t = sc.nextDouble();
        double distance = v * t;
        System.out.println("Расстояние: " + distance);

        // 6. Квадрат и куб числа
        // Пример: 3 → квадрат = 9, куб = 27
        System.out.println("\n6) Квадрат и куб числа");
        System.out.println("Подсказка: введите число (например: 3)");
        double x = sc.nextDouble();
        double square = x * x;
        double cube = x * x * x;
        System.out.println("Квадрат числа: " + square);
        System.out.println("Куб числа: " + cube);

        sc.close();
    }
}
