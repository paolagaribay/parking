import java.util.List;
import java.util.ArrayList;

public class GreenLot {
    String name;
    int capacity;
    double price;
    double discount;
    String policies;
    List<Car> green;

    public GreenLot() {
        name = "GreenLot";
        capacity = 7;
        price = 5;
        discount = .10;
        green = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("GreenLot created.");
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
        return green;
    }
}