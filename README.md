# Ticket_Service_Homework
User can check available seats,find and hold best available seats,reserve a seat,reserve a group of seats.


********
How the maven was installed and the setup was processed

-->If planning to run application via maven following steps needs to be executed.
1)	Download Maven
https://maven.apache.org/download.cgi

2)	2a)Set Environment variables(System Variables)
Variable Path - M2_HOME
Variable Value – Path t maven folder i.e. parent directory of bin

2b) System Variables
Variable Path – M2
Variable Value - %M2_HOME%\bin
Add it to the path variable as well
       
       
3)	Install Java and configure its path


4)	Open command prompt and check if mvn –version. To check maven is installed or not.


-->Creating JAVA Project using Apache Maven
Step 1: Navigate to the folder where the new project shall be created.
mvn archetype:generate -DgroupId=com.stadium -DartifactId=stadium -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


Step 2: Add class path variable in Eclipse IDE
Inside the Eclipse IDE, we click on Windows > Preferences.
In the left panel, we click on Java > Build path > Classpath Variables.
In the right panel, we click on “New:” button and we fill these values:
Name: “M2_REPO”
Path: “C:\Users\Username\.m2\repository\”
We click on the “OK” button.


Step 3: Open cmd and navigate to newly created project and excute mvn eclipse:eclipse



Step4: Paste the application


Step5: Create a jar file mvn package


Step6: Project Execution steps
java –cp target\stadium-1.0-SNAPSHOT.jar stadium.Entry_point


-->How to run the application


Unzip the stadium folder and there would be one more stadium folder inside unzipped stadium folder open command prompt and navigate to that directory. Example if placed stadium folder in Desktop it would be like
C:\Usesrs\Name_of_the_machine\Desktop\stadium\stadium
And execute following command
java –cp target\stadium-1.0-SNAPSHOT.jar stadium.Entry_point

NOTE : There are no dependency so once can directly import the application in any IDE.


	
