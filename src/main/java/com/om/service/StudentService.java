package com.om.service;

import com.om.baseclasses.BaseResponse;
import com.om.model.Student;

public interface StudentService {

    BaseResponse createStudent(Student student);

    BaseResponse getAllStudents();
}
