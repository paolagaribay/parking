import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public abstract class Groups {
    String name;
    int capacity;
    double price;
    double discount;
    String policies;
    List<Car> lot;
    int count;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String getPolicies() {
        return policies;
    }

    public List<Car> getLot() {
        return lot;
    }
    public void setCount(int c) {
        count += c;
    }
    public boolean isFull() {
        if (capacity-count == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public abstract boolean checkDiscount(Date d);

}