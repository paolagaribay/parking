import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class BlueLot extends Groups {
    public BlueLot() {
        name = "BlueLot";
        capacity = 5;
        price = 10;
        discount = 1;
        lot = new ArrayList<Car>();
        policies = "This is our valet option. Free parking on the 1st day of every month. Open 24/7. Full security. No refunds.";
        count = 0;
    }
    public boolean checkDiscount(Date d) {
        int i = d.getDate();
        if (i == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}