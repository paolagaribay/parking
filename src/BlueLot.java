import java.util.List;
import java.util.ArrayList;

public class BlueLot extends Groups {
    public BlueLot() {
        name = "BlueLot";
        capacity = 10;
        price = 3;
        discount = .20;
        lot = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("BlueLot created.");
    }
}