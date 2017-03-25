
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
		System.out.println("------------------------------------------------------");
		DoubleLinkedSortedList.Node N = dlsl.FindNode("Great ggggg");
		System.out.println(N.getDataItem());
		System.out.println("--------------asdasdsad----------------------------------------");
		System.out.println(N);
		System.out.println("--------------asdasdsad----------------------------------------");
		System.out.println(N.toString());
		System.out.println("--------------asdasdsad----------------------------------------");
		boolean Del = dlsl.RemoveNode("Great ggggg");
		if(Del)
		{
			System.out.println("DELETED");
			dlsl.PrintNodesBackward();
			
			
		}else
		{
			
			System.out.println("NoDel");
		}
		
	}

}
