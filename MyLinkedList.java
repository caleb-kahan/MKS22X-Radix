import java.util.Iterator;
public class MyLinkedList<E> implements Iterable<E> {
  public class Node{
    private Node next,prev;
    private E data;

    Node next(){
      return next;
    }
    public Node(Node next, Node prev, E data){
      this.next = next;
      this.prev = prev;
      this.data = data;
    }
    Node prev(){
      return prev;
    }
    void setNext(Node other){
      next = other;
    }
    void setPrev(Node other){
      prev = other;
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
      return "Previous Node: " + prev.data + ", This Node: " + data + ", Next Node: " + next.data + ".";
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
  public Iterator<E> iterator(){
	return new MyLinkedListIterator<E>(this);
  }
  public void add(E element){
    if(end==null) {
	Node nod = new Node(null, null, element);
	start = nod;
	end = nod;
    }
    else {
	Node nod = new Node(null, end, element);
	if (true)System.out.println("WOWZie");
	if (nod==null)System.out.println("WOW");
	end.setNext(nod);
	nod.setPrev(end);
	end = nod;
	length++;
  }
  public void extend(MyLinkedList<E> other){
    length +=other.length;
    start.setNext(other.start);
    other.start.setPrev(end);
    end = other.end;
    other.clear();
  }
  public E removeFront(){
    length--;
    start = start.next();
    start.prev().setNext(null);
    return start.prev().getData();
  }
}
