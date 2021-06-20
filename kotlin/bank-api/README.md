Bank api
========

Bank api with the following technologies :
* Kotlin .
* Spring boot .
* Spring security .
* Jdk 11 .

Setup :

* Download Intellij 
* Install the jdk 11.
* Clone the proyect .
* Run the Postgresql inside the docker folder with the command : ```docker compose up```

Maven stages :

* Compile the proyect ```mvn clean compile```
* Test the proyect : ```mvn clean test```
* Generate the jar : ```mvn clean package```
  
Teardown :

* Run the command ```docker compose down```
