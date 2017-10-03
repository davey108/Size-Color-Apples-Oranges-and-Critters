/**
 * Representation of Apple type
 * Inherit properties of Fruit and also its own Color attribute
 * @see Fruit
 * 
 */
class Apple extends Fruit {
  /**
   * An Enumeration that dictates the color that an Apple can have
   * 
   */
 public enum Color {
   /**
    * Green Color Apple
    * <p>
    * In color comparison, Green is the lowest hierachy
    * @see ColorComp#compare(Apple o1, Apple o2)
    */
  GREEN, 
    
  /**
   * Yellow Color Apple
   * <p>
   * In color comparison hierachy, Yellow is higher than Green and lower than Red
   * @see ColorComp#compare(Apple o1, Apple o2)
  */ 
  YELLOW, 
   
  /**
   * Red Color Apple 
   * <p>
   * In color comparison hierachy, Red is the highest
   * @see ColorComp#compare(Apple o1, Apple o2)
  */
  RED;
  /**
   * A method to set the Apple's Color to one of the three Colors
   * @return The Color of the Apple from the list of Color enum
   * @see Color
  */
  public static Color getRandomColor() {
   return values()[(int) (Math.random() * values().length)];
  }
 }
 /**
  * The color of the apple
 */ 
 protected Color color;
 
 /**
  * Constructor that calls to Fruit to set size and set the Color of the Apple
  * @see Fruit#Fruit()
 */
 public Apple() {
  super();
  this.color = Color.getRandomColor();
 }
 
 /**
  * Get the color of the Apple
  * @return The color of the Apple
 */ 
 public Color getColor() {
  return color;
 }
 /**
  * Change Color of the Apple into corresponding integer number
  * @return The Corresponding integer number for each Color: Green is -1, Yellow is 0, Red is 1
  * @see Color
 */
 public int getColorIndex(){
   return color == Color.GREEN ? -1 : color == Color.YELLOW ? 0 : 1;
 }
 
 /**
  * Give the String representation of the Apple including its Color and Size 
  * @return The String representation of the Apple
 */
 public String toString() {
  return "A["+(color.toString().charAt(0))+"|"+size+"]";
 }
}