import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1 - Сумма от 1 до N");
            System.out.println("2 - Количество цифр");
            System.out.println("3 - Таблица умножения");
            System.out.println("4 - Максимальная цифра");
            System.out.println("5 - Палиндром");
            System.out.println("6 - Количество чётных цифр");
            System.out.println("7 - Случайные числа до 0");
            System.out.println("8 - Сумма до 0");
            System.out.println("9 - Проверка пароля");
            System.out.println("0 - Выход");
            System.out.print("Выберите задачу: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Пример: N = 5 → результат: 15");
                    System.out.print("Введите N: ");
                    int n = scanner.nextInt();

                    int sum = 0, i = 1;
                    do {
                        sum += i;
                        i++;
                    } while (i <= n);

                    System.out.println("Сумма: " + sum);
                    break;
                }

                case 2: {
                    System.out.println("Пример: 12345 → результат: 5");
                    System.out.print("Введите число: ");
                    int number = scanner.nextInt();

                    int count = 0;
                    do {
                        number /= 10;
                        count++;
                    } while (number != 0);

                    System.out.println("Количество цифр: " + count);
                    break;
                }

                case 3: {
                    System.out.println("Пример: 3 → таблица от 3*1 до 3*10");
                    System.out.print("Введите число: ");
                    int n = scanner.nextInt();

                    int i = 1;
                    do {
                        System.out.println(n + " * " + i + " = " + (n * i));
                        i++;
                    } while (i <= 10);
                    break;
                }

                case 4: {
                    System.out.println("Пример: 48291 → результат: 9");
                    System.out.print("Введите число: ");
                    int number = scanner.nextInt();

                    int max = 0;
                    do {
                        int digit = number % 10;
                        if (digit > max) max = digit;
                        number /= 10;
                    } while (number > 0);

                    System.out.println("Максимальная цифра: " + max);
                    break;
                }

                case 5: {
                    System.out.println("Пример: 121 → палиндром, 123 → не палиндром");
                    System.out.print("Введите число: ");
                    int number = scanner.nextInt();

                    int original = number, reversed = 0;
                    do {
                        reversed = reversed * 10 + number % 10;
                        number /= 10;
                    } while (number > 0);

                    if (original == reversed)
                        System.out.println("Палиндром");
                    else
                        System.out.println("Не палиндром");
                    break;
                }

                case 6: {
                    System.out.println("Пример: 123456 → результат: 3");
                    System.out.print("Введите число: ");
                    int number = scanner.nextInt();

                    int count = 0;
                    do {
                        int digit = number % 10;
                        if (digit % 2 == 0) count++;
                        number /= 10;
                    } while (number > 0);

                    System.out.println("Чётных цифр: " + count);
                    break;
                }

                case 7: {
                    System.out.println("Пример вывода: 7 3 9 1 0");
                    int number;
                    do {
                        number = (int)(Math.random() * 10);
                        System.out.println(number);
                    } while (number != 0);
                    break;
                }

                case 8: {
                    System.out.println("Пример: 5, 3, -2, 0 → результат: 6");
                    int number, sum = 0;

                    do {
                        System.out.print("Введите число (0 для выхода): ");
                        number = scanner.nextInt();
                        sum += number;
                    } while (number != 0);

                    System.out.println("Сумма: " + sum);
                    break;
                }

                case 9: {
                    System.out.println("Пример: 123 → ошибка, qwerty → принят");
                    scanner.nextLine();

                    String password;
                    do {
                        System.out.print("Введите пароль (>=6 символов): ");
                        password = scanner.nextLine();
                    } while (password.length() < 6);

                    System.out.println("Пароль принят");
                    break;
                }

                case 0:
                    System.out.println("Выход из программы...");
                    break;

                default:
                    System.out.println("Неверный выбор!");
            }

        } while (choice != 0);

        scanner.close();
    }
}