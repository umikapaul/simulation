# Simulation Design Final
### Names

Umika Paul, Fernanda Corona, Yasser Elmzoudi

## Team Roles and Responsibilities

 All: Each member helped and worked with other members to implement their portions of the project. Each part of the project involved contributions from all members.

* Team Member #1 (Umika Paul): Responsible for the backend of the project. She made the abstract classes, enum, and concrete classes for the Cell and Grid to allow for proper functioning of the six simulations. She was also responsible for implementing the different edge and neighborhood policies. She wrote all the tests for these classes.

* Team Member #2 (Fernanda Corona): Responsible for the frontend of the project. She was responsible for the classes including the GamePane, ScreenVisuals, and ButtonPanel, as well as the different shapes. She worked to make the simulation more user interactive by implementing colors, styles, and languages. She wrote the tests for these classes.

* Team Member #3 (Yasser Elmzoudi): Responsible for Controller, configuration, and exceptions. He wrote the classes encapsulating the exceptions and ErrorPanel, and was responsible for proper functioning of the graph. He also separated the controller from the view and helped structure the code.

## Design goals

#### What Features are Easy to Add

New simulations

- Adding a new simulation simply entails adding another subclass of <code>Cell</code> and <code>Grid</code> 
- Cell would contain an overridden method <code>update</code> that contains the rules for updating cells in each cycle

New shapes

- Our <code>GamePanel</code> allows for the addition of new shapes, simply by adding another subclass with the new shape that needs to be added
- Unless a shape already exists within the <code>javafx.scene.shape.Shape</code> library, a new class should be made in the Shapes package. The points corresponding to the shape should then be chosen within the class that was created. The constructor for this class should, at the very minimum, take in row and column parameters to have the shape’s points be dependent on these values. 

New Buttons / Displays on the grid

- Adding a new button can be done easily by adding the button to the <code>ButtonPanel</code> class. To have control over the button’s styles, the button name should be added as a key to the <code>ObjectId.properties</code> file found in the StyleResources package. The string value of this key should then be added to the <code>UserButtonStyles.css</code> file by adding a hashtag before the string value and then placing curly brackets containing the button’s styles after the value. An example of this can be seen below. 



## High-level Design

#### Core Classes

<img src="doc/DesignDiagram.JPG" width="1000" height="400"/>

Data files needed: 

All the data csv files are located in the data folder. The properties files are located in the resources directory in src, and the properties files for the languages are located in the languageresources directory. The css files are located in the styleresources directory.

Note: For the tests, some of the files needed to run the tests are in the <code>Test Sources</code> folder. This folder needs to be set as the Test Resources root.

Features implemented:

- There are six different simulations included - Game of Life, Percolation, Segregation, Rock Paper Scissors, Predatory Prey, and Spreading of Fire.

#### Game of Life

<img src="doc/GameOfLife.gif" width="500" height="500"/>

#### Spreading of Fire

<img src="doc/SpreadingOfFire.gif" width="500" height="500"/>

#### Percolation

<img src="doc/Percolation.gif" width="500" height="500"/>

#### Predator Prey

<img src="doc/PredatorPrey.gif" width="500" height="500"/>

#### Rock, Paper, Scissors

<img src="doc/RockPaperScissors.gif" width="500" height="500"/>

#### Segregation

<img src="doc/Segregation.gif" width="500" height="500"/>

- Different edge policies: These include Finite, Klein Bottle, and Torodial.

#### Klein Bottle

Notice how the enclosed block on the bottom right and top left side of the screen are full because the grid connects on both sides after twisting one of the sides. Site: https://en.wikipedia.org/wiki/Klein_bottle.

<img src="doc/KleinBottle.gif" width="500" height="500"/>

#### Torodial

Notice how the enclosed block on the right and left side of the screen are full because the grid connects on both sides.

<img src="doc/Torodial.gif" width="500" height="500"/>

- Different neighborhood policies: These include Complete, Diagonal, and Cardinal.

#### Diagonal

Only the northeast, southeast, northwest, and southwest neighbors count. The cells blocked above and below remain blocked.

<img src="doc/Diagonal.gif" width="500" height="500"/>

#### Cardinal

Only the north, east, south, and west count as neighbors. The cells that are blocked diagonally remain blocked.

<img src="doc/Cardinal.gif" width="500" height="500"/>

- **Three languages: English, Spanish, and French.**

Below is the panel you can choose a language and shape from.

<img src="doc/LanguageShape.gif" width="400" height="300"/>

- **Simulation graph: Represents the number of each type of state in the simulation across time.**

<img src="doc/Graph.gif" width="500" height="500"/>

- **Ability to load new files, pause, reset, change speed, and step through simulation.**

As shown in the above gifs, the user can press the buttons in order to change the simulation. To increase the speed, drag the slider to the right.

- **Different shapes in grid: Triangle, Hexagon, and Rectangle.**

#### Triangle

<img src="doc/Spanish.gif" width="500" height="500"/>

#### Hexagon

<img src="doc/Hexagon.gif" width="500" height="500"/>

**- Style of Cells: Both images and different colors can be loaded onto the cells.**

<img src="doc/TreeImage.gif" width="500" height="500"/><img src="doc/FishImage.gif" width="500" height="500"/>

**- Different Themes: A few different colors / themes can be loaded upon startup into the simulation.**

Different themes can be chosen. Look at the Duke and UNC below!

<img src="doc/Duke.gif" width="500" height="500"/><img src="doc/UNC.gif" width="500" height="500"/>

**- Exception handling.**

An error box opens up upon a user entering an invalid simulation or any other error.


## Assumptions that Affect the Design

#### Features Affected by Assumptions
- With the use of reflection in our project, an assumption that we were required to make involved the names of certain keys in our property files. These included the type of randomization that the simulation was subjected to, as well as the neighborhood and edge policy that the simulation implemented

- We also made the assumption that only certain files could be loaded in to process the initial configurations of the simulations. While we restricted the types of these files to java property files, ultimately, any property file could be loaded by the user. Of course, we implemented and put in place the correct error-handeling necessary to throw an error to users without ending their simulation, however this assumption could have been avoided by placing all of the simulation java property files necessary to load simulations into their own package and simply restricting user access only to that package when a file is loaded.

## Significant differences from Original Plan
The original plan we discussed is outlined below:

## Design Overview
* The `Cell` class should store the current state of each cell and contains the corresponding relationships between different cell states.
* The `Grid` class will be responsible for creating a 2D grid of rectangular cells.
* The `GridReader` class will read the grid’s dimensions and the initial cell states of the grid from a CSV formatted file.
* The `Visualization` class will be responsible for showing.the simulation based on the current cell states of the grid.
* The `UserInterface` class will allow the user to pause, step through, resume, or save a current simulation. The user will also have the option to load or choose a different simulation file.
* We also intend to create an abstract class that can be extended to create different types of simulations.
* We also hope to implement Enum to be able to choose between different simulation files quickly.

- Commonalities between models:
    - Dynamic cells that change based upon certain conditions
    - Element of replication (creating same Objects multiple times and populating respective cells accordingly)
    - Characteristics of cells depend on neighboring cells and the Objects therein
    - Potential method to determine if Update is necessary for current cell and for neighboring cells
    - initialize method could creat Grid and populate all of the cells accordingly
    - Elements in a potential configuration file:
        - Size of Grid
        - Type of simulation 
        
- Potential Classes:
    - `Cell` abstract class
    - `Grid` class
    - Enum to generate different types of Cells
    - `GridReader` class
    - `GridWriter` class
    - `NeighboringCells` interface
    - `Display` class
    - `Controller` class
   
This class's purpose or value is to define the different possible types of cells:
```java
public abstract class Cell implements NeighboringCells {
    public void update();
    public String getState();
    public void setState(String state);
    public void createCell(Enum cellType);
    public int countOfNeighboringStates(List<Cells> neighboringCells, String state);
    public String getNextState();
}
```

This interface contains the necessary methods for retrieving and updating neighboring cells:
```java
public interface NeighboringCells {
    public List<Cell> getNeighbors();
    public void updateNeighbors();
}
```

This class's purpose or value is to define and populate the layout of Cells:
```java
public class Grid {
    public void setUp(String fileName);
    public List<Cell> getCells();
    public void updateDisplay();
    public void changeSimulation(String simulation); //Updates the simulation applied to all cells (changing their type) by reading new simulation states from file
    public String getSimulation();
    public void updateSimulation(String newSimulation) //called within changeSimulation
}
```

This class's purpose or value is to read in the layout of the Grid:
```java
public class GridReader {
    public void readGrid(String fileName);
}
```

This class's purpose or value is to write the final state of a Grid to a file:
```java
public class GridWriter {
    public void writeGrid(String fileName);
}
```

This class's purpose or value is to Display the Model to users:
```java
public class Display {
    public Scene makeScene(int width, int height);
    public void updateDisplay(Scene model);
}
```

This class's purpose or value is to interact between the Model and the Display:
```java
public class Controller {
    public void showModel(Grid cells);
    public void showError (String message);
}
```

This Enum's purpose is to represent the different types of Cells:
```java
public enum cellType {
    public Cell createCell(int row, int column);
}
```
## Design Details

* The `SimulationVisualizer` class collaborates with the Cell class to be able to determine whether a Cell should be displayed as ‘Alive’ or ‘Dead’. It then changes the cell color based on the state of the cell and its neighboring cells.
* `Grid` initializes a grid based on the data file. It converts the data file into a 2D grid, obtains the neighboring cells, and updates them with rules of the game.
* Abstract class to handle different kinds of simulations, with each subclass containing the rules for a single simulation.
* `GridReader` reads all the lines from a given file.
* `Cell` encapsulates the logic for returning whether the cell is alive or dead, and updates them according to the rules.

* Use Cases:
    * Apply the rules to a cell: set the next state of a cell to dead by counting its number of neighbors using the Game of Life rules for a cell in the middle (i.e., with all of its neighbors)
    ```java
    for (Cell currentCell: grid.getCells()) {
      if (currentCell.getState().equals("alive")) {
        int count = countOfNeighboringStates(currentCell.getNeighbors, "alive")
        if (count < UNDERPOPULATION) {
          currentCell.setState("dead");
            }
        else if (count == 2 || count == 3) {
          currentCell.setState("alive");
        }
        else if (count > OVERPOPULATION) {
          currentCell.setState("dead");
        }
        else if (count == 3) {
          currentCell.setState("alive")
        }
      }
    } 
  ```
    
    * Move to the next generation: update all cells in a simulation from their current state to their next state
    ```java
    for (Cell currentCell: grid.getCells()) {
        currentCell.setState(currentCell.getNextState())
    }
    ```
    
    * Switch simulations: load a new simulation from a data file, replacing the current running simulation with the newly loaded one
    ```java
    FileWriter previousModel = new FileWriter();
    previousModel.writeFile(grid.getSimulation());
    grid.changeSimulation(newSimulation); //reads from File as well
    ```



## Design Considerations

* At this point, we are unsure as to what methods would be common to all simulations. Hence, it was difficult to construct many abstract classes or inheritance hierarchies at this point.
    * Potential abstract `Cell` and `Grid` classes whose subclasses would be constructed based off an `enum`
* Understanding the functionality of `Controller` and how it communicates between `Model` and `View`
    * Ensure that these packages adhere to the Single Responsibility Principle and only contain the information necessary for the completion of their appropriate functions
## User Interface

Diagram of Planned User Interface:

![This is cool, too bad you can't see it](Simulation_Design.jpg "An initial UI")

* Model
    * Display of the current simulation
* Select Simulation Button
    * Gives users the option to select a new simulation configuration file and display it in Model
* Run Button
    * Runs the simulation at the selected speed
* Pause Button
    * Pauses the simulation
* Step Button
    * Steps through one iteration of the simulation
* Save Button
    * Saves the current state of the model
* Speed Slider
    * Adjusts the speed of the simulation
* Size Slider
    * Adjusts the size of the cells (the smaller the cells, the larger the grid)

The discrepancies evident between our original plan and our excuted program– while minimal– include our inability to include a `NeighboringCells` interface, as well as including a slider for users to adjust the size of the cells during the simulation. We chose not to implement a `NeighboringCells` interface in our `Cell` class as we believed that this interface would be extremely large as it would contain all of the methods that would pertain to how neighboring cells would act. We strongly believed that this would ultimately serve only to violate the Interface Segregation Principle as the interface would be much too general. Rather, we decided to incorporate the differing functionalities of neighboring cells in our abstract `Cell` class. This proved to be more beneficial especially considering that a cell and its neighboring cells are closely related to the type of `Cell` that they are, allowing us to be confident that an abstraction would be best in this case.
 
## New Features HowTo

#### Easy to Add Features

Unless a shape already exists within the <code>javafx.scene.shape.Shape</code> library, a new class should be made in the Shapes package. The points corresponding to the shape should then be chosen within the class that was created. The constructor for this class should, at the very minimum, take in row and column parameters to have the shape’s points be dependent on these values. 

To add new Grid Shapes, the abstract class <code>GamePane</code> must be extended and an instance variable to hold a new 2D Shape Array should be created. In the example below,  this instance variable is called </code>allShapes</code>. The abstract method <code>makeArray</code> should be copied and altered according to the new shape that will be displayed in the grid. Within the <code>makeArray</code> method, every shape should be added to the instance variable described above. The method <code>getInitialArray</code> should also be overridden and should return the instance variable of the 2D Shape Array to which the shapes were added. As an example, the <code>HexagonGamePane</code> class is provided below. 

```java
package view.GamePaneShapes;
import javafx.scene.shape.Shape;
import model.grid.Grid;
import view.Shapes.Hexagon;

/**
 * Class that makes the hexagon game pane.
 */

public class HexagonGamePane extends GamePane {

  private static final double HEIGHT_FACTOR = 1.60;
  private static final double WIDTH_FACTOR = 1.3;
  private Shape[][] allShapes;

  /**
   * Constructor for this class.
   *
   * @param grid   Hexagon grid.
   * @param width  Width of grid.
   * @param height Height of grid.
   */
  public HexagonGamePane(Grid grid, int width, int height) {
    super(grid, width, height);
  }

  /**
   * Makes the array of hexagons.
   *
   * @param myGrid The given grid.
   */
  @Override
  public void makeArray(Grid myGrid) {
    allShapes = new Hexagon[myGrid.gridRows()][myGrid.gridColumns()];
    for (int r = 0; r < myGrid.gridRows(); r++) {
      for (int c = 0; c < myGrid.gridColumns(); c++) {
        Hexagon mynewPixel = new Hexagon(r, c, polyWidth(), polyHeight());
        allShapes[r][c] = mynewPixel;
      }
    }
  }

  @Override
  public Shape[][] getInitialArray() {
    return allShapes;
  }

  private double polyHeight() {
    return cellHeight() / HEIGHT_FACTOR;
  }

  private double polyWidth() {
    return cellWidth() / WIDTH_FACTOR;
  }

}

```

To add an additional <code>Grid</code> Shape that the user can choose from, a <code>GamePane</code> with that shape should be added to the package <code>GamePane</code> Shapes found in the View package. This class should be named <code><English Translation Of Shape>GamePane</code> to allow our use of reflection to work correctly. Once the file is made, the shape should be added to each language file by having the key be the english translation of the shape and having the value be the corresponding language’s translation of the shape. The translated version of the shape should also be added to the existing key <code>Shape</code> to have the option available as a drop down item.

In order to add an additional language, a corresponding <code>.properties</code> file in lowercase must be made in the LanguageResources package. Once the file is made, all the keys found in the <code>english.properties</code> must be copied and have their values changed accordingly. Finally, the language should be added to the <code>InitialOptions.properties</code> found in the StyleResources package. An example of the <code>spanish.properties</code> file can be seen below.

<img src="doc/LanguagePropertiesEx.png" width="1200" height="250"/>

To add additional Styles, a new <code>.css</code> file must be created and placed in the <code>StyleResources</code>package. The appropriate translation for each language found in the Language Resources package should also be added by adding a key with the english translation of the style and having the value of this key be the corresponding language’s translation. The translated version of the new style should be added to the Language's Translation of <code>Style</code> key to have the new option displayed as an item in the drop down menu. In the example above the this key is named <code>Modo</code>. The <code>ColorStyles.properties</code> file should then reflect the new additions by having the English translation of the word as the key and having the corresponding <code>.css</code> file name be the value. 

#### Other Features not yet Done

To add more edge policies or neighborhood policies it is possible to create a new <code>getNeighbors</code> interface that can have classes with information about how to get the neighbors. We implemented different edge policies and neighborhood policies for the rectangle shape but to do so in the same capacity for the hexagon and the triangle it would be easier to make use of an interface, if we were given more time. 



