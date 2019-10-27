import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class GreenLot extends Groups {
    public GreenLot() {
        name = "GreenLot";
        capacity = 6;
        price = 7;
        discount = .50;
        lot = new ArrayList<Car>();
        policies = "This is our garage option. A 50% discount is available during the weekends.Open 24/7. Fully covered. No refunds.";
        count = 0;
    }
    public boolean checkDiscount(Date d) {
        int i = d.getDay();
        if (i == 0 || i == 6) {
            return true;
        }
        else {
            return false;
        }
    }
}