import java.util.Random;
/**
 * Representation of a Bird and dictate its Move Behaviors and how it is display on the interaction 
 * @see Critter
 */
public class Bird extends Critter{
 /**
  * {@inheritDoc}
  *   
 */
 @Override
 public char getChar() {
    return 'B';
  }
 /**
  * {@inheritDoc}
  * Randomly selects one of the four directions (north, south, east, or west) each time.
  * @see Direction
 */
 @Override
 public Direction getMove(CritterInfo info) {
   // calling random to get a random direction from the enum of direction
   // excluding the last value of the enum (because we don't want NONE)
   currentDirection = Direction.values()[new Random().nextInt(Direction.values().length-1)];
   return currentDirection;
 }
}