public class MyLinkedList{
  private Node start;
  private Node end;
  private int length;

  public void clear(){
    this = MyLinkedList();
  }
  public void add(E){
    Node nod = new Node(null, end, E);
    end.setNext(nod);
    end = nod;
    length++;
  }
  public void extend(MyLinkedList<E> other){
    length +=other.length;
    end.setNext(other.start);
    other.setPrev(end);
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
