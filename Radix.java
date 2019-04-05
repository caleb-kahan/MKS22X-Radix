import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    int maxDigit = 1;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(int i =0;i<buckets.length;i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    double t1 = System.currentTimeMillis();
    for(int x: data){
      maxDigit = Integer.toString(x).length();
    }
    /*for(int x: data){
      maxDigit = (int)Math.max(maxDigit,(Math.ceil(Math.log10(x+1))));
    }*/
    double t2 = System.currentTimeMillis();
    System.out.println(t2-t1);
    for(int x: data){
      if(x<0){
        buckets[9-(getDigit(1,x))].add(x);
      }
      else{
        buckets[10+(getDigit(1,x))].add(x);
      }
    }
    MyLinkedList<Integer> everything = new MyLinkedList<Integer>();
    for(int i= 1; i<=maxDigit+1; i++){
      for(int j = 0;j<20;j++){
        everything.extend(buckets[j]);
      }
      if(i==maxDigit+1)
	  break;
      Iterator<Integer> iter = everything.iterator();
      for(int j=0;j<everything.length;j++){
          int x = iter.next();
          if(x<0){
            buckets[9-(getDigit(i,x))].add(x);
          }
          else{
            buckets[10+(getDigit(i,x))].add(x);
          }
      }
      everything.clear();
    }
   Iterator<Integer> iter = everything.iterator();
    int j=0;
    while(j<everything.length){
        data[j] = iter.next();
        j++;
    }
  }
  public static int getDigit(int digit, int num){
      return (Math.abs(num)/(int)Math.pow(10,digit-1))%10;
  }
}
