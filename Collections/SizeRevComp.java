import java.util.Comparator;
/**
 * A class that provide method to sort the Fruits by reverse size
 * @see Fruit
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html"> Comparator</a>
 * 
*/
class SizeRevComp implements Comparator<Fruit> {
  /**
   * Compare the sizes of the two Fruit objects and return appropriate integer value. Note that this is the reverse functionality of the Comparator's compare(T o1, T o2) method
   * @param f1 First Fruit object
   * @param f2 Second Fruit object
   * @return a positive, 0, or negative integer if second Fruit object's size is more than, equal to, or less than first fruit objec's size respectively
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare(T,%20T)"> compare</a>
   * 
  */
 public int compare(Fruit f1, Fruit f2) {
  return f2.getSize()-f1.getSize();
 }
}