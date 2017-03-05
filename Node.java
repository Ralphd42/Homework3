/**
 * 
 */

/**
 * @author ralph
 *
 */
public class Node
{
        private String dataItem;// the DataITem
        private Node prev; // the Previous Node
        private Node next; // the next Node

        public Node( String nodeData, Node Next, Node Prev)
        {
        	dataItem = nodeData;
        	this.next = Next;
        	this.prev = Prev;

        }

        public Node ( String nodeData)
        {
                this(nodeData,null,null);
        }

        public String getDataItem()
        {
                return dataItem;
        }
        public void SetPrevNode(Node node)
        {
                        prev = node;
        }

        public void SetNext(Node node)
        {
                        next = node;
        }
        public Node getNext()
        {
                return next;
        }
        public Node getPrev()
        {
                return prev;
        }

}
