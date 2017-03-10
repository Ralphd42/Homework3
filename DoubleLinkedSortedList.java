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
public class DoubleLinkedSortedList
{
        private Node first;// first in list
        private Node last; // last in list
        public DoubleLinkedSortedList()
        {
                first = null;
                last = null;
        }
        public boolean isEmpty()
        {
                return first==null;
        }

        public void PrintNodesForward()
        {
                        Node tmp = first;
                        while(tmp!=null)
                        {
                                        System.out.println(tmp.getDataItem());
                                        tmp = tmp.getNext();
                        }
        }
        public void PrintNodesBackward()
        {
                        Node tmp = last;
                        while(tmp!=null)
                        {
                                        System.out.println(tmp.getDataItem());
                                        tmp = tmp.getPrev();
                        }
        }
        
        
        
        
        
        public void AddNode( String NodeText)
        {
                if( isEmpty())
                {
                        Node newNode =new Node(NodeText);
                        first = newNode;
                        last  = newNode;
                        return;
                }
                Node tmp = first;
                while (tmp!=null  && NodeText.compareTo(tmp.getDataItem()) >0)
                {
                	tmp = tmp.getNext();
                }
                if (tmp!=null)  // found one to insert before
                {
                	Node newNode = new Node(NodeText, tmp, tmp.getPrev());// create and add new node
                	if(tmp.getPrev()!=null )// check for first
                	{
                		tmp.getPrev().SetNext(newNode);  // set previous to point to new next
                	}
                	else
                	{
                		first = newNode;
                	}
                	tmp.SetPrevNode(newNode); // set tmp previous to
                }else  // insert at end
                {
                	Node newNode = new Node(NodeText, null, last);
                	last.SetNext(newNode);
                }
                	
        }
        public Node FindNode(String NodeText)
        {
        	Node tmp = first;
            while (tmp!=null  && NodeText.compareTo(tmp.getDataItem()) !=0)
            {
            	tmp = tmp.getNext();
            }
        	return tmp;
        }
        
        public boolean RemoveNode(String NodeText)
        {
        	boolean deleted = false;
        	Node tmp = first;
            while (tmp!=null  && NodeText.compareTo(tmp.getDataItem()) !=0)
            {
            	tmp = tmp.getNext();
            }
            if(tmp!=null)
            {
            	//Deelete the node
            	Node Prev = tmp.getPrev();
            	Node Next = tmp.getNext();
            	// Set next of Prev to Next
            	Prev.SetNext(Next);
            	//Set Prev ofNext to 
            	
            }
            
        	return deleted;
        }



}