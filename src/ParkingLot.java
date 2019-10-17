import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
  int capacity;
  double price;
  List<Car> lot;
  int count;
  double total;

  public ParkingLot(int c, double p) {
    capacity = c;
    price = p;
    lot = new ArrayList<Car>();
    System.out.println("Parking lot created");
  }
  public void entering(Car c) {
      count++;
      if (count <= capacity) {
          Date time = new Date();
          Ticket t = new Ticket("T" +c.getCarId, time, null); //set time
          c.setTicket(t); //pass/set object to object
          lot.add(c);
          System.out.println("Car parked");
      }
      else {
          System.out.println("Parking lot full, come back next time");
      }
    // if not full - create ticket of rand id
    // set in time
    // give ticket to car
    // add car to list
  }
  public void leaving(Car c) {
      if (c in lot) {
          if (c.getTicket != null) {
              Date t = new Date();
              (c.getTicket).setOutTime(t);
              p = pay(c.getTicket);
              System.out.println("cost: " + p);
              //pay
              count--;
              lot.remove(c);
              System.out.println("Car left");
          }
          else {
              System.out.println("No ticket shown");
          }
      }
      else {
          System.out.println("Car not in lot");
      }
    // if car in list - get ticket
    // set out time
    // pay ticket
    // remove car from list
  }
  public double pay(Ticket t) {
    i = t.geInTime();// get in time
    o = t.getOutTime();// get out time
    diff = i-o; // set difference to totaltime
    totalpay = diff * price;
    total += totalpay
    return totalpay
  }
  public double getTotal() {
      return total;
  }
}
