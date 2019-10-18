import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

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
          LocalTime in = LocalTime.now();
          System.out.println(in);
          c.setTicket();
          c.getTicket().setInTime(in);
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
  public void leaving(String c) {
      int k = 0;
      for (int i = 0; i < lot.size(); i++) {
          if (lot.get(i).getCarId().equals(c)) {
              LocalTime out = LocalTime.now();
              System.out.println(out);
              if (lot.get(i).getTicket() != null) {
                  lot.get(i).getTicket().setOutTime(out);
                  //pay
                  lot.remove(lot.get(i));
                  count--;
                  System.out.println("Car left");
              }
              else {
                  System.out.println("No ticket shown");
              }
              k = 1;
          }
      }
      if (k != 1) {
          System.out.println("Car not in lot");
      }

    // if car in list - get ticket
    // set out time
    // pay ticket
    // remove car from list
  } /*
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
  } */
}
