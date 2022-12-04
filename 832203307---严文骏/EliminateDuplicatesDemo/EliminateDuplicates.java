package EliminateDuplicatesDemo;
import java.util.Arrays;
public class EliminateDuplicates {
    public static void main(String[] args) {
        int[] array = {96, 91, 75, 22, 77, 46, 73, 87, 66, 46, 19, 55, 65, 21, 83, 8, 73, 80, 90, 52, 72,
                51, 2, 22, 4, 8, 51, 66, 36, 82, 68, 61, 74, 64, 72, 24, 21, 46, 63, 23, 93, 44,
                40, 24, 78, 15, 85, 61, 18, 40, 3, 40, 27, 58, 81, 56, 73, 5, 15, 38, 83, 91, 19,
                92, 79, 66, 45, 62, 45, 93, 66, 12, 25, 60, 65, 48, 18, 60, 17, 21, 61, 74, 44,
                65, 50, 88, 88, 43, 5, 7, 96, 3, 95, 18, 64, 74, 92, 88, 62, 52, 32, 96, 75, 78,
                11, 16, 41, 33, 5, 12, 26, 10, 90, 5, 77, 91, 69, 35, 14, 73, 54, 56, 74, 56, 48,
                50, 7, 47, 44, 81, 13, 15, 39, 65, 74, 32, 71, 58, 67, 81, 30, 52, 69, 99, 67, 83,
                49, 34, 7, 31, 32, 58, 26, 62, 53, 56, 63, 7, 59, 58, 68, 45, 45, 22, 49, 35, 28,
                91, 62, 0, 37, 92, 17, 64, 12, 84, 91, 87, 47, 13, 51, 75, 8, 62, 45, 63, 11, 46,
                85, 34, 51, 50, 76, 46, 25, 64, 49, 9, 7, 33};
        int[]a = clear(array);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 ){
                count++;
            }
        }
        int[]result = new int[count];
        for (int i = 0,j = 0; i < a.length; i++) {
            if (array[i] > 0){
                result[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1){
                System.out.print(result[i]);
            }else {
            System.out.print(result[i] + ",");}
        }
    }
    public static int[] clear(int[] arr){
        int a = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]){
                    arr[j] = a;
                }
            }
        }
        return arr;
    }
}
