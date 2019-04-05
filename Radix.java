import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    int maxDigit = 1;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(int i =0;i<buckets.length;i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    for(int x: data){
      maxDigit = (int)Math.max(maxDigit,(Math.ceil(Math.log10(x+1))));
    }
    for(int x: data){
      if(x<0){
        buckets[9-(getDigit(1,x))].add(x);
      }
      else{
        buckets[10+(getDigit(1,x))].add(x);
      }
    }
    for(int i= 1; i<=maxDigit+1; i++){
      MyLinkedList<Integer> everything = new MyLinkedList<Integer>();
      for(int j = 0;j<20;j++){
        everything.extend(buckets[j]);
      }
      MyLinkedList<Integer>.Node first = everything.start;
      for(int j=0;j<everything.length;j++){
        int x = first.getData();
        if(i==maxDigit+1){
          data[j]=x;
        }
        else{
          if(x<0){
            buckets[9-(getDigit(i,x))].add(x);
          }
          else{
            buckets[10+(getDigit(i,x))].add(x);
          }
        }
        first = first.next();
      }
    }
  }
  public static int getDigit(int digit, int num){
      num = Math.abs(num);
      int power = digit -1;
      int divisor = (int)Math.pow(10,power);
      num/=divisor;
      return num%10;
  }
}
