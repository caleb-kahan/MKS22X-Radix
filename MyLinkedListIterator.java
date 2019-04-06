import java.util.Iterator;
public class MyLinkedListIterator<E> implements Iterator<E>{
	MyLinkedList<E>.Node current;
	MyLinkedList<E>.Node end;

	public MyLinkedListIterator(MyLinkedList<E> list){
		current = list.start;
		end = list.end;
	}
	public boolean hasNext(){
		if(current.next()==null) return false;
		return true;
	}
	public E next(){
		E data = current.getData();
		current = current.next();
		return data;
	}
}
