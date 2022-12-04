package Task;

public class Totoro extends Animal{
private double price = 320;

    public Totoro() {
    }

    public Totoro(String name, int age, String gender) {
        super(name, age, gender);
    }
    public Totoro(String name, int age, String gender,double inputprice){
        super(name, age, gender,inputprice);
    }

    @Override
    public String toString() {
        return "龙猫[" + "名字是：" + this.getName() + "," + "性别为：" + this.getGender() + "," + "年龄为："+ this.getAge() + "," + "价格为：" + this.getPrice() + "]";
    }
    @Override
    public double getPrice() {
        return price;
    }
}
