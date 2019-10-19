import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Formatter;

public class Main {
  public static void main(String[] args) {
    int capacity = 0;
    double price = 0;
    if(args.length < 1) {
      System.out.println("Error, usage: java Main.java inputfile");
      System.exit(1);
    }
    try {
      Scanner s = new Scanner(new File(args[0]));

      capacity = s.nextInt();
      price = s.nextDouble();
      ParkingLot pl = new ParkingLot(capacity, price);
      System.out.println("This parking lot is $" + price + " the hour. Total capacity: " + capacity);
      System.out.println("");
      while (s.hasNextLine()) {
        String p = s.next();
        String carId = s.next();
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        } //simulate waiting
        if (p.equals("Entering")) {
          Car c = new Car(carId);
          System.out.println("Car "+carId + " has arrived at lot.");
          pl.entering(c);
        }
        else if (p.equals("Leaving")) {
          System.out.println("Car "+carId + " is leaving the lot.");
          pl.leaving(carId);
        }
        else {
          System.out.println("Error: line should start with 'Entering' or 'Leaving'");
        }
        System.out.println("");
      }
      s.close();
      System.out.println("End of parking log.");
      System.out.println("Total money made: " + String.format("%.02f",pl.getTotal()));
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }
}
