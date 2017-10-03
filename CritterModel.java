/**
 *  Modified from version by Stuart Reges (1/26/00)
 *  
 *  Class CritterModel keeps track of the state of the critter simulation.
 */

import java.util.*;
import java.awt.*;

public class CritterModel {
   /**
    * Height of the simulation board
    */
    private int myHeight;
    /**
     * Width of the simulation board 
    */
    private int myWidth;
    /**
     * The Board of Critter objects or the animals in it 
    */
    private Critter[][] myGrid;
    /**
     * The Board of char display representation for each Animal 
    */
    private char[][] display;
    /**
     * Keep track of the critters' position on the board
    */
    private Map<Critter, Point>myList;
    /**
     * Keep track of the critter count of each Animals 
    */
    private SortedMap<String, Integer>critterCount;
    /**
     * Constructor to initialize the board, set the display on each location, total the number of each critters 
     * @param width the width of the board
     * @param height the height of the board
    */
    public CritterModel(int width, int height) {
        myWidth = width;
        myHeight = height;
        myGrid = new Critter[width][height];
        display = new char[width][height];
        updateDisplay();
        myList = new HashMap<Critter, Point>();
        critterCount = new TreeMap<String, Integer>();
    }
    /**
     * Add a number of critters to the board
     * @param number number of critters to add to board
     * @param critter the Class to read in the various Animal Classes name to pass into the map
     * @throws RuntimeException If the total number of add critters to the board + the size exceed the board's dimensions
     * @throws RuntimeException If there is no argument for the Class critter
     * @throws RuntimeException If Class critter is not an instance of Critter
     * 
    */
    public void add(int number, Class critter) {
        if (myList.size() + number > myWidth * myHeight)
            throw new RuntimeException("adding too many critters");
        for (int i = 0; i < number; i++) {
            Object instance;
            try {
                instance = critter.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("no zero-argument constructor for "
                                           + critter);
            }
            if (!(instance instanceof Critter)) {
                throw new RuntimeException(critter
                                           + " does not extend Critter");
            }
            Critter next = (Critter)instance;
            int x, y;
            do {
                x = randomInt(0, myWidth - 1);
                y = randomInt(0, myHeight - 1);
            } while (myGrid[x][y] != null);
            myGrid[x][y] = next;
            display[x][y] = next.getChar();
            myList.put(next, new Point(x, y));
        }
        String name = critter.getName();
        if (!critterCount.containsKey(name))
            critterCount.put(name, number);
        else
            critterCount.put(name, critterCount.get(name) + number);
    }
    /**
     * Give a random integer with max and min set
     * @param low The lowest integer the random can output
     * @param high The highest integer the random can output
     * @return a random number between the range of low and high
    */
    private static int randomInt(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }
    /**
     * Get the board's width
     * @return the board's width
    */
    public int getWidth() {
        return myWidth;
    }
    /**
     * Get the board's height
     * @return the board's height
    */
    public int getHeight() {
        return myHeight;
    }
    /**
     * Get the character at x and y location of the board
     * @param x the x-coordinate location of the char
     * @param y the y-coordinate location of the char
     * @return the char at the x and y location
    */
    public char getChar(int x, int y) {
        return display[x][y];
    }

    // We want to ask each critter once on each round how to display it.
    // This method does the asking, storing the result in display.
    /**
     * Ask each critter once each round on how to display it and store the result in display 
    */
    private void updateDisplay() {
        // set it to all dots
        for (int x = 0; x < myWidth; x++) 
            for (int y = 0; y < myHeight; y++)
                if (myGrid[x][y] == null)
                    display[x][y] = '.';
                else
                    display[x][y] = myGrid[x][y].getChar();
    }
    /**
     * Update the critters' direction for each move call 
    */
    public void update() {
        Critter[][] newGrid = new Critter[myWidth][myHeight];
        Object[] list = myList.keySet().toArray();
        Collections.shuffle(Arrays.asList(list));
        for (int i = 0; i < list.length; i++) {
            Critter next = (Critter) list[i];
            Point p = myList.get(next);
            Direction move = next.getMove(new Info(p.x, p.y));
            movePoint(p, move);
            if (newGrid[p.x][p.y] != null) {
                String c = newGrid[p.x][p.y].getClass().getName();
                critterCount.put(c, critterCount.get(c) - 1);
                myList.remove(newGrid[p.x][p.y]);
            }
            newGrid[p.x][p.y] = next;
        }
        myGrid = newGrid;
        updateDisplay();
    }
    /**
     * Get the number of critters count 
     * @return the critter counts from Collections
    */
    public Set<Map.Entry<String, Integer>> getCounts() {
        return Collections.unmodifiableSet(critterCount.entrySet());
    }
    
    // translates a point's coordinates 1 unit in a particular direction
    /**
     * Translate the coordinate into actual moving direction. So North is (0,+1), South is (0,-1), East is (+1,0), West is (-1,0)
     * @param p The point with certain x and y coordinate
     * @param direction The direction that the point should be heading to, changing either its x or y direction
     * 
    */
    private void movePoint(Point p, Direction direction) {
        if (direction == Direction.NORTH)
            p.y = (p.y + myHeight - 1) % myHeight;
        else if (direction == Direction.SOUTH)
            p.y = (p.y + 1) % myHeight;
        else if (direction == Direction.EAST)
            p.x = (p.x + 1) % myWidth;
        else if (direction == Direction.WEST)
            p.x = (p.x + myWidth - 1) % myWidth;
        else if (direction != Direction.NONE)
            throw new RuntimeException("Illegal direction");
    }

    // an object used to query a critter's state (position, neighbors)
    /**
     * Use to query a critter's state including its position and neighbors     
    */
    private class Info implements CritterInfo {
       /**
        * The x coordinate of the current critter 
       */
        private int x;
        /**
        * The y coordinate of the current critter 
        */
        private int y;
        
        /**
         * Constructor to set the info of the critter, including its x and y coordinate 
         * @param x the x-coordinate of the info critter
         * @param y the y-coordinate of the info critter
        */
        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
        /**
         * Get the current x position of the critter's info
         * @return the x coordinate of the critter
        */ 
        public int getX() {
            return x;
        }
        /**
         * Get the current y position of the critter's info
         * @return the y coordinate of the critter
        */
        public int getY() {
            return y;
        }
        /**
         * Get the current Critter neighbor of the infoed critter in the input direction
         * @param direction The direction to look for a neighbor of the infoed critter
         * @return The Critter neighbor of the infoed critter after looking in the above direction
        */
        public Critter getNeighbor(Direction direction) {
            Point other = new Point(x, y);
            movePoint(other, direction);
            return myGrid[other.x][other.y];
        }
        /**
         * Give the board's height
         * @return the board's height
        */
        public int getHeight() {
            return myHeight;
        }
        
        /**
         * Give the board's width
         * @return the board's width
        */
        public int getWidth() {
            return myWidth;
        }
    }
}
