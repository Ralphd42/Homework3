
public class HW3 {

	public HW3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedSortedListDict dlsl = new DoubleLinkedSortedListDict();
		dlsl.AddItem("Hello");
		dlsl.AddItem("Good bye");
		dlsl.AddItem("Great ggggg");
		
		dlsl.PrintNodesForward();
		System.out.println("------------------------");
		dlsl.PrintNodesBackward();
		System.out.println("------------------------------------------------------");
		DoubleLinkedSortedListDict.DictNode N = dlsl.FindItem("Great ggggg");
		System.out.println(N.getKey());
		System.out.println("--------------asdasdsad----------------------------------------");
		System.out.println(N);
		System.out.println("--------------asdasdsad----------------------------------------");
		System.out.println(N.toString());
		System.out.println("--------------asdasdsad----------------------------------------");
		boolean Del = dlsl.RemoveItem("Great ggggg");
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
