public class Car {
  String carId;
  Ticket t;
  public Car(String id) {
    carId = id;
  }
  public String getCarId() {
    return carId;
  }
  public void setTicket() {
    t = new Ticket("T--"+carId);
  }
  public Ticket getTicket() {
    return t;
  }
}
