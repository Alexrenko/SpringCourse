package edu.spring.springrest.controllers;

import edu.spring.springrest.entities.Student;
import edu.spring.springrest.entities.response.StudentsErrorResponse;
import edu.spring.springrest.exceptions.StudentNotFoundException;
import edu.spring.springrest.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
public class StudentsRestController {

    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        try {
            return studentsService.getStudentById(id);
        } catch (Exception e) {
            throw new StudentNotFoundException();
        }
    }

    @GetMapping
    public List<Student> getAllStudents() {
        try {
            return studentsService.getAllStudentsList();
        } catch (Exception e) {
            throw new StudentNotFoundException();
        }
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setId(0L);
        try {
            return studentsService.saveOrUpdate(student);
        } catch (Exception e) {
            throw new StudentNotFoundException();
        }
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Student updateStudent(@RequestBody Student student) {
        try {
            return studentsService.saveOrUpdate(student);
        } catch (Exception e) {
            throw new StudentNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public int deleteStudent(@PathVariable Long id) {
        try {
            studentsService.delete(id);
            return HttpStatus.OK.value();
        } catch (Exception e) {
            throw new StudentNotFoundException();
        }
    }

    @ExceptionHandler
    public ResponseEntity<StudentsErrorResponse> handleException(StudentNotFoundException exc) {
        StudentsErrorResponse studentsErrorResponse = new StudentsErrorResponse();
        studentsErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentsErrorResponse.setMessage(exc.getMessage());
        studentsErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentsErrorResponse,
                HttpStatus.NOT_FOUND);
    }

}

