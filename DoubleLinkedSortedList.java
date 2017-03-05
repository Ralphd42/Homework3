/**
 * 
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




}