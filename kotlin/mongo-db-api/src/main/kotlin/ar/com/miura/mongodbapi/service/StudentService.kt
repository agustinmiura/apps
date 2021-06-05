package ar.com.miura.mongodbapi.service

import ar.com.miura.mongodbapi.domain.Student
import ar.com.miura.mongodbapi.repository.DepartmentRepository
import ar.com.miura.mongodbapi.repository.StudentRepository
import ar.com.miura.mongodbapi.repository.SubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.awt.print.Pageable
import java.util.*

@Service
class StudentService(
    @Autowired val studentRepository: StudentRepository,
    @Autowired val subjectRepository: SubjectRepository,
    @Autowired val departmentRepository: DepartmentRepository
){
    fun createStudent(student:Student): Student {

        if (student.department != null) {
            departmentRepository.save(student.department)
        }

        if (student.subjects!=null && student.subjects.isNotEmpty()) {
            subjectRepository.saveAll(student.subjects)
        }

        return studentRepository.save(student)
    }

    fun getAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun getById(id:String):Student  {
        val student: Optional<Student> = studentRepository.findById(id)
        return student.get()
    }

    fun update(student:Student) {
        studentRepository.save(student)
    }

    fun deleteById(id:String) {
        studentRepository.deleteById(id)
    }

    fun delete(student:Student) {
        studentRepository.delete(student)
    }

    fun getAllByName(name:String):List<Student> {
        val students:List<Student> = studentRepository.findByNameWithCustomQuery(name)
        return students
    }

    fun getByNameAndEmail(name:String, email:String):Student {
        return studentRepository.findByNameAndEmail(name, email)
    }

    fun getbyNameOrEmail(name:String, email:String):Student {
        return studentRepository.findByNameOrEmail(name, email)
    }

    fun getByDepartmentName(name:String):List<Student> {
        return studentRepository.findByDepartmentDepartmentName(name)
    }

    fun getBySubject(subject:String):List<Student> {
        return studentRepository.findBySubjectsSubjectName(subject)
    }

    fun getByEmailsLike(email:String):List<Student> {
        return studentRepository.findByEmailIsLike(email)
    }

    fun getAllWithPagination(pageNumber:Int ,pageSize: Int):List<Student> {
        val pageable: PageRequest = PageRequest.of(pageNumber-1, pageSize)
        return studentRepository.findAll(pageable).content
    }

    fun getAllWithSorting():List<Student> {
        val sort:Sort = Sort.by(Sort.Direction.ASC, "name", "email")
        return studentRepository.findAll(sort)
    }

    fun byEmailLike(email:String):List<Student> {
        return studentRepository.findByEmailIsLike(email)
    }

    fun byNameStartsWith(name:String):List<Student> {
        return studentRepository.findByNameStartsWith(name)
    }

    fun byDepartmenId(id:String):List<Student> {
        return studentRepository.findByDepartmentId(id)
    }

    fun getBySubjectName(subject:String):List<Student> {
        return studentRepository.findBySubjectsSubjectName(subject)
    }

}