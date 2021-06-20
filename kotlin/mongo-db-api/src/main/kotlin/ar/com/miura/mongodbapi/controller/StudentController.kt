package ar.com.miura.mongodbapi.controller

import ar.com.miura.mongodbapi.domain.Student
import ar.com.miura.mongodbapi.repository.StudentRepository
<<<<<<< HEAD
<<<<<<< HEAD
import ar.com.miura.mongodbapi.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController (
    @Autowired val studentService: StudentService
){

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        val students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    fun createStudent(@RequestBody student:Student): Student {
        return studentService.createStudent(student)
    }

    @PutMapping("/update")
    fun updateStudent(@RequestBody student:Student) {
        studentService.update(student)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id:String) {
        studentService.deleteById(id)
    }

    @GetMapping("/name/{name}")
    fun getByName(@PathVariable name:String):List<Student> {
        return studentService.getAllByName(name)
    }

    @GetMapping("/or/name/email")
    fun getByNameOrMail(@RequestParam name:String,@RequestParam email:String):Student {
        return studentService.getbyNameOrEmail(name, email)
    }

    @GetMapping("/pagination")
    fun getByPagination(@RequestParam pageNumber:Int, @RequestParam pageSize:Int):List<Student> {
        return studentService.getAllWithPagination(pageNumber, pageSize)
    }

    @GetMapping("/sorting")
    fun getBySorting():List<Student> {
        return studentService.getAllWithSorting()
    }

    @GetMapping("/department/name/{name}")
    fun getByDepartmentName(@PathVariable name:String):List<Student> {
        return studentService.getByDepartmentName(name)
    }

    @GetMapping("/department/id/{id}")
    fun byDepartmentId(@PathVariable id:String):List<Student> {
        return studentService.byDepartmenId(id)
    }

    @GetMapping("/subject/{name}")
    fun getBySubjectName(@PathVariable name:String):List<Student> {
        return studentService.getBySubject(name)
    }


    @GetMapping("/department/start/{start}")
    fun getByStarts(@PathVariable name:String):List<Student> {
        return studentService.getBySubjectName(name)
    }

    @GetMapping("/name/starts/{name}")
    fun nameStartsWith(@PathVariable name:String):List<Student> {
        return studentService.byNameStartsWith(name)
    }

=======
=======
import ar.com.miura.mongodbapi.service.StudentService
>>>>>>> d8a8e34 (Added queries and endpoints .)
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController (
    @Autowired val studentService: StudentService
){

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        val students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

<<<<<<< HEAD
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
=======
    @PostMapping
    fun createStudent(@RequestBody student:Student): Student {
        return studentService.createStudent(student)
    }

    @PutMapping("/update")
    fun updateStudent(@RequestBody student:Student) {
        studentService.update(student)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id:String) {
        studentService.deleteById(id)
    }

    @GetMapping("/name/{name}")
    fun getByName(@PathVariable name:String):List<Student> {
        return studentService.getAllByName(name)
    }

    @GetMapping("/or/name/email")
    fun getByNameOrMail(@RequestParam name:String,@RequestParam email:String):Student {
        return studentService.getbyNameOrEmail(name, email)
    }

    @GetMapping("/pagination")
    fun getByPagination(@RequestParam pageNumber:Int, @RequestParam pageSize:Int):List<Student> {
        return studentService.getAllWithPagination(pageNumber, pageSize)
    }

    @GetMapping("/sorting")
    fun getBySorting():List<Student> {
        return studentService.getAllWithSorting()
    }

    @GetMapping("/department/name/{name}")
    fun getByDepartmentName(@PathVariable name:String):List<Student> {
        return studentService.getByDepartmentName(name)
    }

    @GetMapping("/department/id/{id}")
    fun byDepartmentId(@PathVariable id:String):List<Student> {
        return studentService.byDepartmenId(id)
    }

    @GetMapping("/subject/{name}")
    fun getBySubjectName(@PathVariable name:String):List<Student> {
        return studentService.getBySubject(name)
    }


    @GetMapping("/department/start/{start}")
    fun getByStarts(@PathVariable name:String):List<Student> {
        return studentService.getBySubjectName(name)
    }

    @GetMapping("/name/starts/{name}")
    fun nameStartsWith(@PathVariable name:String):List<Student> {
        return studentService.byNameStartsWith(name)
    }

>>>>>>> d8a8e34 (Added queries and endpoints .)
}