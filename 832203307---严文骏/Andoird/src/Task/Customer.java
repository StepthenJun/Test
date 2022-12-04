package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {
    private String name;
    private int count;

    private double cost;
    private LocalDateTime time = LocalDateTime.now();

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", time=" + time +
                '}';
    }

    public Customer() {
    }

    public Customer(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
}
