# VW Cleaning Robots Technical Challenge

Francisco Jesús Moya Guillem

This project was carried out as a Technical Test in order to access to a position within the organization.

The project has been developed under the following requirements:


- Data structure defined as input must be completely respected.


- Example:\
  5 5\
  1 2 N\
  LMLMLMLMM\
  3 3 E\
  MMRMMRMRRM


- First line defines the Grid size, separating the data with spaces; the first value corresponds to the rows and the second to the columns.


- Second line is defining the robot's initial position on the grid, separating the data with spaces; the first value defines the row, the second the column, and the third the cardinal orientation in the cell.


- Third line defines the set of operations the robot will perform.


- The remaining lines from this point on will be defining new robots.


- Robots must operate sequentially (when there is more than one in the scene, the next one will not start its tasks until the previous one has finished, and so on).


- The robot must store its position in space considering the designated cleaning area:
    - X
    - Y
    - Direction: N S E W


- Robot's performing set of operations will be stored internally to be executed sequentially. For instance valid operations could be:
    + L: Rotates 90 degrees to the left.
    + R: Rotates 90 degrees to the right.
    + M: Moves forward to the next grid cell in front.


- All robots will report their final position upon completing their task.

Assumptions made in order to develop the test:

- The input data will be entered into the "Inputs.txt" file.


- The robot must check that it will not go outside the grid, and it will be kept on the preestablished boundaries and limits.


- The robot cannot move backwards; it must rotate on its own axis.


- If the instruction set leads the robot to move outside the grid in the next step, it must stop immediately and not continue its task.


- Robots are equipped with an autonomous navigation technology in order to avoid obstacles. Therefore, if other robots are on the grid the robot needs to access, it will not be affected and will continue its path.


- A prior check of the entered commands is performed. If any value is not defined in the instruction set, the robot will not move and will display an error message.


- A prior check of the robot's coordinates and orientation is performed. If any value is not defined in the instruction set, the robot will not move and will display an error message.


- The grid must have at least one cell in size. Otherwise, an error message will be displayed when orders are introduced.


- Since the environment is still in testing and the robots are not yet perfected; also, assuming the operator does not yet have an interface to prevent data entry errors, it is compulsory guarantee environment and people's safety. Therefore, a robust error control has been implemented, displaying error messages whenever the entered data is invalid, preventing a robot from being instantiated and executing its actions if the commands are not from the recognized set or if the test area and robot coordinates have missing data.

Project's implementation: Technologies used

- IntelliJ IDEA as IDE.

- Kotlin as programming language.

- JUnit5 for unit testing.

The project has been developed using a hexagonal architecture and Domain Driven Design patterns, encapsulating business logic within domains and keeping all auxiliary data structures as close to the domain as possible.

An orchestrator called Driver has been created, which is responsible for instantiating all domain classes and handles the application logic.

Since the project is in the experimental phase, and it is assumed that there are no interfaces, an "Inputs.txt" file has been created to enter the variables that will serve as input for the cleaning program.

In this project, objects cannot be instantiated using their default constructors. It is necessary to use the various setters and getters to interact. This decision has been given the fact that the environment is still experimental and user safety must be prioritized. Therefore, strong error handling and validations have been implemented to ensure all inputs have the correct format.

Function reuse has been maximized to avoid unnecessary and hard-to-maintain code.

Since the project is in the testing phase and users don't yet have the tools to use it, the project organization has been built to make it as easy as possible for other users or programmers to use it. There are no checks, data conversions, scenarios, or robots to implement. Simply call the startCleaningProgram() function and fill out "Inputs.txt." The system works if the entered data is correct. If not, any errors in the data entered are displayed in the console for correction. This provides an easy-to-use testing environment.

It is worth mentioning that despite my knowledge of Java, I chose to use Kotlin for the first time to take on a greater challenge and demonstrate my adaptability to any type of language. I invested a total of 2 hours reading documentation and watching online courses to learn how it works.

This project has taken a total of 9 hours and 45 minutes in order to be completed. Time has been invested in the following phases:
- 30 minutes for gathering requirements and assumptions
- 2 hours for Kotlin's adaptation
- 6 hours at programming
- 30 minutes for testing
- 45 minutes for develop final documentations

No AI was used in the implementation of this project.