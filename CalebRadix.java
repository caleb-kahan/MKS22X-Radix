public class CalebRadix{
  public static void main(String [] args){
    int [] a = {1,1,2,-3,1,-5,1,1,1,1};
    Radix.radixsort(a);
    int [] b = {};
    Radix.radixsort(b);
    print(a);
    print(b);
  }
  public static void print(int [] data){
    String returner = "{";
    for(int x: data){
      returner+=x+",";
    }
    System.out.println(returner+"}");
  }
}
