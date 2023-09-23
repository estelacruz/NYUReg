# NYUReg: Course Registration System  &nbsp; <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">


# Functionality 
<img width="659" alt="Screen Shot 2023-09-23 at 3 03 09 AM" src="https://github.com/estelacruz/NYUReg/assets/79770461/b95249ef-9ee2-4223-9ae0-91b5bea03d18">

1. The program starts by reading course data from a file named "courses" and populates an ArrayList of course objects.

2. Users are presented with a menu that allows them to perform actions such as adding, editing, displaying, searching, deleting, sorting, displaying high-volume courses, and writing results to a new text file.

3. Courses can be added with user input for various attributes such as name, instructor, section number, etc.

4. Courses can be edited by specifying the course name and section number, and users can choose which attributes to modify.

5. All courses can be displayed, searched by name and section number, and deleted based on user input.

6. Courses can be sorted by the number of students registered, and high-volume courses (with 30+ registered students) can be displayed.

7. The program can write the results of displaying high-volume courses to a new text file.



# Motivation  

This is a course registration system implemented in Java using an object-oriented programming framework. NYUReg integrates aspects of Java's Four Pillars of Object-Oriented Programming (OOP):

# Encapsulation

Encapsulation is the concept of bundling data (attributes) and the methods (functions) that operate on that data into a single unit, known as a class. It restricts direct access to some of an object's components and prevents unintended interference.

Each course is encapsulated within the studentclass class. This encapsulation ensures that course data (name, instructor, section number, etc.) is protected and can only be modified through well-defined methods, maintaining data integrity and security.


# Abstraction 

Abstraction is the process of simplifying complex implementation. We achieve this by highlighting essential attributes and behaviors while hiding intricate details.

Abstraction is fundamental to NYUReg's design. It abstracts the details of course management, allowing users to interact with courses through high-level methods without needing to understand the inner complexities of data manipulation.


# Polymorphism

Polymorphism allows you to create multiple objects of different classes that share a common superclass, and you can operate on them using methods defined in that common superclass. Polymorphism is achieved through method overriding (dynamic/runtime polymorphism) or method overloading (static/compile-time polymorphism). 

Dynamic polymorphism occurs when you have a subclass that overrides a method from its superclass with a specific implementation. The actual method that gets called is determined at runtime based on the actual object type (subclass or superclass) being referenced.

Static polymorphism occurs when you have multiple methods in the same class with the same name but different parameters (method overloading).  The selection of the appropriate method happens at compile time based on the method's signature (name and parameter types). The compiler determines which method to call based on the number or types of arguments when you invoke the method. This allows you to use the same method name for related operations that may vary in the type or number of inputs they accept.

In NYUReg, there isn't explicit usage of polymorphism.

# Inheritance 

Inheritance allows you to create a new class (a subclass or child class) that inherits properties and behaviors from an existing class (a superclass or parent class). It promotes code reuse and the creation of hierarchies of related classes (is-a relationship).

In NYUReg, the courseMng and studentclass classes are separate and do not inherit from each other or from a common superclass so  there isn't explicit usage of inheritence. Instead, they have a composition relationship, where the courseMng class contains instances of studentclass objects (has-a relationship).


# Project Highlights


1. Seamless Course Management: This project simplifies the management of critical data. Users/students can take advantage of course operations, allowing you to effortlessly add, edit, display, search, and delete courses. 

2. Discovery through Sorting: Students can gain insights quickly by being able to sort courses based on student enrollment numbers.

 3. High-Volume Course Recognition: This system identifies courses with 30 or more students to identify high-demand courses.
