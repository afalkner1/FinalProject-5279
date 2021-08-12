# FinalProject-5279
For this project I have created an Employee Managment System in Java with Gradle. 

## Architecture
Please refer to the UML Diagram below for a clearer overveiw of the program architecture. 

There is a class Event.java which uses the Calendar library. In this class there are two attributes, start_time and end_time. These are Calendar objects to represent the start and end time of this event. There are methods to set the date and time for start_time and end_time. Additionally, there is a method to determine if two Event objects overlap in time. 

The Task.java class extends the Event.java class. The Task class had three additional attributes, Employee, Head and a String info. These represent the Employee assigned to the task, the departmend Head who assigned the task, and the task description. All features from the Event class carry over whereby you can set a start and end date for this task. 

The Meeting.java class also extends the Event.java class. The Meeting class has an additional attributes of an meeting_id and a list of attendees. 

You have two types of employees, regular employees (Employees.java) and department Heads (Head.java). There can only be one head per department. 

I have an interface Worker.java, which Employee.java implements. In the Employee class there are methods to set different fields such as deparment, and Employee_ID. There are methods to request leave and create a meeting. There are also lists of all Tasks, a leave calendar, and a HashMap of meetings. 

The Head.java class extends the Employee class. There are additional attributes of a leave calendar that includes dates for all employees in their department, and a HashMap of all employees in the department. Additonal methods are creating a task for an employee, deciding to accept an employees leavee request, and adding and removing employees from their HashMap. 

The Database.java class acts as the database that holds all information and performs clean operations on the database Employees and Heads. The Database holds a HashMap of all employees, and methods for adding/removing Employeees and Heads, creating tasks and meetings, handling leave requests, and promoting Employees to department Heads. 

The present.java class is simple class used for a quick demo during project presentation. 

## UML Diagram
![data](/images/UML_diagram.png)

## Program Features 
* Add/Remove Employees, and department heads

* Promote Employees

* Request Leave

* Create Meetings 

* Create Tasks

Other features include that two meetings cannot overlap in time with any other meetings for the attendees, and an employee will not be granted leave if someone else in the department is on leave at the same time. 

## Concepts from Class

I have used an Object-Oriented Design, with Class Objects, Abstraction, Inheritance, Polymorphism, Encapsulation. 

### Design Principles

* DRY 

* Singleton (Creational)

* Mediator (Behavioral) 

* Java Streams

* Composite design pattern 

## Tests 

I created a test file for each class that tests all functionality of that class. Test files are located in management/lib/src/test/java. You can run all tests using Github Actionsor by running the Autograder.java file on your local machine. 
