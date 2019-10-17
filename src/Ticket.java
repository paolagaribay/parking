
public class Ticket {
    Date inTime;
    Date outTime;
    String ticketId;
    public Ticket(String id, Date in, Date out) {
        ticketId = id;
        inTime = in;
        outTime = out; //maybe remove
        System.out.println("Ticket created");
    }
    public void setOutTime(Date t) {
        outTime = t;
    }
    public Date getInTime() {
        return inTime;
    }
    public Date getOutTime() {
        return outTime;
    }
    public String getTicket() {
      return ticketId;
    }
}
