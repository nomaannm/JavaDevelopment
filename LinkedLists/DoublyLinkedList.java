public class DoublyLinkedList <T> implements Iterable <T>
{
    private int size = 0;
    private Node <T> head = null ;
    private Node <T> tail = null;

    //Class Node to represent each set of data
    private class Node <T> {
        T data;
        Node <T> prev , next ;
        public Node(T data , Node <T> prev , Node <T> next)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override public String toString()
        {
            return data.toString();
        }
    }

    public void clear(){
        Node <T> trav = head ;
        while(trav != null){
            Node <T> next = trav.next;
            trav.prev = trav.next = null ;
            trav.data = null ;
            trav = next ;
        }
        head = tail = trav = null;
        size = 0 ;
    }

    //Returns the size of the linked list
    public int size() {
        return size ;
    }

    //Is linked list empty or not ?
    public boolean isEmpty(){
        return size() == 0 ; //will return 1 if the size would be 0 and 0 if not
    }

    //Add an element to the tail of the linked list ,O(1)
    public void add(T elem)
    {
        addLast(elem);
    }

    //Add an element to the start of the linked list , O(1)
    public void addFirst(T elem)
    {
        if(isEmpty()){
            head = tail = new Node <T>(elem , null , null);
        }
        else{
            head.prev = new Node <T>(elem , null , head);
            head = head.prev ;
        }

        size++ ;

    }

    //add an elemnt to the last of the linked list , O(1)
    public void addLast(T elem)
    {
        if(isEmpty())
        {
            head = tail = new Node <T> (elem , null , null);
        }
        else{
            tail.next = new Node<T> (elem , tail , null);
            tail = tail.next ;
        }

        size++ ;

    }

    //checks the value of the first node , if it exists , O(1)
    public T peekFirst()
    {
        if(isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast()
    {
        if(isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst()
    {
        if(isEmpty()) throw new RuntimeException("Empty List");
        
        //extract the data at the head and move
        // the head pointer forwards one node
        T data = head.data ;
        head = head.next ;
        --size;

        //If the list is empty set the tail to null as well
        if (isEmpty()) tail = null ;

        //Do a memory cleanup of the previous node
        else head.prev = null;

        //return the data that was at the first node we just removed
        return data;
    }

    //remove the last value from the tail of the linked list , O(1)
    public T removeLast()
    {
        if(isEmpty()) throw new RuntimeException("Empty List");

        T data = tail.data;
        tail = tail.prev;
        --size ;

        if(isEmpty()) head = null ;
        else tail.next = null ;

        return data ;
    }

    //removing an arbitrary node from the linked llist , O(n)
    private T remove(Node <T> node)
    {
        // If the node to be removed is either at the head or the tail , it should be handled independently
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        //Make the pointers of the adjacent nodes skip over 'node'
        node.next.prev = node.prev ;
        node.prev.next = node.next ;

        //Temprorary store the data we want to return 
        T data = node.data ;

        //memory cleanup
        node.data = null ;
        node = node.prev = node.next = null ;

        --size;

        return data ;
    }

    //O(n)
    public T removeAt(int index)
    {
        if(index < 0 || index >= size) throw new IllegalArgumentException();

        int i ;
        Node <T> trav;

        //Search from the front of the list
        if(index < size/2)
        {
            for(i = 0 , trav = head ; i != index ; i++)
              trav = trav.next;

        }

        //Search from the back of the list
        else{
            for(i = size - 1 , trav = tail ; i != index ; i--)
               trav = trav.prev;
        }

        return remove(trav);
    }

    //Remove a particular value in the linked list , O(n)
    public boolean remove(Object obj)
    {
        Node <T> trav = head;

        //Support searching for null
        if(obj == null)
        {
            for (trav = head ; trav != null ; trav = trav.next)
            {
                if(trav.data == null);
                remove(trav);
                return true;
            }

        }

        //searching for non null 
        else{
            for(trav = head ; trav != null ; )
            {
                if(obj.equals(trav.data))
                  remove(trav);
                  return true;
            }

        }
        return false;
    }

    //finding the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj)
    {
        int idx = 0 ;
        Node <T> trav = head ;

        //Support searching for null
        if(obj == null)
        {
            for (trav = head ; trav != null ; trav = trav.next, idx++)
            {
                if(trav.data == null)
                   return idx;

            }
        }

        //Searching for a non-null object
        else{
            for(trav = head ; trav != null ; trav = trav.next , idx++)
            {
                if(obj.equals(trav.data))
                   return idx;
            }
        }

        return -1;
    }

    //Check if a value is contained within the linked list
    public boolean contains(Object obj)
    {
        return indexOf(obj) != -1;
    }

    @Override public java.util.Iterator <T> iterator()
    {
        return new java.util.Iterator <T> (){
            private Node <T> trav = head;
            @Override public boolean hasNext(){
                return trav != null ;
            }
            @Override public T next () {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }
    @Override public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node <T> trav = head ;
        while( trav != null)
        {
            sb.append(trav.data + ", ");
            trav = trav.next ;
        }
        sb.append(" ]");
        return sb.toString();

    }

    public static DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
    public static void main(String args[])
    {
        list.add(3);
        list.add(4);
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        list.add(5);
        String answer = list.toString();
        System.out.println(answer);
    }

    


}