package ar.com.miura.mongodbapi.controller

import ar.com.miura.mongodbapi.domain.Student
import ar.com.miura.mongodbapi.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/students")
open class StudentController (@Autowired val studentRepository: StudentRepository){

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        val students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

}