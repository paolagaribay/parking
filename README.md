# parking
COSC 4353: Assignment #3/4

usage:  cd src/main/java        javac main.java         java main.java textFile.txt

Your goal is to model a parking lot using object-oriented programming principles. This project is relatively open-ended; we will be grading based on your use of OOP principles. Assumptions:

  1. A parking lot has a capacity.
  2. A parking lot has entrance and exit gates.
  3. Cars receive a time-stamped ticket at entry.
  4. Cars present the ticket at exit gates, pay and then leave the parking lot.
  5. Cars cannot be admitted if there is no space in the parking lot.
  6. NEW: Each parking lots belongs to a group that sets the price, discounts, and policies in the group.
  7. Cars can inquire the latest price and availability of parking space.
  8. NEW: groups can send the latest prices to interested cars.
  9. NEW: Cars can be only at one place at a time, i.e., they cannot park in two different parking lots.
  10. NEW: Cars choose the lowest available parking lot for parking.
Requirement: NEW: Use the Maven build system to automated the build process.
Goal: The owners of parking lots want you to maximize their profits.
