import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;

class AllApplets extends Applet implements ActionListener {

    CardLayout cardLayout;
    Panel mainPanel;
    Task8Panel task8Panel;

    // ── main: запуск как обычного приложения ────────────────
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Applets — Все задания");
        AllApplets applet = new AllApplets();
        applet.init();
        applet.start();
        frame.add(applet);
        frame.setSize(700, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void init() {
        setLayout(new BorderLayout());

        // ── Панель навигации (верх) ──────────────────────────
        Panel navPanel = new Panel(new FlowLayout());
        for (int i = 1; i <= 9; i++) {
            Button b = new Button("Задание " + i);
            b.setActionCommand("task" + i);
            b.addActionListener(this);
            navPanel.add(b);
        }
        add(navPanel, BorderLayout.NORTH);

        // ── Основная область с CardLayout ───────────────────
        cardLayout = new CardLayout();
        mainPanel  = new Panel(cardLayout);

        mainPanel.add(new Task1Panel(), "task1");
        mainPanel.add(new Task2Panel(), "task2");
        mainPanel.add(new Task3Panel(), "task3");
        mainPanel.add(new Task4Panel(), "task4");
        mainPanel.add(new Task5Panel(), "task5");
        mainPanel.add(new Task6Panel(), "task6");
        mainPanel.add(new Task7Panel(), "task7");

        task8Panel = new Task8Panel();
        mainPanel.add(task8Panel, "task8");

        mainPanel.add(new Task9Panel(), "task9");

        add(mainPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        cardLayout.show(mainPanel, cmd);
        if (cmd.equals("task8")) {
            task8Panel.startAnimation();
        } else {
            task8Panel.stopAnimation();
        }
    }


    static class Task1Panel extends Panel {
        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawString("Рисование фигур", 10, 20);

            g.drawRect(40, 40, 130, 80);
            g.drawString("Прямоугольник", 55, 135);

            g.drawOval(230, 40, 100, 100);
            g.drawString("Круг", 265, 155);

            g.drawLine(380, 40, 500, 120);
            g.drawString("Линия", 420, 140);
        }
    }


    static class Task2Panel extends Panel {
        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawString("Вроде не дольтоник", 10, 20);

            Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA};
            String[] names = {"Красный", "Зелёный", "Синий", "Оранжевый", "Пурпурный"};

            for (int i = 0; i < colors.length; i++) {
                g.setColor(colors[i]);
                g.fillRect(20 + i * 110, 40, 90, 70);
                g.setColor(Color.BLACK);
                g.drawString(names[i], 22 + i * 110, 125);
            }
        }
    }

    static class Task3Panel extends Panel {
        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawString("Вот это шрифт", 10, 20);

            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 28));
            g.drawString("Hello Java Applet", 80, 100);

            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.ITALIC, 18));
            g.drawString("Hello Java Applet", 130, 160);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(":)", 20, 220);
        }
    }

    static class Task4Panel extends Panel implements ActionListener {
        Label label;

        Task4Panel() {
            setLayout(new FlowLayout());
            add(new Label("Кнопка?:"));
            Button btn = new Button("Нажми меня");
            label = new Label("                              ");
            btn.addActionListener(this);
            add(btn);
            add(label);
        }

        public void actionPerformed(ActionEvent e) {
            label.setText("Буум!");
        }
    }

    static class Task5Panel extends Panel implements ActionListener {
        int count = 0;
        Label label;

        Task5Panel() {
            setLayout(new FlowLayout());
            add(new Label("Нажималка"));
            Button btn = new Button("Нажми");
            label = new Label("Счётчик: 0");
            btn.addActionListener(this);
            add(btn);
            add(label);
        }

        public void actionPerformed(ActionEvent e) {
            count++;
            label.setText("Счётчик: " + count);
        }
    }

    static class Task6Panel extends Panel implements ActionListener {
        TextField textField;
        Label label;

        Task6Panel() {
            setLayout(new FlowLayout());
            add(new Label("Введите имя:"));
            textField = new TextField(15);
            Button btn = new Button("Приветствовать");
            label = new Label("                              ");
            btn.addActionListener(this);
            add(textField);
            add(btn);
            add(label);
        }

        public void actionPerformed(ActionEvent e) {
            label.setText("Привет, " + textField.getText() + "!");
        }
    }

    static class Task7Panel extends Panel implements ActionListener {
        Color currentColor = Color.BLUE;
        Panel canvas;

        Task7Panel() {
            setLayout(new BorderLayout());

            Panel btnPanel = new Panel(new FlowLayout());
            btnPanel.add(new Label("КВАдраты"));
            for (String lbl : new String[]{"Red", "Green", "Blue"}) {
                Button b = new Button(lbl);
                b.addActionListener(this);
                btnPanel.add(b);
            }
            add(btnPanel, BorderLayout.NORTH);

            canvas = new Panel() {
                public void paint(Graphics g) {
                    g.setColor(currentColor);
                    g.fillRect(100, 30, 200, 100);
                    g.setColor(Color.BLACK);
                    g.drawString("Выберите цвет кнопкой", 120, 150);
                }
            };
            add(canvas, BorderLayout.CENTER);
        }

        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Red":   currentColor = Color.RED;   break;
                case "Green": currentColor = Color.GREEN; break;
                case "Blue":  currentColor = Color.BLUE;  break;
            }
            canvas.repaint();
        }
    }


    static class Task8Panel extends Panel implements Runnable {
        int x = 20;
        int speed = 4;
        Thread thread;

        void startAnimation() {
            if (thread == null || !thread.isAlive()) {
                thread = new Thread(this);
                thread.start();
            }
        }

        void stopAnimation() {
            thread = null;
        }

        public void run() {
            while (thread != null) {
                x += speed;
                int w = getWidth();
                if (w > 0) {
                    if (x > w - 60) speed = -Math.abs(speed);
                    if (x < 20)     speed =  Math.abs(speed);
                }
                repaint();
                try { Thread.sleep(16); } catch (InterruptedException ex) { break; }
            }
        }

        public void paint(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawString("Анимация (круг движется влево/вправо)", 10, 20);
            g.setColor(Color.YELLOW);
            g.fillOval(x, 80, 50, 50);
            g.setColor(Color.BLACK);
            g.drawOval(x, 80, 50, 50);
            g.drawString("x = " + x, 10, 180);
        }
    }

    static class Task9Panel extends Panel implements MouseListener {
        ArrayList<Point> points = new ArrayList<>();

        Task9Panel() {
            addMouseListener(this);
        }

        public void mouseClicked(MouseEvent e) {
            points.add(new Point(e.getX(), e.getY()));
            repaint();
        }

        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawString("Кликни в любом месте — появится круг", 10, 20);
            g.setColor(Color.RED);
            for (Point p : points) {
                g.fillOval(p.x - 10, p.y - 10, 20, 20);
            }
        }

        public void mousePressed(MouseEvent e)  {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e)  {}
        public void mouseExited(MouseEvent e)   {}
    }
}