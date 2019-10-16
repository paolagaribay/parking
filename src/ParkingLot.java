import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
  int capacity;
  double price;
  List<Car> lot;
  // list of cars parked
  // counter
  // total
  public ParkingLot(int c, double p) {
    capacity = c;
    price = p;
    lot = new ArrayList<Car>();
    System.out.println("Parking lot created");
  } /**
  public boolean checkCapacity() {
    // check if parking lot full 
  }
  public void entering(Car c, Date t) {
    // if not full - create ticket of rand id
    // set in time
    // give ticket to car
    // add car to list
  }
  public void leaving(Car c, Date t) {
    // if car in list - get ticket
    // set out time
    // pay ticket
    // remove car from list
  }
  public int pay(Ticket t) {
    // get in time
    // get out time
    // set difference to totaltime
    // totalpay = totaltime * price
    // return totalpay
  }
  public int total() {
    //total += totalpay
    // return total
  } **/
}
