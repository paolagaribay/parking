import java.io.File;
import java.io.IOException;
import java.util.Scanner;


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

      System.out.println("Capacity: " + capacity);
      System.out.println("Price per hour: " + price);

      ParkingLot pl = new ParkingLot(capacity, price);

      while (s.hasNextLine()) {
        String p = s.next();
        String carId = s.next();

        if (p.equals("Entering")) {
          System.out.println(carId + " is entering");
          Car c = new Car(carId);
        }
        else if (p.equals("Leaving")) {
          System.out.println(carId + " is leaving");
        }
        else {
          System.out.println("Error: line should read Entering/Leaving CarID");
        }
      }
      s.close();
      System.out.println("End of parking log");
    }
    catch(IOException e) {
      e.printStackTrace();
    }
        // park car
        // remove car for each leaving
        // get total money made
  }
}
