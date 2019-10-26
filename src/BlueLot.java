import java.util.List;
import java.util.ArrayList;

public class BlueLot {
    String name;
    int capacity;
    double price;
    double discount;
    String policies;
    List<Car> blue;

    public BlueLot() {
        name = "BlueLot";
        capacity = 10;
        price = 3;
        discount = .20;
        blue = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("BlueLot created.");
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
        return blue;
    }
}