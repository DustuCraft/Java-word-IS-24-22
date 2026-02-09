import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nЛабораторная работа №4");
            System.out.println("Выберите номер задания:");
            System.out.println("1 – Знак числа");
            System.out.println("2 – Оценка по баллам");
            System.out.println("3 – Сравнение двух чисел");
            System.out.println("4 – День недели");
            System.out.println("5 – Чётное или нечётное");
            System.out.println("6 – Доступ по возрасту");
            System.out.println("7 – Месяц и количество дней");
            System.out.println("8 – Состояние температуры");
            System.out.println("9 – Проверка диапазона");
            System.out.println("10 – Калькулятор");
            System.out.println("0 – Выход");

            System.out.print("Введите номер задания: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("Введите целое число: ");
                    int n = scanner.nextInt();

                    if (n > 0)
                        System.out.println("Число положительное (пример: 5)");
                    else if (n < 0)
                        System.out.println("Число отрицательное (пример: -3)");
                    else
                        System.out.println("Число равно нулю (пример: 0)");
                }

                case 2 -> {
                    System.out.print("Введите балл (0–100): ");
                    int score = scanner.nextInt();

                    if (score >= 90) System.out.println("Оценка: 5");
                    else if (score >= 75) System.out.println("Оценка: 4");
                    else if (score >= 60) System.out.println("Оценка: 3");
                    else System.out.println("Оценка: 2");
                }

                case 3 -> {
                    System.out.print("Введите первое число: ");
                    int a = scanner.nextInt();
                    System.out.print("Введите второе число: ");
                    int b = scanner.nextInt();

                    if (a > b) System.out.println("Первое число больше");
                    else if (a < b) System.out.println("Второе число больше");
                    else System.out.println("Числа равны");
                }

                case 4 -> {
                    System.out.print("Введите номер дня (1–7): ");
                    int day = scanner.nextInt();

                    switch (day) {
                        case 1 -> System.out.println("Понедельник");
                        case 2 -> System.out.println("Вторник");
                        case 3 -> System.out.println("Среда");
                        case 4 -> System.out.println("Четверг");
                        case 5 -> System.out.println("Пятница");
                        case 6 -> System.out.println("Суббота");
                        case 7 -> System.out.println("Воскресенье");
                        default -> System.out.println("Неверный номер дня");
                    }
                }

                case 5 -> {
                    System.out.print("Введите число: ");
                    int num = scanner.nextInt();
                    if (num % 2 == 0)
                        System.out.println("Число чётное");
                    else
                        System.out.println("Число нечётное");
                }

                case 6 -> {
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    if (age >= 18)
                        System.out.println("Доступ разрешён");
                    else
                        System.out.println("Доступ запрещён");
                }

                case 7 -> {
                    System.out.print("Введите номер месяца (1–12): ");
                    int month = scanner.nextInt();

                    switch (month) {
                        case 1 -> System.out.println("Январь — 31 день");
                        case 2 -> System.out.println("Февраль — 28 или 29 дней");
                        case 3 -> System.out.println("Март — 31 день");
                        case 4 -> System.out.println("Апрель — 30 дней");
                        case 5 -> System.out.println("Май — 31 день");
                        case 6 -> System.out.println("Июнь — 30 дней");
                        case 7 -> System.out.println("Июль — 31 день");
                        case 8 -> System.out.println("Август — 31 день");
                        case 9 -> System.out.println("Сентябрь — 30 дней");
                        case 10 -> System.out.println("Октябрь — 31 день");
                        case 11 -> System.out.println("Ноябрь — 30 дней");
                        case 12 -> System.out.println("Декабрь — 31 день");
                        default -> System.out.println("Неверный номер месяца");
                    }
                }

                case 8 -> {
                    System.out.print("Введите температуру (например 36.6): ");
                    double temp = scanner.nextDouble();

                    if (temp < 0)
                        System.out.println("Холодно");
                    else if (temp <= 20)
                        System.out.println("Тепло");
                    else
                        System.out.println("Жарко");
                }

                case 9 -> {
                    System.out.print("Введите число: ");
                    int x = scanner.nextInt();

                    System.out.println("Пример диапазона: от 10 до 50");

                    if (x >= 10 && x <= 50)
                        System.out.println("Число входит в диапазон 10–50");
                    else
                        System.out.println("Число не входит в диапазон 10–50");
                }

                case 10 -> {
                    System.out.print("Введите первое число: ");
                    double x = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double y = scanner.nextDouble();
                    System.out.print("Введите операцию (+, -, *, /): ");
                    char op = scanner.next().charAt(0);

                    switch (op) {
                        case '+' -> System.out.println("Результат: " + (x + y));
                        case '-' -> System.out.println("Результат: " + (x - y));
                        case '*' -> System.out.println("Результат: " + (x * y));
                        case '/' -> {
                            if (y != 0)
                                System.out.println("Результат: " + (x / y));
                            else
                                System.out.println("Деление на ноль невозможно");
                        }
                        default -> System.out.println("Неверная операция");
                    }
                }

                case 0 -> System.out.println("Выход из программы");

                default -> System.out.println("Неверный выбор");
            }

        } while (choice != 0);
    }
}