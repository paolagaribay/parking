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
      Scanner s = new Scanner(new File(args[0]));   // read file

      try {     // validate input
        capacity = s.nextInt();
        price = s.nextDouble();
      }catch (java.util.InputMismatchException e) {
        System.out.println("Error: file should start with capacity followed by price");
        System.exit(1);
      }
      if (capacity <= 0) {
        System.out.println("Error: Capacity not valid");
        System.exit(1);
      }
      else if (price <= 0) {
        System.out.println("Error: Price not valid");
        System.exit(1);
      }

      ParkingLot pl = new ParkingLot(capacity, price);  // set parking lot
      System.out.println("This parking lot is $" + price + " the hour. Total capacity: " + capacity);
      System.out.println("");

      while (s.hasNextLine()) {
        String line = s.nextLine();
        Scanner ls = new Scanner(line);
        if(line.isEmpty()) {
          continue;
        }

        try {   // simulate waiting time
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          System.out.println(e);
        }

        while (ls.hasNext()) {
          try {
            String p = ls.next();    // check if entering or leaving
            String carId = ls.next();    // get car id

            if (ls.hasNext()) {
              System.out.println("Error: extra input in line. Line should read 'Entering/Leaving CarID'\n");
              while(ls.hasNext()) {
                ls.next();
              }
              continue;
            }

            if (p.equals("Entering")) { // park car
                Car c = new Car(carId);
                System.out.println("Car " + carId + " has arrived at lot.");
                pl.entering(c);
            }
            else if (p.equals("Leaving")) { // remove car
                System.out.println("Car " + carId + " is leaving the lot.");
                pl.leaving(carId);
            }
            else {
                System.out.println("Error: line should start with 'Entering' or 'Leaving'");
            }
            System.out.println("");

          }catch (java.util.NoSuchElementException e) {
            System.out.println("Error: line should read 'Entering/Leaving CarID'\n");
            continue;
          }
        }
        ls.close();
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