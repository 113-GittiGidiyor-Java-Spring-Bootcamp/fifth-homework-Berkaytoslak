package com.fifthhomework.fifthhomework.controller;


import com.fifthhomework.fifthhomework.dto.CourseDTO;
import com.fifthhomework.fifthhomework.dto.StudentDTO;
import com.fifthhomework.fifthhomework.entity.Course;
import com.fifthhomework.fifthhomework.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public List<Course> findIncludeName(@PathVariable String name) {
        return courseService.findIncludeName(name);
    }


    @PutMapping
    public ResponseEntity<Course> update(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.update(courseDTO), HttpStatus.OK);
    }
    @PostMapping("/addStudent")
    public ResponseEntity<Course> addStudentToCourse(@RequestBody StudentDTO studentDTO, @RequestParam long courseId){
        return new ResponseEntity<>(courseService.addStudentToCourse(studentDTO,courseId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Course> save(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.save(courseDTO), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        courseService.deleteById(id);
    }
    @DeleteMapping("/deleteByName/{name}")
    public void deleteByName(@PathVariable String name) {
        courseService.deleteByName(name);
    }
    @DeleteMapping
    public void deleteByObject(@RequestBody CourseDTO courseDTO) {
        courseService.deleteByObject(courseDTO);
    }


}

