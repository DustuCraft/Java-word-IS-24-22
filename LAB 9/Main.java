public class Main {

    public static void main(String[] args) {

        // Вариант 1
        System.out.println("=== Transport ===");
        Car1 car = new Car1("Car", 120);
        Train train = new Train("Train", 200);
        Airplane airplane = new Airplane("Airplane", 900);
        car.move();
        train.move();
        airplane.move();

        // Вариант 2
        System.out.println("\n=== Shapes ===");
        Circle circle = new Circle(5);
        Rectangle rect = new Rectangle(4,6);
        Triangle tri = new Triangle(3,4);
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rect.area());
        System.out.println("Triangle area: " + tri.area());

        // Вариант 3
        System.out.println("\n=== Employees ===");
        Manager manager = new Manager("Alice",5000);
        Developer developer = new Developer("Bob",4000);
        Designer designer = new Designer("Tom",3500);
        manager.work();
        developer.work();
        designer.work();

        // Вариант 4
        System.out.println("\n=== Bank ===");
        SavingsAccount sa = new SavingsAccount("111",1000);
        sa.deposit(500);
        sa.withdraw(200);

        CreditAccount ca = new CreditAccount("222",500);
        ca.deposit(200);
        ca.withdraw(300);

        // Вариант 5
        System.out.println("\n=== Education ===");
        Student1 student = new Student1("Ali");
        Teacher teacher = new Teacher("John");
        Administrator admin = new Administrator("Sara");
        student.study();
        teacher.teach();
        admin.manage();

        // Вариант 6
        System.out.println("\n=== Devices ===");
        Laptop laptop = new Laptop("Dell",65);
        Smartphone phone = new Smartphone("Samsung",20);
        Tablet tablet = new Tablet("Apple",30);
        laptop.turnOn();
        phone.turnOn();
        tablet.turnOn();

        // Вариант 7
        System.out.println("\n=== Animals ===");
        Lion lion = new Lion();
        Elephant elephant = new Elephant();
        Monkey monkey = new Monkey();
        lion.makeSound();
        elephant.makeSound();
        monkey.makeSound();

        // Вариант 8
        System.out.println("\n=== Vehicles ===");
        Bike bike = new Bike();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
        bike.startEngine();
        bus.startEngine();
        taxi.startEngine();

        // Вариант 9
        System.out.println("\n=== Components ===");
        CPU cpu = new CPU();
        RAM ram = new RAM();
        GPU gpu = new GPU();
        cpu.showInfo();
        ram.showInfo();
        gpu.showInfo();

        // Вариант 10
        System.out.println("\n=== Products ===");
        Food food = new Food(10);
        Electronics el = new Electronics(500);
        Clothes clothes = new Clothes(70);
        food.showPrice();
        el.showPrice();
        clothes.showPrice();

        // Вариант 11
        System.out.println("\n=== Team ===");
        Player player = new Player();
        Coach coach = new Coach();
        Doctor doctor = new Doctor();
        player.play();
        coach.train();
        doctor.heal();

        // Вариант 12
        System.out.println("\n=== Instruments ===");
        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        Drums drums = new Drums();
        guitar.playSound();
        piano.playSound();
        drums.playSound();

        // Вариант 13
        System.out.println("\n=== Courses ===");
        ProgrammingCourse pc = new ProgrammingCourse();
        MathCourse mc = new MathCourse();
        HistoryCourse hc = new HistoryCourse();
        pc.startCourse();
        mc.startCourse();
        hc.startCourse();

        // Вариант 14
        System.out.println("\n=== Characters ===");
        Warrior warrior = new Warrior();
        Mage mage = new Mage();
        Archer archer = new Archer();
        warrior.attack();
        mage.attack();
        archer.attack();

        // Вариант 15
        System.out.println("\n=== Appliances ===");
        Refrigerator ref = new Refrigerator();
        WashingMachine wm = new WashingMachine();
        Microwave mw = new Microwave();
        ref.operate();
        wm.operate();
        mw.operate();
    }
}

/* Вариант 1 */
class Transport{
    String name;
    int speed;

    Transport(String name,int speed){
        this.name=name;
        this.speed=speed;
    }

    void move(){
        System.out.println(name + " moves with speed " + speed);
    }
}

class Car1 extends Transport{
    Car1(String name,int speed){
        super(name,speed);
    }
}

class Train extends Transport{
    Train(String name,int speed){
        super(name,speed);
    }
}

class Airplane extends Transport{
    Airplane(String name,int speed){
        super(name,speed);
    }
}

/* Вариант 2 */
class Shape{
    double area(){
        return 0;
    }
}

class Circle extends Shape{
    double r;
    Circle(double r){ this.r=r; }
    double area(){ return Math.PI*r*r; }
}

class Rectangle extends Shape{
    double a,b;
    Rectangle(double a,double b){ this.a=a; this.b=b; }
    double area(){ return a*b; }
}

class Triangle extends Shape{
    double a,h;
    Triangle(double a,double h){ this.a=a; this.h=h; }
    double area(){ return 0.5*a*h; }
}

/* Вариант 3 */
class Employee{
    String name;
    double salary;

    Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }

    void work(){
        System.out.println(name + " is working");
    }
}

class Manager extends Employee{
    Manager(String name,double salary){ super(name,salary); }
}

class Developer extends Employee{
    Developer(String name,double salary){ super(name,salary); }
}

class Designer extends Employee{
    Designer(String name,double salary){ super(name,salary); }
}

/* Вариант 4 */
class BankAccount{
    String accountNumber;
    double balance;

    BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    void deposit(double amount){
        balance+=amount;
        System.out.println("Deposit: "+amount+" Balance: "+balance);
    }

    void withdraw(double amount){
        balance-=amount;
        System.out.println("Withdraw: "+amount+" Balance: "+balance);
    }
}

class SavingsAccount extends BankAccount{
    SavingsAccount(String a,double b){ super(a,b); }
}

class CreditAccount extends BankAccount{
    CreditAccount(String a,double b){ super(a,b); }
}

/* Вариант 5 */
class Person{
    String name;
    Person(String name){ this.name=name; }
}

class Student1 extends Person{
    Student1(String name){ super(name); }
    void study(){ System.out.println(name+" studies"); }
}

class Teacher extends Person{
    Teacher(String name){ super(name); }
    void teach(){ System.out.println(name+" teaches"); }
}

class Administrator extends Person{
    Administrator(String name){ super(name); }
    void manage(){ System.out.println(name+" manages"); }
}

/* Вариант 6 */
class Device{
    String brand;
    int power;

    Device(String brand,int power){
        this.brand=brand;
        this.power=power;
    }

    void turnOn(){
        System.out.println(brand+" device is turned on");
    }
}

class Laptop extends Device{
    Laptop(String b,int p){ super(b,p); }
}

class Smartphone extends Device{
    Smartphone(String b,int p){ super(b,p); }
}

class Tablet extends Device{
    Tablet(String b,int p){ super(b,p); }
}

/* Вариант 7 */
class Animal{
    void makeSound(){
        System.out.println("Animal sound");
    }
}

class Lion extends Animal{
    void makeSound(){ System.out.println("Lion roars"); }
}

class Elephant extends Animal{
    void makeSound(){ System.out.println("Elephant trumpets"); }
}

class Monkey extends Animal{
    void makeSound(){ System.out.println("Monkey screams"); }
}

/* Вариант 8 */
class Vehicle{
    void startEngine(){
        System.out.println("Engine started");
    }
}

class Bike extends Vehicle{}
class Bus extends Vehicle{}
class Taxi extends Vehicle{}

/* Вариант 9 */
class Component{
    void showInfo(){
        System.out.println("Component info");
    }
}

class CPU extends Component{}
class RAM extends Component{}
class GPU extends Component{}

/* Вариант 10 */
class Product{
    double price;

    Product(double price){
        this.price=price;
    }

    void showPrice(){
        System.out.println("Price: "+price);
    }
}

class Food extends Product{
    Food(double p){ super(p); }
}

class Electronics extends Product{
    Electronics(double p){ super(p); }
}

class Clothes extends Product{
    Clothes(double p){ super(p); }
}

/* Вариант 11 */
class TeamMember{}

class Player extends TeamMember{
    void play(){ System.out.println("Player plays"); }
}

class Coach extends TeamMember{
    void train(){ System.out.println("Coach trains players"); }
}

class Doctor extends TeamMember{
    void heal(){ System.out.println("Doctor heals players"); }
}

/* Вариант 12 */
class Instrument{
    void playSound(){
        System.out.println("Instrument sound");
    }
}

class Guitar extends Instrument{
    void playSound(){ System.out.println("Guitar sound"); }
}

class Piano extends Instrument{
    void playSound(){ System.out.println("Piano sound"); }
}

class Drums extends Instrument{
    void playSound(){ System.out.println("Drums sound"); }
}

/* Вариант 13 */
class Course{
    void startCourse(){
        System.out.println("Course started");
    }
}

class ProgrammingCourse extends Course{}
class MathCourse extends Course{}
class HistoryCourse extends Course{}

/* Вариант 14 */
class Character{
    void attack(){
        System.out.println("Character attacks");
    }
}

class Warrior extends Character{
    void attack(){ System.out.println("Warrior attacks with sword"); }
}

class Mage extends Character{
    void attack(){ System.out.println("Mage casts spell"); }
}

class Archer extends Character{
    void attack(){ System.out.println("Archer shoots arrow"); }
}

/* Вариант 15 */
class Appliance{
    void operate(){
        System.out.println("Appliance operating");
    }
}

class Refrigerator extends Appliance{}
class WashingMachine extends Appliance{}
class Microwave extends Appliance{}