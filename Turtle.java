/**
 * Representation of a Turtle and dictate its Move Behaviors and how it is display on the interaction  
 * @see Critter 
*/
public class Turtle extends Critter{
  /**
   * Keep track of the number of move in the same direction before changing direction 
   * 
  */
 protected int numMove = 1;
 /**
  * Tracking previous move direction to know what will next move direction be 
 */
 protected Direction prevDir;
 /**
  * {@inheritDoc} 
 */
 @Override
 public char getChar() {
    return 'T';
  }
 /**
  * {@inheritDoc}
  * Walks south five steps, then west five steps, the north five steps, then east five steps and
  * repeats. This forms a clockwise box pattern.
  * @see Direction
 */
 @Override
 public Direction getMove(CritterInfo info) {
   // if there is no previous Direction then start off with South
   // and increase the numMove
   if(prevDir == null){
     currentDirection = Direction.SOUTH;
     prevDir = currentDirection;
     numMove++;
   }
   // if numMove is resetted to 1, that means the Turtle did 5 
   // steps in a previous direction already, so check what prevDir is
   // and choose a next appropriate direction
   // then set prevDir to the current Direction for recording purpose 
   // and increase numMove
   else if(numMove == 1){
     if(prevDir == Direction.SOUTH){
       currentDirection = Direction.WEST;
     }
     else if(prevDir == Direction.NORTH){
       currentDirection = Direction.EAST;
     }
     else if(prevDir == Direction.WEST){
       currentDirection = Direction.NORTH;
     }
     else if(prevDir == Direction.EAST){
       currentDirection = Direction.SOUTH;
     }
     prevDir = currentDirection;
     numMove ++;
   }
   // if we are still in the less than 5 steps, keep 
   // moving in the direction and increase numMove
   // if at 5, reset but still move in same direction (because 5th is still suppose to be in same direction)
   else{
     if(numMove < 5){
       numMove ++;
     }
     else if(numMove == 5){
       numMove = 1;
     }
   }
  return currentDirection;
 }
}