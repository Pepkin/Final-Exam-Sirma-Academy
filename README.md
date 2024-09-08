# Sirma Academy Final Exam

## Objective: To find the pair of players that played in common matches the longest and their time together on the field

### Don't forget to edit the *application.properties* file so that the database can run properly
Edit the parts in **Bold**:
spring.datasource.url=jdbc:postgresql://localhost:5432/**finalExam**
spring.datasource.username=**postgres**
spring.datasource.password=**password**

## Business Logic
My business logic is as follows:
We are searching for the players that played the most on the field.
That happens when the player has played multiple matches.  
More matches -> more time on the field.

Therefore, I found the teams with most matches. 
Collected the MatchIds from the matches that they played in and started looking at the Records.
I found all the players that played in these matches and made a List of the players from the same team.
Believe it or not, only one team has the most matches, logically these players would have played the most.
Found their names from the Players database and calculated each players time on the field individually.
After having their individual time on the field, I started creating pairs.

Lastly, all pairs, without repeating, are displayed in the main view and their time together.
Best pairs have 630 minutes, or 7 matches, which is the most games played for a single team.  
Everything is in the BusinessLogic class in the Service Package

## Controllers

All Entities have Controllers that display the information from the database.
I have implemented CRUD operations for evey entity. And I tested it via Postman.
### Main Controller
All results can be seen at "/"
Displays the results of the BusinessLogic class and solves the problem that was given
### Players Controller
All players can be seen at /api/players  
Every individual player can be seen at api/players/{id}
And they can be Edited and Deleted at api/players

### Teams Controller
All players can be seen at /api/teams  
Every individual player can be seen at api/teams/{id}  
And they can be Edited and Deleted at api/teams

### Matches Controller
All players can be seen at /api/matches  
Every individual player can be seen at api/matches/{id}  
And they can be Edited and Deleted at api/matches

### Records Controller
All players can be seen at /api/records  
Records can not be Edited ot Deleted

## Models
There are four Entities:  
### Players  
They have properties of Id, Team Number, Position, Full Name, Team Id   
And additionally Getter, Setters, No Argument Constructor and All Arguments Constructor

### Records  
They have properties of Id, Player Id, Match Id, from Minutes, to Minutes   
And additionally Getter, Setters, No Argument Constructor and All Arguments Constructor

### Teams  
They have properties of Id, Name, Manager Full Name, Group   
And additionally Getter, Setters, No Argument Constructor and All Arguments Constructor

### Matches
They have properties of Id, A Team Id, B Team Id, Date, Score  
And additionally Getter, Setters, No Argument Constructor and All Arguments Constructor

## Repository
Every Entity has it's own repository, that extends JPARepository interface.
Every repository except Records repository has custom method that is getById()

## Services
Every Entity has a Service that handles the communication between the Repository and the Controllers.  

Apart from that, Every Service file has a method that runs on application startup. It reads the information from the files and adds it to the repositories.

## Readers
There is a Reader for every different .csv file that was provided. It reads the data and sends it to the database via the executable commands in every service file.  

Every reader file contains the Data validation for every different Entity.

Also, there is a BomRemover class, that removes the BOM (Byte Remover Mark). It was needed, because I had troubles parsing the data when reading it an it was the only way to solve the problem.

## Thank you for reading!