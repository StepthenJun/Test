package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MyAnimalShop implements AnimalShop{
    private double balance;
    private double outputprice;
    private ArrayList <Animal>animalList = new ArrayList<>();
    private ArrayList <Customer>customList = new ArrayList<>();
    private boolean work;

    public MyAnimalShop() {
    }

    public MyAnimalShop(double balance, ArrayList animalList, ArrayList customList, boolean work) {
        this.balance = balance;
        this.animalList = animalList;
        this.customList = customList;
        this.work = work;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOutputprice() {
        return outputprice;
    }

    public void setOutputprice(double outputprice) {
        this.outputprice = outputprice;
    }

    public ArrayList getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList animalList) {
        this.animalList = animalList;
    }

    public ArrayList getCustomList() {
        return customList;
    }

    public void setCustomList(ArrayList customList) {
        this.customList = customList;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    //进购宠物
    public void buyAnimal(Animal animal){
        if (balance <= 0){
            throw new InsufficientBalanceException("余额不足，请及时充值");
        }
        this.animalList.add(animal);
    }

    //招待客户 -> 接受客户参数，在顾客列表中加入新顾客，
    //出售动物，如果店内没有动物，抛出AnimalNotFoundException。
    //通过toString输出动物信息，并把钱入账，将动物移除列表

    //迎接顾客（1。迎接顾客；2，顾客购买宠物）
    public void welcomeCustom(Customer customer){
        this.customList.add(customer);
        System.out.println("欢迎" + customer.getName() + "到我们的店。");
        System.out.println( "这是您第" + customer.getCount() + "次光临我们的小店");
        System.out.println("我们店的宠物有：");
        for (int i = 0; i < animalList.size(); i++) {
            System.out.println(i + 1 + "." + animalList.get(i));
        }
        if (animalList.size() == 0){
            throw new AnimalNotFoundException("我们的店里没宠物了捏");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你想要的动物的编号");
            int a = sc.nextInt();
            Animal animal = animalList.get(a - 1);
            customer.setCost(animal.getPrice());
            animalList.remove(a - 1);
            System.out.println("欢迎下次光临");
        }
    }
    //检查是否歇业
    public void over() {
        double bonus = 0;
        double Earnedmoney = 0;
        System.out.println("--------本店暂停营业--------");
        if (customList.size() == 0 ){
            System.out.println("今天生意似乎不是很好，没有顾客光临。");
        }
            else {
                System.out.println("今天的顾客有");
                for (int i = 0; i < customList.size(); i++) {
                    //bug：可能店里的顾客或者宠物集合为空
                    if (customList.get(i).getTime().toLocalDate().isEqual(LocalDate.now()) && customList.get(i).getTime().isBefore(LocalDateTime.now())) {
                        System.out.println(customList.get(i));
               }
            }
                //有bug
            int num = customList.size();
                for (int j = 0; j <num; j++) {
                    Earnedmoney +=customList.get(j).getCost();
             }
             bonus = Earnedmoney - getOutputprice();
            System.out.println("今天的利润为：" + bonus);
        }
            double Balance = getBalance() + bonus;
        System.out.println("余额为" + Balance);
        if (Balance <= 0){
            System.out.println("您已经欠费了哦，请及时交纳");
        }
        else {
            System.out.println("今天又是赚钱的一天");
        }

    }
}
