package Task;

public class ChineseDog extends Animal{
    private boolean isVaccinelnjected;
    private double price = 100;

    @Override
    public String toString() {
        return "狗狗[" + "名字是：" + this.getName() + "," + "性别为：" + this.getGender() + "," + "年龄为："+ this.getAge() + "," + "价格为：" + this.getPrice() + "是否接种疫苗：" + this.isVaccinelnjected() + "]";
    }
    public ChineseDog(String name, int age, String gender, boolean isVaccinelnjected) {
        super(name, age, gender);
        this.isVaccinelnjected = isVaccinelnjected;
    }
    public ChineseDog(String name, int age, String gender,double inputprice){
        super(name, age, gender,inputprice);
    }

    public ChineseDog() {
    }

    public boolean isVaccinelnjected() {
        return isVaccinelnjected;
    }

    public void setVaccinelnjected(boolean vaccinelnjected) {
        isVaccinelnjected = vaccinelnjected;
    }

    @Override
    public double getPrice() {
        return price;
    }



}
