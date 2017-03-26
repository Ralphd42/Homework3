/**
 * • Insert a node in the list in alphabetical order
• Find a node that matches a String
• Traverse the list forwards and print
• Traverse the list backwards and print
• Delete a node from the list
• Delete/destroy the list
 */

/**
 * @author ralph
 *This class uses a double linked list to create a dictionary.
 *
 */
public class DoubleLinkedSortedListDict {
	private DictNode first;// Head of List
	private DictNode last; // Tail node of list
    private boolean isCaseSensitve; // specifies if searching etc will be case sensitive
    private boolean allowDuplicates;// specifies if we are allowing duplicates
	
    /***
     * Default Constructor
     */
    public DoubleLinkedSortedListDict() {
		this(true,true);
		
	}
    /**
     * Constructor with parameters 
     * @param CaseSensitve    -is it a case sensitve dictionary
     * @param allowDuplicates  - does it allow duplicates
     */
	public DoubleLinkedSortedListDict(boolean CaseSensitve,boolean allowDuplicates ) {
		first = null;
		last = null;
		isCaseSensitve =CaseSensitve;
		this.allowDuplicates = allowDuplicates;
	}
	
	

	/**
	 * 
	 * @return true if empty dictionary
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * This will print the nodes in forward order
	 */
	public void PrintNodesForward() {
		DictNode tmp = first;
		while (tmp != null) {
			System.out.println(tmp.toString());
			tmp = tmp.getNext();
		}
	}
	
	/**
	 * This will print the nodes in reverse order
	 */
	public void PrintNodesBackward() {
		DictNode tmp = last;
		while (tmp != null) {
			System.out.println(tmp.toString());
			tmp = tmp.getPrev();
		}
	}
	
	/**
	 * This function handles the comparing of the strings to determine order of List
	 * @param StringOne
	 * @param StringTwo
	 * @return
	 */
	private int CompStrings(String StringOne,String StringTwo)
	{
		int retval=0;
		if( isCaseSensitve){
			retval=StringOne.compareTo(StringTwo);
		}
		else
		{
			retval=StringOne.toLowerCase().compareTo(StringTwo.toLowerCase());
		
		}
		return retval;
		
		
	}
	

	/**
	 * Adds item to list with only a key
	 * @param dictKey
	 */
	public void AddItem(String dictKey)
	{
		AddItem(dictKey,null);
	}
	/**
	 * Adds item to list with both key and value
	 * @param dictKey - key
	 * @param Value   - value
	 */
	public void AddItem(String dictKey, Object Value) {
		if(!allowDuplicates)
		{
			if(ItemExists(dictKey))
			{
				throw new DictException("Item Already exists in list");
			}
			
		}
		
		
		if (isEmpty()) {
			DictNode newNode = new DictNode(dictKey, null, null, Value);
			first = newNode;
			last = newNode;
			return;
		}
		DictNode tmp = first;
		while (tmp != null &&  CompStrings(dictKey,tmp.getKey()) > 0) {
			tmp = tmp.getNext();
		}
		if (tmp != null) // found one to insert before
		{
			DictNode newNode = new DictNode(dictKey, tmp, tmp.getPrev(), Value);// create
																				// and
																				// add
																				// new
																				// node
			if (tmp.getPrev() != null)// check for first
			{
				tmp.getPrev().SetNext(newNode); // set previous to point to new
												// next
			} else {
				first = newNode;
			}
			tmp.SetPrevNode(newNode); // set tmp previous to
		} else // insert at end
		{
			DictNode newNode = new DictNode(dictKey, null, last, Value);
			last.SetNext(newNode);
		}

	}
	/**
	 * tests if an item exists in dictionary
	 * @param ItemName name of item
	 * @return  true if item does exist.  
	 */
	public boolean ItemExists(String ItemName)
	{	
		DictNode tmp = first;
		while (tmp != null && CompStrings(ItemName,tmp.getKey()) != 0) {
			tmp = tmp.getNext();
		}
		return tmp!=null;
	}
	
	
	/**
	 *  this gives the dictionary node of the item
	 *  I only included this because assignment asked for it.  
	 * @param ItemText   this is the name of the item
	 * @return the DictionaryNode if it exists null otherwise
	 */
	public DictNode FindItem(String ItemText) {
		DictNode tmp = first;
		while (tmp != null && CompStrings(ItemText,tmp.getKey()) != 0             ) {
			tmp = tmp.getNext();
		}
		return tmp;
	}

	
	/**
	 * removes item by name(key) from dictionary
	 * @param KeyVal  this is the dictionary Key(Name)
	 * @return true if exists false if didn't
	 */
	public boolean RemoveItem(String KeyVal) {
		boolean deleted = false;
		DictNode tmp = first;
		while (tmp != null && CompStrings(KeyVal,tmp.getKey()) != 0 ) {
			tmp = tmp.getNext();
		}
		if (tmp != null) {
			deleted = true;
			// Delete the node
			DictNode Prev = tmp.getPrev();
			DictNode Next = tmp.getNext();
			if (Prev != null) {
				if (Next != null) {
					Prev.SetNext(Next);
					Next.SetPrevNode(Prev);
				} else {
					Prev.SetNext(null);
				}

			} else {
				if (Next != null) {
					Next.SetPrevNode(null);
				}
			}
		}

		return deleted;
	}
	
	/**
	 * Adds or updates item in dictionary
	 * @param Key  the key to either add or update
	 * @param Value the new value to either add or update
	 */
	public void SetEntry(String Key, String Value)
	{
		DictNode node =FindItem(Key);
		if(node!=null)
		{
			node.setValue(Value);
		
		}else
		{
			AddItem(Key,Value);
		}
	}
	
	
	
	
	class DictNode {
		private String key;// the DataITem
		private DictNode prev; // the Previous Node
		private DictNode next; // the next Node
		private Object value;  // the value

		/**
		 * sets value of a NODE
		 * @param newValue  the new value
		 */
		public void setValue(Object newValue) {

			value = newValue;
		}

		/**
		 * Gets the value of a node
		 * @return the value
		 */
		public Object getValue() {
			return value;

		}

		/**
		 * 
		 * @param Key key
		 * @param Next the next node
		 * @param Prev the Previous Node
		 * @param NodeValue The value if it has one
		 */
		public DictNode(String Key, DictNode Next, DictNode Prev, Object NodeValue) {
			this.key = Key;
			this.next = Next;
			this.prev = Prev;
			this.value = NodeValue;

		}

		/**
		 * Constructor with only Node Key
		 * Note we do not allow creation of Nodes without Key
		 * @param nodeKey
		 */
		public DictNode(String nodeKey) {
			this(nodeKey, null, null, null);
		}
		/**
		 * gets the Node KEY
		 * Note that there isn't a setter.  This can't be set after created
		 * @return the key
		 */
		public String getKey() {
			return key;
		}
		/**
		 * Sets Previous Node
		 * @param node the previous Node
		 */
		public void SetPrevNode(DictNode node) {
			prev = node;
		}
		/**
		 *  Sets Next Node
		 * @param node The Next Node
		 */
		public void SetNext(DictNode node) {
			next = node;
		}
		/**
		 * 
		 * @return the NextNode
		 */
		public DictNode getNext() {
			return next;
		}
		/**
		 * 
		 * @return the previous Node
		 */
		public DictNode getPrev() {
			return prev;
		}
		
		/**
		 * returns string representation of Node
		 */
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append(key);
			if(value!=null)
			{
				sb.append(" - ");
				sb.append(value);
			}
			return sb.toString();
		}

	}

}