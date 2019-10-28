import java.util.Calendar;
import java.util.ArrayList;

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
    public boolean checkDiscount(Calendar d) {
        int i = d.get(d.DATE);
        if (i == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}