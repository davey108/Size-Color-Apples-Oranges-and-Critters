/**
 * Representation of a Wolf and dictate its Move Behaviors and how it is display on the interaction  
 * @see Critter
*/ 
public class Wolf extends Critter{
 // Move: North then East then North then West then North and NONE and repeat
 //protected Direction prevDir;
 // if numNorth = 0, then next move is East, if numNorth = 1, then next is West, if 3, then next is North, if 4, then next is North and reset to 0
 /**
  * Keep track of which North currently at to determine the next move (if at first north, then move East, if at second North then move West and if at third, then Wait a move) 
 */
 int trackNum = 0;
 /**
  * Track whether or not a wolf has started moving or not 
 */
 boolean start;
 /**
  * {@inheritDoc} 
 */
 @Override
 public char getChar() {
    return 'W';
  }
 /**
  * {@inheritDoc}
  * Move North then East then North then West then North and Stop Wait (NONE) and repeat this pattern
 */ 
 @Override
 public Direction getMove(CritterInfo info) {
   // if the Wolf hasn't start moving then start the move to North then
   // increase the trackNum to tell that we are at first North
   // set start to true so that the wolf is moving 
   if(currentDirection == Direction.NONE && start == false){
     currentDirection = Direction.NORTH;
     trackNum ++;
     start = true;
   }
   else{
     // see if we at first North
     if(trackNum == 1){
       // if previous Direction is at North then move East
       if(currentDirection == Direction.NORTH){
         currentDirection = Direction.EAST;
       }
       // if previous direction is East and we at first North
       // then move North and increase trackNum so we know we at 2nd North
       else{
         currentDirection = Direction.NORTH;
         trackNum ++;
       }
     }
     // see if we at second North
     // and same concept as first North
     else if(trackNum == 2){
       if(currentDirection == Direction.NORTH){
         currentDirection = Direction.WEST;
       }
       else{
         currentDirection = Direction.NORTH;
         trackNum ++;
       }
     }
     // see if we at third North
     // and same concept as other Norths
     else if(trackNum == 3){
       if(currentDirection == Direction.NORTH){
         currentDirection = Direction.NONE;
       }
       else{
         // If we reached the wait move, then reset and reloop the pattern (so move back to North with 
         // trackNum 1)
         currentDirection = Direction.NORTH;
         trackNum = 1;
       }       
     }
   }
  return currentDirection;
 }
}