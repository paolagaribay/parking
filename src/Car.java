public class Car {
  private String carId;
  private Ticket t;
  private Groups g;

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
  public void setGroup(Groups g) {
    this.g = g;
  }

  public Groups getGroup() {
    return g;
  }
}
