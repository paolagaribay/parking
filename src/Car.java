
public class Car {
  String carId;
  Ticket t;
  public Car(String id) {
    carId = id;
    System.out.println("Car created");
  }
  public String getCarId() {
    return carId;
  }
  public void setTicket(Ticket ti) {
    t = ti;
  }
  public Ticket getTicket() {
    return t;
  }
}
