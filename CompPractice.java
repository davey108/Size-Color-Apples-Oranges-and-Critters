import java.util.*;
/**
 * A class to test out different sorting methods for Apple and Orange
 *  
*/
class CompPractice {
  /** 
   * A main method to make a randomized list of Apple and Oranges
   * then use various compare methods to organize the list in certain fashion and print out the list after each ordering methods
   * <p>
   * Organize oranges list by {@link Fruit#compareTo(Fruit input) size} and {@link SizeRevComp#compare(Fruit f1, Fruit f2) reverse size}
   * <p>
   * Organize apples list by {@link Fruit#compareTo(Fruit input) size},{@link SizeRevComp#compare(Fruit f1, Fruit f2) reverse size},{@link ColorComp#compare(Apple o1, Apple o2) color}, and {@link ColorSizeComp#compare(Apple f1, Apple f2) color first then size}
   * @param args argument for main but this method does not depend on this
   * @see Fruit
   * @see ColorSizeComp
   * @see SizeRevComp
   * @see ColorComp
   * 
  */
 public static void main(String[] args) {
  //get some oranges
  List<Orange> oranges = CompPractice.makeOrangeList(5);
  System.out.println("Original List:\t\t" + oranges);
  
  //sort oranges by their "natural ordering" (their size, smallest to biggest)
  Collections.sort(oranges); //#1
  System.out.println("Sorted by Size Only:\t" + oranges);
  
  //sort oranges in reverse order by size
  Collections.sort(oranges, new SizeRevComp()); //#2
  System.out.println("Sorted in Reverse:\t" + oranges);
  
  System.out.println();
  
  //get some apples
  List<Apple> apples = CompPractice.makeAppleList(5);
  System.out.println("Original List:\t\t" + apples);
  
  //sort apples by their "natural ordering" (their size, smallest to biggest)
  Collections.sort(apples);//#1
  System.out.println("Sorted by Size Only:\t" + apples);
  
  //sort apples in reverse order by size
  Collections.sort(apples, new SizeRevComp()); //#2
  System.out.println("Sorted in Reverse:\t" + apples);
  
  //sort apples by their color (green -> yellow -> red)
  Collections.sort(apples, new ColorComp()); //#3
  System.out.println("Sorted by Color:\t" + apples);
  
  //sort apples by their color and size (green -> yellow -> red, by size within color group)
  Collections.sort(apples, new ColorSizeComp()); //#4
  System.out.println("Sorted Color/Size:\t" + apples);
 }
 /**
  * Make a list of oranges objects with certain size
  * @param size The size of the oranges list
  * @return The list of oranges objects with input size
  * @see Orange
 */
 public static List<Orange> makeOrangeList(int size) {
  List<Orange> o = new ArrayList<>(size);
  for(int i = 0; i < size; i++) {
   o.add(new Orange());
  }
  return o;
 }
 /**
  * Make a list of apples objects with certain size
  * @param size The size of the apple list
  * @return The list of apple objects with input size
  * @see Apple
 */
 public static List<Apple> makeAppleList(int size) {
  List<Apple> a = new ArrayList<>(size);
  for(int i = 0; i < size; i++) {
   a.add(new Apple());
  }
  return a;
 }
}