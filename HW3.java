
public class HW3 {

	public HW3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/** These are the items from the assignment
		• Insert a node in the list in alphabetical order
		• Find a node that matches a String
		• Traverse the list forwards and print
		• Traverse the list backwards and print
		• Delete a node from the list
		• Delete/destroy the list
		 */
		DoubleLinkedSortedListDict dlsl = new DoubleLinkedSortedListDict();
		//• Insert a node in the list in alphabetical order
		dlsl.AddItem("hello");
		dlsl.AddItem("HELLO");
		dlsl.AddItem("ZZTOP");
		dlsl.AddItem("TUNA FISH");
		dlsl.AddItem("BEAR");
		dlsl.AddItem("Jaguar");
		dlsl.SetEntry("Bear", "Large Furry Animal");  // set entry is preferred way to add items to dictionary
		//AddItem is only made public to fulfill requirements of assigmnent
		System.out.println("-Nodes Forward-");
		dlsl.PrintNodesForward();
		/*• Find a node that matches a String*/
		System.out.println("-Find a NODE-");
		DoubleLinkedSortedListDict.DictNode N = dlsl.FindItem("Bear");// find item is only included to full fill assigmnent
		//GetEntry is preferred method to get data from dictionary
		if(N!=null){
		System.out.println(N);
		}else
		{System.out.println("Not Found");}
		System.out.println("GetEntry " + dlsl.GetEntry("Bear"))   ;
		
		
		
		//• Traverse the list forwards and print
		System.out.println("• Traverse the list forwards and print");
		dlsl.PrintNodesForward();
		System.out.println("Traverse the list backwards and print");
		dlsl.PrintNodesBackward();
		System.out.println("Delete a node from the list");
		System.out.println("-Removed BEAR-");
		boolean rv =dlsl.RemoveItem("BEAR");
		dlsl.PrintNodesForward();
		System.out.println("Delete/destroy the list");
		dlsl.DestroyDictionary();
		System.out.print("SIZE = ");
		System.out.println(dlsl.size());
		
		
		
		
		
		
		System.out.println("Enhanced features------------------------");
		System.out.println("Case insensitve List ------------------------");
		dlsl = new DoubleLinkedSortedListDict(false,false); // case insenstive, don't allow duplicates
		//• Insert a node in the list in alphabetical order
		dlsl.AddItem("hello");
		try
		{
		dlsl.AddItem("HELLO");
		}catch (DictException dExc)
		{
			System.out.println(dExc);
			
			
		}
		//Note how this doesn't throw exception
		dlsl.SetEntry("Coffee");
		dlsl.SetEntry("Coffee","DRINk with Caffine");
		
		// add anonymous object to Dictionary
		dlsl.SetEntry("AnonObject",new Object(){public String toString(){return "ANON DATA";}} );
		dlsl.SetEntry("TUNA FISH", "OCEAN FISH-Getting Eating");
		dlsl.SetEntry("Bear", "Large Furry Animal");
		System.out.println("-Nodes Forward-");
		dlsl.PrintNodesForward();
		/*• Find a node that matches a String*/
		System.out.println("-Find a NODE-");
		if( dlsl.ItemExists("Bear"))
		{
			System.out.println(dlsl.GetEntry("Bear"));
			
		}
		System.out.println("-Find a NODE- anonObject");
		if( dlsl.ItemExists("AnonObject"))
		{
			System.out.println(dlsl.GetEntry("AnonObject"));
			
		}
		
		
		//• Traverse the list forwards and print
		System.out.println("• Traverse the list forwards and print");
		dlsl.PrintNodesForward();
		System.out.println("Traverse the list backwards and print");
		dlsl.PrintNodesBackward();
		System.out.println("Delete a node from the list");
		System.out.println("-Removed BEAR-");
		rv =dlsl.RemoveItem("BEAR");
		dlsl.PrintNodesForward();
		System.out.println("Delete/destroy the list");
		dlsl.DestroyDictionary();
		System.out.print("SIZE = ");
		System.out.println(dlsl.size());
	}

}
