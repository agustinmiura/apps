package ar.com.miura.unitetesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UnitetestingApplication

fun main(args: Array<String>) {
	runApplication<UnitetestingApplication>(*args)
}
