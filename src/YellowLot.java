import java.util.List;
import java.util.ArrayList;

public class YellowLot extends ParkingLot {
    public YellowLot() {
        capacity = 5;
        price = 10;
        discount = .05;
        lot = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("YellowLot created.");
    }
}