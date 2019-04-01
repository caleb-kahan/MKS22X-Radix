public class Radix{
  public static void radixsort(int[]data){
    int digitUpTo = 0;
    int [] buckets = new int [20];
    for(int x: data){
      if(x<0){
        buckets[9-(x%Math.pow(10,digitUpTo+1))].add(x);
      }
    }
  }

}
