import java.util.Comparator;
/**
 * A class that provide method to sort Apples first by Color then by Size if the same Color 
 * @see Apple
 * @see ColorComp
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html"> Comparator</a>
*/
class ColorSizeComp extends ColorComp implements Comparator<Apple>{
  /**
   * Compare the two input Apples objects first by Color then by size if they have same Color. Call to {@link ColorComp#compare(Apple o1, Apple o2) compare} to compare by Colors.
   * If same color then use this method second compare to sort by size
   * @param f1 First Apple object
   * @param f2 Second Apple object
   * @return a -1, or 1 if first apple object's color hierachy is higher, or lower than second apple object's color hierachy. 
   * If the two colors are same then return a -1, 0, or 1 if first apple object size is higher, equal, or lower than second apple object's size.
   * 
  */
  public int compare(Apple f1, Apple f2) {
    // call to ColorComp compare method to do comparison by color
    int output = super.compare(f1,f2);
    // if the 2 have same color, then compare them by size
    if(output == 0){
      return f1.getSize() == f2.getSize() ? 0 : f1.getSize() < f2.getSize() ? -1 : 1;
    }
    return output;
  }
}