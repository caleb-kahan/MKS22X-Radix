import java.util.Iterator;
public class MyLinkedList<E> implements Iterable<E> {
  public class Node{
    private Node next;
    private E data;

    Node next(){
      return next;
    }
    
    void setNext(Node other){
      next = other;
    }

    E getData(){
      return data;
    }
    E setData(E i){
      E returner = data;
      data = i;
      return returner;
    }
    public String toString(){
      return  "Data: " + data;
    }
  }

  public Node start;
  public Node end;
  public int length;

  public void clear(){
    start = null;
    end = null;
    length = 0;
  }
  public String toString(){
	String returner = "[";
	MyLinkedListIterator<E> iterator = iterator();
	while(iterator.hasNext())
		returner += iterator.next() + " ";
	return returner+"]";
  }
  public MyLinkedListIterator<E> iterator(){
	return new MyLinkedListIterator<E>(this);
  }
  public void add(E element){
    Node nod = new Node();
    if(length==0) start = nod;
    else end.setNext(nod);
    end = nod;
    length++;
  }
  public void extend(MyLinkedList<E> other){
    if(other.start==null);
	  else if(end==null){
		start = other.start;
		end = other.end;
		length = other.length;
		other.clear();
	  }
	  else {
		length +=other.length;
		end.setNext(other.start);
		//other.start.setPrev(end);
		end = other.end;
		other.clear();
           }

  }
  /*public E removeFront(){
    length--;
    start = start.next();
    start.prev().setNext(null);
    return start.prev().getData();
  }*/
}
