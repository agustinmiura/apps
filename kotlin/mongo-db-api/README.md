# Mongo db api

* Mongo db api with Kotlin and Spring Boot

 * Install 
   * Docker .
   * Jdk 11 . 
   
 * Setup the docker volume :
  * ```docker volume create mongodb```
  * ```docker volume create mongodb_conf```

# Getting Started

<<<<<<< HEAD
 * Setup the ```application.properties``` according to the ```application.properties.sample```
=======
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
 * Run the command ```mvn clean compile``` to compile .
 * Run the command ```mvn clean test``` to run test . 
 * Run the command ```docker-compose up``` to start the local image . "
 * Run the command ```mvn clean test``` to get the reports of coverage inside ```/target/site/jacoco/index.html``` . "
<<<<<<< HEAD
 * Run the commmand ```mvn clean package``` to generate the file ```target/students-api.jar``` before setting ```application.properties```.
=======
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)

#Querying the database 

 * Connect to the docker instance : ```sudo docker exec -it $containerName /bin/bash```
 * Connect to the database : ```mongo -p $password -u $user -p $password```
 * ```show databases``` To list .
 * ```use $databaseName``` To choose a database name.
<<<<<<< HEAD

# Sprint boot actuator :

* Check the endpoint : ```/actuator/health``` and see the health check .

#Create and run the docker image 

* Execute ```mvn clean package``` to create the package .
* Run the command : ```docker build --tag=student-api:latest .```
* Execute the image : ```docker run -p8080:8080 student-api:latest```

#Sample insertion data 

* For creating a student :

``` 
{
  "name": "John3",
  "email": "jpohn3@gmail.com",
  "department": {
    "departmentName": "name",
    "location": "USA"
  },
  "subjects": [
    {
      "subjectName": "math3",
      "marksObtained": 101
    },
    {
      "subjectName": "math3",
      "marksObtained": 21
    }
  ]
}
```
#Deploy en Amazon ECS 

 * Setup the MongoDb to accept connections .
 * Push the image to Amazon registry of images .
 * Create the Fairgate cluster .
 * Create the task and run it .
 * Open the ports in the vpc to access it .

 
=======
 * 
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
