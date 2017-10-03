/**
 * Representation of Orange
 * Inherit properties of Fruit
 * @see Fruit
*/
class Orange extends Fruit {
  /**
   * Constructor that calls to Fruit's constructor to set the size of the Orange
   * @see Fruit#Fruit()
  */
 public Orange() {
  super();
 }
 /**
  * Give a String representation of the Orange
  * @return a String representation of the Orange including its size
 */ 
 public String toString() {
  return "O["+size+"]";
 }
}