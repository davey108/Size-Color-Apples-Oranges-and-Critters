/**
 * Representation of a Mouse and dictate its Move Behaviors and how it is display on the interaction  
 * @see Critter
*/
public class Mouse extends Critter{
 /**
  * {@inheritDoc} 
 */
 @Override
 public char getChar() {
    return 'M';
  }
 /**
  * {@inheritDoc}
  * Moves west one step then north one step and repeats this west-north zig-zag pattern
  * @see Direction
 */
 @Override
 public Direction getMove(CritterInfo info) {
   // if the Mouse has not gotten a direction, then start at West
   if(currentDirection == Direction.NONE){
     currentDirection = Direction.WEST;
     
   }
   // if the previous move is West then current is Noth
   // and vice versa
   else{
     if(currentDirection == Direction.WEST){
       currentDirection = Direction.NORTH;
     }
     else if(currentDirection == Direction.NORTH){
       currentDirection = Direction.WEST;
     }
   }
  return currentDirection;
 }
}