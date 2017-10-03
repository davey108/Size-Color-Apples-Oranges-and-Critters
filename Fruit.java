/**
* Parent of Apple and Orange classes
* Hold various data such as Fruit's size
* @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html"> Comparable</a>
*/
class Fruit implements Comparable<Fruit> {
 /**
 * The size of the Fruit
 */
 protected int size;
 
 /**
 * Constructor that initialize the {@link Fruit#size size} to a random value
 */
 public Fruit() {
  this.size = (int) (Math.random() * 10)+1;
 }
 /** 
 * Get the size of the fruit
 * @return The {@link Fruit#size size} of the fruit
 */
 public int getSize() {
  return size;
 }
 /**
 * Method to compare the {@link Fruit#size size} of two fruits
 * @param input Another Fruit type item to compare to
 * @return a -1, 0 , or 1 as this Fruit is less than, equal to, or greater than the specified input Fruit.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html#compareTo(T)"> compareTo</a>
 */
 public int compareTo(Fruit input){
   // check between this fruit size and input fruit size
   // if equal return 0, if less than return -1 if more return 1
   return this.size == input.size ? 0 : this.size < input.size ? -1 : 1;
 }
 
 /**
 * Give to string representation of the fruit including its size
 * @return The string representation of the Fruit with {@link Fruit#size size}
 */
 public String toString() {
  return "F[s="+size+"]";
 }
}