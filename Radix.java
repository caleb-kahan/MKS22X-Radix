import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    int digitUpTo = 1;
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
        buckets[9-(getDigit(digitUpTo,x))].add(x);
      }
      else{
	//System.out.println(x);
	//System.out.println(digitUpTo);
	//System.out.println((x%(int)Math.pow(10,digitUpTo))); 
        buckets[10+(getDigit(digitUpTo,x))].add(x);
      }
    }
    for(int i=0;i<buckets.length;i++){
	//System.out.println(buckets[i]);
    }
    //System.out.println(maxDigit);
    for(int i= digitUpTo; i<=maxDigit; i++){
      MyLinkedList<Integer> everything = new MyLinkedList<Integer>();
      for(int j = 0;j<20;j++){
        everything.extend(buckets[i]);
      }
      System.out.println(everything);
      MyLinkedList<Integer>.Node first = everything.start;
      for(int j=0;j<everything.length;j++){
        int x = first.getData();
        if(j==maxDigit){
          data[j]=x;
        }
        else{
          if(x<0){
            buckets[9-(int)(x%Math.pow(10,digitUpTo))].add(x);
          }
          else{
            buckets[10+(int)(x%Math.pow(10,digitUpTo))].add(x);
          }
        }
        first = first.next();
      }
    }
  }
  public int getDigit(int digit, int num)
      num = Math.abs(num);
      int power = digit -1;
      int divisor = Math.pow(10,power);
      num/=divisor;
      return num%10;
  }
}
