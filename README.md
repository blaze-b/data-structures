# JAVA

- **Features of java**

    ![alt text](./images/JAVA-Features.PNG)
    
                      
- **Pre-requisites for development** 

    `JDK & JRE Structure`: ![Alt text](https://miro.medium.com/max/636/1*8oNn6HxcWFmrCsgUt27k0w.jpeg)
      
            
- **Structure of a java program**:
 
    ![Alt text](https://www.dremendo.com/java-programming-tutorial/images/java-program-structure.png)

- **Sample Code Example**: 

        import java.util.*;
        import java.lang.*;
        import java.io.*;
        
        class HelloWorld {
            public static void main(String[] args) {
              System.out.println("Hello World......");
              Scanner scanner = new Scanner(System.in);
              System.out.println("Enter the value");
              int value = scanner.nextInt();
              System.out.println("Entered value\t"+value);
            }  
        }
    
- **Variable Declaration and Initialization**

    1. Variables are used to represent values that may be changed in the program. In Java, all variables must be declared before they can be used,
     
        The basic form of a variable declaration is shown here:
        
        `type identifier [ = value][, identifier [= value] ...] ;`
        
        ![Alt text](http://www.atnyla.com/library/images-tutorials/int-data-type-in-java-2a.PNG)
        
        Types of variables in with respective data types,
        
        ![Alt text](http://www.atnyla.com/library/images-tutorials/variable-types-in-java.png)

- **Object Reference**:

    1. Object references do not hold the value of the object they refer to
    
    2. They point to an object by storing the memory address where the object is located
    
    3. A reference variable has a “handle” to an object that allows you access to that object’s attributes. 
    
    4. The default value of all object references is null. A reference can be assigned to another object of the same type or to a new object using the new keyword.


- **Java Arrays**:

    1. It is an object which contains elements of a similar data type
    
    2. Additionally, The elements of an array are stored in a `contiguous memory location(consecutive addresses)`
    
    3. We can store only a fixed set of elements in a Java array.
    
       ![Alt text](https://www.javatpoint.com/images/core/array.gif)
    
    4. Advantages
        
        Code Optimization: It makes the code optimized, we can retrieve or sort the data efficiently.
        
        Random access: We can get any data located at an index position.
    
    5. Disadvantages
        
        Size Limit: We can store only the fixed size of elements in the array. 
        
        It doesn't grow its size at runtime. To solve this problem, collection framework is used in Java which grows automatically.

    6. There are two types of array.
       
          1. Single Dimensional Array
          
                    //Syntax
                    dataType[] arr; (or)  
                    dataType []arr; (or)  
                    dataType arr[];
                    //initiation
                    arrayRefVar=new datatype[size];
                       
          2. Multidimensional Array
          
                    //Syantax
                    dataType[][] arrayRefVar; (or)  
                    dataType [][]arrayRefVar; (or)  
                    dataType arrayRefVar[][]; (or)  
                    dataType []arrayRefVar[]; 
                    //Intantiate
                    int[][] arr=new int[3][3];//3 row and 3 column
                    

- **Control Flow in Java/Control Statements in Java**

   1. Java compiler executes the code from top to bottom. The statements in the code are executed according to the order in which they appear
   
   2. However, Java provides statements that can be used to control the flow of Java code and such statements are called `control flow statements`

   3. Java provides three types of control flow statements.
   
        1. Decision Making statements
            
                if statements
                switch statement
            
        2. Loop statements
            
                do while loop
                while loop
                for loop
                for-each loop
            
        3. Jump statements
            
                break statement
                continue statement


- **Object Oriented Programming**
     
    1. Everything in java is considered as an object. The OOPs concepts are followed as well,
        
        1. **Object**: An `entity` that has `state, behavior and identity`, is known as an object e.g., chair, bike, marker, pen, table, car, etc. It can be physical or logical (tangible and intangible).
        
        2. **Class**: A class is a group of objects which have common properties. It is a `template or blueprint` from which objects are created. It is a logical entity. It can't be physical.
        **It contains**: `Fields, Methods, Constructors, Blocks, Nested Class and interfaces`
        
        3. **Packages**: A java package is a group of similar types of classes, interfaces and sub-packages.
                     
            Package in java can be categorized in two form, `built-in package` and `user-defined package`.
                     
            There are many built-in packages such as java, lang, awt, javax, swing, net, io, util, sql etc.
                    
            ![Alt text](https://static.javatpoint.com/images/package.JPG)
        
        4. **Inheritance**: It is a `mechanism` one object acquires all the features of the parent object, It represents the `IS-A relationship` which is nothing but a simple parent-child relationship,
        
           _Why?_ For the case of `method overriding during runtime` and also for `maximum reusable code`
           
           Types of Inheritance: `Single, Multi-level, Hierarchial, Multiple(not supported in java)`
 
           **Aggregation**:If a class have an entity reference, it is known as Aggregation. Aggregation represents `HAS-A relationship`
         
        5. **Polymorphism** : Polymorphism in Java is a `concept` by which we can perform a single action in different ways
         
        6. **Abstraction**  : It is a `process` of `hiding` the implementation details and showing only functionality to the user,
            
            There are two ways to achieve abstraction in java
            
            1. Abstract class (0 to 100%)
            2. Interface (100%)
