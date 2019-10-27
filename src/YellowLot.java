import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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
    public boolean checkDiscount(Date d) {
        int i = d.getHours();
        if (i >= 17) {
            return true;
        }
        else {
            return false;
        }
    }
}