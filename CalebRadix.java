public class CalebRadix{
  public static void main(String [] args){
    int [] a = {1,1,1,1,1,2,1,1,1,1};
    Radix.radixsort(a);
    print(a);
  }
  public static void print(int [] data){
    String returner = "{";
    for(int x: data){
      returner+=x+",";
    }
    System.out.println(returner+"}");
  }
}
