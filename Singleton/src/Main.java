
public class Main {
	public static void main(String[] args) {
		System.out.println("Start");
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if(obj1 == obj2) {
			System.out.println("obj1�� obj2�� ���� �ν��Ͻ��Դϴ�.");
		} else {
			System.out.println("obj1�� obj2�� �ٸ� �ν��Ͻ��Դϴ�");
		}
		System.out.println("End");
		
		TicketMaker ticketMaker = TicketMaker.getInstance();
		System.out.println(ticketMaker.getNextTicketNumber());
		System.out.println(ticketMaker.getNextTicketNumber());
		System.out.println(ticketMaker.getNextTicketNumber());
		System.out.println(ticketMaker.getNextTicketNumber());
		
		char[] c = {'a', 'b', 'c'};
		int i = c.length;
		System.out.println(i);
	}
}
