
public class ParkingLot {
  // capacity
  // price
  // list of cars parked
  // counter
  parkingLot(int c, int p) {
    // set capacity
    // set price
    // create list
  }
  public boolean checkCapacity() {
    // check if parking lot full 
  }
  public void entering(Car c, time t) {
    // if not full - create ticket of rand id
    // set in time
    // give ticket to car
    // add car to list
  }
  public void leaving(Car c, time t) {
    // if car in list - get ticket
    // set out time
    // pay ticket
    // remove car from list
  }
  public int pay(Ticket t) {
    // get in time
    // get out time
    // set difference to totaltime
    // totalpay = totaltime * price
    // return totalpay
}
