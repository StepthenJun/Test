package Task;

public class Cat extends Animal{
    private double price = 200;

    @Override
    public String toString() {
        return "猫猫[" + "名字是：" + this.getName() + "," + "性别为：" + this.getGender() + "," + "年龄为："+ this.getAge() + "," + "价格为：" + this.getPrice() + "]";
    }
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }
    public Cat(String name, int age, String gender,double inputprice){
        super(name, age, gender,inputprice);
    }
    public Cat(){
    }
    @Override
    public double getPrice() {
        return price;
    }
}
