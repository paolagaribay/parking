import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ParkingLot {

  int capacity;
  double price;
  int count;
  double total;
  double discount;
  YellowLot y;
  GreenLot g;
  BlueLot b;

  public ParkingLot() {
    y = new YellowLot();
    g = new GreenLot();
    b = new BlueLot();

    System.out.println("Welcome! We have 3 parking lot groups available.\n");
    System.out.println("The YellowLot has a price of " + y.getPrice() + ", a capacity of " + y.getCapacity() + ", a discount of " +
            y.getDiscount() + ", and their policies are " + y.getPolicies() + ".\n");
    System.out.println("The GreenLot has a price of " + g.getPrice() + ", a capacity of " + g.getCapacity() + ", a discount of " +
            g.getDiscount() + ", and their policies are " + g.getPolicies() + ".\n");
    System.out.println("The BlueLot has a price of " + b.getPrice() + ", a capacity of " + b.getCapacity() + ", a discount of " +
            b.getDiscount() + ", and their policies are " + b.getPolicies() + ".\n");
  }
  public double getPrice() {
      return price;
  }
  public String getPolicies() {
      return policies;
  }
  public double getDiscount() {
      return discount;
  }
  public double getTotal() {
      return total;
  }
  public int getCapacity() {
      return capacity-count;
  }
  public int getCarsLeft() {
      return lot.size();
  }
  public boolean isFull() {
      if (capacity-count == 0) {
          return true;
      }
      else {
          return false;
      }
  }
  public void entering(Car c) {
      System.out.println("")
  }
  public void parking(Car c, List<Car> lot) {
      count++;
      if (count <= capacity) {
          Date in = new Date();
          c.setTicket();    // give car ticket
          System.out.println("Ticket "+c.getTicket().getTicketId()+" in time: "+in);
          c.getTicket().setInTime(in);
          lot.add(c);       // add car to lot
          System.out.println("Car successfully parked.");
      }
      else {
          System.out.println("Error: Parking lot is full. Car may not enter.");
          count--;
      }
  }
  public void leaving(String c) {
      int k = 0;
      for (int i = 0; i < lot.size(); i++) {
          if (lot.get(i).getCarId().equals(c)) {    // find car in lot
              Date out = new Date();
              if (lot.get(i).getTicket() != null) { // check ticket
                  lot.get(i).getTicket().setOutTime(out);
                  System.out.println("Ticket "+lot.get(i).getTicket().getTicketId()+" out time: "+out);
                  pay(lot.get(i).getTicket().totalTime());  // pay ticket
                  lot.remove(lot.get(i));       // remove car from lot
                  count--;
                  System.out.println("Car successfully left.");
              }
              else {
                  System.out.println("Error: No ticket shown. Return with ticket.");
              }
              k = 1;    // flag if found
          }
      }
      if (k != 1) {
          System.out.println("Error: Car not found in lot.");
      }
  }
  public void pay(long diff) {
    double totalpay = diff /(1000 % 60)/price;  // 1s simulates hour pay
    System.out.println("Ticket paid for: "+String.format("%.02f", totalpay));
    total += totalpay;  // add profit to total
  }
}
