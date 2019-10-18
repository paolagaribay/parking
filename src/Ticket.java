import java.time.LocalTime;

public class Ticket {
    LocalTime inTime;
    LocalTime outTime;
    String ticketId;
    public Ticket(String id) {
        ticketId = id;
        System.out.println("Ticket created");
    }
    public void setInTime(LocalTime in) {
        inTime = in;
        System.out.println("Time in set");
    }
    public void setOutTime(LocalTime out) {
        outTime = out;
        System.out.println("Time out set");
    }
    public LocalTime getInTime() {
        return inTime;
    }
    public LocalTime getOutTime() {
        return outTime;
    }
    public String getTicketId() {
      return ticketId;
    }
}
