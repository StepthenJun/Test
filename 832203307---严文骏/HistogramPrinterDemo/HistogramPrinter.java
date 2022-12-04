package HistogramPrinterDemo;
public class HistogramPrinter {
    public static void main(String[] args) {
        String textNum = "1022473578476949426110832338899437170338449409627474102214022150928";
        int[] a = new int[textNum.length()];
        for (int i = 0; i < textNum.length(); i++) {
            a[i] = textNum.charAt(i) - 48;
        }
        //找出现数字最多的次数
        //将0-10存到数组
        int[] b = new int[10];
        for (int i = 0; i < a.length; i++) {
            b[a[i]]++;
        }
        int max = b[0];   //定义次数
        int value = 0;    //定义最大值
        for (int i = 1; i < b.length; i++) {
            if (b[i] > max) {
                max = b[i];
                value = i;
            }
        }
        System.out.print("出现次数最多的值是:" + value + ", 出现了" + max + "次");
        System.out.println("");
        for (int i = 0; i < max; i++) {
            int num = 0;
            for (int j = 0; j < 10; j++) {
                //这里调用次数，去判断每个数字是否符合条件输出
                if (i < max - b[num] ){
                    System.out.print("     ");
                }else {
                    System.out.print("[" + j + "]" + "  ");
                }
                num++;
            }
            System.out.println("");
        }
    }
    //计算每个数字的次数
//    public static int count(int num,int []arr){
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == num){
//                count++;
//            }
//        }
//        return count;
//    }
}

