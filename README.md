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


<img width="838" alt="Screen Shot 2023-03-24 at 11 32 58 AM" src="https://user-images.githubusercontent.com/35234798/227570808-c0e15052-7b8e-4f12-8534-a6412a0b2571.png">
<img width="847" alt="Screen Shot 2023-03-24 at 11 33 20 AM" src="https://user-images.githubusercontent.com/35234798/227570878-7d932baa-06fc-4d07-9b64-f428490ff25f.png">
<img width="847" alt="Screen Shot 2023-03-24 at 11 33 39 AM" src="https://user-images.githubusercontent.com/35234798/227570960-ee8f9be6-8334-461e-9ffd-6a42d7ef48d2.png">
<img width="840" alt="Screen Shot 2023-03-24 at 11 33 52 AM" src="https://user-images.githubusercontent.com/35234798/227571018-7a61b29e-8c33-4316-a076-c546b5910b86.png">
<img width="844" alt="Screen Shot 2023-03-24 at 11 34 11 AM" src="https://user-images.githubusercontent.com/35234798/227571088-def18ba6-30c8-441c-87d9-2e6e916b10a2.png">
<img width="847" alt="Screen Shot 2023-03-24 at 11 34 25 AM" src="https://user-images.githubusercontent.com/35234798/227571162-5d80cb3d-db1d-473f-81c9-513dcda25a71.png">


