
public class HW3 {

	public HW3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedSortedList dlsl = new DoubleLinkedSortedList();
		dlsl.AddNode("Hello");
		dlsl.AddNode("Good bye");
		dlsl.AddNode("Great ggggg");
		
		dlsl.PrintNodesForward();
		System.out.println("------------------------");
		dlsl.PrintNodesBackward();
	}

}
