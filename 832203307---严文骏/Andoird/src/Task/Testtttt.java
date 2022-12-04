package Task;

import java.util.Scanner;

public class Testtttt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean b;
        System.out.println("狗狗是否接种疫苗:true or flase");
        while (true){
            String ss = sc.next();
            if (Boolean.parseBoolean(ss)){
                b = Boolean.parseBoolean(ss);
                break ;
            }else {
                System.out.println("请输出正确格式");
            }
        }
        System.out.println(b);
    }
}
