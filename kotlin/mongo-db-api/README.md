# Mongo db api

* Mongo db api with Kotlin and Spring Boot

 * Install 
   * Docker .
   * Jdk 11 . 
   
 * Setup the docker volume :
  * ```docker volume create mongodb```
  * ```docker volume create mongodb_conf```

# Getting Started

 * Run the command ```mvn clean compile``` to compile .
 * Run the command ```mvn clean test``` to run test . 
 * Run the command ```docker-compose up``` to start the local image . "
 * Run the command ```mvn clean test``` to get the reports of coverage inside ```/target/site/jacoco/index.html``` . "

#Querying the database 

 * Connect to the docker instance : ```sudo docker exec -it $containerName /bin/bash```
 * Connect to the database : ```mongo -p $password -u $user -p $password```
 * ```show databases``` To list .
 * ```use $databaseName``` To choose a database name.
 * 
