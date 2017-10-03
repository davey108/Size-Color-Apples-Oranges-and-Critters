import java.util.Random;
/**
 * Representation of a Frog and dictate its Move Behaviors and how it is display on the interaction 
 * @see Critter
*/
public class Frog extends Critter{
  /**
   * Keep track of the number of move a Frog already made in that direction
   * Frog changes direction after 3 moves in the same previous direction
   * @see Frog#getMove(CritterInfo info)
  */
 protected int numMove = 1;
 /**
  * {@inheritDoc} 
 */
 @Override
 public char getChar() {
    return 'F';
  }
 /**
  * {@inheritDoc}
  * Picks a random direction, then moves three times in that direction before choosing a new
  * random direction.
  * @see Direction
 */
 @Override
 public Direction getMove(CritterInfo info) {
   // pick a new direction if we are starting or if the frog already did 3 steps
   // in the same direction previously
   if(currentDirection == Direction.NONE || numMove == 1){
     currentDirection = Direction.values()[new Random().nextInt(Direction.values().length -1)];     
     numMove ++;     
   }
   else{
     // if the 3 moves have not been reached yet, then increase the count
     // and return same direction
     if(numMove < 3){
       numMove++;       
     }
     // if the 3 moves reached, then just reset but return same direction
     // because the current move is still 3rd
     else if(numMove == 3){
       numMove = 1;
     }     
   }
   return currentDirection;
 }
}