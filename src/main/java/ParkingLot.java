import java.util.Calendar;
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
        y = new YellowLot(); // add groups
        g = new GreenLot();
        b = new BlueLot();
        fullLot = new ArrayList<Car>();

        System.out.println("Welcome! We have 3 parking lot groups available.");  // print group details
        System.out.println("Line should read 'Entering/Leaving CarId Choice(optional when entering)'");
        System.out.println("Choice: 'y' to hear YellowLot details, 'g' to hear GreenLot details, 'b' to hear BlueLot details" +
                " or '1' for YellowLot, '2' for GreenLot, '3' for BlueLot\n");
        System.out.println("YellowLot: price - " + y.getPrice() + ", capacity - " + y.getCapacity() + ", discount - " +
                (100*y.getDiscount()) + "%, policies - " + y.getPolicies());
        System.out.println("GreenLot: price - " + g.getPrice() + ", capacity - " + g.getCapacity() + ", discount - " +
                (100*g.getDiscount()) + "%, policies - " + g.getPolicies());
        System.out.println("BlueLot: price - " + b.getPrice() + ", capacity - " + b.getCapacity() + ", discount - " +
                (100*b.getDiscount()) + "%, policies - " + b.getPolicies()+"\n");
    }
    public void entering(Car c, String choice) { // choose lot or print details
        if (choice.equals("y")) {
            getGroupPrice(y);
            getGroupCapacity(y);
        }
        else if (choice.equals("g")) {
            getGroupPrice(g);
            getGroupCapacity(g);
        }
        else if (choice.equals("b")) {
            getGroupPrice(b);
            getGroupCapacity(b);
        }
        else if (choice.equals("1")) {
            if(!y.isFull()) {
                c.setGroup(y);
                parking(c, y);
            }
            else {
                System.out.println("Error: YellowLot Full");
            }
        }
        else if (choice.equals("2")) {
            if(!g.isFull()) {
                c.setGroup(g);
                parking(c, g);
            }
            else {
                System.out.println("Error: GreenLot Full");
            }
        }
        else if (choice.equals("3")) {
            if(!b.isFull()) {
                c.setGroup(b);
                parking(c, b);
            }
            else {
                System.out.println("Error: BlueLot Full");
            }
        }
        else {    // no choice
            if(getBestLot()!= null) {
                c.setGroup(getBestLot());
                parking(c, getBestLot());
            }
        }
    }
    public void getGroupCapacity(Groups g) {  // send details
        System.out.println(g.getName()+ " has a current capacity of: "+g.getCapacity());
    }
    public void getGroupPrice(Groups g){
        System.out.println(g.getName()+ " has a price of: "+g.getPrice());
    }
    public Groups getBestLot() {  // choose cheapest available lot
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
        if (!fullLot.contains(c)) {   // check if not already in lot
            count++;
            System.out.println("Parking in lot: " + g.getName());
            g.setCount(1);
            Calendar in = Calendar.getInstance();
            c.setTicket();    // give car ticket
            c.getTicket().setInTime(in);
            System.out.println("Ticket " + c.getTicket().getTicketId() + " in time: " + in.getTime());
            double d = getGroupDiscount(g.checkDiscount(in), g.getDiscount());    // determine discount
            c.getTicket().setDis(d);
            System.out.println("Discount applicable: " + (d * 100) + "%");
            fullLot.add(c);
            g.getLot().add(c);       // add car to lot
            System.out.println("Car successfully parked.");
        }
        else {
            System.out.println("Error: car already in lot");
        }
    }
    public void leaving(String c) {
        int k = 0;

        for (int i = 0; i < fullLot.size(); i++) {
            if (fullLot.get(i).getCarId().equals(c)) {    // find car in lot
                k = 1;    // flag if found
                Calendar out = Calendar.getInstance();
                if (fullLot.get(i).getTicket() != null) { // check ticket
                    fullLot.get(i).getTicket().setOutTime(out);
                    System.out.println("Ticket " + fullLot.get(i).getTicket().getTicketId() + " out time: " + out.getTime());
                    pay(fullLot.get(i).getTicket().totalTime(), fullLot.get(i).getGroup().getPrice(), fullLot.get(i).getTicket().getDis());  // pay ticket
                    fullLot.get(i).getGroup().setCount(-1);
                    fullLot.get(i).getGroup().getLot().remove(fullLot.get(i));
                    fullLot.remove(fullLot.get(i));       // remove car from lot
                    count--;
                    System.out.println("Car successfully left.");
                }
                else {
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
    public double getGroupDiscount(boolean d, double p) {
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
        return count;    // count of cars
    }
}
