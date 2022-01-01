package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student", params = {})
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getListStudent(){
        return studentService.getListStudent();
    }

    @PostMapping
    public void addNew(@RequestBody Student student) {
        studentService.addNew(student);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.update(id, name, email);
    }
}
