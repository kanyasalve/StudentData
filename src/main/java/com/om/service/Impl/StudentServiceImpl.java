package com.om.service.Impl;

import com.om.baseclasses.BaseResponse;
import com.om.baseclasses.CustomHttpStatus;
import com.om.baseclasses.ErrorCode;
import com.om.baseclasses.Errors;
import com.om.model.Student;
import com.om.repo.StudentRepo;
import com.om.service.StudentService;
import com.om.utils.StudentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;


    @Override
    public BaseResponse createStudent(Student student) {
        BaseResponse baseResponse;
        try{
            if(student !=null){
                if(student.getName() != null && student.getAddress() !=null && student.getSubjects()!=null){
                    baseResponse = StudentUtils.getBaseResponse(HttpStatus.OK, studentRepo.save(student));
                }else{
                    log.error("one field missing");
                    Collection<Errors> errors=new ArrayList<>();
                    errors.add(Errors.builder()
                            .message(ErrorCode.NAME_OR_ADDRESS_OR_SUBJECTS_MISSING)
                            .errorCode(String.valueOf(Errors.ERROR_TYPE.USER.toCode()))
                            .errorType(Errors.SEVERITY.HIGH.name())
                            .build());
                    baseResponse = StudentUtils.getBaseResponse(CustomHttpStatus.FAILURE,errors);
                }
            }else{
               log.error("student data empty");
               Collection<Errors> errors=new ArrayList<>();
               errors.add(Errors.builder()
                       .message(ErrorCode.NO_DATA_FOUND)
                       .errorCode(String.valueOf(Errors.ERROR_TYPE.USER.toCode()))
                       .errorType(Errors.SEVERITY.HIGH.name())
                       .build());
                baseResponse = StudentUtils.getBaseResponse(CustomHttpStatus.FAILURE,errors);
            }
        }catch (Exception e){
            log.error("Exception occurred while createding student {}",e.getMessage());
            throw new RuntimeException(e);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse getAllStudents() {
        BaseResponse baseResponse;
        try {
            List<Student> students = studentRepo.findAll();
            baseResponse = StudentUtils.getBaseResponse(HttpStatus.OK, students);
        } catch (Exception e) {
            log.error("Exception occurred while fetching subjects {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return baseResponse;
    }
    }

