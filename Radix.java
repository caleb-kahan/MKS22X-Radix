import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    //double t1 = System.currentTimeMillis();
    int maxDigit = 1;
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for(int i =0;i<buckets.length;i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    //double t2 = System.currentTimeMillis();
    //System.out.println("Subcomponent 1 Time: " + (t2-t1));
    //double t3 = System.currentTimeMillis();
    for(int x: data){
      maxDigit = Math.max(maxDigit, Integer.toString(x).length());
    }
    //double t4 = System.currentTimeMillis();
    //System.out.println("Subcomponent 2 Time: " + (t4-t3));

    for(int x: data){
      if(x<0){
        buckets[9-x%10].add(x);
      }
      else{
        buckets[10+x%10].add(x);
      }
    }


    MyLinkedList<Integer> everything = new MyLinkedList<Integer>();
    for(int i= 2; i<=maxDigit+1; i++){
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
      if(num<0)num*=-1;
      if(digit==1) return num % 10;
      return num/power10(digit-1)%10;
  }
  public static int power10 (int power){
        int returner=1;
	for(int i=0;i<power;i++){
		returner*=10;
	}
	return returner;
  }
}
