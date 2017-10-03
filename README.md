# Apples & Oranges Collections and Critters Map
This project has two parts: 
1. First part is a sorting collections of juicy apples and oranges with different sizes and colors.
2. A critters map representation much like how the natural environment animals mapped on a pixel map.

# Apples & Oranges Collections:
This part of the project is basically sort either a list of oranges with different sizes in order OR sort list of apples with different sizes AND colors in order. Few of the classes here are:
### Files Descriptions:
- *Fruit.java* - The parent of all the fruits! This class role is to determine the sizes of each fruit and also have a compareTo method to compare the fruit by sizes.
- *Apple.java* - Child of *Fruit.java* - It has an extra attribute of colors. 
- *Orange.java* - Child of *Fruit.java* - It is just a tasty orange class.
- *SizeRevComp.java* - A class that contains a method to sort the collections by reverse size, in other words, smallest size is at the end of the list. 
- *ColorComp.java* - A class that contains a method to sort the collections of apples by color. Each color has its own priority list. 
- *ColorSizeComp.java* - A class that contains a method to sort the collections of apples by both color and size. 
- *CompPractice.java* - A couple of example collections to test out each sorting methods.
### How to Run Apples & Oranges Colelctions:
1. Download all the files in *Collections* folder
2. Compile and run *ColorComp.java* to see results of sorted collections

# Critters Map
This part of the project is a representation of critters map. In other word, a representation of animals in the wild fighting and crossing each others in the environment and fighting for food resources. Some animals will dissapear and some will survive!

### Files Descriptions:
- *Critter.java* - Parent of all critters. It store what is the current direction of the critter and its representation
- *Bird.java* - Child of *Critter.java*. It has its own move pattern to move and representation on the critter map.
- *Frog.java* - Child of *Critter.java*. It has its own move pattern to move and representation on the critter map.
- *Mouse.java* - Child of *Critter.java*. It has its own move pattern to move and representation on the critter map.
- *Turtle.java* - Child of *Critter.java*. It has its own move pattern to move and representation on the critter map.
- *Wolf.java* - Child of *Critter.java*. It has its own move pattern to move and representation on the critter map.
- *Direction.java* - A fixed enumeration that has 4 fixed cardinal directions: North, South, East, West.
- *CritterFrame.java* - The framework for the critter map.
- *CritterMain.java* - The main class that will run the critter simulation.
- *CritterPanel.java* - This displays the critter type and numbers on the side of the critter map.
- *CritterModel.java* - This class keep track of the current state of the simulation
- *CritterInfo.java* - This provides the current state of the critters

### How to Run Critters Map:
1. Download all the files in *Critter-Game*
2. Edit the number of animal by changing the "1" in *CritterMain.java* to your liking number per that critter type.
3. Compile and run the Critter simulation. Click *Play* to see the simulation unfolds!
