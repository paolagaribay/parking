import java.util.List;
import java.util.ArrayList;

public class YellowLot {
    String name;
    int capacity;
    double price;
    double discount;
    String policies;
    List<Car> yellow;

    public YellowLot() {
        name = "YellowLot";
        capacity = 5;
        price = 10;
        discount = .05;
        yellow = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("YellowLot created.");
    }
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String getPolicies() {
        return policies;
    }

    public List<Car> getLot() {
        return yellow;
    }
}