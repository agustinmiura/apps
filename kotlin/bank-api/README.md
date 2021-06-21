Bank api
========

Bank api with the following technologies :
* Kotlin .
* Spring boot .
* Spring security .
<<<<<<< HEAD
<<<<<<< HEAD
* Jdk 11 .

Setup :

* Download Intellij 
* Install the jdk 11.
* Clone the proyect .
* Run the Postgresql inside the docker folder with the command : ```docker compose up```
* Set in your .bashrc file the content from ```src/main/resources/environment/create_variables.sh```

Maven stages :

* Compile the proyect ```mvn clean compile```
* Test the proyect : ```mvn clean test```
* Generate the jar : ```mvn clean package```
  
Teardown :

* Run the command ```docker compose down```
<<<<<<< HEAD
=======
* Unit testing.
* Jdk 11 .

>>>>>>> f17257c (Created api with security)
=======
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
>>>>>>> 75427a7 (feature/security)
=======

Misc info :

* https://bcrypt-generator.com/ to generate the password .
>>>>>>> e4ab3b2 (feature/security Added custom authentication provider.)
