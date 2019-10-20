public class Car {
  private String carId;
  private Ticket t;

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
