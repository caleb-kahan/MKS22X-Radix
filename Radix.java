public class Radix{
  public static void radixsort(int[]data){
    int digitUpTo = 1;
    int maxDigit = 1;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(MyLinkedList x: buckets){
      x = new MyLinkedList();
    }
    for(int x: data){
      maxDigit = Math.max(maxDigit,Math.log10(x));
    }
    for(int x: data){
      if(x<0){
        buckets[9-(x%Math.pow(10,digitUpTo))].add(x);
      }
      else{
        buckets[10+(x%Math.pow(10,digitUpTo))].add(x);
      }
    }
    for(int i= digitUpTo; i<=maxDigit; i++){
      MyLinkedList<Integer> everything = new MyLinkedList();
      for(int i = 0;i<20;i++){
        everything.extend(buckets[i]);
      }
      Node first = everything.start;
      for(int i=0;i<everything.length;i++){
        int x = first.getData();
        if(x<0){
          buckets[9-(x%Math.pow(10,digitUpTo))].add(x);
        }
        else{
          buckets[10+(x%Math.pow(10,digitUpTo))].add(x);
        }
        first = first.next();
      }
    }
  }
}
