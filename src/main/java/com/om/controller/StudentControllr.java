package com.om.controller;

import com.om.baseclasses.BaseResponse;
import com.om.baseclasses.Constants;
import com.om.baseclasses.EndPointRefer;
import com.om.model.Student;
import com.om.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentControllr {
    @Autowired
    StudentService studentService;
    @PostMapping(EndPointRefer.CREATE_STUDENT)
    public BaseResponse createStudent(@RequestBody Student student){
        log.info(EndPointRefer.CREATE_STUDENT + Constants.CONTROLLER_STARTED);
        return studentService.createStudent(student);
    }
    @GetMapping(EndPointRefer.LIST_OF_ALL_STUDENTS)
    public BaseResponse getAllStudents(){
        log.info(EndPointRefer.LIST_OF_ALL_STUDENTS + Constants.CONTROLLER_STARTED);
        return studentService.getAllStudents();
    }
}
