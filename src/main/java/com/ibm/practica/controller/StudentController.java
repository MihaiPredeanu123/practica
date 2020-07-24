package com.ibm.practica.controller;

import com.ibm.practica.dto.StudentDto;
import com.ibm.practica.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// SFAT: Urmariti toate adnotarile din aplicatie si cautati-le prin documentatia de la Spring (https://docs.spring.io/spring/docs/current/spring-framework-reference/) -> pagina principala
// sau direct pe google ex: "@RestController Spring". Sa va faceti un obicei din a cauta pe google, o sa aveti nevoie mai tarziu :D.
@RestController
@RequestMapping("/students") // toate endpoint-urile din controller vor precedate "/students" (ex pe local: http://localhost:8080/api/student-service/students/endpoint1...)
@Validated
public class StudentController {

    // injectam StudentService in controller sa ne folosim de metodele lui. Recomand o lectura pe google dupa "Dependency injection" (in general si in Spring)
    @Autowired
    private StudentService studentService;

    // un endpoint de "test" pe care puteti sa il apelati ca sa vedeti ca merge controllerul.
    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok()
                .body("Hello from the Students Controller.");
    }

    // find un endpoint REST in care vreti sa vi se returneze niste date (in cazul nostru studenti) veti dori sa fie returnat un JSON (de aceea proprietea de "produces")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtoList = this.studentService.getAllStudents();
        return ResponseEntity.ok().body(studentDtoList);
    }

    // aici "name" este un PATH VARIABLE. Mai puteti folosi aici si QUERY PARAMETERS. Recomand o lectura cu diferentele dintre cele 2"
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> getStudentByName(@PathVariable("name") String name) {
        StudentDto studentDto = this.studentService.getStudentByName(name);
        return ResponseEntity.ok().body(studentDto);
    }

    @GetMapping(value = "/year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDto>> getStudentsByYear(@PathVariable("year") int year) {
        List<StudentDto> studentDtoList = this.studentService.getAllStudentsFromYear(year);
        return ResponseEntity.ok().body(studentDtoList);
    }

    @GetMapping(value = "faculty/{facultyName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDto>> getStudentsByFacultyName(@PathVariable("facultyName") String facultyName){
        List<StudentDto> studentDtoList = this.studentService.getStudentsByFacultyName(facultyName);
        return ResponseEntity.ok().body(studentDtoList);
    }

    @GetMapping(value = "course/{courseName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDto>> getStudentsByCourseName(@PathVariable("courseName") String courseName){
        List<StudentDto> studentDtoList = this.studentService.getStudentsByCourseName(courseName);
        return ResponseEntity.ok().body(studentDtoList);
    }

    // la POST, cand trimiteti un Request Body, mai apare si proprietatea de consumes. Care in cazul nostru este tot un JSON (studentul trimis in request body pentru a fi salvat).
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto newStudentDto) {
        StudentDto createdStudentDto = this.studentService.saveStudent(newStudentDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudentDto);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentToBeUpdatedDto) {
        StudentDto updatedStudentDto = this.studentService.updateStudent(studentToBeUpdatedDto);
        return ResponseEntity.ok().body(updatedStudentDto);
    }

    // la delete return type-ul este void (nu in controller, in controller vom returna mereu un ResponseEntity). Dar pentru ca nu ni se returneaza studentul sters, am ales sa returnez un text de "success".
    // Puteti la fel sa nu returnati nimic, decat un HTTP status Code de 200.
    // Recomand cu ocazia asta sa cititi si despre HTTP status Codes (nu e mult aici, sa intelegeti diferenta dintre coduri cu 1, 2, 3, 4, 5 in fata. nu trebuie invatate asa cum sunt). Sa stiti de ele, si cand
    // va loviti de vreun cod le cautati pe google. Nici eu nu le stiu pe toate.
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Integer studentId) {
        this.studentService.deleteStudentById(studentId);

        return ResponseEntity.ok()
                .body("Student with id of " + studentId + " was deleted successfully!");
    }
}
