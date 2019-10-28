import java.util.Calendar;

public class Ticket {
    private Calendar inTime;
    private Calendar outTime;
    private String ticketId;
    private long totalTime;
    private double d;

    public Ticket(String id) {
        ticketId = id;
    }
    public void setInTime(Calendar in) {
        inTime = in;
    }
    public void setOutTime(Calendar out) {
        outTime = out;
    }
    public Calendar getInTime() {
        return inTime;
    }
    public Calendar getOutTime() {
        return outTime;
    }
    public String getTicketId() {
      return ticketId;
    }
    public long totalTime() {   // calculate time difference
        totalTime = outTime.getTimeInMillis() - inTime.getTimeInMillis();
        return totalTime;
    }
    public void setDis(double d) {
        this.d = d;
    }
    public double getDis() {
        return d;
    }
}
