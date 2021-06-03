package ar.com.miura.mongodbapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
class MongoDbApiApplication

fun main(args: Array<String>) {
	runApplication<MongoDbApiApplication>(*args)
}
