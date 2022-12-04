package SumDiagonalsDemo;

import java.util.Scanner;

public class SumDiagonals {
    public static void main(String[] args) {
        int number;
        int diagonal = 0;
        int diagona2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要规定的正方形数组的长度：");
        String num = sc.next();
        while (true) {
            try {
                number = Integer.parseInt(num);
                break;
            }catch (Exception e ){
                System.out.println("请输入数字");
            }
        }
        int[][] arr = new int[number][number];
        System.out.println("请输入每一行的数字");
        for (int i = 0; i < number; i++) {
            int arrnum = i + 1;
            System.out.println("请输入第" + arrnum + "行的数字");
            for (int j = 0; j < number; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i1 = 0; i1 < number;i1++) {
                diagonal = diagonal + arr[i1][i1];
        }
        System.out.println("diagonal的值为" + diagonal);
        for (int i2 = 0,j = number - 1; i2 < number;i2++) {
            diagona2 = diagona2 + arr[i2][j];
            j--;
        }
        System.out.println("diagona2的值为" + diagona2);
        if (number % 2 == 0){
            int sum = diagonal + diagona2;
            System.out.println("Sum of diagonals = " + sum);
        }else {
            int sum = diagonal + diagona2 - arr[(number-1) / 2][(number-1) / 2];
            System.out.println(sum);
        }



    }
}
