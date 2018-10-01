
public class TicketMaker {
	private static TicketMaker ticketMaker = new TicketMaker();
		
	public static TicketMaker getInstance() {
	
		return ticketMaker;
	}
	
	
	
	private int ticket = 1000;
	public int getNextTicketNumber() {
		return ticket++;
	}
	
}
