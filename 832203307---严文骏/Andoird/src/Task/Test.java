package Task;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Animal> animalslist = new ArrayList<>();
        MyAnimalShop myAnimalShop = new MyAnimalShop();
        myAnimalShop.setAnimalList(animalslist);
        Scanner sc = new Scanner(System.in);
            Lable:while (true) {
                System.out.println("--------------------------欢迎使用宠物店系统---------------------------");
                System.out.println("  请选择您需要使用的服务（输入序号即可）,返回上一级输入esc即可  ");
                System.out.println(" 1.录入您出售的宠物信息 ");
                System.out.println(" 2.买宠物 ");
                System.out.println(" 3.招待顾客 ");
                System.out.println(" 4.查询货架上的宠物 ");
                System.out.println(" 5.歇业 ");
                System.out.println(" 6.存入余额 ");
                if (myAnimalShop.getBalance() == 0){
                    System.out.println("温馨提示：当前系统里的余额为0，请往您的宠物店里添加营业的资金o");
                }
                System.out.println("----------------------------------------------------------------------");
                String num = sc.next();
                    switch (num){
                        case "1" -> {addAnimal(animalslist);break;}
                        case "2" -> {buyAnimal(myAnimalShop,animalslist);break;}
                        case "3" -> {welcomeCustom(myAnimalShop);break;}
                        case "4" -> {checkMyAinmal(animalslist);break;}
                        case "5" -> {over(myAnimalShop);
                            System.out.println("欢迎下次使用本程序");
                            break Lable;}
                        case "6" -> {setBanlance(myAnimalShop);}
                        default -> System.out.println("请输入正确的序号");
                    }
                }
        }
    private static void setBanlance(MyAnimalShop myAnimalShop ) {
        double banlance;
        System.out.println("请存入您的资金");
        Scanner sc = new Scanner(System.in);
        banlance = Double.parseDouble(sc.next());
        myAnimalShop.setBalance(banlance);
        System.out.println("*存入成功*");
    }

    //5.歇业
    private static void over(MyAnimalShop myAnimalShop) {
        myAnimalShop.over();
    }

    //2.购买宠物
    //bug：购买宠物时余额不足时会出问题
    private static void buyAnimal(MyAnimalShop myAnimalShop,ArrayList<Animal> animalslist) {
        Scanner sc = new Scanner(System.in);
        System.out.println("您要购买的宠物是");
        System.out.println("1.猫" + "2.狗" + "3.龙猫");
        String num = sc.next();
        Lable4:switch (num){
            case "1" -> {
                System.out.println("记录您购买的猫猫信息");
                Scanner message = new Scanner(System.in);
                Cat c =new Cat();
                //修改成myanimalshop里buy方法的调用
                addAnimalMessage(c,message);
                System.out.print("进购价：");
                double inputprice = message.nextInt();
                c.setInputprice(inputprice);
                double ouputprice=myAnimalShop.getOutputprice() + inputprice;
                myAnimalShop.setOutputprice(ouputprice);
                try {
                    myAnimalShop.buyAnimal(c);
                    System.out.println("恭喜你购买成功，为宠物店新添了一员");
                } catch (InsufficientBalanceException e) {
                    System.out.println("你没钱了，请即使充值");
                }
                System.out.println("继续请输任意键按回车，返回请输入esc");
                String s = message.next();
                if (s.toLowerCase().equals("esc")){
                    System.out.println("--------------------------");
                    break Lable4;
                }
                else {
                    System.out.println("--------------------------");
                }
            }
            case "2" -> {
                System.out.println("记录您购买的狗狗信息");
                Scanner message = new Scanner(System.in);
                ChineseDog d = new ChineseDog();
                addAnimalMessage(d,message);
                System.out.print("进购价：");
                double inputprice = message.nextInt();
                d.setInputprice(inputprice);
                double ouputprice=myAnimalShop.getOutputprice() + inputprice;
                myAnimalShop.setOutputprice(ouputprice);
                System.out.println("狗狗是否接种疫苗:true or flase");
                while (true){
                    String ss = message.next();
                    boolean b;
                    if (Boolean.parseBoolean(ss)){
                        b = Boolean.parseBoolean(ss);
                        d.setVaccinelnjected(b);
                        break ;
                    }else {
                        System.out.println("请输出正确格式");
                    }
                }
                try {
                    myAnimalShop.buyAnimal(d);
                    System.out.println("恭喜你购买成功，为宠物店新添了一员");
                } catch (InsufficientBalanceException e) {
                    System.out.println("你没钱了,请及时充值");
                }
                System.out.println("继续请输任意键按回车，返回请输入esc");
                String s = message.next();
                if (s.toLowerCase().equals("esc")){
                    System.out.println("---------------------");
                    break Lable4;
                }
                else {
                    System.out.println("---------------------");
                }
            }
            case "3" -> {
                System.out.println("记录您购买的龙猫信息");
                Scanner message = new Scanner(System.in);
                Totoro t = new Totoro();
                //修改成myanimalshop里buy方法的调用
                addAnimalMessage(t,message);
                System.out.print("进购价：");
                double inputprice = message.nextInt();
                t.setInputprice(inputprice);
                double ouputprice=myAnimalShop.getOutputprice() + inputprice;
                myAnimalShop.setOutputprice(ouputprice);
                try {
                    myAnimalShop.buyAnimal(t);
                    System.out.println("恭喜你购买成功，为宠物店新添了一员");
                } catch (InsufficientBalanceException e) {
                    System.out.println("你没钱了，请即使充值");
                }
                System.out.println("继续请输任意键按回车，返回请输入esc");
                String s = message.next();
                if (s.toLowerCase().equals("esc")){
                    System.out.println("--------------------------");
                    break Lable4;
                }
                else {
                    System.out.println("--------------------------");
                }
            }
            default -> {
                System.out.println("请输入正确的序号");
            }
        }
    }
    //4.检查animal
    private static void checkMyAinmal(ArrayList<Animal> annimalslist) {
        if (annimalslist.size() != 0) {
            for (int i = 0; i < annimalslist.size(); i++) {
                System.out.println(annimalslist.get(i).toString());
             }
        } else {
            System.out.println("货架上没宠物了捏,请及时添加哦");
        }

    }
    //3.欢迎顾客
    private static void welcomeCustom(MyAnimalShop myAnimalShop) {
            Customer c = new Customer();
            Scanner sc = new Scanner(System.in);
        Lable3:while (true) {
            System.out.println("请输入顾客的信息");

            System.out.print("姓名:");
            String name = sc.next();
            c.setName(name);

            System.out.print("次数:");
            int count = sc.nextInt();
            c.setCount(count);
            try {
                myAnimalShop.welcomeCustom(c);
            }catch (AnimalNotFoundException e){
                System.out.println("店里没宠物卖了捏（可能是店主没上架）");
            }
            System.out.println("继续请输任意键按回车，返回请输入esc");
            String s = sc.next();
            if (s.toLowerCase().equals("esc")){
                System.out.println("---------------------");
                break Lable3;
            }
             else {
                System.out.println("---------------------");
                continue ;
            }
        }
    }

    //1.添加宠物
    private static void addAnimal(ArrayList<Animal> animalslist) {
        while (true) {
            System.out.println("--------请选择您要添加宠物--------");
            System.out.println("1.猫猫" + "2.狗狗" + "3.龙猫" + "tip：输入esc可以返回主界面");
            Scanner sc = new Scanner(System.in);
            String num = sc.next();
            if(num.equals("0") || num.toLowerCase().equals("esc")){
                break;
            }
            switch (num){
                case "1" -> {
                    Lable1:while (true) {
                        Cat c = new Cat();
                        System.out.println("请添加猫猫的信息");
                        Scanner catMessage = new Scanner(System.in);
                        addAnimalMessage(c,catMessage);
                        animalslist.add(c);
                        System.out.println("添加成功，继续请输任意键按回车，返回请输入esc");
                        String s = catMessage.next();
                        if (s.toLowerCase().equals("esc")){
                            System.out.println("--------------------------");
                            break Lable1;
                        }
                        else {
                            System.out.println("--------------------------");
                            continue;
                        }
                    }
                }
                case "2" -> {
                    //狗狗这有个打疫苗的信息还未填写
                    Lable2:while (true) {
                        ChineseDog d = new ChineseDog();
                        System.out.println("--------请添加狗狗的信息--------");
                        Scanner dogMessage = new Scanner(System.in);
                        addAnimalMessage(d,dogMessage);
                        animalslist.add(d);
                        System.out.println("狗狗是否接种疫苗:true or flase");
                        while (true){
                            String ss = dogMessage.next();
                             boolean b;
                            if (Boolean.parseBoolean(ss)){
                                b = Boolean.parseBoolean(ss);
                                d.setVaccinelnjected(b);
                                break ;
                            }else {
                                System.out.println("请输出正确格式");
                            }
                        }
                        System.out.println("添加成功，继续请输任意键按回车，返回请输入esc");
                        String s = dogMessage.nextLine();
                        if (s.toLowerCase().equals("esc")){
                            System.out.println("--------------------------");
                            break Lable2;
                        }
                        else {
                            System.out.println("--------------------------");
                            continue;
                        }
                    }
                }
                case "3" -> {
                    Lable1:while (true) {
                        Totoro t = new Totoro();
                        System.out.println("请添加龙猫的信息");
                        Scanner catMessage = new Scanner(System.in);
                        addAnimalMessage(t,catMessage);
                        animalslist.add(t);
                        System.out.println("添加成功，继续请输任意键按回车，返回请输入esc");
                        String s = catMessage.next();
                        //到时候这里可以包装成一个方法，减少代码的复写
                        if (s.toLowerCase().equals("esc")){
                            System.out.println("--------------------------");
                            break Lable1;
                        }
                        else {
                            System.out.println("--------------------------");
                            continue;
                        }
                    }
                }
            }
        }
    }
    //方法：录入宠物信息
    public static void addAnimalMessage(Animal a,Scanner animalMessage){
        animalMessage = new Scanner(System.in);
        System.out.print("姓名:");
        String name = animalMessage.nextLine();
        a.setName(name);
        System.out.print("年龄:");
        int age = animalMessage.nextInt();
        a.setAge(age);
        System.out.print("性别:");
        String gender = animalMessage.next();
        a.setGender(gender);
    }
}
