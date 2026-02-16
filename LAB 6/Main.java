import java.util.Scanner;

public class Main {

    // ===== Задание 1 =====
    public static double rectangleArea(double width, double height) {
        return width * height;
    }

    // ===== Задание 2 =====
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // ===== Задание 3 =====
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static double max(double a, double b) {
        return (a > b) ? a : b;
    }

    // ===== Задание 4 =====
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Факториал отрицательного числа не определён.");
            return -1;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // ===== Задание 5 =====
    public static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        return base * power(base, exponent - 1);
    }

    // ===== Главное меню =====
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание:");
        System.out.println("1 - Площадь прямоугольника");
        System.out.println("2 - Проверка чётности");
        System.out.println("3 - Максимум из двух чисел");
        System.out.println("4 - Факториал (рекурсия)");
        System.out.println("5 - Степень числа (рекурсия)");

        System.out.print("Введите номер задания: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.println("\nПример: width = 5, height = 3 → Площадь = 15\n");

                System.out.print("Введите ширину: ");
                double width = scanner.nextDouble();

                System.out.print("Введите высоту: ");
                double height = scanner.nextDouble();

                double area = rectangleArea(width, height);
                System.out.println("Площадь прямоугольника: " + area);
                break;

            case 2:
                System.out.println("\nПример: 8 → чётное, 7 → нечётное\n");

                System.out.print("Введите число: ");
                int number = scanner.nextInt();

                if (isEven(number)) {
                    System.out.println("Число " + number + " является чётным.");
                } else {
                    System.out.println("Число " + number + " является нечётным.");
                }
                break;

            case 3:
                System.out.println("\nПример: max(10, 25) = 25\n");

                System.out.println("Выберите тип:");
                System.out.println("1 - int");
                System.out.println("2 - double");
                int typeChoice = scanner.nextInt();

                if (typeChoice == 1) {
                    System.out.print("Введите первое число: ");
                    int a = scanner.nextInt();
                    System.out.print("Введите второе число: ");
                    int b = scanner.nextInt();
                    System.out.println("Максимум: " + max(a, b));
                } else if (typeChoice == 2) {
                    System.out.print("Введите первое число: ");
                    double a = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double b = scanner.nextDouble();
                    System.out.println("Максимум: " + max(a, b));
                } else {
                    System.out.println("Неверный выбор типа.");
                }
                break;

            case 4:
                System.out.println("\nПример: 5! = 120\n");

                System.out.print("Введите число: ");
                int factNumber = scanner.nextInt();

                long factResult = factorial(factNumber);
                if (factResult != -1) {
                    System.out.println("Факториал числа " + factNumber + " = " + factResult);
                }
                break;

            case 5:
                System.out.println("\nПример: 2^4 = 16\n");

                System.out.print("Введите основание: ");
                int base = scanner.nextInt();

                System.out.print("Введите показатель степени (положительный): ");
                int exponent = scanner.nextInt();

                if (exponent < 0) {
                    System.out.println("Отрицательная степень не поддерживается.");
                } else {
                    long powerResult = power(base, exponent);
                    System.out.println(base + " в степени " + exponent + " = " + powerResult);
                }
                break;

            default:
                System.out.println("Неверный номер задания.");
        }

        scanner.close();
    }
}