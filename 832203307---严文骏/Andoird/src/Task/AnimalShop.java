package Task;

public interface AnimalShop {
    public static void GetnewAnimal(String type,double inputPrice,String gender,int age){
        System.out.println( type + "," + inputPrice + "," + gender + "," + age);
    }

    public static void welcomeCustomer(Customer customer){
        System.out.println("欢迎" + customer.getName() + "到我们的店。");
        System.out.println( "这是您第" + customer.getCount() + "次光临我们的小店");
    }
    public void over();
}
