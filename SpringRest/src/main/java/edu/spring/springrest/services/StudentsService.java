package edu.spring.springrest.services;

import edu.spring.springrest.entities.Student;
import edu.spring.springrest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository repository;

    @Transactional(readOnly = true)
    public Student getStudentById(long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudentsList() {
        return repository.findAll();
    }

    @Transactional
    public Student saveOrUpdate(Student student) {
        return repository.save(student);
    }

    @Transactional
    public void delete(long id) {
        if (repository.existsById(id))
            repository.delete(repository.findById(id).get());
    }

}
