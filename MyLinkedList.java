public class MyLinkedList<E>{
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
      data = i;
    }
    String toString(){
      return "Previous Node: " + prev.data + ", This Node: " + data + ", Next Node: " + next.data + ".";
    }
  }

  private Node start;
  private Node end;
  private int length;

  public void clear(){
    this = MyLinkedList();
  }
  public void add(E element){
    Node nod = new Node(null, end, element);
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
