import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main1 {


    static ArrayList<String> history = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }


    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("  ⚠ Ошибка: деление на ноль запрещено.");
            return Double.NaN;
        }
        return a / b;
    }


    public static double power(double a, double b) {
        return Math.pow(a, b);
    }


    public static double sqrt(double a) {
        if (a < 0) {
            System.out.println("  ⚠ Ошибка: квадратный корень из отрицательного числа.");
            return Double.NaN;
        }
        return Math.sqrt(a);
    }


    public static double percent(double a, double b) {
        return (a / 100.0) * b;
    }

    public static double sinDeg(double deg) { return Math.sin(Math.toRadians(deg)); }
    public static double cosDeg(double deg) { return Math.cos(Math.toRadians(deg)); }
    public static double tanDeg(double deg) { return Math.tan(Math.toRadians(deg)); }


    public static double evaluateExpression(String expr) {
        expr = expr.replaceAll("\\s+", ""); // убираем пробелы
        return parseAddSub(expr, new int[]{0});
    }

    private static double parseAddSub(String expr, int[] pos) {
        double result = parseMulDiv(expr, pos);
        while (pos[0] < expr.length()) {
            char op = expr.charAt(pos[0]);
            if (op == '+' || op == '-') {
                pos[0]++;
                double right = parseMulDiv(expr, pos);
                result = (op == '+') ? result + right : result - right;
            } else break;
        }
        return result;
    }


    private static double parseMulDiv(String expr, int[] pos) {
        double result = parseUnary(expr, pos);
        while (pos[0] < expr.length()) {
            char op = expr.charAt(pos[0]);
            if (op == '*' || op == '/') {
                pos[0]++;
                double right = parseUnary(expr, pos);
                if (op == '/') {
                    if (right == 0) throw new ArithmeticException("Деление на ноль");
                    result /= right;
                } else {
                    result *= right;
                }
            } else break;
        }
        return result;
    }


    private static double parseUnary(String expr, int[] pos) {
        if (pos[0] < expr.length() && expr.charAt(pos[0]) == '-') {
            pos[0]++;
            return -parseUnary(expr, pos);
        }
        if (pos[0] < expr.length() && expr.charAt(pos[0]) == '(') {
            pos[0]++;
            double result = parseAddSub(expr, pos);
            if (pos[0] < expr.length() && expr.charAt(pos[0]) == ')') pos[0]++;
            return result;
        }
        return parseNumber(expr, pos);
    }


    private static double parseNumber(String expr, int[] pos) {
        int start = pos[0];
        while (pos[0] < expr.length() &&
                (Character.isDigit(expr.charAt(pos[0])) || expr.charAt(pos[0]) == '.')) {
            pos[0]++;
        }
        if (start == pos[0]) throw new NumberFormatException("Неверный символ в позиции " + pos[0]);
        return Double.parseDouble(expr.substring(start, pos[0]));
    }


    public static void clearScreen() {
        for (int i = 0; i < 40; i++) System.out.println();
    }


    public static void addToHistory(String entry) {
        history.add(entry);
    }

    public static void showHistory() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════╗");
        System.out.println("  ║      📋 История вычислений       ║");
        System.out.println("  ╚══════════════════════════════════╝");
        if (history.isEmpty()) {
            System.out.println("  История пуста.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.printf("  %2d. %s%n", i + 1, history.get(i));
            }
        }
    }


    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = Double.parseDouble(scanner.nextLine().trim());
                return val;
            } catch (NumberFormatException e) {

                System.out.println("  ⚠ Ошибка ввода! Введите корректное число (например: 3.14 или -7).");
            }
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(scanner.nextLine().trim());
                if (val >= min && val <= max) return val;
                System.out.printf("  ⚠ Введите число от %d до %d.%n", min, max);
            } catch (NumberFormatException e) {
                // Задание 8: InputMismatchException / NumberFormatException
                System.out.println("  ⚠ Ошибка ввода! Введите целое число.");
            }
        }
    }

    public static void main(String[] args) {
        clearScreen();
        System.out.println("  ╔══════════════════════════════════╗");
        System.out.println("  ║       КАЛЬКУЛЯТОР НА JAVA        ║");
        System.out.println("  ╠══════════════════════════════════╣");
        System.out.println("  ║  1 — Консольный калькулятор      ║");
        System.out.println("  ║  2 — Графический (Swing GUI)     ║");
        System.out.println("  ╚══════════════════════════════════╝");
        int mode = readInt("  Ваш выбор: ", 1, 2);

        if (mode == 2) {
            SwingCalculator.launch();
        } else {
            runConsoleCalculator();
        }
    }

    public static void runConsoleCalculator() {
        boolean running = true;


        while (running) {
            clearScreen();
            System.out.println();
            System.out.println("  ╔══════════════════════════════════════╗");
            System.out.println("  ║          МЕНЮ КАЛЬКУЛЯТОРА           ║");
            System.out.println("  ╠══════════════════════════════════════╣");
            System.out.println("  ║  1  — Сложение          (+)          ║");
            System.out.println("  ║  2  — Вычитание         (-)          ║");
            System.out.println("  ║  3  — Умножение         (*)          ║");
            System.out.println("  ║  4  — Деление           (/)          ║");
            System.out.println("  ║  5  — Степень           (x^y)        ║");
            System.out.println("  ║  6  — Квадратный корень (√x)         ║");
            System.out.println("  ║  7  — Процент           (a% от b)    ║");
            System.out.println("  ║  8  — Тригонометрия     (sin/cos/tan)║");
            System.out.println("  ║  9  — Вычислить выражение            ║");
            System.out.println("  ║  10 — История вычислений             ║");
            System.out.println("  ║  0  — Выход                          ║");
            System.out.println("  ╚══════════════════════════════════════╝");


            int choice = readInt("  Выберите операцию (0–10): ", 0, 10);

            if (choice == 0) {
                running = false;
                System.out.println("\n  До свидания!");
                break;
            }

            double num1, num2, result;
            String entry;

            switch (choice) {

                case 1:
                    num1 = readDouble("  Первое число:  ");
                    num2 = readDouble("  Второе число:  ");
                    result = add(num1, num2);
                    entry = num1 + " + " + num2 + " = " + result;
                    System.out.println("  Результат: " + result);
                    addToHistory(entry);
                    break;

                case 2:
                    num1 = readDouble("  Первое число:  ");
                    num2 = readDouble("  Второе число:  ");
                    result = subtract(num1, num2);
                    entry = num1 + " - " + num2 + " = " + result;
                    System.out.println("  Результат: " + result);
                    addToHistory(entry);
                    break;

                case 3:
                    num1 = readDouble("  Первое число:  ");
                    num2 = readDouble("  Второе число:  ");
                    result = multiply(num1, num2);
                    entry = num1 + " × " + num2 + " = " + result;
                    System.out.println("  Результат: " + result);
                    addToHistory(entry);
                    break;

                case 4:
                    num1 = readDouble("  Первое число:  ");
                    num2 = readDouble("  Второе число:  ");
                    result = divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        entry = num1 + " ÷ " + num2 + " = " + result;
                        System.out.println("  Результат: " + result);
                        addToHistory(entry);
                    }
                    break;


                case 5:
                    num1 = readDouble("  Основание (x): ");
                    num2 = readDouble("  Показатель (y): ");
                    result = power(num1, num2);
                    entry = num1 + " ^ " + num2 + " = " + result;
                    System.out.println("  Результат: " + result);
                    addToHistory(entry);
                    break;


                case 6:
                    num1 = readDouble("  Число: ");
                    result = sqrt(num1);
                    if (!Double.isNaN(result)) {
                        entry = "√" + num1 + " = " + result;
                        System.out.println("  Результат: " + result);
                        addToHistory(entry);
                    }
                    break;


                case 7:
                    num1 = readDouble("  a (процент): ");
                    num2 = readDouble("  b (от числа): ");
                    result = percent(num1, num2);
                    entry = num1 + "% от " + num2 + " = " + result;
                    System.out.println("  " + num1 + "% от " + num2 + " = " + result);
                    addToHistory(entry);
                    break;


                case 8:
                    System.out.println("  1 — sin   2 — cos   3 — tan");
                    int trig = readInt("  Выбор: ", 1, 3);
                    num1 = readDouble("  Угол в градусах: ");
                    String fname;
                    switch (trig) {
                        case 1: result = sinDeg(num1); fname = "sin"; break;
                        case 2: result = cosDeg(num1); fname = "cos"; break;
                        default: result = tanDeg(num1); fname = "tan"; break;
                    }
                    entry = fname + "(" + num1 + "°) = " + result;
                    System.out.println("  " + entry);
                    addToHistory(entry);
                    break;


                case 9:
                    System.out.print("  Выражение (например: 2 + 3 * 4): ");
                    String expr = scanner.nextLine().trim();
                    try {
                        result = evaluateExpression(expr);
                        entry = expr + " = " + result;
                        System.out.println("  " + entry);
                        addToHistory(entry);
                    } catch (Exception ex) {
                        System.out.println("  ⚠ Ошибка: " + ex.getMessage());
                    }
                    break;


                case 10:
                    showHistory();
                    break;
            }

            System.out.print("\n  Нажмите Enter, чтобы продолжить...");
            scanner.nextLine();
        }
    }
}

class SwingCalculator extends JFrame implements ActionListener {

    private JTextField display;          // поле вывода
    private StringBuilder input = new StringBuilder();

    public SwingCalculator() {
        setTitle("Java Калькулятор");
        setSize(340, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout(5, 5));
        getContentPane().setBackground(new Color(30, 30, 30));


        display = new JTextField("0");
        display.setFont(new Font("Courier New", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(20, 20, 20));
        display.setForeground(new Color(230, 230, 230));
        display.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        display.setPreferredSize(new Dimension(340, 75));
        add(display, BorderLayout.NORTH);


        JPanel grid = new JPanel(new GridLayout(5, 4, 6, 6));
        grid.setBackground(new Color(30, 30, 30));
        grid.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        String[] labels = {
                "C",  "±",  "%",  "÷",
                "7",  "8",  "9",  "×",
                "4",  "5",  "6",  "−",
                "1",  "2",  "3",  "+",
                "0",  ".",  "⌫",  "="
        };

        for (String lbl : labels) {
            JButton btn = makeButton(lbl);
            btn.addActionListener(this);
            grid.add(btn);
        }
        add(grid, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    private JButton makeButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Courier New", Font.BOLD, 20));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        switch (text) {
            case "=":
                btn.setBackground(new Color(255, 149, 0));
                btn.setForeground(Color.WHITE);
                break;
            case "÷": case "×": case "−": case "+":
                btn.setBackground(new Color(80, 80, 80));
                btn.setForeground(new Color(255, 180, 60));
                break;
            case "C": case "±": case "%": case "⌫":
                btn.setBackground(new Color(90, 90, 90));
                btn.setForeground(new Color(200, 200, 200));
                break;
            default:
                btn.setBackground(new Color(55, 55, 55));
                btn.setForeground(Color.WHITE);
        }
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {

            case "C":
                input.setLength(0);
                display.setText("0");
                break;

            case "⌫":
                if (input.length() > 0) {
                    input.deleteCharAt(input.length() - 1);
                    display.setText(input.length() == 0 ? "0" : input.toString());
                }
                break;

            case "±":
                if (input.length() > 0) {
                    String s = input.toString();
                    if (s.startsWith("-")) input.deleteCharAt(0);
                    else input.insert(0, "-");
                    display.setText(input.toString());
                }
                break;

            case "%":
                try {
                    double v = Double.parseDouble(input.toString());
                    v /= 100.0;
                    String r = (v == Math.floor(v)) ? String.valueOf((long) v) : String.valueOf(v);
                    input.setLength(0);
                    input.append(r);
                    display.setText(r);
                } catch (Exception ignored) {}
                break;

            case "=":
                try {
                    String expr = input.toString()
                            .replace("÷", "/")
                            .replace("×", "*")
                            .replace("−", "-");
                    double result = Main1.evaluateExpression(expr);
                    String res = (result == Math.floor(result) && !Double.isInfinite(result))
                            ? String.valueOf((long) result)
                            : String.valueOf(result);
                    display.setText(res);
                    Main1.addToHistory(input + " = " + res);
                    input.setLength(0);
                    input.append(res);
                } catch (Exception ex) {
                    display.setText("Ошибка");
                    input.setLength(0);
                }
                break;

            default:
                if (input.toString().equals("0") && cmd.matches("[0-9]")) {
                    input.setLength(0);
                }
                input.append(cmd);
                display.setText(input.toString());
        }
    }


    public static void launch() {
        SwingUtilities.invokeLater(() -> new SwingCalculator().setVisible(true));
    }
}