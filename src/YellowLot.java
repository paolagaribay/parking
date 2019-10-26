import java.util.List;
import java.util.ArrayList;

public class YellowLot extends Groups {
    public YellowLot() {
        name = "YellowLot";
        capacity = 3;
        price = 10;
        discount = .05;
        lot = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("YellowLot created.");
    }
}