import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ParkingLot {

  int count;
  double total;
  List<Car> fullLot;
  YellowLot y;
  GreenLot g;
  BlueLot b;

  public ParkingLot() {
    y = new YellowLot();
    g = new GreenLot();
    b = new BlueLot();
    fullLot = new ArrayList<Car>();

    System.out.println("Welcome! We have 3 parking lot groups available.\n");
    System.out.println("Choose 1 for YellowLot, 2 for GreenLot, 3 for BlueLot, or 0 for no choice.\n");
    System.out.println("The YellowLot has a price of " + y.getPrice() + ", a capacity of " + y.getCapacity() + ", a discount of " +
            y.getDiscount() + ", and their policies are " + y.getPolicies() + ".\n");
    System.out.println("The GreenLot has a price of " + g.getPrice() + ", a capacity of " + g.getCapacity() + ", a discount of " +
            g.getDiscount() + ", and their policies are " + g.getPolicies() + ".\n");
    System.out.println("The BlueLot has a price of " + b.getPrice() + ", a capacity of " + b.getCapacity() + ", a discount of " +
            b.getDiscount() + ", and their policies are " + b.getPolicies() + ".\n");
  }
  public void entering(Car c, int choice) {
      if (choice == 0) {
          if(getBestLot()!= null) {
              c.setGroup(getBestLot());
              parking(c, getBestLot());
          }
      }
      else if (choice == 1) {
          if(!y.isFull()) {
              c.setGroup(y);
              parking(c, y);
          }
          else {
              System.out.println("Error: YellowLot Full");
          }
      }
      else if (choice == 2) {
          if(!g.isFull()) {
              c.setGroup(g);
              parking(c, g);
          }
          else {
              System.out.println("Error: GreenLot Full");
          }
      }
      else if (choice == 3) {
          if(!b.isFull()) {
              c.setGroup(b);
              parking(c, b);
          }
          else {
              System.out.println("Error: BlueLot Full");
          }
      }
  }
  public Groups getBestLot() {
      if(!y.isFull()) {
          return y;
      }
      else if(!g.isFull()) {
          return g;
      }
      else if(!b.isFull()) {
          return b;
      }
      else {
          System.out.println("Error: All lot groups full");
          return null;
      }
  }
  public void parking(Car c, Groups g) {
      count++;
      System.out.println("Parking in lot: "+g.getName());
          g.setCount(1);
          Date in = new Date();
          c.setTicket();    // give car ticket
          System.out.println("Ticket "+c.getTicket().getTicketId()+" in time: "+in);
          c.getTicket().setInTime(in);
          fullLot.add(c);
          g.getLot().add(c);       // add car to lot
          System.out.println("Car successfully parked.");

  }
  public void leaving(String c) {
      int k = 0;

      try {
          for (int i = 0; i < fullLot.size(); i++) {
              if (fullLot.get(i).getCarId().equals(c)) {    // find car in lot
                  Date out = new Date();
                  k = 1;    // flag if found
                  if (fullLot.get(i).getTicket() != null) { // check ticket
                      fullLot.get(i).getTicket().setOutTime(out);
                      System.out.println("Ticket " + fullLot.get(i).getTicket().getTicketId() + " out time: " + out);
                      pay(fullLot.get(i).getTicket().totalTime(), fullLot.get(i).getGroup().getPrice(), fullLot.get(i).getGroup().getDiscount());  // pay ticket
                      fullLot.remove(fullLot.get(i));       // remove car from lot
                      fullLot.get(i).getGroup().getLot().remove(fullLot.get(i));
                      fullLot.get(i).getGroup().setCount(-1);
                      count--;
                      System.out.println("Car successfully left.");
                  } else {
                      System.out.println("Error: No ticket shown. Return with ticket.");
                  }
              }
          }
      }catch (IndexOutOfBoundsException e) {
          System.out.println("Car successfully left.");
      }
      if (k != 1) {
          System.out.println("Error: Car not found in lot.");
      }
  }
  public void pay(long diff, double p, double d) {
    double t = diff /(1000 % 60)/p;  // 1s simulates hour pay
      double totalpay = t - (t*d);
    System.out.println("Ticket paid for: "+String.format("%.02f", totalpay));
    total += totalpay;  // add profit to total
  }
    public double getTotal() {
        return total;
    }
    public int getCarsLeft() {
        return fullLot.size();
    }

}
