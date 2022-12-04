package Task;

import java.awt.event.KeyEvent;
import java.io.*;
import java.security.Key;
import java.util.Scanner;

public class test11 {
    public static void main(String[] args) {

        try {
            File file = new File("D:\\data.txt");
            if (!file.exists()) {
                file.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            }
            FileOutputStream fos = new FileOutputStream(file, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            String data = "是我被传过来了";
            bw.write(data);
            bw.newLine();
            bw.flush();
            bw.close();
            osw.close();
            fos.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
