import java.util.List;
import java.util.ArrayList;

public class BlueLot extends ParkingLot {
    public BlueLot() {
        capacity = 10;
        price = 3;
        discount = .20;
        lot = new ArrayList<Car>();
        policies = "Here are our policies";
        System.out.println("BlueLot created.");
    }
}