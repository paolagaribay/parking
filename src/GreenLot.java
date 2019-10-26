import java.util.List;
import java.util.ArrayList;

public class GreenLot extends Groups {
    public GreenLot() {
        name = "GreenLot";
        capacity = 7;
        price = 5;
        discount = .10;
        lot = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("GreenLot created.");
        count = 0;
    }
}