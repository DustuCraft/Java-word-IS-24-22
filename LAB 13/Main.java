import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {

    static class Student {
        String name;
        int age;
        double grade;

        Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String toString() {
            return name + " (" + age + ", " + grade + ")";
        }
    }

    static class Order {
        int amount;

        Order(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public String toString() {
            return "Order: " + amount;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20);
        List<String> strings = Arrays.asList("java", "stream", "api", "lambda", "code");

        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 90),
                new Student("Bob", 22, 70),
                new Student("Charlie", 20, 85),
                new Student("David", 23, 60)
        );

        List<Order> orders = Arrays.asList(
                new Order(500),
                new Order(1500),
                new Order(2000),
                new Order(700)
        );

        while (true) {

            System.out.println("\nЗадание");
            System.out.println("1  - Сложение двух чисел");
            System.out.println("2  - Строка в верхний регистр");
            System.out.println("3  - Фильтр нечётных чисел");
            System.out.println("4  - Квадраты чисел");
            System.out.println("5  - Найти максимум");
            System.out.println("6  - Сортировка строк по длине");
            System.out.println("7  - Первая буква заглавная");
            System.out.println("8  - Строки длиной > 5");
            System.out.println("9  - Вывод списка (method reference)");
            System.out.println("10 - Найти минимум (Optional)");
            System.out.println("11 - Consumer (вывод строки)");
            System.out.println("12 - Supplier (случайное число)");
            System.out.println("13 - Сортировка студентов по возрасту");
            System.out.println("14 - Студенты > 80 и сортировка по имени");
            System.out.println("15 - Цепочка (filter → map → sorted)");
            System.out.println("16 - Группировка студентов по возрасту");
            System.out.println("17 - Сумма элементов (reduce)");
            System.out.println("18 - distinct + limit");
            System.out.println("19 - flatMap (список списков)");
            System.out.println("20 - Заказы > 1000 + сортировка");
            System.out.println("0  - Выход");

            System.out.print("Выбери номер: ");
            int choice = scanner.nextInt();

            System.out.println("\n--- Результат ---");

            switch (choice) {

                case 1:
                    BinaryOperator<Integer> sum = (a, b) -> a + b;
                    System.out.println("5 + 3 = " + sum.apply(5, 3));
                    break;

                case 2:
                    Function<String, String> toUpper = String::toUpperCase;
                    System.out.println(toUpper.apply("hello"));
                    break;

                case 3:
                    list.stream().filter(n -> n % 2 != 0)
                            .forEach(System.out::println);
                    break;

                case 4:
                    list.stream().map(n -> n * n)
                            .forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Max = " +
                            list.stream().max(Integer::compare).orElse(0));
                    break;

                case 6:
                    strings.stream()
                            .sorted(Comparator.comparing(String::length))
                            .forEach(System.out::println);
                    break;

                case 7:
                    strings.stream()
                            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                            .forEach(System.out::println);
                    break;

                case 8:
                    strings.stream()
                            .filter(s -> s.length() > 5)
                            .forEach(System.out::println);
                    break;

                case 9:
                    list.forEach(System.out::println);
                    break;

                case 10:
                    System.out.println("Min = " +
                            list.stream().min(Integer::compare).orElse(0));
                    break;

                case 11:
                    Consumer<String> printer = System.out::println;
                    printer.accept("Hello Consumer");
                    break;

                case 12:
                    Supplier<Integer> random = () -> new Random().nextInt(100);
                    System.out.println(random.get());
                    break;

                case 13:
                    students.stream()
                            .sorted(Comparator.comparing(s -> s.age))
                            .forEach(System.out::println);
                    break;

                case 14:
                    students.stream()
                            .filter(s -> s.grade > 80)
                            .sorted(Comparator.comparing(s -> s.name))
                            .forEach(System.out::println);
                    break;

                case 15:
                    list.stream()
                            .filter(x -> x > 5)
                            .map(x -> x * 2)
                            .sorted()
                            .forEach(System.out::println);
                    break;

                case 16:
                    Map<Integer, List<Student>> grouped =
                            students.stream()
                                    .collect(Collectors.groupingBy(s -> s.age));
                    System.out.println(grouped);
                    break;

                case 17:
                    System.out.println("Sum = " +
                            list.stream().reduce(0, Integer::sum));
                    break;

                case 18:
                    list.stream()
                            .distinct()
                            .limit(3)
                            .forEach(System.out::println);
                    break;

                case 19:
                    List<List<Integer>> listOfLists = Arrays.asList(
                            Arrays.asList(1, 2),
                            Arrays.asList(3, 4)
                    );

                    listOfLists.stream()
                            .flatMap(List::stream)
                            .forEach(System.out::println);
                    break;

                case 20:
                    orders.stream()
                            .filter(o -> o.getAmount() > 1000)
                            .sorted(Comparator.comparing(Order::getAmount))
                            .forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
}