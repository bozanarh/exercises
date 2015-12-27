package tests;

public class MyList<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    
    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }
    public void push(Item i) {
        Node<Item> n = new Node<Item>();
        n.item = i;
        n.next = head;
        head = n;
        if (tail == null) tail = n;
    }

    public boolean hasLoop() {
        if( head == null ) return false;

        Node<Item> curr = head;
        do {
            curr = curr.next;            
        } while(curr != head && curr != null);
        return curr == null ? false : true;
    } 

    //for test only
    public String print( int num ) {
    	StringBuilder s = new StringBuilder();
    	Node<Item> curr = head;
    	
    	for( int i=0; i<num; i++) {
    		if( curr == null ) break;
    		s.append(curr.item.toString());
    		s.append(" ");
    		curr = curr.next;
    	}
    	return s.toString();
    }
    
    //for test only
    public void forceLooping(){
        assert( tail != null );
        assert( head != null );
        tail.next = head;
    }

    //test
    public static void test( boolean forceLooping ) {
        MyList<Integer> l = new MyList<Integer>();
        
        for( int i=0; i<5; i++ ){
            l.push(new Integer(i));    
        }
        System.out.println(l.print(10));
        if (forceLooping) l.forceLooping();
        System.out.println(l.hasLoop());
    }

    
    //for test only
    public static void main(String [] args) {
        System.out.printf("Test1: ");
        test(false);
        System.out.printf("Test2: ");
        test(true);   
    }
}
