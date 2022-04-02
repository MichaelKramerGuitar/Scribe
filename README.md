# 1 Application Description: Scribe 
_*A company has the following categories of customers, Business, Returning, Frequent, New and VIP
customers. The management of the company needs to send to their customers personalize emails
based on the customer types. The company needs to have an application that generates emails from
a base template for different customer types.
In this assignment, you will implement this “EMail Generation System” for email autogeneration
based on specific customer types.*_
The company has the following requirements:
1. Each Email consists of multiple components like email header, main text content, and email
   footer. These components are different for each customer type and should be generated
   together based on customer-specific type. The email generation system should be able to
   create these components based on customer types.
2. After emails are generated, company may need to check the emails for spelling and grammar
   errors before sending out them out to customers. For some of customer types company may
   need to encrypt the emails as well in addition to checks. These two optional tasks may be
   added to email generation task. Further such ad-hoc tasks may be defined in future.
3. Overall in the company application only one instance of EMailGenerationSystem should be
   created.

## 1.1 Implementation Details
   Your implementation should include the following functionalities:
   * Provided classes for customers of different types.
   * Provide Unit tests that illustrate how your “EMailGeneration” system works. It should generate
   different email components for different customer types. In your Unit tests, generate at
   least one object of each customer type and test the email generation.
   * Create Unit tests for additional tasks of Email content checks and email encryption.
   * In your JUnit tests, create an initialization method with "@Before" to create a single instance
   of “EMailGeneration” system, and use this instance in any following tests. (See code
   examples for Junit Tests)
   _*Note: The given application scenario can be implemented in different ways and with different
   implementation details. You should only focus on Email Generation process (and not sending or
   receiving system), and how you can use design patterns in this implementation. There is not only
   one single correct design and implementation for the above application scenario. Each software
   developer might consider different assumptions and design the software based on them. In this
   assignment, you are free to have your detailed assumptions and implement the details in your
   own way based on your own ideas. You should document your assumptions very well in your
   README.md file of your project and consider them in your UML diagrams.


# 2 Assignment Tasks
## 2.1 Task 1 : Implementation Description. (2 points)
   _*Provide a description of how would you implement this application considering software design
   principles. Describe what are your main software design concepts regarding this application.
   Describe which design pattern you have applied and why.
   Write your description in a README.md file, using MarkDown format.
   We recommend to write this description after you finished the other tasks in this assignment.
   Describe in detail:*_
   * How flexible is your implementation, e.g., how you add or remove in future new drink types?
     * With both the abstract factory pattern for different semantic element types according to different
       customer types it is quite easy to add or remove these and thusly this design is quite flexible.
       It deserves noting that with five distinct customer types as per the requirements the number
       of corresponding semantic element classes grows very quickly, 3 for every 1 new customer type.
       With the given requirements, the elements package is approaching 20 classes. Further, the email
       package is approaching 15 classes, mostly different customer type classes. Increased code means
       more code to maintain, however, the flexibility is good as previously mentioned.

     * Further, the decorator pattern, shown in the utilities package, is also quite flexible with 
      regards to adding or removing functionalities following this pattern. Therein lies the beauty of the pattern.

     * Both the abstract factory pattern and the decorator pattern are demonstrating high cohesion
      and low coupling, resulting in high flexibility. Removing a class or adding a class in either
      class is a simple as that, no adjustments to code outside of the class being added or removed
      are necessary.
   * How is the simplicity and understandability of your implementation?
     * Even though this implementation demonstrates the layering of three patterns (Singleton EmailGenerationSystem,
the abstract factory for semantic elements according to customer types, and the decorator pattern
for ad hoc functionality to the emails such as spell and grammar checks and encryption)
the implementation remains simple and intuitive to understand given a basic understanding
of the requirements provided by the assignment. Although there are surely other ways to satisfy
the requirements, it seems that this layering of these three designs may be the most
intuitive approach. If different semantic elements are needed per customer types it makes sense
to start there, the abstract factory allows for high cohesion and low coupling to achieve this.
The decorator pattern allows for high cohesion and low coupling to achieve adding
functionalities at will to emails and a Singleton is perhaps the only way to enforce a
central, singular generation system. Although the parts are complex and the overall design
is layered, the implementation seems to remain simple and understandable consequently.
   * How you avoided duplicated code?
     * By adhering as strictly as possible to the patterns described above and factoring out
       any necessary tangential processes such as verifying an email address provided
       for a sender or receiver is in the proper format is factored out into it's own function.
       Even in the Main class, factoring out the log format into  its own function. Otherwise
       there is very little repetition. Although it deserves mentioning that the assembleEmail()
       method of the utilities package classes (adhering to the decorator pattern), although
       are similar are stand in's for essentially different algorithms. This goes for the check()
       and encrypt() functions in the respective Checker and Encryptor classes as well. These
       are currently placeholders for these respective algorithms since this assignment was
       about the design and not these algorithms which in of themselves are studies in
       their own right - we're simply showing here where these belong in the design and consequently
       the illusion of duplicated code may come across when in fact this is not an accurate assessment. Otherwise, by adhering to the respective patterns there is almost no duplicated code necessary.

# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

# Run all the unit test classes.


```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn spotbugs:gui 
```

or 


```bash
mvn spotbugs:spotbugs
```


```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs. 


For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html


SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```




