public class Node{
  private Node next,prev;
  private Integer data;

  Node next(){
    return next;
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
  Integer getData(){
    return data;
  }
  Integer setData(Integer i){
    data =i;
  }
  String toString(){
    return "Previous Node: " + prev.data + " This Node: " + data + " Next Node: "+ next.data;
  }
}
