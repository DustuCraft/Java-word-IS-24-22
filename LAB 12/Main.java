import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1 - Длина строки");
            System.out.println("2 - Изменение регистра");
            System.out.println("3 - Подсчёт слов");
            System.out.println("4 - Разворот слов");
            System.out.println("5 - Поиск слова");
            System.out.println("6 - Замена слова");
            System.out.println("7 - Палиндром");
            System.out.println("8 - Сравнение строк");
            System.out.println("9 - Разделение строки");
            System.out.println("10 - Гласные и согласные");
            System.out.println("11 - Удалить пробелы");
            System.out.println("12 - Самое длинное слово");
            System.out.println("13 - Символы без пробелов");
            System.out.println("14 - startsWith");
            System.out.println("15 - endsWith");
            System.out.println("16 - Разворот строки");
            System.out.println("17 - Удалить цифры");
            System.out.println("18 - Гласные → *");
            System.out.println("19 - Частота символов");
            System.out.println("20 - Только цифры");
            System.out.println("0 - Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            String text, sentence;
            String[] words;

            switch (choice) {

                case 1:
                    text = "Java — это мощный язык программирования";
                    System.out.println(text);
                    System.out.println("Длина: " + text.length());
                    break;

                case 2:
                    text = "Привет Мир";
                    System.out.println(text.toUpperCase());
                    System.out.println(text.toLowerCase());
                    break;

                case 3:
                    sentence = "Я учусь в университете и изучаю Java";
                    words = sentence.split(" ");
                    System.out.println(sentence);
                    System.out.println("Слов: " + words.length);
                    break;

                case 4:
                    sentence = "Программирование это интересно";
                    words = sentence.split(" ");
                    for (String word : words) {
                        System.out.print(new StringBuilder(word).reverse() + " ");
                    }
                    System.out.println();
                    break;

                case 5:
                    text = "Я люблю изучать Java программирование";
                    String word = "Java";
                    System.out.println(text);
                    System.out.println(text.contains(word) ? "Найдено" : "Не найдено");
                    break;

                case 6:
                    text = "Я учу старое слово";
                    System.out.println(text.replace("старое", "новое"));
                    break;

                case 7:
                    text = "level";
                    String reversed = new StringBuilder(text).reverse().toString();
                    System.out.println(text.equals(reversed) ? "Палиндром" : "Не палиндром");
                    break;

                case 8:
                    String str1 = "Java";
                    String str2 = "Java";
                    System.out.println(str1.equals(str2) ? "Равны" : "Не равны");
                    break;

                case 9:
                    text = "яблоко,банан,груша";
                    String[] parts = text.split(",");
                    for (String part : parts) {
                        System.out.println(part);
                    }
                    break;

                case 10:
                    text = "Программирование";
                    int vowels = 0, consonants = 0;
                    for (char c : text.toLowerCase().toCharArray()) {
                        if ("аеёиоуыэюя".indexOf(c) != -1) vowels++;
                        else if (Character.isLetter(c)) consonants++;
                    }
                    System.out.println("Гласные: " + vowels);
                    System.out.println("Согласные: " + consonants);
                    break;

                case 11:
                    text = "Я люблю Java";
                    System.out.println(text.replace(" ", ""));
                    break;

                case 12:
                    text = "Java это очень интересный язык";
                    words = text.split(" ");
                    String longest = "";
                    for (String w : words) {
                        if (w.length() > longest.length()) longest = w;
                    }
                    System.out.println("Самое длинное: " + longest);
                    break;

                case 13:
                    text = "Я люблю Java";
                    System.out.println(text.replace(" ", "").length());
                    break;

                case 14:
                    text = "Привет мир";
                    System.out.println(text.startsWith("Привет"));
                    break;

                case 15:
                    text = "Это предложение.";
                    System.out.println(text.endsWith("."));
                    break;

                case 16:
                    text = "Java";
                    System.out.println(new StringBuilder(text).reverse());
                    break;

                case 17:
                    text = "Java123";
                    System.out.println(text.replaceAll("\\d", ""));
                    break;

                case 18:
                    text = "Программирование";
                    System.out.println(text.replaceAll("[аеёиоуыэюяАЕЁИОУЫЭЮЯ]", "*"));
                    break;

                case 19:
                    text = "java";
                    for (char c : text.toCharArray()) {
                        int count = 0;
                        for (char x : text.toCharArray()) {
                            if (c == x) count++;
                        }
                        System.out.println(c + ": " + count);
                    }
                    break;

                case 20:
                    text = "12345";
                    System.out.println(text.matches("\\d+") ? "Только цифры" : "Есть другие символы");
                    break;

                default:
                    System.out.println("Ошибка!");
            }
        }

        scanner.close();
    }
}