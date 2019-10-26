import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ParkingLot {

  int capacity;
  double price;
  List<Car> lot;
  int count;
  double total;
  String policies;
  double discount;

  public ParkingLot() {
    //capacity = 0;
    //price = 0;
    //lot = null;
    //discount = 0;
    //policies = "";
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

  public void entering(Car c) {
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
