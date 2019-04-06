import java.util.Iterator;
public class MyLinkedListIterator<E> implements Iterator<E>{
	MyLinkedList<E>.Node current;
	MyLinkedList<E>.Node end;

	public MyLinkedListIterator(MyLinkedList<E> list){
		current = list.start;
		end = list.end;
	}
	public boolean hasNext(){
		if(current!=end) return true;
		return false;
	}
	public E next(){
                System.out.println("Enter");
		E data = current.getData();
                System.out.println("Enter 2");
		current = current.next();
                System.out.println("Enter 3");
		return data;
	}
}
