Oauth2 application
==================

Application that uses Oauth2 for authentication :
* Kotlin .
* Spring boot .
* Spring security .
* Jdk 11 .

Setup :

* Download Intellij
* Install the jdk 11.
* Clone the proyect .
* Registar an Oauth 2 application in Github.
  * Set the callback url to : ```http://localhost:8080/```
* Setup the ```application.properties``` like the file ```application.properties.sample```
* Run the app .
* Go to the url ```/``` and use your credentials .

Maven stages :

* Compile the proyect ```mvn clean compile```
* Test the proyect : ```mvn clean test```
* Generate the jar : ```mvn clean package```

Teardown :

* Run the command ```docker compose down```

Misc info :

* https://bcrypt-generator.com/ to generate the password .
