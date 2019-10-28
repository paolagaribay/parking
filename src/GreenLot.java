import java.util.ArrayList;
import java.util.Calendar;

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
    public boolean checkDiscount(Calendar d) {
        int i = d.get(d.DAY_OF_WEEK);
        if (i == 1 || i == 7) {
            return true;
        }
        else {
            return false;
        }
    }
}