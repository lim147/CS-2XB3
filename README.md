# 2XB3_Project


Stepsafe is a web application that is designed to provide a user with safe and efficient directions between locations in Toronto using crime event records collected by the Toronto Police Service. Our application first takes in the start and end location as addresses. The Google Directions API is then called to generate possible paths from the start to the end. Our application then selects all relevant crimes events to the locations of interest, and uses the Dijkstra shortest path algorithm to compute the path with the lowest crime rating and distance. Lastly, the directions for this optimal path is returned to the user on the web application page.

Compile Time Notes
In order to successfully run the Java application, the following must be altered under the Client.java class:

String cmd = "python";
- The cmd must be changed to the appropriate python version on your computer

String filepath = "C:\\Users\\Pieci\\Desktop\\2XB3_Project\\StepSafe\\stepsafeAPI\\py_scripts\\callAPI.py";
- The filepath must be changed to the absolute path of callAPI.py


Must be built in the Java EE platform
To run the server, left click index.html under WebContent, and select “Run as” and “Run on server”

To set up the running environment for web application:
Install Web Tools Platform into Eclipse.
Install Tomcat package.
Create a server: New > Other > Server.
When first time have jsp files in Eclipse, go to Properties > Project Facets > Runtimes and check “Apache Tomcat” box to enable servlet package in the project.
