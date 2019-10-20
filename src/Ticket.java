import java.util.Date;

public class Ticket {
    private Date inTime;
    private Date outTime;
    private String ticketId;
    private long totalTime;

    public Ticket(String id) {
        ticketId = id;
    }
    public void setInTime(Date in) {
        inTime = in;
    }
    public void setOutTime(Date out) {
        outTime = out;
    }
    public Date getInTime() {
        return inTime;
    }
    public Date getOutTime() {
        return outTime;
    }
    public String getTicketId() {
      return ticketId;
    }
    public long totalTime() {   // calculate time difference
        totalTime = outTime.getTime() - inTime.getTime();
        return totalTime;
    }
}
