import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
  }
  public void entering(Car c) {
      count++;
      if (count <= capacity) {
          Date in = new Date();
          c.setTicket();
          System.out.println("Ticket "+c.getTicket().getTicketId()+" in time: "+in);
          c.getTicket().setInTime(in);
          lot.add(c);
          System.out.println("Car successfully parked.");
      }
      else {
          System.out.println("Error: Parking lot is full. Car may not enter.");
      }
  }
  public void leaving(String c) {
      int k = 0;
      for (int i = 0; i < lot.size(); i++) {
          if (lot.get(i).getCarId().equals(c)) {
              Date out = new Date();
              if (lot.get(i).getTicket() != null) {
                  lot.get(i).getTicket().setOutTime(out);
                  System.out.println("Ticket "+lot.get(i).getTicket().getTicketId()+" out time: "+out);
                  pay(lot.get(i).getTicket().totalTime());

                  lot.remove(lot.get(i));
                  count--;
                  System.out.println("Car successfully left.");
              }
              else {
                  System.out.println("Error: No ticket shown.");
              }
              k = 1;
          }
      }
      if (k != 1) {
          System.out.println("Error: Car not found in lot.");
      }
  }
  public void pay(long diff) {
    double totalpay = diff /(1000 % 60)/price;
    System.out.println("Ticket paid for: "+String.format("%.02f", totalpay));
    total += totalpay;
  }
  public double getTotal() {
      return total;
  }
}
