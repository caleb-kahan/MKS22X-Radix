public class CalebRadix{
  public static void main(String [] args){
    int [] a = {1,-1,21,-3,1,2,32,16,19,-5,1,-11,1,1,1};
    int [] b = {-10,-9,-8,-7,-6,-5,-3,-2,-1,0,1,2,3,4,5};
    Radix.radixsort(a);
    int [] c = {1};
    int [] d = {0,2,-1};
    int [] e = {0};
    int [] f = {};
    Radix.radixsort(b);
    Radix.radixsort(c);
    Radix.radixsort(d);
    Radix.radixsort(e);
    Radix.radixsort(f);
    print(a);
    print(b);
    print(c);
    print(d);
    print(e);
    print(f);
  }
  public static void print(int [] data){
    String returner = "{";
    for(int x: data){
      returner+=x+",";
    }
    System.out.println(returner+"}");
  }
}
