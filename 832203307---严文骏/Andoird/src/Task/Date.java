package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Date {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDateTime time = LocalDateTime.now();
        LocalDate birthday = LocalDate.of(1997, 8, 17);
        System.out.println(today);
        System.out.println(time);
    }
}
