import java.util.ArrayList;
import java.util.Calendar;

public class YellowLot extends Groups {
    public YellowLot() {
        name = "YellowLot";
        capacity = 7;
        price = 5;
        discount = .20;
        lot = new ArrayList<Car>();
        policies = "This is our lot option. A 20% discount is available if parking after 5PM. Open 24/7. Not covered. No refunds.";
        count = 0;
    }
    public boolean checkDiscount(Calendar d) {
        int i = d.get(d.HOUR_OF_DAY);   // discount after 5pm
        if (i > 19) {
            return true;
        }
        else {
            return false;
        }
    }
}