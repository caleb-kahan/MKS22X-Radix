import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    //double t1 = System.currentTimeMillis();
    int maxDigit = 1;
    @SuppressWarnings("unchecked")
    MyLinkedList <Integer> [] buckets = new MyLinkedList[20];
    for(int i =0;i<buckets.length;i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    for(int x: data){
      maxDigit = Math.max(maxDigit, Integer.toString(x).length());
    }

    for(int x: data){
      if(x>=0){
        buckets[10+x%10].add(x);
      }
      else{
        //% returns negative numbers
        buckets[9+x%10].add(x);
      }
    }
    MyLinkedList<Integer> everything = new MyLinkedList<Integer>();
    for(int i= 2; i<=maxDigit+1; i++){
      everything = new MyLinkedList<Integer>();
      for(int j = 0;j<20;j++){
        everything.extend(buckets[j]);
      }
      if(i==maxDigit+1)
	       break;
      Iterator<Integer> iter = everything.iterator();

      while(iter.hasNext()){
          int x = iter.next();
          if(x<0){
            buckets[9-(getDigit(i,x))].add(x);
          }
          else{
            buckets[10+(getDigit(i,x))].add(x);
          }
      }
      //We go one more time: check hasNext();
      int x = iter.next();
      if(x<0){
          buckets[9-(getDigit(i,x))].add(x);
      }
      else{
          buckets[10+(getDigit(i,x))].add(x);
       }
    }
   Iterator<Integer> iter = everything.iterator();
    int j=0;
    while(j<data.length){
        data[j] = iter.next();
        j++;
    }
  }
  public static int getDigit(int digit, int num){
      if(num<0)num*=-1;
      for(int i=1;i<digit;i++){
		      num/=10;
      }
      return num % 10;
  }
}
