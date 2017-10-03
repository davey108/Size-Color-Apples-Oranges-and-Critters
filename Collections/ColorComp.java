import java.util.Comparator;
/**
 * A class that provide method to sort Apples by Color
 * @see Apple
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html"> Comparator</a>
*/

class ColorComp implements Comparator<Apple>{
  static int d;
  /**
   * Compare the Color of the two input Apple objects and return the appropriate integer value. Color hierachy goes by(least to highest): Green then Yellow then Red
   * @param o1 First Apple object
   * @param o2 Second Apple object
   * @return a -1, 0, or 1 if first apple object's color hierachy is higher than, equal to, or less than second object's color hierachy respectively  
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare(T,%20T)"> compare</a>
  */
 public int compare(Apple o1, Apple o2){
   // compare the color integer value correspondence. If equal, return 0, if o1 is more than o2 then return 1 else -1
   return o1.getColorIndex() == o2.getColorIndex() ? 0 : o1.getColorIndex() > o2.getColorIndex() ? 1 : -1;
 }
}