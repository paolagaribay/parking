import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {

    if (args.length < 1) {
      System.out.println("Error, usage: java Main.java inputfile");
      System.exit(1);
    }

    try {
      Scanner s = new Scanner(new File(args[0]));   // read file

      ParkingLot pl = new ParkingLot();

      while (s.hasNextLine()) {
        String line = s.nextLine();
        Scanner ls = new Scanner(line);
        if (line.isEmpty()) {
          continue;
        }

        try {   // simulate waiting time
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println(e);
        }

        while (ls.hasNext()) {
          try {
            String p = ls.next();    // check if entering or leaving
            String carId = ls.next();    // get car id
            String choice = "";
            int i = 0;

            if (ls.hasNext()) {   // check choice
              choice = ls.next();

              if (!(choice.equals("y") || choice.equals("g") || choice.equals("b") ||
                      choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
                System.out.println("Error: Optional choice when entering - 'y' to hear YellowLot details, " +
                        "'g' to hear GreenLot details, 'b' to hear BlueLot details" +
                        " or '1' for YellowLot, '2' for GreenLot, '3' for BlueLot\n");
                i = 1;
                if (ls.hasNext()) {   // check if more input
                  while (ls.hasNext()) {
                    ls.next();
                  }
                  i = 1;
                }
              }
              if (ls.hasNext()) {   // check if more input
                System.out.println("Error: extra input in line\n");
                while (ls.hasNext()) {
                  ls.next();
                }
                i = 1;
              }
            }
            if (i ==1) {
              continue;
            }

            if (p.equals("Entering")) { // enter lot
              Car c = new Car(carId);
              System.out.println("Car " + carId + " has arrived at lot.");
              pl.entering(c, choice);
            }
            else if (p.equals("Leaving")) { // remove car
              if (choice.equals("")) {
                System.out.println("Car " + carId + " is leaving the lot.");
                pl.leaving(carId);
              } else {
                System.out.println("Error: Line should read 'Leaving CarID'\n");
                continue;
              }
            }
            else {
              System.out.println("Error: line should start with 'Entering' or 'Leaving'\n");
              continue;
            }
            System.out.println("");

          } catch (java.util.NoSuchElementException e) {
            System.out.println("Error: line should read 'Entering/Leaving CarID Choice(optional when entering)'\n");
            continue;
          }
        }
        ls.close();
      }
      s.close();
      System.out.println("End of parking log.");
      System.out.println("Total money made: " + String.format("%.02f", pl.getTotal()));
      System.out.println("Cars left in lots: " + pl.getCarsLeft());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}