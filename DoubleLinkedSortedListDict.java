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
 *
 */
public class DoubleLinkedSortedListDict {
	private DictNode first;// first in list
	private DictNode last; // last in list

	public DoubleLinkedSortedListDict() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void PrintNodesForward() {
		DictNode tmp = first;
		while (tmp != null) {
			System.out.println(tmp.getKey());
			tmp = tmp.getNext();
		}
	}

	public void PrintNodesBackward() {
		DictNode tmp = last;
		while (tmp != null) {
			System.out.println(tmp.getKey());
			tmp = tmp.getPrev();
		}
	}

	public void AddItem(String dictKey, Object Value) {
		if (isEmpty()) {
			DictNode newNode = new DictNode(dictKey, null, null, Value);
			first = newNode;
			last = newNode;
			return;
		}
		DictNode tmp = first;
		while (tmp != null && dictKey.compareTo(tmp.getKey()) > 0) {
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

	public DictNode FindNode(String NodeText) {
		DictNode tmp = first;
		while (tmp != null && NodeText.compareTo(tmp.getKey()) != 0) {
			tmp = tmp.getNext();
		}
		return tmp;
	}

	public boolean RemoveNode(String KeyVal) {
		boolean deleted = false;
		DictNode tmp = first;
		while (tmp != null && KeyVal.compareTo(tmp.getKey()) != 0) {
			tmp = tmp.getNext();
		}
		if (tmp != null) {
			deleted = true;
			// Deelete the node
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

	class DictNode {
		private String key;// the DataITem
		private DictNode prev; // the Previous Node
		private DictNode next; // the next Node
		private Object value;

		public void setValue(Object newValue) {

			value = newValue;
		}

		public Object getValue() {
			return value;

		}

		public DictNode(String Key, DictNode Next, DictNode Prev, Object NodeValue) {
			this.key = Key;
			this.next = Next;
			this.prev = Prev;
			this.value = NodeValue;

		}

		public DictNode(String nodeKey) {
			this(nodeKey, null, null, null);
		}

		public String getKey() {
			return key;
		}

		public void SetPrevNode(DictNode node) {
			prev = node;
		}

		public void SetNext(DictNode node) {
			next = node;
		}

		public DictNode getNext() {
			return next;
		}

		public DictNode getPrev() {
			return prev;
		}
		public String toString()
		{
			
			
		}

	}

}