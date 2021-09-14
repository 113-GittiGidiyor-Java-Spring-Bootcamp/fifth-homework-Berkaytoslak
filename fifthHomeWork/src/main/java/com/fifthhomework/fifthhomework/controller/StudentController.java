package com.fifthhomework.fifthhomework.controller;


import com.fifthhomework.fifthhomework.dto.StudentDTO;
import com.fifthhomework.fifthhomework.entity.Student;
import com.fifthhomework.fifthhomework.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public List<Student> findIncludeName(@PathVariable String name) {
        return studentService.findIncludeName(name);
    }

    @GetMapping("/Genders")
    public List<?> groupByGender() {
        return studentService.groupByGender();
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody @Valid StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody @Valid StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.update(studentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @DeleteMapping
    public void deleteByObject(@RequestBody StudentDTO studentDTO) {
        studentService.deleteByObject(studentDTO);
    }



    @DeleteMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name) {
        studentService.deleteByName(name);
    }
}


