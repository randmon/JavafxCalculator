# JavafxCalculator

A very simple calculator made with Java and JavaFX where I try to apply a couple design patterns seen in the course Object-oriented Design.

## Use

![screenshot of the app](/calc.png?raw=true "Title")

To use the calculator, select an input field. If the field is selected, it will become yellow.
Then use the white number buttons to write a number on the selected field.

To change the operation, click on a blue operation button (+, ., /, *)

To reset the selected number input, click the red backspace button.

Finally, clicking on the green equals button will execute the current operation.


## Design patterns

#### MVC
The project is split into Model, View and Controller packages.

#### Facade
The controller class interacts with the logic through a Facade class

#### Observer
The Controller is an observer of the Facade class, which is an observable

#### Strategy
The different operations (addition, subtraction, multiplication, division) are split into different classes which extend an Operation abstract class

#### Factory
There is an Operation Factory which returns an instance of the correct concrete operation, making use of an Enumeration, so that if we want to add a new operation, let's say, "Modulo", we don't need to alter any existing code besides adding one line to the Enumeration class.
