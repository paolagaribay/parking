import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ParkingLot {

  private int count;
  private double total;
  private List<Car> fullLot;
  private Groups y;
  private Groups g;
  private Groups b;

  public ParkingLot() {
    y = new YellowLot();
    g = new GreenLot();
    b = new BlueLot();
    fullLot = new ArrayList<Car>();

    System.out.println("Welcome! We have 3 parking lot groups available.");
    System.out.println("Choose 1 for YellowLot, 2 for GreenLot, 3 for BlueLot, or 0 for no choice.\n");
    System.out.println("YellowLot: price - " + y.getPrice() + ", capacity - " + y.getCapacity() + ", discount - " +
            y.getDiscount() + ", policies - " + y.getPolicies());
    System.out.println("GreenLot: price - " + g.getPrice() + ", capacity - " + g.getCapacity() + ", discount - " +
            g.getDiscount() + ", policies - " + g.getPolicies());
    System.out.println("BlueLot: price - " + b.getPrice() + ", capacity - " + b.getCapacity() + ", discount - " +
            b.getDiscount() + ", policies - " + b.getPolicies() + "\n");
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
      c.getTicket().setInTime(in);
      System.out.println("Ticket "+c.getTicket().getTicketId()+" in time: "+in);
      double d = getLotDiscount(g.checkDiscount(in), g.getDiscount());
      c.getTicket().setDis(d);
      System.out.println("Discount applicable: "+(d*100)+"%");
      fullLot.add(c);
      g.getLot().add(c);       // add car to lot
      g.setCount(1);
      System.out.println("Car successfully parked.");

  }
  public void leaving(String c) {
      int k = 0;

      for (int i = 0; i < fullLot.size(); i++) {
          if (fullLot.get(i).getCarId().equals(c)) {    // find car in lot
              Date out = new Date();
              k = 1;    // flag if found
              if (fullLot.get(i).getTicket() != null) { // check ticket
                  fullLot.get(i).getTicket().setOutTime(out);
                  System.out.println("Ticket " + fullLot.get(i).getTicket().getTicketId() + " out time: " + out);
                  pay(fullLot.get(i).getTicket().totalTime(), fullLot.get(i).getGroup().getPrice(), fullLot.get(i).getTicket().getDis());  // pay ticket
                  fullLot.get(i).getGroup().setCount(-1);
                  fullLot.get(i).getGroup().getLot().remove(fullLot.get(i));
                  fullLot.remove(fullLot.get(i));       // remove car from lot
                  count--;
                  System.out.println("Car successfully left.");
              } else {
                  System.out.println("Error: No ticket shown. Return with ticket.");
              }
          }
      }
      if (k != 1) {
          System.out.println("Error: Car not found in lot.");
      }
  }
  public void pay(long diff, double p, double d) {
    double t = diff/1000 * p;  // 1s simulates hour pay
      double totalpay = t - (t*d);

    System.out.println("Ticket paid for: "+String.format("%.02f", totalpay));
    total += totalpay;  // add profit to total
  }
  public double getLotDiscount(boolean d, double p) {
      if (d == true) {
          return p;
      }
      else {
          return 0;
      }
  }
    public double getTotal() {
        return total;
    }
    public int getCarsLeft() {
        return fullLot.size();
    }
    public int getLotCapacity(Groups g) {
      return g.getCapacity();
    }
    public String getLotPolicies(Groups g){
      return g.getPolicies();
    }

}
